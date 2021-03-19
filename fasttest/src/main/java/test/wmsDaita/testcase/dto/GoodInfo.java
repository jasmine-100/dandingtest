package test.wmsDaita.testcase.dto;

import lombok.Data;

@Data
public class GoodInfo {
    String name;
    String barCode;
    String cargoCode;
    String grossWeight;
    String isPurchase;
    String code;

    public GoodInfo(String name, String barCode, String cargoCode, String grossWeight, String isPurchase, String code) {
        this.name = name;
        this.barCode = barCode;
        this.cargoCode = cargoCode;
        this.grossWeight = grossWeight;
        this.isPurchase = isPurchase;
        this.code = code;
    }
}
