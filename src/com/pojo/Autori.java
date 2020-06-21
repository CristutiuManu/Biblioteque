package com.pojo;

import java.sql.Date;

public class Autori {
	
	private int id;
	private String nume;
	private String prenume;
	private Date data_nasterii;
	private Date data_decesului;
	
	public Autori() {}
	
	public Autori(int id, String nume, String prenume, Date data_nasterii, Date data_decesului) {
		
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		this.data_nasterii = data_nasterii;
		this.data_decesului = data_decesului;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public Date getData_nasterii() {
		return data_nasterii;
	}

	public void setData_nasterii(Date data_nasterii) {
		this.data_nasterii = data_nasterii;
	}

	public Date getData_decesului() {
		return data_decesului;
	}

	public void setData_decesului(Date data_decesului) {
		this.data_decesului = data_decesului;
	}
	
	
	
	
	
	

}
