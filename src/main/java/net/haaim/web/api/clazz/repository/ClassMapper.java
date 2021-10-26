package net.haaim.web.api.clazz.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import net.haaim.web.api.clazz.entity.ClassEntity;
import net.haaim.web.api.clazz.entity.DailyClassAttendanceEntity;

@Mapper
public interface ClassMapper {
	
	@Insert("INSERT INTO class (year, class_name, start_date, end_date, day_time"
			+ ", textbook, pass_score, description, status, input_id"
			+ ", input_date) "
			+ "VALUES (#{year}, #{className}, #{startDate}"
			+ ", #{endDate}, #{dayTime}, #{textbook}"
			+ ", #{passScore}, #{description}, #{status}"
			+ ", #{inputId}, NOW())")
	@Options(useGeneratedKeys = true, keyProperty = "class_no")
	Integer save(ClassEntity entity);
	
	/**
	 * 일별 출결 현황.
	 * @return
	 */
	DailyClassAttendanceEntity dailyClassAttendance();
}
