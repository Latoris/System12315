package com.latoris.consume.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.latoris.consume.beans.ComplaintBean;

public interface ComplaintMapper {
	public ComplaintBean findComplaintByCid(long cid);
	public void addComplaint(ComplaintBean ComplaintBean);
	public void delComplaint(@Param(value="cid")long cid);
	public void updateComplaintById(@Param(value="Complaint")ComplaintBean Complaint, @Param(value="cid")long cid);
	public List<ComplaintBean> findComplaint();
	public List<ComplaintBean> findComplaintByUid(@Param(value="uid")long uid);
}
