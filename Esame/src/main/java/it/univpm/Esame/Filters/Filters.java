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
		int contFull=0;
		int contPart=0;
		int conTrue=0;
		int contFalse=0;
		int contCont=0;
		int contNull=0;
		
		
		System.out.println(body.getLocation());
		System.out.println(body.getOrario());
		System.out.println(body.getRuolo());
		System.out.println(body.getRemoto());
		//int j=0;
		JsonParser downloader = new JsonParser();
		ArrayList<Lavoro> annunci = downloader.Parsing();
		System.out.println(annunci.size()+" dim iniziale");
		
		for(int j=0;j<annunci.size();j++) {
			if(annunci.get(j).isRemoto()==true)
				conTrue++;
			else 
				contFalse++;
			
			if(annunci.get(j).getOrario().equalsIgnoreCase("part time"))
				contPart++;
			if(annunci.get(j).getOrario().equalsIgnoreCase("full time"))
				contFull++;
			if(annunci.get(j).getOrario().equalsIgnoreCase("contract"))
				contCont++;
			if(annunci.get(j).getOrario().equalsIgnoreCase("null"))
				contNull++;
		}
		System.out.println("contatore true "+conTrue);
		System.out.println("contatore false "+contFalse);
		System.out.println("contatore Full time "+contFull);
		System.out.println("contatore Part time "+contPart);
		System.out.println("contatore null "+contNull);
		System.out.println("contatore contract "+contCont);
		
		//filtro location
		if(body.getLocation() != "" && body.getLocation() != "null") { //body.getLocation() != null ||
			for(int i=0;i<annunci.size();i++)
				if(annunci.get(i).getLuogo().contains(body.getLocation())==false) {
					System.out.println(annunci.get(i).getLuogo());
					annunci.remove(i);
					i--;
				}
		}
		System.out.println(annunci.size()+" dim dopo filtro location");
		
		//filtro orario full-time part-time contratto
		if(body.getOrario() != "")
		{	System.out.print("ciao");
			for(int z=0;z<annunci.size();z++)
				if(body.getOrario().equalsIgnoreCase(annunci.get(z).getOrario())==false ) {
					System.out.println(annunci.get(z).getOrario());
					annunci.remove(z);
					z--;
					}
		}
		System.out.println(annunci.size()+" dim dopo filtro tipo contratto");
		
		//filtro ruolo
		if(body.getRuolo() != "" && body.getRuolo() != "null") {
			System.out.print("ciao");
			for(int y=0;y<annunci.size();y++)
				if(annunci.get(y).getRuolo().contains(body.getRuolo())==false ) {
					System.out.println(annunci.get(y).getRuolo());
					annunci.remove(y);
					y--;
					}
		}
		System.out.println(annunci.size()+" dim dopo filtro ruolo");
		
		//filtro remoto
		if(body.getRemoto() != false) {
			for(int x=0;x<annunci.size();x++)
				if(body.getRemoto() != annunci.get(x).isRemoto()) {
					annunci.remove(x);
					x--;
				}
		} 
		System.out.println(annunci.size()+" dim dopo filtro remoto per i false");
		
		if(body.getRemoto() != true) {
			for(int h=0;h<annunci.size();h++)
				if(body.getRemoto() != annunci.get(h).isRemoto()) {
					System.out.println(annunci.get(h).isRemoto());
					annunci.remove(h);
					h--;
					}
		}
		
		System.out.println(annunci.size()+" dim dopo filtro remoto per i true");
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
