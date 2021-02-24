package test.wmsDaita.dto.Kuwei;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/24 21:41
 */
@Data
public class Hangdao {
    String code;
    String zoneCode;

    public Hangdao(String code, String zoneCode) {
        this.code = code;
        this.zoneCode = zoneCode;
    }
}
