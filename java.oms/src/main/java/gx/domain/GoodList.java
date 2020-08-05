package gx.domain;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/22 13:09
 */
@Data
public class GoodList {

     String name;
    //小B用户id
     String userId;
    //0、上架;1、下架
     String status;
     String sourceItemCode;
     String outeItemCode;

    public GoodList(String name, String userId, String outeItemCode) {
        this.name = name;
        this.userId = userId;
        this.status = "0";
        this.sourceItemCode = "FX"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        this.outeItemCode = outeItemCode;
    }
}
