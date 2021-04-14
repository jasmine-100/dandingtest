package test.erp.testcase.outapi.puluosi.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/14 10:56
 */
@Data
public class Stockin {

    private String appKey;
    private String appSecret;
    private String applyNo;//融资单号（即 上游采购单号）
    private String approveDate;//全款支付时间
    private String customerId;//货主编码
    private String entryNotice;//入库通知单号（即 入库单号）
    private String method;//
    private String sourceCode;
    private String warehouseId;
    private String sign;

    private List<Good> goodList;

    public Stockin(String applyNo,String entryNotice,String customerId, String warehouseId, String approveDate, List<Good> goodList) {
        this.appKey = "69310916123999402868";
        this.appSecret = "kckcfnvyfbsh4flq19gg9p9q5aw0ch";
        this.applyNo = applyNo;
        this.approveDate = approveDate;
        this.customerId = customerId;
        this.entryNotice = entryNotice;
        this.method = "wms.entry.in.notice";
        this.sourceCode = "170";
        this.warehouseId = warehouseId;
        this.sign = "0PNZ0+EIJZ1ZA3AMEG2P5W==";
        this.goodList = goodList;
    }

    @Data
    public static class Good {
        private String goodsNo;//货品sku
        private String unit;//单位
        private int num;//数量
        private String goodsName;//货品数量

        public Good(String goodsNo, String goodsName, String unit, int num) {
            this.goodsNo = goodsNo;
            this.unit = unit;
            this.num = num;
            this.goodsName = goodsName;
        }
    }
}

