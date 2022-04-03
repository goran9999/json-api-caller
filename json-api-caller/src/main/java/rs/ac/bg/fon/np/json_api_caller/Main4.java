package rs.ac.bg.fon.np.json_api_caller;

import java.io.FileWriter;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Main4 {

	public static void main(String[] args) {
		Currency currency1 = new Currency();
		currency1.setAsset_id("BTC");
		currency1.setData_start(new Date());
		currency1.setName("Bitcoin");
		currency1.setType_is_crypto(true);
		currency1.setVolume_1mth_used(134215.23);
		currency1.setPrice_usd(43556.34);
		
		JsonObject jsonCurrency=new JsonObject();
		
		jsonCurrency.addProperty("asset_id", currency1.getAsset_id());
		jsonCurrency.addProperty("name", currency1.getName());
		jsonCurrency.addProperty("type_is_crypto", currency1.isType_is_crypto());
		jsonCurrency.addProperty("volume_1mth_used", currency1.getVolume_1mth_used());
		jsonCurrency.addProperty("data_start", currency1.getData_start().toString());
		jsonCurrency.addProperty("price_usd", currency1.getPrice_usd());
		
		try (FileWriter fw=new FileWriter("rucni_upis.json")){
			Gson gson=new GsonBuilder().setPrettyPrinting().create();
			fw.write(gson.toJson(jsonCurrency));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
