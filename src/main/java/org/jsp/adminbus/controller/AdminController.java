package org.jsp.adminbus.controller;

import org.jsp.adminbus.dto.Admin;
import org.jsp.adminbus.dto.ResponseStructure;
import org.jsp.adminbus.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admins")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@PutMapping("/admins")
	public ResponseEntity<ResponseStructure<Admin>> updateMerchant(@RequestBody Admin admin) {
		return adminService.updateAdmin(admin);
	}
	
	@GetMapping("/admins/{id}")
	public ResponseEntity<ResponseStructure<Admin>> findUserById(@PathVariable int id) {
		return adminService.findAdminById(id);
	}
	
	@GetMapping("/admins/loginbyphone")
	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(@RequestParam long phone, @RequestParam String password){
		return adminService.loginAdmin(phone, password);
	}
	
	@GetMapping("/admins/loginbyemail")
	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(@RequestParam String email, @RequestParam String password){
		return adminService.loginAdmin(email, password);
	}
}
