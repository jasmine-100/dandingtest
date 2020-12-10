package ccs.dto;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/10 9:25
 */
@Data
public class Param2 {
    private String content;

    public Param2(String content) {
        this.content = content;
    }
}
