package com.cenfotec.exam.query;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cenfotec.exam.domain.Patent;
import com.cenfotec.exam.service.IPatentService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class PatentQuery implements GraphQLQueryResolver {

	@Autowired
	private IPatentService service;

	public List<Patent> getPatents() {
		return service.getAll();
	}

	public Optional<Patent> getPatent(String id) throws Exception {
		return service.getById(id);
	}

}