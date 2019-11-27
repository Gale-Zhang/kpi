package com.gale.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import com.gale.dao.ConversionDao;
import com.gale.entity.Conversion;
import com.gale.service.ConversionService;

@Service
public class ConversionServiceImpl implements ConversionService{
	@Autowired
	private ConversionDao conversionDao;
	@Override
	public Conversion getByID(long conversionID) {
		return  conversionDao.queryByID(conversionID);
	}
	@Override
	public List<Conversion> getList(){
		return conversionDao.queryAll(0, 1000);
	}
	@Override
	public void addConversion(Conversion conversion) {
		conversionDao.addConversion(conversion);
	}
	@Override
	public void deleteConversion(long conversionID) {
		conversionDao.deleteConversion(conversionID);
	}
	@Override 
	public List<Conversion> getByTeacherID(long teacherID) {
		return conversionDao.queryByTeacherID(teacherID);
	}
}
