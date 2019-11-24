package com.gale.service;
import com.gale.entity.Other;
import java.util.List;

public interface OtherService {
	Other getByID(long ID);
	void addOther(Other other);
	void deleteOther(long ID);
	List<Other> getList();
	List<Other> getByTeacherID(long teacherID);
}