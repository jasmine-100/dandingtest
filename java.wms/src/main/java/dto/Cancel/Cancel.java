package dto.Cancel;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/25 18:03
 */
public class Cancel {
    String warehouseCode;
    String cargoCode;
    String soNo;

    public Cancel(String warehouseCode, String cargoCode, String soNo) {
        this.warehouseCode = warehouseCode;
        this.cargoCode = cargoCode;
        this.soNo = soNo;
    }

}
