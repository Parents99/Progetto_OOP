package it.univpm.Esame.Filters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import ch.qos.logback.core.property.FileExistsPropertyDefiner;
import it.univpm.Esame.Model.Lavoro;
import it.univpm.Esame.Model.RequestBody;

@Service
public class Filters {
	
	public ArrayList<Lavoro> ShowFilters(RequestBody body) {
		ArrayList<Lavoro> annunci = new ArrayList<Lavoro>();
		JSONObject obj = new JSONObject();
		try {
			String next;
			BufferedReader fileR = new BufferedReader(new FileReader("doc/"+"lista_annunci.txt"));
			do {
				next = fileR.readLine();
				if(next!=null) {
					obj = (JSONObject) JSONValue.parseWithException(next);
					if(body.getLocation().equalsIgnoreCase((String) obj.get("location")) && 
							body.getOrario().equalsIgnoreCase((String) obj.get("employment_type")) && 
								body.getRuolo().equalsIgnoreCase((String) obj.get("employment_type"))){
						
								
					}
					{
						Lavoro c = new Lavoro();
						c.setName(body.getName());
						c.setSunrise((String)obj.get("sunrise"));
						c.setSunset((String)obj.get("sunset"));
						annunci.add(c);
					}
				} else if(orari.isEmpty()) {
					fileR.close();
					String out = "Città non presente nell'archivio...";
					throw new InvalidBodyException(out); 
				}
			}while(next!=null);
			fileR.close();
		}catch(IOException e) {
			String out = "File non trovato";
			throw new InvalidBodyException(out); 
		}
	} // fine metodo
}
