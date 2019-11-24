package com.gale.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import com.gale.dao.FundingDao;
import com.gale.entity.Funding;
import com.gale.service.FundingService;

@Service
public class FundingServiceImpl implements FundingService{
	@Autowired
	private FundingDao fundingDao;
	@Override
	public Funding getByID(long fundingID) {
		return  fundingDao.queryByID(fundingID);
	}
	@Override
	public List<Funding> getList(){
		return fundingDao.queryAll(0, 1000);
	}
	@Override
	public void addFunding(Funding funding) {
		fundingDao.addFunding(funding);
	}
	@Override
	public void deleteFunding(long fundingID) {
		fundingDao.deleteFunding(fundingID);
	}
	@Override 
	public List<Funding> getByTeacherID(long teacherID) {
		return fundingDao.queryByTeacherID(teacherID);
	}
}
