package it.univpm.Esame.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


//'Authorization: Token 595f621a2851ad012fa8909a1fb1c9dee278cfaa'
public class Database {
	
	public static JSONObject JSONDownloader() throws IOException {
		Database base=new Database();
		String token = new String(base.ReadToken());
		
		String data = "";
		String line = "";
		
		try {
			String url = "https://findwork.dev/api/jobs/?search=javascript";
			URLConnection http = new URL(url).openConnection();
			http.addRequestProperty("Authorization", "Token "+token);
			http.setRequestProperty("Content-Type", "application/json");
			http.setRequestProperty("accept", "application/json");
			http.setDoOutput(true);
			
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
	
	
	private String ReadToken() {
		String token;
		try {
			BufferedReader fileR = new BufferedReader(new FileReader("doc/"+"token.txt"));
			token = fileR.readLine();
			if(token==null) {
				fileR.close();
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Inserire il token nel file.");
			}
			fileR.close();
		}catch(IOException e) {
			e.getStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"File non trovato.");
		}
		return token;
	}

}
