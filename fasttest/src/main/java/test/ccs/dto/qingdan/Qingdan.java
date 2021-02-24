package test.ccs.dto.qingdan;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/4 16:07
 */
@Data
public class Qingdan {
     String declareOrderNo;
     String customsDetail;
     long customsTime;
     String customsStatus;
     String ebpCode;
     String preNo;
    //清单编号
     String invtNo;

    public Qingdan(String declareOrderNo, String customsStatus, String ebpCode) {
        String str = new SimpleDateFormat("MMddHHmmss").format(new Date());
        this.declareOrderNo = declareOrderNo;
        this.customsTime = System.currentTimeMillis();
        this.customsStatus = customsStatus;
        this.ebpCode = ebpCode;
        if(customsStatus.equals("800")){
            this.customsDetail="[Code:2600;Desc:放行]";
            this.preNo ="PN"+str;
            this.invtNo = "QD"+str;
        }else{
            if(customsStatus.equals("120")){
                this.customsDetail="[Code:1800;Desc:逻辑校验通过]";
            }else if(customsStatus.equals("2")){
                this.customsDetail = "清单新增申报成功[电商企业编码：4401962010订单编号：124183351885]";
            }
            this.preNo ="";
            this.invtNo = "";
        }
    }

}
