package test.oms.testcase.dto.intercept;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/29 13:11
 */
@Data
public class Intercept {

    private String shopId;
    private List<String> outOrderNos;

    public Intercept(String shopId, String orderno) {
        this.shopId = shopId;
        this.outOrderNos = new ArrayList<>();
        outOrderNos.add(orderno);
    }

}
