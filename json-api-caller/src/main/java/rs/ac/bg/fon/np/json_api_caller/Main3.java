package rs.ac.bg.fon.np.json_api_caller;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main3 {

	public static void main(String[] args) {
		try(FileReader fr=new FileReader("niz_objekata.json")) {
			Gson gson=new GsonBuilder().create();
			List<Currency> currencies=Arrays.asList(gson.fromJson(fr, Currency[].class));
			for(Currency c:currencies) {
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
