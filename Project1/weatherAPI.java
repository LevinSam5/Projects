import java.io.*;
import java.net.*;
import com.google.gson.*;

public class weatherAPI {
	int[] getData(String city) throws IOException {
		// creating a URL object and establishing connection to the JSON file
		// that contains the information from the weather API
		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city +  "&APPID=26aa1d90a24c98fad4beaac70ddbf274");
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
				
				// making different variables to hold 
				// current temp
				// min and max temp of the city
				int temp = parseDataTemp(content);
				int minTemp = parseDataTempLow(content);
				int maxTemp = parseDataTempHigh(content);
				// if there is no input
				if(content == "") {
					throw new IOException("No Data"); // use the IO exception
				}
				// returning an array with the
				// information of the temperature
				int[] array = new int[3];
				array[0] = temp;
				array[1] = minTemp;
				array[2] = maxTemp;
				
				return array;
				
				
	}
	
	int parseDataTemp(String content) {
		JsonObject jsonObject = new JsonParser().parse(content).getAsJsonObject(); // creating Json object so I can parse through the Json file
		String pageName = jsonObject.getAsJsonObject("main").get("temp").getAsString(); // extracting the temp attribute from the main object
		double kelvin = Double.parseDouble(pageName); // converting the string to a double to properly represent the temp
		
		// converting from kelvin to fahrenheit
		double temp = (((kelvin - 273.15) * 9) / 5) + 32;
	
		
		return (int)temp; // returning the current temperature for the city
		
	}
	
	int parseDataTempLow(String content) {
		JsonObject jsonObject = new JsonParser().parse(content).getAsJsonObject(); // creating Json object so I can parse through the Json file
		String pageName = jsonObject.getAsJsonObject("main").get("temp_min").getAsString(); // extracting the temp_min attribute from the main object
		double kelvin = Double.parseDouble(pageName); // converting the string to a double
		
		// conversion from Kelvin to fahrenheit
		double minTemp = (((kelvin - 273.15) * 9) / 5) + 32;
		
		return (int)minTemp; // returning the low for the city
	}
	
	int parseDataTempHigh(String content) {
		JsonObject jsonObject = new JsonParser().parse(content).getAsJsonObject(); // creating Json object so I can parse through the Json file
		String pageName = jsonObject.getAsJsonObject("main").get("temp_max").getAsString(); // extracting the temp_max attribute
		double kelvin = Double.parseDouble(pageName); // converting the string to a double
		
		// conversion from Kelvin to fahrenheit
		double maxTemp = (((kelvin - 273.15) * 9) / 5) + 32;
		
		return (int)maxTemp; // returning the high for the city
		
	}
	
	
	
	
	
	
	

}
