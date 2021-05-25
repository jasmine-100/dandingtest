package test.erp.testcase.apiuser.dto.purchase;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/23 14:21
 */
@Data
public class PurchasePage {

//    private int totalPage;
    private int pageSize;
    private int currentPage;
//    private int totalCount;
    private String compatible;
    private String status;

    public PurchasePage(int pageSize, int currentPage,String status) {
//        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
//        this.totalCount = totalCount;
        this.compatible = "true";
        this.status = status;
    }
}
