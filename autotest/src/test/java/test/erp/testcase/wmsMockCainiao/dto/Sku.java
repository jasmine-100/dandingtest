package test.erp.testcase.wmsMockCainiao.dto;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/7 17:59
 */
@Data
public class Sku {
    private String itemId;//菜鸟仓回传的货品SKU
    private String outerItemLineId;//行号
    private int qty;//数量
    private List<SkuDetail> skuDetailList;

    public Sku(String itemId,int qty) {
        this.itemId = itemId;
        this.outerItemLineId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        this.skuDetailList = new ArrayList<>();
        skuDetailList.add(new SkuDetail(qty));
        this.qty = skuDetailList.stream().collect(Collectors.summingInt(SkuDetail::getQty));
    }

    @Data
    public class SkuDetail {
        private String inventoryType;//GOOD 正品
        private int qty;

        public SkuDetail(int qty) {
            this.inventoryType = "GOOD";
            this.qty = qty;
        }
    }
}
