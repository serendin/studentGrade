package com.model;

public class Student implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String sno;
	private String name;
	private String sex;
	private String birth;
	private String sclass;
	private String phone;

	public Student() {
		super();
	}

	public Student(String sno, String name, String sex, String birth, String sclass, String phone) {
		super();
		this.sno = sno;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.sclass = sclass;
		this.phone = phone;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
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

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
