package qimen.dto;

import lombok.Data;

@Data
public class Params {
    String businessNo;
    String dateType;
    String sourceData;
    String sourceSystemCode;
    String targetSystemCode;

    public Params(String businessNo, String dateType, String sourceData, String sourceSystemCode, String targetSystemCode) {
        this.businessNo = businessNo;
        this.dateType = dateType;
        this.sourceData = sourceData;
        this.sourceSystemCode = "QM";
        this.targetSystemCode = "ERP";
    }
}
