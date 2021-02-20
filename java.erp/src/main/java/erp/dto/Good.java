package erp.dto;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/20 11:41
 */
@Data
public class Good {
    String goodsCode; // ID,SKU
    String goodsName;
    String barcode;//条形码
    String model;  // 规格型号
    String brandCode;//品牌编码
    String type;//DUTY_PAID 完税;BONDED 保税
    double length;
    double width;
    double height;
    double grossWeight;//毛重
    double netWeight;//净重
    double retailPrice;//价格
//    String goodsLevel//等级
    String batchManagement;// YES 开启批次管理;NO 关闭
    int shelfLife;// 保质期
    int noSellDate;// 禁售天数
    int noCollectDate;// 禁收天数
    int warningDate;// 预警天数
}
