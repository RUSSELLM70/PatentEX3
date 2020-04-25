package com.cenfotec.exam.service;

import java.util.List;
import java.util.Optional;

import com.cenfotec.exam.domain.Patent;

public interface IPatentService {

	public void set(Patent patent) throws Exception;

	public List<Patent> getAll();

	public Optional<Patent> getById(String id) throws Exception;

	public Optional<Patent> getByGUID(String id) throws Exception;

	public Patent update(Patent patent) throws Exception;

	public boolean delete(String id) throws Exception;

}
