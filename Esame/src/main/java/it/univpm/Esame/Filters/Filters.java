package it.univpm.Esame.Filters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



import org.springframework.stereotype.Service;

import it.univpm.Esame.Exception.BodyException;
import it.univpm.Esame.Model.Lavoro;
import it.univpm.Esame.Model.RequestBody;
import it.univpm.Esame.Service.JsonParser;


@Service
public class Filters {
	
	@SuppressWarnings("static-access") //per downloader.parsing()
	
	public ArrayList<Lavoro> Filter(RequestBody body) throws IOException {
		BodyException e = new BodyException();
		JsonParser downloader = new JsonParser();
		ArrayList<Lavoro> annunci = downloader.Parsing();
		
		//filtro location
		if (body.getLocation()!=null) {
			if(body.getLocation() != "") { 
				for(int i=0;i<annunci.size();i++)
					if(annunci.get(i).getLuogo().contains(body.getLocation())==false) {
						annunci.remove(i);
						i--;
					}
			}
		}
		
		
		//filtro orario full-time part-time contratto
		if (body.getOrario()!=null) {
			if(body.getOrario() != ""){	
				for(int i=0;i<annunci.size();i++)
					if(body.getOrario().equalsIgnoreCase(annunci.get(i).getOrario())==false ) {
						annunci.remove(i);
						i--;
						}
			}
		}
		
		
		//filtro ruolo
		if (body.getRuolo()!=null) {
			if(body.getRuolo() != "") {
				for(int i=0;i<annunci.size();i++)
					if(annunci.get(i).getRuolo().contains(body.getRuolo())==false ) {
						annunci.remove(i);
						i--;
					}
			}
		}
		
		
		//filtro remoto		
		if (body.getRemoto() != null){
			if(body.getRemoto() instanceof Boolean == false)
				e.InvalidBody("Remoto è di tipo booleano, inserire true o false");
			if(body.getRemoto() != false) {
				for(int i=0;i<annunci.size();i++)
					if(body.getRemoto() != annunci.get(i).isRemoto()) {
						annunci.remove(i);
						i--;
					}
			} 
		
		
			if(body.getRemoto() != true) {
				for(int i=0;i<annunci.size();i++)
					if(body.getRemoto() != annunci.get(i).isRemoto()) {
						annunci.remove(i);
						i--;
					}
			}
		}
		
		
		if(annunci.size()==0)
			e.BodyResults("Nessun risultato trovato");
		return annunci;
			
	} // fine metodo
}
