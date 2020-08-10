package domain;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/10 9:25
 */
@Data
public class Hezhu {
    private String content;

    public Hezhu(String content) {
        this.content = content;
    }
}
