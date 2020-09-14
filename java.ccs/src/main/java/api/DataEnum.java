package api;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/9/11 14:18
 */
public class DataEnum {
    public static String getGoodName(){
        GoodName name = GoodName.values()[new Random().nextInt(GoodName.values().length)];
        return name.toString();
    }
    public enum GoodName{苹果,书包,牛奶,口香糖,电脑,鼠标,键盘,洗手液,抽纸巾,大豆油,碳酸饮料,酸奶,纯牛奶,小风扇,雨衣,帽子,手机,手链,项链
        ,矿泉水,纸尿裤,豆浆,垃圾袋,加多宝,王老吉,盐汽水,鲜花,可口可乐,空调,风扇,遮阳帽,太阳镜,手机挂件,头绳,洗面奶,洗发水,氨基酸面膜,自行车,奶粉,鲜奶;}

    @Test
    public void test(){
        System.out.println(getGoodName());
    }
}
