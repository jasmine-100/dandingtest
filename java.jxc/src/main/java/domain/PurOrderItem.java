package domain;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:33
 */
@Data
public class PurOrderItem {
    private String proCode;
    private boolean emgFlag;
    private boolean selected;
    private double purchasePrice;
    private int purchaseNum;
    private double totalMoney;

    public PurOrderItem(String proCode, double purchasePrice, int purchaseNum) {
        this.proCode = proCode;
        this.emgFlag = false;
        this.selected = false;
        this.purchasePrice = purchasePrice;
        this.purchaseNum = purchaseNum;
        this.totalMoney = this.purchasePrice*this.purchaseNum;
    }
}
