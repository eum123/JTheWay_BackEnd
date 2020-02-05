package net.jtheway.web.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jtheway.web.sample.entity.SampleEntity;
import net.jtheway.web.sample.repository.SampleRepository;

@Service
public class SampleService {
	
	@Autowired
	private SampleRepository repo;
	
	public SampleEntity search(String name) {
		return repo.findOne(name);
	}
	
	public List<SampleEntity> searchAll() {
		return repo.findAll();
	}
}
