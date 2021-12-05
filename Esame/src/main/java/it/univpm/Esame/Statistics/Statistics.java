package it.univpm.Esame.Statistics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import it.univpm.Esame.Model.Lavoro;
import it.univpm.Esame.Model.BodyClass;

import it.univpm.Esame.Model.StatResult;
import it.univpm.Esame.Service.JsonParser;


@Service
public class Statistics {
	
	public StatResult Statistic(BodyClass body) throws IOException {
		
		StatResult risultati = new StatResult();  //valore di ritorno con le statistiche
		JsonParser download = new JsonParser();  
		ArrayList<Lavoro> annunci = download.Parsing();  // scarico il json
		risultati.setNumTot(annunci.size());  //num totale di annunci (per le percentuali)
		ArrayList<String> tmp = new ArrayList<String>(); // arraylist di keyword
		int j=0;
		
		if(body.getLocation() !="" && body.getLocation()!=null) {	//verifico che sia stata inserita la città
			for(int i=0;i<annunci.size();i++) { //manca i top 5 dei lavori richiesti
				if(body.getLocation().contains(annunci.get(i).getLuogo())){
					if(annunci.get(i).getOrario().equalsIgnoreCase("full time"))
						risultati.setNumFulltime(); //metodi set che incrementano solamente
					if(annunci.get(i).getOrario().equalsIgnoreCase("part time"))
						risultati.setNumPartime();  
					if(annunci.get(i).getOrario().equalsIgnoreCase("contract"))
						risultati.setNumContract();
					if(annunci.get(i).isRemoto())
						risultati.setNumRemoto();
					if(annunci.get(i).getOrario().equals("null")) //annunci senza orari, per contare numLocalità
						j++;
					tmp.addAll(annunci.get(i).getKeyword()); //concateno tutti i keyword di ogni annuncio in un unico arraylist
				}
			}
		}else { //se non è stata inserita una città faccio le statistiche  sul totale degli annunci
			for(int i=0;i<annunci.size();i++) { //manca i top 5 dei lavori richiesti
					if(annunci.get(i).getOrario().equalsIgnoreCase("full time"))
						risultati.setNumFulltime(); //metodi set che incrementano solamente
					if(annunci.get(i).getOrario().equalsIgnoreCase("part time"))
						risultati.setNumPartime();  
					if(annunci.get(i).getOrario().equalsIgnoreCase("contract"))
						risultati.setNumContract();
					if(annunci.get(i).isRemoto())
						risultati.setNumRemoto();
					if(annunci.get(i).getOrario().equals("null")) //annunci senza orari, per contare numLocalità
						j++;
					tmp.addAll(annunci.get(i).getKeyword()); //concateno tutti i keyword di ogni annuncio in un unico arraylist
				}
			}
		
			Set<String> set = new HashSet<String>(tmp);  //lo metto dentro un hashSet che non consente i duplicati
			tmp.clear();  //cancello gli elementi dell'arraylist
			tmp.addAll(set);  //e ci rimetto l'hashset privo di duplicati
		
			risultati.setNumTotLocation(risultati.getNumFulltime()+risultati.getNumPartime()+risultati.getNumContract()+j);
		
			double percentuale1 = (risultati.getNumFulltime()/ (double) risultati.getNumTotLocation())*100;
			risultati.setFulltimePerc(String.format("%.01f", percentuale1)+"%"); //"%.01f" per mettere solo una cifra decimale
		
			//calcolo percentuale part time
			double percentuale2=(risultati.getNumPartime()/ (double) risultati.getNumTotLocation())*100;
			risultati.setPartimePerc(String.format("%.01f", percentuale2)+"%");
		
			double percentuale3 = (risultati.getNumContract()/ (double) risultati.getNumTotLocation())*100;
			risultati.setContractPerc(String.format("%.01f", percentuale3)+"%");
			
			double percentuale4 = (risultati.getNumRemoto()/ (double) risultati.getNumTotLocation())*100;
			risultati.setRemotoPercentuale(String.format("%.01f", percentuale4)+"%");
			
			risultati.setLan(tmp);
		
		
		
		
		
		return risultati;
	}
	

}
