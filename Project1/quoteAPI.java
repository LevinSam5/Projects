import java.io.*;

import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class quoteAPI {
	String[] getQuote() throws IOException{
		// creating a URL object and establishing connection to the JSON file
		// that contains the information from the author and quotes API
		URL url = new URL("https://opinionated-quotes-api.gigalixirapp.com/v1/quotes");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		// The buffer reader is passed with the input stream reader,
		// allowing information to be read from the API
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine = "";
		String content = "";
		while ((inputLine = in.readLine()) != null) {
			content += inputLine;
		}	
		in.close();
		
		// returning the quote by array
		String array[] = parseQuote(content);
		return array;
	}
	
	String[] parseQuote(String content) {
		JsonObject jsonObject = new JsonParser().parse(content).getAsJsonObject(); // creating Json object so I can parse through the Json file
		JsonArray array = jsonObject.getAsJsonArray("quotes");
		String[] array1 = new String[2];
		for (int i = 0; i < array.size(); i++) {
			array1[0] = array.get(i).getAsJsonObject().get("quote").getAsString();
			array1[1] = array.get(i).getAsJsonObject().get("author").getAsString();
		}
		return array1;
	}
	
}
