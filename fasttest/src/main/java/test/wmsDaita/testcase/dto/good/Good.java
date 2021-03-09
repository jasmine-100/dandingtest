package test.wmsDaita.testcase.dto.good;

import lombok.Data;

import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/24 15:56
 */
@Data
public class Good {
    List<ErpSku> erpSkuList;

    public Good(List<ErpSku> erpSkuList) {
        this.erpSkuList = erpSkuList;
    }
}
