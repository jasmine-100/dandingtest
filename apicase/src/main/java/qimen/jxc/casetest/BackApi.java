package qimen.jxc.casetest;

import org.junit.jupiter.api.Test;
import qimen.jxc.api.Data;
import qimen.jxc.api.StockinModel;
import wms.jxc.BackStockin;
import wms.jxc.BackStockout;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/31 15:38
 */
public class BackApi {

    // 调拨出库
    @Test
    public void backDiaoboOut() throws Exception {
        BackStockout.backOutDiaobo("OB20200831152405303902","SKU08311329","20200810",10,"","","ZP");
    }
    @Test
    public void backDiaoboIn() throws Exception {
        BackStockin.backStockinDetail("LSHRGHWLRN","DBRKD","ET20200831152405657125","SKU08311329",10,1,"20200810","2020-08-11 10:00:50","2023-08-11 10:00:50","ZP",0);
    }



}
