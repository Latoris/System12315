package com.latoris.consume.impl;

import java.util.List;
import com.latoris.consume.beans.ComplaintBean;
import com.latoris.consume.mapper.ComplaintMapper;
public interface ComplaintService{

	public List<ComplaintBean> findComplaint();
	
	public List<ComplaintBean> findComplaintByUid(Long uid);
	
	public void addComplaint(ComplaintBean Complaint);

	public void updateComplaint(ComplaintBean Complaint, long id) ;

	public void delComplaintById(long id);

	public ComplaintBean findComplaintByCid(long cid);
}
