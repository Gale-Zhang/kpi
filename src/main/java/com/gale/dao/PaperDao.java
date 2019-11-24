package com.gale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gale.entity.Paper;

public interface PaperDao {
	Paper queryByID(long paperID);
	void deletePaper(long paperID);
	void addPaper(Paper paper);
	List<Paper> queryAll(@Param("offset")int offset, @Param("limit")int limit);
	List<Paper> queryByTeacherID(long teacherID);
}
