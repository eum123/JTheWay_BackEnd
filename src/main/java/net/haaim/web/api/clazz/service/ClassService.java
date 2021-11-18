package net.haaim.web.api.clazz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.clazz.entity.ClassCurriculumEntity;
import net.haaim.web.api.clazz.entity.ClassEntity;
import net.haaim.web.api.clazz.entity.ClassListResponse;
import net.haaim.web.api.clazz.entity.ClassMembersEntity;
import net.haaim.web.api.clazz.entity.ClassSaveRequest;
import net.haaim.web.api.clazz.entity.DailyClassAttendanceEntity;
import net.haaim.web.api.clazz.entity.WeeklyClassScheduleResponse;
import net.haaim.web.api.clazz.entity.WeeklyClassScheduleVO;
import net.haaim.web.api.clazz.repository.ClassCurriculumMapper;
import net.haaim.web.api.clazz.repository.ClassMapper;
import net.haaim.web.api.clazz.repository.ClassMembersMapper;
import net.haaim.web.api.common.util.DateHelper;

@RequiredArgsConstructor
@Service
public class ClassService {

	private final ClassMapper mapper;
	private final ClassMembersMapper classMembersMapper;
	private final ClassCurriculumMapper classCurriculumMapper;

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
	
	/**
	 * admin에서 사용하는 수업 목록
	 * @param year
	 * @param grade
	 * @param course
	 * @param largeCategory
	 * @param status
	 * @return
	 */
	public Page<ClassListResponse> findAllByYearAndGradeAndCourseAndLargeCategorAndStatus(
			Integer year, String grade, String course, String largeCategory, Integer status) {
		return mapper.findAllByYearAndGradeAndCourseAndLargeCategorAndStatus(year, grade, course, largeCategory, status);
	}
	
	/**
	 * class 저장.
	 * @param entity
	 * @param logonId
	 * @return
	 */
	@Transactional
	public ClassSaveRequest save(ClassSaveRequest entity, String logonId) {
		//class 저장.
		mapper.save(entity);
		
		//class_members 저장.
		saveClassMembers(entity, logonId);
		
		//class_curriculum 저장.
		saveClassCurriculum(entity, logonId);
		
		return entity;
	}

	private void saveClassCurriculum(ClassSaveRequest entity, String logonId) {
		for(Integer curId : entity.getCurriculumList()) {
			classCurriculumMapper.save(ClassCurriculumEntity.builder()
				.classNo(entity.getClassNo())
				.curId(curId)
				.typeGroup("???")
				.cDate(entity.getStartDate())	//TODO : 값확정 필요.
				.cTime(entity.getDayTime())		//TODO : 값확정 필요.
				.build());
		}
	}
	
	private void saveClassMembers(ClassSaveRequest entity, String logonId) {
		//학생 저장.
		for(Integer studentNo : entity.getStudentList()) {
			classMembersMapper.save(ClassMembersEntity.builder()
					.classNo(entity.getClassNo())
					.memberType(0)
					.memberNo(String.valueOf(studentNo))
					.status(1)
					.inputId(logonId)
					.build());
		}
		//선생 저장.
		classMembersMapper.save(ClassMembersEntity.builder()
				.classNo(entity.getClassNo())
				.memberType(2)
				.memberNo(entity.getTeacherId())
				.status(1)
				.inputId(logonId)
				.build());
	}
	
	public WeeklyClassScheduleResponse weeklyClassSchedule(String startDate) {
		String start = startDate;
		if(start == null) {
			start = DateHelper.getStartDateByWeek();
		}
		
		List<WeeklyClassScheduleVO> list = mapper.weeklyClassSchedule(start);
		
		return WeeklyClassScheduleResponse.builder()
			.preDate(DateHelper.getStartDateByLastWeek(start))
			.nextDate(DateHelper.getStartDateByNextWeek(start))
			.list(list)
			.build();
	}
}
