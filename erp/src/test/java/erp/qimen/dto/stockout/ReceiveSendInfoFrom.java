package erp.qimen.dto.stockout;

import lombok.Data;

@Data
public class ReceiveSendInfoFrom {
    String logisticsCompanyCode;
    String receiveProvince;
    String receiveCity;
    String receiveDistrict;
    String receiveAddress;
    String receiveContactName;
    String receiveContactPhone;
    String sendProvince;
    String sendCity;
    String sendDistrict;
    String sendAddress;
    String sendContactName;
    String sendContactPhone;

    public ReceiveSendInfoFrom() {
        this.logisticsCompanyCode = "";
        this.receiveProvince = "浙江省";
        this.receiveCity = "杭州市";
        this.receiveDistrict = "西湖区";
        this.receiveAddress = "哈哈大街100号";
        this.receiveContactName = "小花花";
        this.receiveContactPhone = "15900008888";
        this.sendProvince = "河南省";
        this.sendCity = "洛阳市";
        this.sendDistrict = "洛龙区";
        this.sendAddress = "开元大道100号科技大厦1001";
        this.sendContactName = "李可";
        this.sendContactPhone = "15899182889";
    }

}
