package com.latoris.consume.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.latoris.consume.beans.ComplaintBean;

public interface ComplaintMapper {
	public ComplaintBean findComplaintByCid(@Param(value="cid")long cid);
	public void addComplaint(ComplaintBean ComplaintBean);
	public void delComplaint(@Param(value="cid")long cid);
	public void updateComplaintByCid(@Param(value="complaint")ComplaintBean complaint, @Param(value="cid")long cid);
	public List<ComplaintBean> findComplaint();
	public List<ComplaintBean> findComplaintByUid(@Param(value="uid")long uid);
	}
