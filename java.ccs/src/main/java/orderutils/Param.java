package orderutils;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/4 15:02
 */
@Data
public class Param {
    private boolean decipher;
    private String msg_type;
    private String content;

    public Param(String content) {
        this.decipher = false;
        this.msg_type = "CUSTOMS_CEB_CALLBACK";   // 除了CUSTOMS_CEB_CALLBACK，其他都识别为口岸
        this.content = content;
    }
}
