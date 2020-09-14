package api;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/9/11 14:18
 */
public class TestData {
    public static String getGoodName(){
        GoodName name = GoodName.values()[new Random().nextInt(GoodName.values().length)];
        return name.toString();
    }
    public enum GoodName{苹果,书包,牛奶,口香糖,电脑,鼠标,洗手液,抽纸巾,大豆油,碳酸饮料,酸奶,纯牛奶,小风扇,雨衣,帽子,手机,手链,项链,矿泉水;}

    @Test
    public void test(){
        System.out.println(getGoodName());
    }
}
