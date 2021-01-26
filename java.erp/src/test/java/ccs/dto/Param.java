package ccs.dto;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/4 15:02
 */
@Data
public class Param {
     boolean decipher;
     String msg_type;
     String content;

    public Param(String content) {
        this.decipher = false;
        this.msg_type = "CUSTOMS_CEB_CALLBACK";   // 除了CUSTOMS_CEB_CALLBACK，其他都识别为口岸
        this.content = content;
    }

    public Param(String content,String msg_type) {
        this.decipher = false;  //是否需要解密，测试环境传false
        this.msg_type = msg_type;   // 除了CUSTOMS_CEB_CALLBACK，其他都识别为口岸
        this.content = content;
    }
}
