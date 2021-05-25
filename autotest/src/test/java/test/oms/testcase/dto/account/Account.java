package test.oms.testcase.dto.account;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/1/26 10:57
 */
@Data
public class Account {
    String targetAccountName;
    String targetAccountNo;
    String targetBank;
    String targetBankCode;
    String submitProofUrl;
    int submitChargeNum;
    String accountType;
    String submitBusinessNo;
    int userId;

    public Account() {
        this.targetAccountName = "杭州但丁云科技有限公司";
        this.targetAccountNo = "19033301040022140";
        this.targetBank = "中国农业银行杭州九堡支行";
        this.targetBankCode = "YL3084058283";
        this.submitProofUrl = "https://dante-img.oss-cn-hangzhou.aliyuncs.com/29611811103.jpg";
        this.submitChargeNum = 10;
        this.accountType = "EXPENSE_ACCOUNT";
        this.submitBusinessNo = "313120001";
        this.userId = 100157;
    }

}
