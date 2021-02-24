package test.wmsDaita.dto.Kuwei;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/24 19:50
 */
@Data
public class Kuwei {
    String code; //库位编码ErpJxKw1
    String zoneCode;//库区编码
    String tunnelCode;//巷道编码
    String pickSeq;//拣选路由
    String type;//库位类型：10暂存位，11拣选位，12存储位，13差异位，14预包位
    String storageRule;//存放规则:SKU_1 一位一品，SKU_N 一位多品
    String mixRuleCode;//混放规则
    String shelfType;//货架类型：10地堆，11高位货架，12轻型货架，13流利货架

    public Kuwei(String code,String zoneCode,String tunnelCode) {
        this.code = code;
        this.zoneCode = zoneCode;
        this.tunnelCode = tunnelCode;
        this.pickSeq = "1";
        this.type = "11";
        this.storageRule = "SKU_N";
        this.mixRuleCode = "MIX-RULE-000001";
        this.shelfType = "11";
    }

}
