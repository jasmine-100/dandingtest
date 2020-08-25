package domainout.stockin;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:33
 */
@Data
public class StoOrderItem {
     String proCode;
     int predictNum;

    public StoOrderItem(String proCode, int purchaseNum) {
        this.proCode = proCode;
        this.predictNum = purchaseNum; //入库数量
    }
}
