package net.haaim.web.api.exam.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.haaim.web.api.exam.entity.ExamListEntity;

@Mapper
public interface ExamMapper {
	Page<ExamListEntity> findAllByStudentNo(@Param("studentNo") Integer studentNo);
}
