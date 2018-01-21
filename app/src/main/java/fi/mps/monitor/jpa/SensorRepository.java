package fi.mps.monitor.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SensorRepository extends PagingAndSortingRepository<Sensor, String> {
	
	Page<Sensor> findSencorByName(Pageable pageable, String name);
}
