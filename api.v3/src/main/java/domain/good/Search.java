package domain.good;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 15:37
 */
@Data
public class Search {
    private String whCode;
    private String accessCode;
    private String page;
    private String size;

    public Search(String whCode, String accessCode, String page, String size) {
        this.whCode = whCode;
        this.accessCode = accessCode;
        this.page = page;
        this.size = size;
    }

}
