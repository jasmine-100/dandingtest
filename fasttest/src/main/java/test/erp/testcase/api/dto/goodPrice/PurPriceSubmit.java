package test.erp.testcase.api.dto.goodPrice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/10 16:28
 */
@Data
public class PurPriceSubmit {
    List<String> idList;

    public PurPriceSubmit(String priceId) {
        this.idList = new ArrayList<>();
        idList.add(priceId);
    }
}
