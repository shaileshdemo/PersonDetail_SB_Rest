package com.persondetail.sb.rest.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persondetail.sb.rest.api.entity.PersonDetail;

public interface PersonDetailRepository extends JpaRepository<PersonDetail, Integer> {

}
