package com.latoris.consume.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.latoris.consume.beans.ComplaintBean;
import com.latoris.consume.impl.ComplaintService;
import com.latoris.consume.mapper.ComplaintMapper;
@Service
public class ComplaintServiceImpl implements ComplaintService{
	
	@Autowired
	private ComplaintMapper mapper;
	
	@Override
	public List<ComplaintBean> findComplaint(){
		return mapper.findComplaint();
		
	}
	@Override
	public List<ComplaintBean> findComplaintByUid(Long uid){
		return mapper.findComplaintByUid(uid);
	}
	@Override
	public void addComplaint(ComplaintBean Complaint) {
		if(Complaint != null){
			mapper.addComplaint(Complaint);
		}
		
	}
	@Override
	public void updateComplaint(ComplaintBean Complaint, long l) {
		mapper.updateComplaintByCid(Complaint, l);
	}
	@Override
	public void delComplaintById(long id) {
		// TODO Auto-generated method stub
		mapper.delComplaint(id);
	}
	@Override
	public ComplaintBean findComplaintByCid(long cid) {
		// TODO Auto-generated method stub
		return mapper.findComplaintByCid(cid);
	}
}