package com.gale.service;
import com.gale.entity.Conversion;
import java.util.List;

public interface ConversionService {
	Conversion getByID(long ID);
	void addConversion(Conversion conversion);
	void deleteConversion(long ID);
	List<Conversion> getList();
	List<Conversion> getByTeacherID(long teacherID);
}