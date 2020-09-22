package domainout.stockin;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:33
 */
@Data
public class PurOrderItem {
 String proCode;
 double purchasePrice;
 int purchaseNum;
 double totalMoney;


public PurOrderItem(String proCode, double purchasePrice, int purchaseNum) {
this.proCode = proCode;
this.purchasePrice = purchasePrice;
this.purchaseNum = purchaseNum;
this.totalMoney = purchasePrice*purchaseNum;
}

 public PurOrderItem(String proCode, String purchasePrice, String purchaseNum,String totalMoney) {
  this.proCode = proCode;
  this.purchasePrice = Double.parseDouble(purchasePrice);
  this.purchaseNum = Integer.parseInt(purchaseNum);
  this.totalMoney = Double.parseDouble(totalMoney);
 }

}
