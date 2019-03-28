package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
public class EmployeeController  {
	
	@Autowired
	EmployeeService empService;
	
	

	@GetMapping(path="/getSalary", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins= "http://localhost:4200")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployeeDetails(){
		List<EmployeeDTO> listEmp= new ArrayList<>();
		try {
		
		listEmp=empService.getAllDetails();
		} 	
        catch(Exception e) {
        	System.out.println(e);
        }
		return ResponseEntity.ok().body(listEmp);
	}

	@PostMapping(path="/addEmployee",produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Boolean>  addToJsonObject(@Valid @RequestBody EmployeeDTO employeeDTO){

		EmployeeDTO emp = new EmployeeDTO();
		emp.setId(employeeDTO.getId());
		emp.setName(employeeDTO.getName());
		emp.setSalary(employeeDTO.getSalary());
		Boolean isAdded = empService.addToJSONFile(emp);
		return ResponseEntity.ok().body(isAdded);
		
	}
	
	  @CrossOrigin(origins="http://localhost:4200")
      @GetMapping(value="/deleteJsonObject/{id}")
      public ResponseEntity<Boolean> deleteJSONObject(@PathVariable(value = "id") String Id) throws ResourceNotFoundException {
		Boolean isObjectDeleted=empService.deleteSpecificJSONObject(Id);
		return ResponseEntity.ok().body(isObjectDeleted);

	}
	
 }
