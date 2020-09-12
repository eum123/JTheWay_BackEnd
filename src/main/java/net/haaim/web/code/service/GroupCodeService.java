package net.haaim.web.code.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.haaim.web.code.entity.GroupCodeEntity;
import net.haaim.web.code.repository.GroupCodeRepository;

@Service
public class GroupCodeService {
	@Autowired
	private GroupCodeRepository repo;

	public List<GroupCodeEntity> searchAll() {
		return repo.findAll();
	}

	public GroupCodeEntity save(String code, String codeName) {
		GroupCodeEntity entity = GroupCodeEntity.builder().code(code).codeName(codeName).inputDate(new Date())
				.inputId("id").build();
		
		return repo.saveAndFlush(entity);
	}
}
