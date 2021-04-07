package test.erp.testcase.outapi.wmsCainiao.dto;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/7 17:29
 */
@Data
public class StockinDto {
    private String handsonOrderCode;//判重字段，随便填
    private String handsonOrderType;//INBOUND_ORDER 入库单
    private boolean handsonOrderComplete;//TRUE 终态；FALSE 中间态
    private String bizOrderCode;//erp入库单号
    private String focOrderCode;//菜鸟仓单号
    private String outOrderCode;//erp入库单号
    private List<Sku> skuList;

    public StockinDto(String outOrderCode,boolean handsonOrderComplete, List<Sku> skuList) {
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        this.handsonOrderCode = "LBX"+str;
        this.handsonOrderType = "INBOUND_ORDER";
        this.handsonOrderComplete = handsonOrderComplete;
        this.bizOrderCode = outOrderCode;
        this.focOrderCode = "C00"+str;
        this.outOrderCode = outOrderCode;
        this.skuList = skuList;
    }

}
