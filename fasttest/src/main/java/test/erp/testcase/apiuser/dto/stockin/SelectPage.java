package test.erp.testcase.apiuser.dto.stockin;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/5/19 14:23
 */
@Data
public class SelectPage {
    private int pageSize;
    private int currentPage;
    private String compatible;
    private String status;//1 已创建

    public SelectPage(int pageSize,String status) {
        this.pageSize = pageSize;
        this.currentPage = 1;
        this.compatible = "true";
        this.status = status;
    }
}
