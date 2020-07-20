package domain;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 17:27
 */
@Data
public class GoodInfo {
    private String gname;
    private String itemLink;

    public GoodInfo(String gname, String itemLink) {
        this.gname = gname;
        this.itemLink = itemLink;
    }
}
