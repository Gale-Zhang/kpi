package com.gale.service;
import com.gale.entity.Paper;
import java.util.List;

public interface PaperService {
	Paper getByID(long ID);
	void addPaper(Paper paper);
	void deletePaper(long ID);
	List<Paper> getList();
	List<Paper> getByTeacherID(long teacherID);
}