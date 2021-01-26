package wmsDaita.dto.stockin;

import lombok.Data;

import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/24 17:25
 */
@Data
public class StockinOrder {
    List<DetailParam> detailParams;
    HdrParam hdrParam;
    SupplierParam supplierParam;

    public StockinOrder(List<DetailParam> detailParams, HdrParam hdrParam) {
        this.detailParams = detailParams;
        this.hdrParam = hdrParam;
        supplierParam = new SupplierParam();
    }
}
