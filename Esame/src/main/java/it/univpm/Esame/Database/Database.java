package it.univpm.Esame.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.json.*;
import org.springframework.http.HttpEntity;



//'Authorization: Token 595f621a2851ad012fa8909a1fb1c9dee278cfaa'
public class Database {
	public static JSONObject JSONDownloader() throws IOException  {
		
		//String url = "https://findwork.dev/api/jobs/ --silent --header 'Authorization: Token 595f621a2851ad012fa8909a1fb1c9dee278cfaa'";
		String apikey="595f621a2851ad012fa8909a1fb1c9dee278cfaa";
		//String urlString="https://findwork.dev/api/jobs/?search=javascript";
		
		String url = "https://findwork.dev/api/jobs/?search=javascript";
		URLConnection http = new URL(url).openConnection();
		http.addRequestProperty("Authorization", "Token 595f621a2851ad012fa8909a1fb1c9dee278cfaa");
		http.setRequestProperty("Content-Type", "application/json");
		http.setRequestProperty("accept", "application/json");
		http.setDoOutput(true);
		
		String data = "";
		String line = "";
		
		try {
			InputStream in = http.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			try {
				
				   while ( ( line = reader.readLine() ) != null ) {
					   data += line;
					   //System.out.println(data);
				   }  
				   
			} finally {
				 reader.close();
			}
		} catch (Exception e) {	
			e.printStackTrace();	
			}
		
		JSONObject json = new JSONObject(data);
		
		
		
		return json;
	}

}
