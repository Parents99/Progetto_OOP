package it.univpm.Esame.Controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.Esame.Exception.BodyException;
import it.univpm.Esame.Filters.Filters;
import it.univpm.Esame.Model.TipsClass;
import it.univpm.Esame.Service.JsonParser;
import it.univpm.Esame.Statistics.Statistics;
import it.univpm.Esame.Model.BodyClass;



@RestController
public class Controller {
	
	@Autowired
	JsonParser lavoro;
	@Autowired
	Filters filters;
	@Autowired
	TipsClass tips;
	@Autowired
	Statistics stat;
	
	@GetMapping(value ="/annunci")
	public ResponseEntity<Object> ShowJobs() throws ParseException, IOException {
		return new ResponseEntity<>(lavoro.Parsing(), HttpStatus.OK);
	}
	
	@GetMapping(value="/tips")
	public TipsClass ShowTips() {
		return new TipsClass();
	}
	
	@PostMapping(value="/filters")
	public ResponseEntity<Object> ShowFilters(@RequestBody BodyClass body) throws ParseException,IOException,BodyException{
		return new ResponseEntity<>(filters.Filter(body),HttpStatus.OK);
	}
	
	@PostMapping(value="/statistics")
	public ResponseEntity<Object> ShowStatistics(@RequestBody BodyClass body) throws ParseException,IOException,BodyException{
		return new ResponseEntity<>(stat.Statistic(body),HttpStatus.OK);
	}
	
}
