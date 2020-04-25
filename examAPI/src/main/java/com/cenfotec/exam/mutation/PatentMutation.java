package com.cenfotec.exam.mutation;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cenfotec.exam.domain.Patent;
import com.cenfotec.exam.service.IPatentService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class PatentMutation implements GraphQLMutationResolver {

	@Autowired
	private IPatentService service;

	public Patent createPatent(String spice_name, String discovered_name, String micro) throws Exception {
		Patent p = new Patent(spice_name, discovered_name, micro);
		p.setGuid(UUID.randomUUID().toString());
		p.setEntry_date(new Date());
		service.set(p);
		return p;
	}

	public Patent getPatentById(String id) throws Exception {
		Optional<Patent> p = service.getById(id);
		return p.get();
	}

	public Patent getPatentByGUID(String guid) throws Exception {
		Optional<Patent> p = service.getByGUID(guid);
		return p.get();
	}

	public List<Patent> getAll() {
		return service.getAll();
	}

	public Patent updatePatent(String id, String spice_name, String discovered_name, String micro) throws Exception {
		Patent p = new Patent(spice_name, discovered_name, micro);
		p.setId(id);
		p.setEntry_date(new Date());
		p = service.update(p);

		return p;
	}

	public Patent delete(String id) throws Exception {
		Optional<Patent> p = service.getById(id);
		boolean var = service.delete(id);
		if (!var) {
			return p.get();
		} else {
			return null;
		}
	}

}