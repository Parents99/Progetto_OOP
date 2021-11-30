package it.univpm.Esame.Filters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



import org.springframework.stereotype.Service;

import it.univpm.Esame.Model.Lavoro;
import it.univpm.Esame.Model.RequestBody;
import it.univpm.Esame.Service.JsonParser;




@Service
public class Filters {
	
	@SuppressWarnings("static-access") //per downloader.parsing()
	
	public ArrayList<Lavoro> Filter(RequestBody body) throws IOException {
		int j=0;
		JsonParser downloader = new JsonParser();
		ArrayList<Lavoro> annunci = downloader.Parsing();
		System.out.println(annunci.size()+"dim");
		
		//filtro location
		if(body.getLocation() != "") { //body.getLocation() != null ||
			
			for(int i=0;i<annunci.size();i++)
				if(annunci.get(i).getLuogo().contains(body.getLocation())==false || annunci.get(i).getLuogo()==null) {
					//System.out.println(annunci.get(i).getLuogo());
					j++;
					annunci.remove(i);
				}
		}
		
		
		System.out.println(annunci.size()+"dim1");
		
		//filtro orario full-time part-time contratto
		if(body.getOrario() != "")
		{	System.out.print("ciao");
			for(int i=0;i<annunci.size();i++)
				if(body.getOrario().equalsIgnoreCase(annunci.get(i).getOrario())==false || annunci.get(i).getLuogo()==null)
					annunci.remove(i);
		}
		
		
		System.out.println(annunci.size()+"dim2");
		//filtro ruolo
		if(body.getRuolo() != "") {
			System.out.print("ciao");
			for(int i=0;i<annunci.size();i++)
				if(body.getRuolo().equalsIgnoreCase(annunci.get(i).getRuolo())==false)
					annunci.remove(i);
		}
		
		System.out.println(annunci.size()+"dim3");
		
		//filtro remoto
		if(body.getRemoto() != false && body.getRemoto() != true) {
			
			for(int i=0;i<annunci.size();i++)
				if(body.getRemoto() != annunci.get(i).isRemoto())
					annunci.remove(i);
		}
		System.out.println(annunci.size()+"dim4");
		//System.out.println(j);
		return annunci;
		
		/*
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
		*/
		
		
		
		
		
		
		
	} // fine metodo
}
