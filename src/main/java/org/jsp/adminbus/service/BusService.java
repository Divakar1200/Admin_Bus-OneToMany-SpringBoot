package org.jsp.adminbus.service;

import java.util.List;
import java.util.Optional;

import org.jsp.adminbus.dao.BusDao;
import org.jsp.adminbus.dao.AdminDao;
import org.jsp.adminbus.dto.Bus;
import org.jsp.adminbus.dto.Admin;
import org.jsp.adminbus.dto.ResponseStructure;
import org.jsp.adminbus.exception.AdminNotFoundException;
import org.jsp.adminbus.exception.BusNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusService {
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private BusDao busDao;
	
	public ResponseEntity<ResponseStructure<Bus>> saveBus(Bus bus, int admin_id) {
		ResponseStructure<Bus> structure = new ResponseStructure<>();
		Optional<Admin> dBAdmin = adminDao.findById(admin_id);
		if (dBAdmin.isPresent()) {
			Admin admin = dBAdmin.get();
			admin.getBuses().add(bus);
			bus.setAdmin(admin);
			adminDao.saveAdmin(admin);
			structure.setData(busDao.saveBus(bus));
			structure.setMessage("Bus added");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Bus>>(structure, HttpStatus.CREATED);
		}
		throw new AdminNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Bus>> updateBus(Bus bus) {
		ResponseStructure<Bus> structure = new ResponseStructure<>();
		Optional<Bus> recBus = busDao.findById(bus.getId());
		if (recBus.isPresent()) {
			Bus dbBus = recBus.get();
			dbBus.setBusNumber(bus.getBusNumber());
			dbBus.setDateOfDeparture(bus.getDateOfDeparture());
			dbBus.setNoOfSeat(bus.getNoOfSeat());
			dbBus.setCostPerSeat(bus.getCostPerSeat());
			dbBus.setFrom_location(bus.getFrom_location());
			dbBus.setTo_location(bus.getTo_location());
			dbBus.setImage_url(bus.getImage_url());
			structure.setData(busDao.saveBus(dbBus));
			structure.setMessage("Bus Updated");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Bus>>(structure, HttpStatus.ACCEPTED);
		}
		throw new BusNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Bus>>> findByAdminId(int id) {
		ResponseStructure<List<Bus>> structure = new ResponseStructure<>();
		List<Bus> bus = busDao.findByAdminId(id);
		if (bus.size() > 0) {
			structure.setData(bus);
			structure.setMessage("Buses Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>>(structure, HttpStatus.OK);
		}
		throw new AdminNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Bus>>> findByBusNum(String bnum) {
		ResponseStructure<List<Bus>> structure = new ResponseStructure<>();
		List<Bus> bus = busDao.findByBusNumber(bnum);
		if (bus.size() > 0) {
			structure.setData(bus);
			structure.setMessage("Buses Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>>(structure, HttpStatus.OK);
		}
		throw new BusNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Bus>>> findByDOD(String date_of_dep) {
		ResponseStructure<List<Bus>> structure = new ResponseStructure<>();
		List<Bus> bus = busDao.findByDOD(date_of_dep);
		if (bus.size() > 0) {
			structure.setData(bus);
			structure.setMessage("Buses Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>>(structure, HttpStatus.OK);
		}
		throw new BusNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Bus>>> findByTravels(String Tname) {
		ResponseStructure<List<Bus>> structure = new ResponseStructure<>();
		List<Bus> bus = busDao.findByTravelsName(Tname);
		if (bus.size() > 0) {
			structure.setData(bus);
			structure.setMessage("Buses Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>>(structure, HttpStatus.OK);
		}
		throw new BusNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Bus>>> findByDateAndPlace(String date_of_dep, String from_loca, String to_loca) {
		ResponseStructure<List<Bus>> structure = new ResponseStructure<>();
		List<Bus> bus = busDao.findByDateAndPlace(date_of_dep, from_loca, to_loca);
		if (bus.size() > 0) {
			structure.setData(bus);
			structure.setMessage("Buses Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>>(structure, HttpStatus.OK);
		}
		throw new BusNotFoundException();
	}
	
//	public ResponseEntity<ResponseStructure<Bus>> findBusbyId(int id) {
//		Optional<Bus> dBBus = busDao.findById(id);
//		ResponseStructure<Bus> structure = new ResponseStructure<>();
//		if (dBBus.isPresent()) {
//			structure.setData(dBBus.get());
//			structure.setMessage("Bus Found");
//			structure.setStatusCode(HttpStatus.OK.value());
//			return new ResponseEntity<ResponseStructure<Bus>>(structure, HttpStatus.OK);
//		}
//		throw new BusNotFoundException();
//	}
}
