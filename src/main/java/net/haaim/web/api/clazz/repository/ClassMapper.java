package net.haaim.web.api.clazz.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
	
	/**
	 * class 목록.
	 * @return
	 */
	@Select("SELECT class_no, year, class_name, start_date "
			+ ", end_date, day_time, textbook, pass_score, description "
			+ ", status, input_id, input_date, update_id, update_date "
			+ "FROM class "
			+ "WHERE status = #{status} "
			+ "ORDER BY input_date DESC ")
	List<ClassEntity> findAllByStatus(@Param("status") Integer status);
}
