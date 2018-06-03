package com.latoris.consume.beans;

import java.sql.Date;

public class UserBean {
	
	private long uid;
	private int card_type;
	private String card_num;
	private String sex;
	private Date birthday;
	private String name;
	private String username;
	private String password;
	private String phone;
	private String addr;
	
	@Override
	public String toString() {
		return "UserBean [uid=" + uid + ", card_type=" + card_type + ", card_num=" + card_num + ", sex=" + sex
				+ ", birthday=" + birthday + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", phone=" + phone + ", addr=" + addr + "]";
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public int getCard_type() {
		return card_type;
	}
	public void setCard_type(int card_type) {
		this.card_type = card_type;
	}
	public String getCard_num() {
		return card_num;
	}
	public void setCard_num(String card_num) {
		this.card_num = card_num;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

}
