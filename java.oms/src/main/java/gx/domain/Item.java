package gx.domain;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/22 13:33
 */
@Data
public class Item {
    private String outItemCode;
    private double unitPrice;
    private int count;

    public Item(String outItemCode, double unitPrice, int count) {
        this.outItemCode = outItemCode;
        this.unitPrice = unitPrice;
        this.count = count;
    }
}
