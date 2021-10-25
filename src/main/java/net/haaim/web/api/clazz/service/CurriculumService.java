package net.haaim.web.api.clazz.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.clazz.entity.ClassEntity;
import net.haaim.web.api.clazz.entity.CurriculumEntity;
import net.haaim.web.api.clazz.repository.CurriculumMapper;

@RequiredArgsConstructor
@Service
public class CurriculumService {

	private final CurriculumMapper mapper;

	public CurriculumEntity save(CurriculumEntity entity) {
		
		Integer cno = mapper.save(entity);
		entity.setCno(cno);
		
		return entity;
	}
}
