package gateway;

import lombok.Data;

/**
 * @Auther: Dante-GXJ
 * @Date: 2020/10/15 11:39
 * @Description:
 */
@Data
public class LoginToken {
    private String code;
    private TokenData data;
}
