package com.gale.service;
import java.util.List;

import com.gale.entity.Teacher;

public interface KpiService {
	List<Float> calKPI(long teacherID);
	List<List<Float>> calKPI(List<Teacher> teachers);
	List<String> getDetail(long teacherID);
}