package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class LeitorJson {

	static Map<String, String> mapJson = new HashMap<String, String>();
	static Gson gson = new Gson();
	static Reader reader;

	public static void main(String[] args) throws IOException {

		lerArquivoJson();
		gravaArquivoJson();
	}

	
	private static void gravaArquivoJson() throws IOException {

		mapJson.put("url", "htpps://qaacademy.com,br");
		mapJson.put("curso", "teste automatizado");
		mapJson.put("endereço", "Paulista, 509");
		
		FileWriter writer = new FileWriter("./src/main/resources/massaTeste_writer.json");
		gson.toJson(mapJson, writer);
				writer.flush();
		
	}
	
	private static void lerArquivoJson() throws FileNotFoundException {
		reader = new FileReader("./src/main/resources/massaTeste.json");
		mapJson = gson.fromJson(reader, Map.class);
		
		System.out.println(mapJson.get("url"));
		System.out.println(mapJson.get("produto"));
		System.out.println(mapJson.get("valor"));
	}
}
