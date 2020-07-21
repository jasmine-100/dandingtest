package domain;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description : 清单回执
 * @Date : Created in 2020/7/20 13:50
 */
@Data
public class BackList {

    private String declareOrderNo;
    private String customsDetail;
    private long customsTime;
    private String customsStatus;
    private String ebpCode;
    private String preNo;
    //清单编号
    private String invtNo;

    public BackList(String declareOrderNo, String customsStatus, String ebpCode) {
        String str = new SimpleDateFormat("MMddHHmmss").format(new Date());
        this.declareOrderNo = declareOrderNo;
        this.customsTime = System.currentTimeMillis();
        this.customsStatus = customsStatus;
        if(customsStatus.equals("800")){
            this.customsDetail="[Code:2600;Desc:放行]";
        }
        this.ebpCode = ebpCode;
        this.preNo ="PN"+str;
        this.invtNo = "QD"+str;
    }

}
