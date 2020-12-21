package com.persondetail.sb.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persondetail.sb.rest.api.entity.PersonDetail;
import com.persondetail.sb.rest.api.exception.PersonDetailServiceException;
import com.persondetail.sb.rest.api.service.PersonDetailService;

@RestController
@RequestMapping("/person")
public class PersonDetailController {

	@Autowired
	private PersonDetailService service;

	@PostMapping("/addPersonDetail")
	public PersonDetail addPersonDetail(@RequestBody PersonDetail personDetail) throws PersonDetailServiceException {
		return service.savePersonDetail(personDetail);

	}

	@PutMapping("/updatePersonDetail")
	public PersonDetail updatePersonDetail(@RequestBody PersonDetail personDetail) {
		return service.updatePersonDetail(personDetail);

	}

	@DeleteMapping("/delete/{id}")
	public String deletePersonDetail(@PathVariable int id) throws PersonDetailServiceException {
		return service.deleteById(id);

	}

	@GetMapping("/count")
	public String getPersonDetailCount(@RequestBody PersonDetail personDetail) {
		return service.getPersonDetailCount(personDetail);

	}

	@GetMapping("/personDetails")
	public List<PersonDetail> findAllPersonDetails() {
		return service.getPersonDetails();

	}

}
