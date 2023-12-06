package org.jsp.adminbus.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.adminbus.dto.Bus;
import org.jsp.adminbus.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BusDao {
	@Autowired
	private BusRepository busRepository;
	
	public Bus saveBus(Bus bus) {
		return busRepository.save(bus);
	}
	
	public Bus updateBus(Bus bus) {
		return busRepository.save(bus);
	}

	public Optional<Bus> findById(int id) {
		return busRepository.findById(id);
	}
	
	public List<Bus> findByAdminId(int id) {
		return busRepository.findByAdminId(id);
	}
	
	public List<Bus> findByBusNumber(String bus_number) {
		return busRepository.findByBusNumber(bus_number);
	}
	
	public List<Bus> findByTravelsName(String Travels_name) {
		return busRepository.findByTravelsName(Travels_name);
	}
	
	public List<Bus> findByDOD(String date) {
		return busRepository.findByDateOfDeparture(date);
	}
	
	public List<Bus> findByDateAndPlace(String DOD, String from, String to) {
		return busRepository.findByDateAndPlace(DOD, from, to);
	}
}
