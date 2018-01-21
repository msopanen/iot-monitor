package fi.mps.monitor.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorWriter {
	
	private SensorRepository repository;
	
	@Autowired
	public SensorWriter(SensorRepository repository) {
		this.repository = repository;
	}
	
	public void save(Sensor sensor) {
		
		repository.save(sensor);
	}
}
