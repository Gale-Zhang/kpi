package com.gale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gale.entity.Other;

public interface OtherDao {
	Other queryByID(long otherID);
	void deleteOther(long otherID);
	void addOther(Other other);
	List<Other> queryAll(@Param("offset")int offset, @Param("limit")int limit);
	List<Other> queryByTeacherID(long teacherID);
}
