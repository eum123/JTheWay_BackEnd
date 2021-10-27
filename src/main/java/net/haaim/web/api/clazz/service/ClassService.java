package net.haaim.web.api.clazz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.clazz.entity.ClassEntity;
import net.haaim.web.api.clazz.entity.DailyClassAttendanceEntity;
import net.haaim.web.api.clazz.repository.ClassMapper;

@RequiredArgsConstructor
@Service
public class ClassService {

	private final ClassMapper mapper;

	public ClassEntity save(ClassEntity entity) {
		
		Integer classNo = mapper.save(entity);
		entity.setClassNo(classNo);
		
		return entity;
	}
	
	public DailyClassAttendanceEntity dailyClassAttendance() {
		return null;
	}
	
	public List<ClassEntity> findAllStatus(Integer status) {
		return mapper.findAllByStatus(status);
	}
}
