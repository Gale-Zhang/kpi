package com.gale.service;
import com.gale.entity.Funding;
import java.util.List;

public interface FundingService {
	Funding getByID(long ID);
	void addFunding(Funding funding);
	void deleteFunding(long ID);
	List<Funding> getList();
	List<Funding> getByTeacherID(long teacherID);
}