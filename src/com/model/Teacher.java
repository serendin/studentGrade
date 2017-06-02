package com.model;

public class Teacher implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String tno;
	private String name;
	private String sex;
	private String birth;
	private String phone;
	
	public Teacher(){
	}
	public Teacher(String tno, String name, String sex, String birth, String phone) {
		super();
		this.tno = tno;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.phone = phone;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


}
