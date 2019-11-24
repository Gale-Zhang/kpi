package com.gale.service;
import com.gale.entity.Patent;
import java.util.List;

public interface PatentService {
	Patent getByID(long ID);
	void addPatent(Patent patent);
	void deletePatent(long ID);
	List<Patent> getList();
	List<Patent> getByTeacherID(long teacherID);
}