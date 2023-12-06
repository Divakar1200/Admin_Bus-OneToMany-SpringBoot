package org.jsp.adminbus.repository;

import java.util.List;

import org.jsp.adminbus.dto.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusRepository extends JpaRepository<Bus, Integer> {

	@Query("select b from Bus b where b.admin.id=?1")
	public List<Bus> findByAdminId(int id);
	
	@Query("select b from Bus b where b.busNumber=?1")
	public List<Bus> findByBusNumber(String bus_number);
	
	@Query("select b from Bus b where b.admin.travel_name=?1")
	public List<Bus> findByTravelsName(String travels_name);
	
	@Query("select b from Bus b where b.dateOfDeparture=?1")
	public List<Bus> findByDateOfDeparture(String date);
	
	@Query("select b from Bus b where b.dateOfDeparture=?1 and b.from_location=?2 and b.to_location=?3")
	public List<Bus> findByDateAndPlace(String date, String from_loc, String to_loc);
}
