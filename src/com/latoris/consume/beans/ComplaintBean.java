package com.latoris.consume.beans;

import java.sql.Timestamp;

public class ComplaintBean {

	public ComplaintBean(long cid, long uid, String eid, String merchandise_name, Timestamp submit_time,
			Timestamp happen_time, int purchase_way, int problem_type, String complaint_content, String appeal_type,
			String count, int amount, int status, long iid) {
		super();
		this.cid = cid;
		this.uid = uid;
		this.eid = eid;
		this.merchandise_name = merchandise_name;
		this.submit_time = submit_time;
		this.happen_time = happen_time;
		this.purchase_way = purchase_way;
		this.problem_type = problem_type;
		this.complaint_content = complaint_content;
		this.appeal_type = appeal_type;
		this.count = count;
		this.amount = amount;
		this.status = status;
		this.iid = iid;
	}
	@Override
	public String toString() {
		return "ComplaintBean [cid=" + cid + ", uid=" + uid + ", eid=" + eid + ", merchandise_name=" + merchandise_name
				+ ", submit_time=" + submit_time + ", happen_time=" + happen_time + ", purchase_way=" + purchase_way
				+ ", problem_type=" + problem_type + ", complaint_content=" + complaint_content + ", appeal_type="
				+ appeal_type + ", count=" + count + ", amount=" + amount + ", status=" + status + ", iid=" + iid + "]";
	}
	private long cid;
	private long uid;
	private String eid;
	private String merchandise_name;
	private Timestamp submit_time;
	private Timestamp happen_time;
	private int purchase_way;
	private int problem_type;
	private String complaint_content;
	private String appeal_type;
	private String count;
	private int amount;
	private int status;
	private long iid;
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getMerchandise_name() {
		return merchandise_name;
	}
	public void setMerchandise_name(String merchandise_name) {
		this.merchandise_name = merchandise_name;
	}
	public Timestamp getSubmit_time() {
		return submit_time;
	}
	public void setSubmit_time(Timestamp submit_time) {
		this.submit_time = submit_time;
	}
	public Timestamp getHappen_time() {
		return happen_time;
	}
	public void setHappen_time(Timestamp happen_time) {
		this.happen_time = happen_time;
	}
	public int getPurchase_way() {
		return purchase_way;
	}
	public void setPurchase_way(int purchase_way) {
		this.purchase_way = purchase_way;
	}
	public int getProblem_type() {
		return problem_type;
	}
	public void setProblem_type(int problem_type) {
		this.problem_type = problem_type;
	}
	public String getComplaint_content() {
		return complaint_content;
	}
	public void setComplaint_content(String complaint_content) {
		this.complaint_content = complaint_content;
	}
	public String getAppeal_type() {
		return appeal_type;
	}
	public void setAppeal_type(String appeal_type) {
		this.appeal_type = appeal_type;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getIid() {
		return iid;
	}
	public void setIid(long iid) {
		this.iid = iid;
	}
	
}
