package test.erp.qimen.dto.stockin;

import lombok.Data;

@Data
public class ReceiveSendInfoParam {
    String receiveProvince;
    String receiveCity;
    String receiveDistrict;
    String receiveAddress;
    String receiveContactName;
    String receiveContactPhone;
    String logisticsCompanyCode;

    public ReceiveSendInfoParam() {
        this.receiveProvince = "浙江省";
        this.receiveCity = "杭州市";
        this.receiveDistrict = "江干区";
        this.receiveAddress = "九和路金海城";
        this.receiveContactName = "小美美";
        this.receiveContactPhone = "15988880000";
        this.logisticsCompanyCode = "SF";
    }
}
