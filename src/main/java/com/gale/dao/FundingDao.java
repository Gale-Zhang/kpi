package com.gale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gale.entity.Funding;

public interface FundingDao {
	Funding queryByID(long fundingID);
	void deleteFunding(long fundingID);
	void addFunding(Funding funding);
	List<Funding> queryAll(@Param("offset")int offset, @Param("limit")int limit);
	List<Funding> queryByTeacherID(long teacherID);
}
