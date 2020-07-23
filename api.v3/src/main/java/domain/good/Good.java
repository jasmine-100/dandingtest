package domain.good;

import lombok.Data;

import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 15:15
 */
@Data
public class Good {

    private String  whCode;
    private String  accessCode;
    private List<Sku> skuList;

    public Good(String whCode, String accessCode, List<Sku> skuList) {
        this.whCode = whCode;
        this.accessCode = accessCode;
        this.skuList = skuList;
    }

}
