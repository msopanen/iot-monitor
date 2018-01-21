package fi.mps.monitor.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SencorReader {
	
	private SensorRepository repository;
	
	@Autowired
	public SencorReader(SensorRepository repository) {
		this.repository = repository;
	}
	
	public Page<Sensor> findAllSencors(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Page<Sensor> findSencorsByName(PageRequest pageable, String name) {
		return repository.findSencorByName(pageable, name);
	}
}
