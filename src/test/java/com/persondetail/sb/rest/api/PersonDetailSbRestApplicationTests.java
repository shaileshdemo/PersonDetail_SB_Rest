package com.persondetail.sb.rest.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.persondetail.sb.rest.api.dao.PersonDetailRepository;
import com.persondetail.sb.rest.api.entity.PersonDetail;
import com.persondetail.sb.rest.api.exception.PersonDetailServiceException;
import com.persondetail.sb.rest.api.service.PersonDetailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonDetailSbRestApplicationTests {

	@Autowired
	private PersonDetailService service;

	@MockBean
	private PersonDetailRepository repository;

	@Test
	public void getPersonDetailsTest() {
		when(repository.findAll())
				.thenReturn(Stream.of(new PersonDetail(11, "Michel", "Foxx"), new PersonDetail(12, "Robert", "George"))
						.collect(Collectors.toList()));
		assertEquals(2, service.getPersonDetails().size());

	}

	@Test
	public void savePersonDetailTest() throws PersonDetailServiceException {
		PersonDetail personDetail = new PersonDetail(15, "Rajaram", "Niranjan");
		when(repository.save(personDetail)).thenReturn(personDetail);
		assertEquals(personDetail, service.savePersonDetail(personDetail));

	}

	@Test
	public void deleteById() throws PersonDetailServiceException {
		PersonDetail personDetail = new PersonDetail(1, "Arjun", "Kher");
		service.deleteById(1);
		verify(repository, times(1)).deleteById(personDetail.getId());

	}

}
