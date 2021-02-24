package test.wmsDaita.dto.Kuwei;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/24 21:30
 */
@Data
public class Kuqu {
    String code;//库区编码
    String name;//库区名称
    String pickSeq;//序号
    String type;//类型：10暂存，11拣选，12拣选，13差异，14预包
    String storageRule;//存放规则:SKU_1 一位一品，SKU_N 一位多品
    String skuQuality;//正残属性：DAMAGE 次品，AVL 正品

    public Kuqu(String code,String name,String type,String skuQuality) {
        this.code = code;
        this.name = name;
        this.pickSeq = "1";
        this.type = type;
        this.storageRule = "SKU_N";
        this.skuQuality = skuQuality;
    }

}
