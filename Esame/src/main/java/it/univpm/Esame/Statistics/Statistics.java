package it.univpm.Esame.Statistics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import it.univpm.Esame.Model.Lavoro;
import it.univpm.Esame.Exception.BodyException;
import it.univpm.Esame.Model.BodyClass;

import it.univpm.Esame.Model.StatResult;
import it.univpm.Esame.Service.JsonParser;

	/**
	 * classe in cui si effettuano le statistiche 
	 * @author Garzarella Fiore
	 * @author Parente Christian
	 */


@Service
public class Statistics {
	
	/**
	 * Metodo che effettua le statistiche in relazione alla location passata dall'utente.
	 * @param body
	 * @return Statistiche sugli annunci
	 * @throws IOException
	 * @throws BodyException
	 */
	
	public StatResult Statistic(BodyClass body) throws IOException,BodyException { // mi passo l'intero body ma utilizzo solo location 
		
		BodyException e= new BodyException();
		StatResult risultati = new StatResult();  //valore di ritorno con le statistiche
		JsonParser download = new JsonParser();  
		ArrayList<Lavoro> annunci = download.Parsing();  // scarico il json
		risultati.setNumTotale(annunci.size());  //num totale di annunci (per le percentuali)
		ArrayList<String> tmp = new ArrayList<String>(); // arraylist di keyword
		int contatore=0; //per contare gli annunci senza orari, =null
		ArrayList<Integer> conta = new ArrayList<Integer>();
		
		if(body.getLocation() !="" && body.getLocation()!=null) {	//verifico che sia stata inserita la città
			for (Lavoro lavori: annunci) { //manca i top 5 dei lavori richiesti
				if(body.getLocation().contains(lavori.getLuogo())){
					if(lavori.getOrario().equalsIgnoreCase("full time"))
						risultati.setNumFulltime(); //metodi set che incrementano solamente
					if(lavori.getOrario().equalsIgnoreCase("part time"))
						risultati.setNumPartime();  
					if(lavori.getOrario().equalsIgnoreCase("contract"))
						risultati.setNumContract();
					if(lavori.isRemoto())
						risultati.setNumRemoto();
					if(lavori.getOrario().equals("null")) //annunci senza orari, per contare numLocalità
						contatore++;
					tmp.addAll(lavori.getKeyword()); //concateno tutti i keyword di ogni annuncio in un unico arraylist
				}
			}
		}else { //se non è stata inserita una città faccio le statistiche  sul totale degli annunci
			for (Lavoro lavori : annunci) { //manca i top 5 dei lavori richiesti
					if(lavori.getOrario().equalsIgnoreCase("full time"))
						risultati.setNumFulltime(); //metodi set che incrementano solamente
					if(lavori.getOrario().equalsIgnoreCase("part time"))
						risultati.setNumPartime();  
					if(lavori.getOrario().equalsIgnoreCase("contract"))
						risultati.setNumContract();
					if(lavori.isRemoto())
						risultati.setNumRemoto();
					if(lavori.getOrario().equals("null")) //annunci senza orari, per contare numLocalità
						contatore++;
					tmp.addAll(lavori.getKeyword()); //concateno tutti i keyword di ogni annuncio in un unico arraylist
				}
			}
		
		Set<String> set = new HashSet<String>(tmp);  //lo metto dentro un hashSet che non consente i duplicati
		tmp.clear();  //cancello gli elementi dell'arraylist
		tmp.addAll(set);  //e ci rimetto l'hashset privo di duplicati
		
		risultati.setNumTotLocation(risultati.getNumFulltime()+risultati.getNumPartime()+risultati.getNumContract()+contatore);
		
		double percentuale1 = (risultati.getNumFulltime()/ (double) risultati.getNumTotLocation())*100;
		risultati.setFulltimePercentuale(String.format("%.01f", percentuale1)+"%"); //"%.01f" per mettere solo una cifra decimale
		
		//calcolo percentuale part time
		double percentuale2=(risultati.getNumPartime()/ (double) risultati.getNumTotLocation())*100;
		risultati.setPartimePercentuale(String.format("%.01f", percentuale2)+"%");
		
		double percentuale3 = (risultati.getNumContract()/ (double) risultati.getNumTotLocation())*100;
		risultati.setContractPercentuale(String.format("%.01f", percentuale3)+"%");
			
		double percentuale4 = (risultati.getNumRemoto()/ (double) risultati.getNumTotLocation())*100;
		risultati.setRemotoPercentuale(String.format("%.01f", percentuale4)+"%");
		
		for (Lavoro lavori : annunci) 
			conta.add(lavori.getKeyword().size());
		Collections.sort(conta); 		//dato che devo trovare massimo e minimo riordino e prendo la prima e ultima posizione
		risultati.setNumMinKeyword(conta.get(0));
		risultati.setNumMaxKeyword(conta.get(conta.size()-1));
			
		risultati.setLinguaggi(tmp);
		
		if(risultati.getNumTotLocation()==0)
			e.BodyResults("nessun risultato trovato, location non trovata");
		
		return risultati;
		
	}
	
	

}
