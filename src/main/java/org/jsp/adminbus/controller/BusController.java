package org.jsp.adminbus.controller;

import java.util.List;

import org.jsp.adminbus.dto.Bus;
import org.jsp.adminbus.dto.ResponseStructure;
import org.jsp.adminbus.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusController {

	@Autowired
	private BusService busService;	
	
	@PostMapping("/buses/{admin_id}")
	public ResponseEntity<ResponseStructure<Bus>> saveBus(@RequestBody Bus bus, @PathVariable int admin_id) {
		return busService.saveBus(bus, admin_id);
	}
	
	@PutMapping("/buses")
	public ResponseEntity<ResponseStructure<Bus>> updateProduct(@RequestBody Bus bus) {
		return busService.updateBus(bus);
	}
	
	@GetMapping("/buses/by-admin/{admin_id}")
	public ResponseEntity<ResponseStructure<List<Bus>>> findByAdminId(@PathVariable int admin_id) {
		return busService.findByAdminId(admin_id);
	}
	
	@GetMapping("/buses/by-bus-number/{busNumber}")
	public ResponseEntity<ResponseStructure<List<Bus>>> findByBusNumber(@PathVariable String busNumber) {
		return busService.findByBusNum(busNumber);
	}
	
	@GetMapping("/buses/by-travels-name/{TravelsName}")
	public ResponseEntity<ResponseStructure<List<Bus>>> findByTravelsName(@PathVariable String TravelsName) {
		return busService.findByTravels(TravelsName);
	}
	
	@GetMapping("/buses/by-date/{dateofdept}")
	public ResponseEntity<ResponseStructure<List<Bus>>> findByDateOfDeparture(@PathVariable String dateofdept) {
		return busService.findByDOD(dateofdept);
	}
	
	@GetMapping("/buses/by-dateandlocation/{dateofdept}/{From}/{To}")
	public ResponseEntity<ResponseStructure<List<Bus>>> findByDateFromTo(@PathVariable String dateofdept, @PathVariable String From, @PathVariable String To) {
		return busService.findByDateAndPlace(dateofdept, From, To);
	}
}
