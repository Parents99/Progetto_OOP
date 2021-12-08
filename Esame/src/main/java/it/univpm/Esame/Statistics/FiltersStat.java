package it.univpm.Esame.Statistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.univpm.Esame.Exception.BodyException;
import it.univpm.Esame.Filters.Filters;
import it.univpm.Esame.Model.BodyClass;
import it.univpm.Esame.Model.Lavoro;
import it.univpm.Esame.Model.StatResult;

/**
 * cLasse che gestisce la generazione delle statistiche in base
 * ai parametri inseriti
 * @author Parente Christian
 *@author Fiore Garzarella
 */

@Service
public class FiltersStat {
	
	public StatResult Stats(BodyClass body) throws IOException, BodyException {
		StatResult risultati = new StatResult();
		Filters f = new Filters();
		
		ArrayList<Lavoro> annunci = f.Filter(body); //richiamo i filtri
		risultati.setNumTotale(annunci.size());
		int contatore=0;
		ArrayList<String> tmp=new ArrayList<String>();
		ArrayList<Integer> conta = new ArrayList<Integer>();
		
		
		for (Lavoro lavori : annunci) { //manca i top 5 dei lavori richiesti
			if(lavori.getOrario().equalsIgnoreCase("full time"))
				risultati.setNumFulltime(); //metodi set che incrementano solamente
			if(lavori.getOrario().equalsIgnoreCase("part time"))
				risultati.setNumPartime();  
			if(lavori.getOrario().equalsIgnoreCase("contract"))
				risultati.setNumContract();
			if(lavori.isRemoto())
				risultati.setNumRemoto();
			tmp.addAll(lavori.getKeyword()); //concateno tutti i keyword di ogni annuncio in un unico arraylist
		}
		
		Set<String> set = new HashSet<String>(tmp);  //lo metto dentro un hashSet che non consente i duplicati
		tmp.clear();  //cancello gli elementi dell'arraylist
		tmp.addAll(set);  //e ci rimetto l'hashset privo di duplicati
		tmp=filtraKeywords(tmp);
		
		double percentuale1 = (risultati.getNumFulltime()/ (double) risultati.getNumTotale())*100;
		risultati.setFulltimePercentuale(String.format("%.01f", percentuale1)+"%"); //"%.01f" per mettere solo una cifra decimale
		
		//calcolo percentuale part time
		double percentuale2=(risultati.getNumPartime()/ (double) risultati.getNumTotale())*100;
		risultati.setPartimePercentuale(String.format("%.01f", percentuale2)+"%");
		
		double percentuale3 = (risultati.getNumContract()/ (double) risultati.getNumTotale())*100;
		risultati.setContractPercentuale(String.format("%.01f", percentuale3)+"%");
			
		double percentuale4 = (risultati.getNumRemoto()/ (double) risultati.getNumTotale())*100;
		risultati.setRemotoPercentuale(String.format("%.01f", percentuale4)+"%");
		
		for (Lavoro lavori : annunci) 
			conta.add(lavori.getKeyword().size());
		Collections.sort(conta); 		//dato che devo trovare massimo e minimo riordino e prendo la prima e ultima posizione
		risultati.setNumMinKeyword(conta.get(0));
		risultati.setNumMaxKeyword(conta.get(conta.size()-1));
			
		risultati.setLinguaggi(tmp);
		
		
		return risultati;
		
	}
	
	/**
	 * Metodo che permette di filtrare le keywords attraverso
	 * una lista presente sul file lista_keywords
	 * @param arr
	 * @return
	 */
	
	private ArrayList<String> filtraKeywords(ArrayList<String> arr){
		String c;
		try {
			BufferedReader file = new BufferedReader(new FileReader("doc/"+"lista_keywords.txt"));
			 c= file.readLine();
			if(c==null) 
				file.close();

			file.close();
		}catch(IOException e) {
			e.getStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"File non trovato.");
		}
		for(int j=0;j<arr.size();j++){
			if(c.contains(arr.get(j))==false) {
				arr.remove(j);
				j--;
			}
		}
		return arr;
		
	}


}
