package test.erp.testcase.outQimen.dto;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class Params {
    String businessNo;
    String dateType;
    String methodType;
    String sourceData;
    String sourceSystemCode;
    String targetSystemCode;

    public Params(String businessNo,String methodType, Object sourceData) {
        this.businessNo = businessNo;
        this.dateType = "1";
        this.methodType = methodType;
        this.sourceData = JSON.toJSONString(sourceData);
        this.sourceSystemCode = "QM";
        this.targetSystemCode = "ERP";
    }
}
