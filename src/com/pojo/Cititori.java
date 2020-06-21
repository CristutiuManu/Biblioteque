package com.pojo;

public class Cititori {

	private int id;
	private String nume;
	private String prenume;
	private String adresa;
	private String localitate;
	private String judet;
	private String telefon;
	private String email;
	
	
	public Cititori() {}
	
	public Cititori(int id, String nume, String prenume, String adresa, String localitate, String judet, String telefon,
			String email) {
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		this.adresa = adresa;
		this.localitate = localitate;
		this.judet = judet;
		this.telefon = telefon;
		this.email = email;
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getLocalitate() {
		return localitate;
	}

	public void setLocalitate(String localitate) {
		this.localitate = localitate;
	}

	public String getJudet() {
		return judet;
	}

	public void setJudet(String judet) {
		this.judet = judet;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
	
	
}
