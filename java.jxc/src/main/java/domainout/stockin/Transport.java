package domainout.stockin;

import lombok.Data;

import java.util.Random;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/25 18:30
 */
@Data
public class Transport {
    long arriveTime;
    String filesKey;
    String mobile;
    String name;
    String transName;
    int transNo;
    int transType;

    public Transport() {
        this.arriveTime = System.currentTimeMillis();
        this.mobile = "15966663333";
        this.name = "qll";
        this.transName = "BSHT";
        this.transNo = new Random().nextInt(99999999);
        this.transType = 1;
    }
}
