package fi.mps.monitor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fi.mps.monitor.jpa.Sensor;
import fi.mps.monitor.jpa.SencorReader;
import fi.mps.monitor.jpa.SensorWriter;

@RestController
@RequestMapping("v1/sencors")
public class SensorController {

	SencorReader reader;
	SensorWriter writer;

	@Autowired
	public SensorController(SencorReader reader, SensorWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	@GetMapping( produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
	public Page<Sensor> findSencors(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size,
			@RequestParam(value = "name", required = false) String name ) {
		return reader.findSencorsByName(PageRequest.of(page, size), name);
	}
	
	@RequestMapping( value = "/save", method = RequestMethod.GET)
	public ResponseEntity<String> save() {
		
		for(int i=0; i<50; i++) {
			writer.save(new Sensor(Integer.toString(i), "Foo"));
		}
		
		for(int i=50; i<100; i++) {
			writer.save(new Sensor(Integer.toString(i), "Bar"));
		}
		
		return ResponseEntity.ok().build();
	}
}
