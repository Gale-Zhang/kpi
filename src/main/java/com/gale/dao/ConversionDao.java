package com.gale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gale.entity.Conversion;

public interface ConversionDao {
	Conversion queryByID(long conversionID);
	void deleteConversion(long conversionID);
	void addConversion(Conversion conversion);
	List<Conversion> queryAll(@Param("offset")int offset, @Param("limit")int limit);
	List<Conversion> queryByTeacherID(long teacherID);
}
