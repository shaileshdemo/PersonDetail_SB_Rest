package com.persondetail.sb.rest.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.persondetail.sb.rest.api.dao.PersonDetailRepository;
import com.persondetail.sb.rest.api.entity.PersonDetail;
import com.persondetail.sb.rest.api.exception.PersonDetailServiceException;

@Service
public class PersonDetailService {

	@Autowired
	private PersonDetailRepository repository;

	public PersonDetail savePersonDetail(PersonDetail personDetail) throws PersonDetailServiceException {
		if (personDetail.getFirstName() == null || personDetail.getLastName().isEmpty()) {
			throw new PersonDetailServiceException("Names should not be null or empty ",
					HttpStatus.BAD_REQUEST.value());
		} else {
			return repository.save(personDetail);
		}
	}

	public PersonDetail updatePersonDetail(PersonDetail personDetail) {
		PersonDetail existingPersonDetail = repository.findById(personDetail.getId()).orElse(null);
		existingPersonDetail.setFirstName(personDetail.getFirstName());
		existingPersonDetail.setLastName(personDetail.getLastName());
		return repository.save(existingPersonDetail);

	}

	public String deleteById(int id) throws PersonDetailServiceException {
		repository.deleteById(id);
		if (repository.findById(id) == null) {
			throw new PersonDetailServiceException("Id not exist in db ", HttpStatus.NOT_FOUND.value());
		} else {
			return "Person Id removed from the PersonDetail ID :" + id;
		}
	}

	public String getPersonDetailCount(PersonDetail personDetail) {
		return "Total Persons in PersonDetails Table : " + repository.count();

	}

	public List<PersonDetail> getPersonDetails() {
		return repository.findAll();

	}

}
