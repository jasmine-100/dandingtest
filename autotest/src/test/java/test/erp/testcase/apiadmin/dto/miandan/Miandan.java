package test.erp.testcase.apiadmin.dto.miandan;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/26 11:01
 */
@Data
public class Miandan {

    private String warehouse;//实体仓编码
    private String warehouseName;//实体仓名称
    private String platformCode;//面单获取接口
    private List<String> saleCodeList;//渠道id

    public Miandan(String warehouse, String warehouseName, String platformCode, String saleCode) {
        this.warehouse = warehouse;
        this.warehouseName = warehouseName;
        this.platformCode = platformCode;
        this.saleCodeList = new ArrayList<>();
        saleCodeList.add(saleCode);
    }

}
