package test.wmsDaita.dto.rq;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/23 14:25
 */
@Data
public class RongQi {

    String code;
    String name;

    public RongQi(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
