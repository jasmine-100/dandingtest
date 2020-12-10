package wmsKunei.dto.stockout;

import lombok.Data;

import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/25 17:05
 */
@Data
public class StockoutOrder {
    String soNo;
    String businessType;
    String warehouseCode;
    String cargoCode;
    String carrierCode;
    List<Detail> listDetail;
    String orderType;
    String poNo;
    String receiverProv;
    String receiverCity;
    String receiverArea;
    String receiverAddress;
    String receiverTel;
    String receiverMan;
    String saleShopId;

    public StockoutOrder(String soNo, String warehouseCode, String cargoCode, String carrierCode, List<Detail> listDetail) {
        this.soNo = soNo;
        this.businessType = "B2C";
        this.warehouseCode = warehouseCode;
        this.cargoCode = cargoCode;
        this.carrierCode = carrierCode;
        this.listDetail = listDetail;
        this.orderType = "10";
        this.poNo = "PO72254212410";
        this.receiverProv = "浙江省";
        this.receiverCity = "杭州市";
        this.receiverArea = "江干区";
        this.receiverAddress = "彩虹街棒棒糖路100号";
        this.receiverTel = "15699993333";
        this.receiverMan = "小宝贝";
        this.saleShopId = "JSHOP2369622211";
    }
}
