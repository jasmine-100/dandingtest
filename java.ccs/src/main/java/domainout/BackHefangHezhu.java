package domainout;

import client.ApiClient;
import dao.Data;
import domain.Hezhu;

import java.io.IOException;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description : 核注核放：调用成功 通用回执
 * @Date : Created in 2020/8/10 10:14
 */
public class BackHefangHezhu {

    /**
     *ccs系统内部核注核放单编号
     * @param EtpsPreentNo 企业内部编码
     * @param SeqNo  预录入核注清单编号/预录入核放编号
     * @throws IOException
     */
    public static void callPass(String EtpsPreentNo,String SeqNo) throws IOException {
        String data = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
                "<CommonResponeMessage>" +
                    "<SeqNo>"+SeqNo+"</SeqNo>" +
                    "<EtpsPreentNo>"+EtpsPreentNo+"</EtpsPreentNo>" +
                    "<CheckInfo>调用成功</CheckInfo>" +
                    "<DealFlag>0</DealFlag>" +
                "</CommonResponeMessage>";
        new ApiClient(Data.URL3).doPostForm(new Hezhu(data));
    }
}
