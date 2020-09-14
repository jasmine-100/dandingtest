package domain;

import lombok.Data;
import utils.UtilTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description : 账册库存实体类
 * @Date : Created in 2020/8/12 15:05
 */
@Data
public class Stock {
    double avgPrice; //平均美元单价
    int currCode;  //币值
    int customsBookId;  //账册的数据库id
    int declarePrice;  //申报单价
    int enable;
    String firstUnit;
    String goodsModel;
    String goodsName;
    String goodsSeqNo;
    String goodsUnit;
    String hsCode;
    long inDate;
    int inLegalQty;
    int inQty;
    String invtGoodsNo;
    String  invtNo;
    String  originCountry;
    String  productId;
    String  remark;
    int inSecondLegalQty;
    String  secondUnit;
    int totalAmt;

    public Stock(String goodsSeqNo,String goodsName, String productId, int customsBookId){
        this.avgPrice = 10;
        this.currCode = 142;
        this.customsBookId = customsBookId;
        this.declarePrice = 10;
        this.enable = 1;
        this.goodsModel = "规格";
        this.goodsName = goodsName;
        this.goodsSeqNo = goodsSeqNo;
        this.goodsUnit = "001";
        this.hsCode = "3304990039";
        this.inDate = UtilTime.getTime("20200901102030");
        this.inLegalQty = 1000;
        this.inQty = 1000;
        this.firstUnit = "011";
        this.invtGoodsNo = "";
        this.invtNo = "";
        this.originCountry = "142";
        this.productId = productId;
        this.remark = "";
        this.inSecondLegalQty = 1;
        this.secondUnit = "011";
        this.totalAmt = 1000;
    }
}
