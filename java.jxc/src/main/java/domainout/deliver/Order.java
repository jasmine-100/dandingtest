package domainout.deliver;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 14:52
 */
@Data
public class Order {
    private String orderNo;

    public Order(String orderNo) {
        this.orderNo = orderNo;
    }
}
