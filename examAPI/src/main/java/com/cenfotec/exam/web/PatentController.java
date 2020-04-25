package com.cenfotec.exam.web;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.exam.domain.Patent;
import com.cenfotec.exam.service.IPatentService;

@RestController
@RequestMapping({ "/patents" })
public class PatentController {

	@Autowired
	IPatentService service;

	@PostMapping
	public String savePatent(@RequestBody Patent patent) {

		try {
			patent.setGuid(UUID.randomUUID().toString());
			patent.setEntry_date(new Date());
			service.set(patent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Successfully inserted into queue";
	}

	@GetMapping
	public ResponseEntity<List<Patent>> getAllPatents() {

		return new ResponseEntity<List<Patent>>(service.getAll(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Patent> getPatentById(@PathVariable String id) {
		Optional<Patent> p = null;
		try {
			p = service.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Patent>(HttpStatus.BAD_REQUEST);
		}
		if (p == null)
			return new ResponseEntity<Patent>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Patent>(HttpStatus.OK);
	}

	@GetMapping("/{guid}")
	public ResponseEntity<Patent> getPatentByGuid(@PathVariable String guid) {
		Optional<Patent> p = null;
		try {
			p = service.getByGUID(guid);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Patent>(HttpStatus.BAD_REQUEST);
		}
		if (p == null)
			return new ResponseEntity<Patent>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Patent>(HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Patent> updatePatent(@RequestBody Patent p) throws Exception{

			p.setEntry_date(new Date());
			Patent newPatent = service.update(p);
	
		return new ResponseEntity<Patent>(newPatent, HttpStatus.OK);
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") String id) throws Exception {
		if(service.delete(id)) {
			return (ResponseEntity<?>) ResponseEntity.ok();
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}
