package test.wmsDaita;

import org.testng.annotations.Test;
import test.wmsDaita.dto.cargo.Cargo;
import utils.client.ApiClient;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/25 10:11
 */
public class CargoApi {

    @Test
    public void addCargo(){
        Cargo cargo = new Cargo("JASMINE","德赛","DT-W1");
        ApiClient.doPostJson(Data.addCargoUrl,null,null,cargo);
    }

}
