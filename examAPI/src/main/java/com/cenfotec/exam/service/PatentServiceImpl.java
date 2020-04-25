package com.cenfotec.exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.cenfotec.exam.domain.Patent;
import com.cenfotec.exam.repository.PatentRepository;

@Service
public class PatentServiceImpl implements IPatentService {
	@Autowired
	PatentRepository repo;

	@Override
	public void set(Patent patent) throws Exception {
		repo.save(patent);
	}

	@Override
	public List<Patent> getAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Patent> getById(String id) throws Exception {
		return repo.findById(id);
	}

	@Override
	public Optional<Patent> getByGUID(String guid) throws Exception {
		return repo.findByGuid(guid);
	}

	@Override
	public Patent update(Patent patent) throws Exception {

		Optional<Patent> ref = repo.findById(patent.getId());
		patent.setGuid(ref.get().getGuid());

		repo.save(patent);
		return patent;
	}

	@Override
	public boolean delete(String id) throws Exception {

		Optional<Patent> ref = repo.findById(id);
		repo.delete(ref.get());
		if (repo.findById(id) == null) {
			return true;
		} else
			return false;

	}

}
