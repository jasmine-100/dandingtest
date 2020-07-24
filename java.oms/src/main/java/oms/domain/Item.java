package oms.domain;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description : OMS 订单商品list类
 * @Date : Created in 2020/7/20 11:18
 */
@Data
public class Item {
    private String shopItemCode;
    private String outItemCode;
    private int count;
    private double unitPrice;

    public Item(String shopItemCode,String outItemCode, int count, double unitPrice) {
        this.outItemCode = outItemCode;
        this.shopItemCode = shopItemCode;
        this.count = count;
        this.unitPrice = unitPrice;
    }
}