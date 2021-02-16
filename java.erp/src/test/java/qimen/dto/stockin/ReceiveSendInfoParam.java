package qimen.dto.stockin;

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
}
