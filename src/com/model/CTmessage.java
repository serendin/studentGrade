package com.model;

public class CTmessage implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String cno;
    private String name;
    private int credit;
    private int period;
    private String tname;
    
	public CTmessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CTmessage(int id,String cno, String name, int credit, int period, String tname) {
		super();
		this.id=id;
		this.cno = cno;
		this.name = name;
		this.credit = credit;
		this.period = period;
		this.tname = tname;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
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
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}

}
