package com.gale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gale.entity.Report;

public interface ReportDao {
	Report queryByID(long reportID);
	void deleteReport(long reportID);
	void addReport(Report report);
	List<Report> queryAll(@Param("offset")int offset, @Param("limit")int limit);
	List<Report> queryByTeacherID(long teacherID);
}
