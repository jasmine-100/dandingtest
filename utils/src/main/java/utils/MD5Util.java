package utils;

import java.security.MessageDigest;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/1/15 10:47
 */
public class MD5Util {
    public MD5Util() {
    }

    public static String MD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(s.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            byte[] var4 = array;
            int var5 = array.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                byte item = var4[var6];
                sb.append(Integer.toHexString(item & 255 | 256).substring(1, 3));
            }

            return sb.toString();
        } catch (Exception var8) {
            var8.printStackTrace();
            return "";
        }
    }
}
