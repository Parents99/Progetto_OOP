package it.univpm.Esame.Statistics;

import java.io.IOException;
import java.util.ArrayList;

import it.univpm.Esame.Model.Lavoro;
import it.univpm.Esame.Model.RequestBody;
import it.univpm.Esame.Model.StatResult;
import it.univpm.Esame.Service.JsonParser;

public class Statistics {
	public StatResult Statistic(RequestBody body) throws IOException {
		StatResult risultati = new StatResult();
		JsonParser download = new JsonParser();
		ArrayList<Lavoro> annunci = download.Parsing();
		risultati.setNumTot(annunci.size());
		
		
		for(int i=0;i<annunci.size();i++) {
			if(body.getLocation().contains(annunci.get(i).getLuogo())){
				if(annunci.get(i).getOrario().equalsIgnoreCase("full time"))
					risultati.setNumFulltime(); //metodi set che incrementano solamente
				if(annunci.get(i).getOrario().equalsIgnoreCase("part time"))
					risultati.setNumPartime(); 
				annunci.get(i).getKeyword()
			}
				
		}
		
		
		
		
		
		return risultati;
	}

	
	
	
	
	
	
}
