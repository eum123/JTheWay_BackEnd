package net.haaim.web.clazz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.clazz.entity.ClazzDTO;
import net.haaim.web.clazz.entity.CurriculumEntity;
import net.haaim.web.clazz.repository.ClazzRepositoryJOOQ;
import net.haaim.web.common.User;

@Service
public class ClazzService {
	@Autowired
	private ClazzRepositoryJOOQ repo;

	
	public Page<ClazzDTO> search(Pageable pageable) {
		//return repo.findAllByOrderByClassNoDesc(pageable);
		return repo.findAllByOrderByNoDesc(pageable);
	}

	public Page<CurriculumEntity> search(Integer year, Integer grade, Integer course, String largeCategory,
			Pageable pageable) {
		return null;
	}
	
	public ClazzDTO regist(User user, Integer year, Integer grade, Integer course, String largeCategory, String mediumCategory) {
//		ClazzEntity entity = ClazzEntity.builder()
//			.year(year)
//			.inputDate(new Date())
//			.inputId(user.getId())
//			.build();
//		return repo.save(entity);
		return null;
	}
}
