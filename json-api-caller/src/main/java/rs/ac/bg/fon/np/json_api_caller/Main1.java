package rs.ac.bg.fon.np.json_api_caller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Main1 {

	public static void main(String[] args) {
		
	
		try {
			
			FileInputStream fin=new FileInputStream(new File("env.properties"));
			
			Properties properties=new Properties();
			
			properties.load(fin);
			
			final String API_KEY=properties.getProperty("API_KEY");
			
			URL url=new URL("https://rest.coinapi.io/v1/assets/BTC?apikey="+API_KEY);
			
			HttpsURLConnection conn=(HttpsURLConnection) url.openConnection();
			
			BufferedReader bfin=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			Gson gson=new GsonBuilder().setPrettyPrinting().create();
			
			JsonArray currencies=gson.fromJson(bfin, JsonArray.class);
			
			JsonObject jsonCurrency=(JsonObject) currencies.get(0);
			
			Currency currency=new Currency();
			
			currency.setAsset_id(jsonCurrency.get("asset_id").getAsString());
			
			currency.setName(jsonCurrency.get("name").getAsString());
			
			currency.setPrice_usd(jsonCurrency.get("price_usd").getAsDouble());
			
			boolean type_is_crypto=jsonCurrency.get("type_is_crypto").getAsInt()==1?true:false;
			
			currency.setType_is_crypto(type_is_crypto);
			
			currency.setVolume_1mth_used(jsonCurrency.get("volume_1mth_usd").getAsDouble());
			
			Date data_start=new SimpleDateFormat("yyyy-MM-dd").parse(jsonCurrency.get("data_start").getAsString());
			
			currency.setData_start(data_start);
			
			System.out.println(currency);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
