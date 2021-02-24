package test.ccs;

import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import org.testng.annotations.Test;
import test.ccs.dto.Item;
import test.ccs.dto.order.Order;
import test.ccs.dto.back.BackDingdanKouan;
import test.ccs.dto.back.BackDingdanZongshu;
import test.ccs.dto.back.BackQingdanZongshu;
import test.ccs.dto.back.BackTax;
import utils.client.ApiClient;
import utils.util.UtilsExcel;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : CCS申报单完整流程：推送申报单--申报订单-申报清单--回执电子税单
 * @Date : Created in 2020/7/20 12:23
 */
public class OrderApiAuto {
    // 推送申报单
    @Test
    public void pushOrder() {
        try {
            Workbook workbook = Workbook.getWorkbook(new File(Data.FILEPATH));
            Sheet sheet = workbook.getSheet(1);
            Range[] ranges = sheet.getMergedCells();

            outer:
            for (int i = 1; i < sheet.getRows(); i++) {  //单一商品申报单
                inner:
                for (Range range : ranges) {
                    if (i >= range.getTopLeft().getRow() && i <= range.getBottomRight().getRow()) {
                        continue outer;
                    }
                }
                List<Item> items = new ArrayList<Item>();
                goodItems(items, sheet, i);
                //接口：推送申报单和回执
                pushOrder(sheet,i, items);
            }

            for (int i = 0; i < ranges.length / 8; i++) { //多商品申报单
                Range range = ranges[i * 8];
                int index = range.getTopLeft().getRow();
                // 组装商品项
                List<Item> items = new ArrayList<Item>();
                for (int j = index; j <= range.getBottomRight().getRow(); j++) {
                    goodItems(items, sheet, j);
                }
                //接口：推送申报单和回执
                pushOrder(sheet,index,items);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 组装商品信息
    public List<Item> goodItems(List<Item> items, Sheet sheet, int row) {
        String productId = sheet.getCell(8, row).getContents();
        String sku = sheet.getCell(9, row).getContents();
        double price = Double.parseDouble(sheet.getCell(10, row).getContents());
        int num = Integer.parseInt(sheet.getCell(11, row).getContents());
        items.add(new Item(productId, sku, num, price));
        return items;
    }

    // 组装订单信息
    public void pushOrder(Sheet sheet, int row, List<Item> items) {
        String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        String outOrderNo = "JOS" + str;
        String declareOrderno = "DS" + str;
        String logiticsNo = "sf" + str;
        UtilsExcel.writeExcel(Data.FILEPATH, 1, row, 0, outOrderNo);
        UtilsExcel.writeExcel(Data.FILEPATH, 1, row, 1, declareOrderno);
        UtilsExcel.writeExcel(Data.FILEPATH, 1, row, 3, logiticsNo);
        String expressCode = sheet.getCell(2, row).getContents();
        String routeCode = sheet.getCell(4, row).getContents();
        String ebpCode = sheet.getCell(5, row).getContents();
        String ebcCode = sheet.getCell(6, row).getContents();
        String agentCode = sheet.getCell(7, row).getContents();
        Order order = new Order("xiaoyuer", "小鱼儿", outOrderNo, declareOrderno, expressCode, logiticsNo, routeCode, items);
        System.out.println(order);
        ApiClient.doPostJson(Data.URL_ORDER, null, null, order);

        dingdanBack(declareOrderno, ebpCode, ebcCode);
        qingdanBack(declareOrderno, ebpCode, ebcCode, agentCode);
    }

    public void dingdanBack(String declareOrderNo,String ebpCode,String ebcCode) {
        try {
            // 口岸：处理成功
            BackDingdanKouan.backPass(declareOrderNo, "2020-8-06");
            Thread.sleep(100);
            // 总署：逻0辑校验通过
            BackDingdanZongshu.logicOk(declareOrderNo, ebpCode, ebcCode, new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
            Thread.sleep(100);
            // 总署:新增申报成功
            BackDingdanZongshu.declareAddOk(declareOrderNo, ebpCode, ebcCode, new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 步骤三：清单申报回执
     */
    public void qingdanBack(String declareOrderNo, String ebpCode, String ebcCode, String agentCode) {
        try {
            // 回执清单号
            String invtNo = "QD" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

            //回执逻辑校验通过报文
            //回传时间格式：年月日时分秒毫秒
            BackQingdanZongshu.backLogic(declareOrderNo, ebpCode, ebcCode, agentCode, invtNo, new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
            Thread.sleep(100);

            // 回执新增申报成功报文
            BackQingdanZongshu.backAddOk(declareOrderNo, ebpCode, ebcCode, agentCode, invtNo, new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
            Thread.sleep(100);

            //回执放行报文
            BackQingdanZongshu.backPass(declareOrderNo, ebpCode, ebcCode, agentCode, invtNo, "20200916110030001");
            Thread.sleep(100);

            // 回执：税金
            BackTax.backTaxrd(invtNo, ebcCode,100, 5.2, 3.6, new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
