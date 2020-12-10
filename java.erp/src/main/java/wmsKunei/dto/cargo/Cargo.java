package wmsKunei.dto.cargo;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/25 10:12
 */
@Data
public class Cargo {
    String code;//货主内部编码
    String outCode;//货主外部编码
    String name;//货主名称
    String warehouseCode;//仓库编码
    String createdBy;
    long createdTime;
    String updatedBy;
    long updatedTime;
    int current;//币制0
    int deleted;// 1
    String remark;
    int size;
    int status;
    boolean searchCount;

    public Cargo(String code, String name,String warehouseCode) {
        this.code = code;
        this.outCode = code;
        this.warehouseCode = warehouseCode;
        this.createdBy = "jasmine";
        this.createdTime = System.currentTimeMillis();
        this.updatedBy = "qll";
        this.updatedTime = System.currentTimeMillis();
        this.current = 0;
        this.deleted = 1;
        this.name = name;
        this.remark = "";
        this.size = 20;
        this.status = 1;
        this.searchCount = true;
    }
}
