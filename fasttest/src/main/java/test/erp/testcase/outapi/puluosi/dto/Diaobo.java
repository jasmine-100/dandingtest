package test.erp.testcase.outapi.puluosi.dto;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/14 10:50
 */
@Data
public class Diaobo {

    private String sign;
    private String method;
    private String appKey;
    private String appSecret;
    private String sendNotice;//出库通知单号（即 出库单号）
    private String sourceCode;//来源系统
    private String customerId;//货主编码
    private String warehouseId;//逻辑仓编码
    private String applyNo;//融资单号（即 销售单号）
    private String expectDate;//预计送达时间
    private String note1;//备注
    private String sendAddress;//发货地址
    private String consigneeName;//收货人
    private String consigneeTel;//收货电话
    private String consigneeAdress;//收货地址
    private List<Good> goodList;

    public Diaobo(String applyNo,String sendNotice,String warehouseId,String customerId,String expectDate,String sendAddress, List<Good> goodList) {
        this.sign = "GDJFFKG++FD==";
        this.method = "wms.entry.out.notice";
        this.appKey = "asfgweg";
        this.appSecret = "appSecret";
        this.sendNotice = sendNotice;
        this.sourceCode = "80";
        this.customerId = customerId;
        this.warehouseId = warehouseId;
        this.applyNo = applyNo;
        this.expectDate = expectDate;
        this.note1 = "快点儿发货";
        this.sendAddress = sendAddress;
        this.consigneeName= "笑哈哈";
        this.consigneeTel= "15966660000";
        this.consigneeAdress = "浙江省杭州市西湖区彩虹路100号";
        this.goodList = goodList;
    }

    @Data
    public static class Good{
        private String goodsNo;//货品sku
        private String goodsName;
        private String unit;//单位
        private String batchId;//批次号
        private int noticesendQty;//调拨数量
        private String note2;//备注
        private int stockType;//正品0，次品1
        private String produceDate;//生产日期
        private String expireDate;//失效日期

        public Good(String goodsNo, String batchId, int noticesendQty,int stockType, String produceDate, String expireDate) {
            this.goodsNo = goodsNo;
            this.goodsName = null;
            this.unit = "个";
            this.batchId = batchId;
            this.noticesendQty = noticesendQty;
            this.note2 = "含赠品";
            this.stockType = stockType;
            this.produceDate = produceDate;
            this.expireDate = expireDate;
        }
    }
}
