package org.jsp.adminbus.service;

import java.util.Optional;

import org.jsp.adminbus.dao.AdminDao;
import org.jsp.adminbus.dto.Admin;
import org.jsp.adminbus.dto.ResponseStructure;
import org.jsp.adminbus.exception.AdminNotFoundException;
import org.jsp.adminbus.exception.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		structure.setData(adminDao.saveAdmin(admin));
		structure.setMessage("Admin Saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		Optional<Admin> recAdmin = adminDao.findById(admin.getId());
		if (recAdmin.isPresent()) {
			Admin dbAdmin = recAdmin.get();
			dbAdmin.setEmail(admin.getEmail());
			dbAdmin.setName(admin.getName());
			dbAdmin.setPassword(admin.getPassword());
			dbAdmin.setPhone(admin.getPhone());
			dbAdmin.setGst(admin.getGst());
			dbAdmin.setTravel_name(admin.getTravel_name());
			structure.setData(adminDao.saveAdmin(dbAdmin));
			structure.setMessage("Admin Updated");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.ACCEPTED);
		}
		throw new AdminNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Admin>> findAdminById(int id) {
		Optional<Admin> dBAdmin = adminDao.findById(id);
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		if (dBAdmin.isPresent()) {
			structure.setData(dBAdmin.get());
			structure.setMessage("Admin Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
		throw new AdminNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(long phone, String password) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		Optional<Admin> dbAdmin = adminDao.LoginPhone(phone, password);
		if (dbAdmin.isPresent()) {
			structure.setMessage("Admin Verified succesfully");
			structure.setData(dbAdmin.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialException();
	}
	
	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(String email, String password) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		Optional<Admin> dbAdmin = adminDao.LoginEmail(email, password);
		if (dbAdmin.isPresent()) {
			structure.setMessage("Admin Verified succesfully");
			structure.setData(dbAdmin.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialException();
	}

}
