package it.univpm.Esame.Statistics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import it.univpm.Esame.Model.Lavoro;
import it.univpm.Esame.Model.RequestBody;

import it.univpm.Esame.Model.StatResult;
import it.univpm.Esame.Service.JsonParser;


@Service
public class Statistics {
	public StatResult Statistic(RequestBody body) throws IOException {
		
		StatResult risultati = new StatResult();  //valore di ritorno con le statistiche
		JsonParser download = new JsonParser();  
		ArrayList<Lavoro> annunci = download.Parsing();  // scarico il json
		risultati.setNumTot(annunci.size());  //num totale di annunci (per le percentuali)
		ArrayList<String> tmp = new ArrayList<String>(); // arraylist di keyword
		
		for(int i=0;i<annunci.size();i++) { //manca i top 5 dei lavori richiesti
			if(body.getLocation().contains(annunci.get(i).getLuogo())){
				if(annunci.get(i).getOrario().equalsIgnoreCase("full time"))
					risultati.setNumFulltime(); //metodi set che incrementano solamente
				if(annunci.get(i).getOrario().equalsIgnoreCase("part time"))
					risultati.setNumPartime();  
				tmp.addAll(annunci.get(i).getKeyword()); //concateno tutti i keyword di ogni annuncio in un unico arraylist
			}
				
		}
		
		Set<String> set = new HashSet<String>(tmp);  //lo metto dentro un hashSet che non consente i duplicati
		tmp.clear();  //cancello gli elementi dell'arraylist
		tmp.addAll(set);  //e ci rimetto l'hashset privo di duplicati
		
		//calcolo percentuale full time
		int full=0;
		int totale=risultati.getNumTot();
		double percentuale=(full/totale)*100;
		
		
		
		String top= percentuale + "%";
		risultati.setFulltimePerc(top);
		
		//calcolo percentuale part time
		top=(risultati.getNumPartime()/risultati.getNumTot())*100+"%";
		risultati.setPartimePerc(top);
		
		risultati.setLan(tmp);
		
		return risultati;
	}

	
	
	
	
	
	
}
