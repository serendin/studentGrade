package com.model;

public class Course implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String cno;
    private String name;
    private int credit;
    private int period;
    
    public Course(){
    }
	public Course(String cno, String name, int credit, int period) {
		super();
		this.cno = cno;
		this.name = name;
		this.credit = credit;
		this.period = period;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}

}
