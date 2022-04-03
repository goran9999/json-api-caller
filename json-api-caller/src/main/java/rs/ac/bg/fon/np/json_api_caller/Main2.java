package rs.ac.bg.fon.np.json_api_caller;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main2 {

	public static void main(String[] args) {
		Currency currency1 = new Currency();
		currency1.setAsset_id("BTC");
		currency1.setData_start(new Date());
		currency1.setName("Bitcoin");
		currency1.setType_is_crypto(true);
		currency1.setVolume_1mth_used(134215.23);
		currency1.setPrice_usd(43556.34);

		Currency currency2 = new Currency();
		currency2.setAsset_id("USD");
		currency2.setData_start(new Date());
		currency2.setName("United States Dollar");
		currency2.setType_is_crypto(false);
		currency2.setVolume_1mth_used(165445.23);
		currency2.setPrice_usd(1.0);

		Currency currency3 = new Currency();
		currency3.setAsset_id("SOL");
		currency3.setData_start(new Date());
		currency3.setName("Solana");
		currency3.setType_is_crypto(true);
		currency3.setVolume_1mth_used(125635.23);
		currency3.setPrice_usd(96.55);

		Currency currency4 = new Currency();
		currency4.setAsset_id("ETH");
		currency4.setData_start(new Date());
		currency4.setName("Ethereum");
		currency4.setType_is_crypto(true);
		currency4.setVolume_1mth_used(7455445.23);
		currency4.setPrice_usd(2451.35);
		
		
		
		try(PrintWriter pw=new PrintWriter(new FileWriter("niz_objekata.json"))) {
			
			Currency [] currencies= {currency1,currency2,currency3,currency4};
			
			Gson gson=new GsonBuilder().setPrettyPrinting().create();
			
			pw.write(gson.toJson(currencies));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
