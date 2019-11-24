package com.gale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gale.entity.Patent;

public interface PatentDao {
	Patent queryByID(long paperID);
	void deletePatent(long paperID);
	void addPatent(Patent patent);
	List<Patent> queryAll(@Param("offset")int offset, @Param("limit")int limit);
	List<Patent> queryByTeacherID(long teacherID);
}
