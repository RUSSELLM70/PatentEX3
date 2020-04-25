package com.cenfotec.exam.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.exam.domain.Patent;

public interface PatentRepository extends MongoRepository<Patent, String> {
	public Optional<Patent> findByGuid(String guid);
}
