package net.haaim.web.clazz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.clazz.entity.ClazzEntity;
import net.haaim.web.clazz.repository.ClazzRepository;

@Service
public class ClazzService {
	@Autowired
	private ClazzRepository repo;

	public Page<ClazzEntity> search(Pageable pageable) {
		return repo.findAll(pageable);
	}
}
