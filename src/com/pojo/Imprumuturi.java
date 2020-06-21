package com.pojo;

import java.sql.Date;

public class Imprumuturi {

	private int id;
	private int id_cititor;
	private int id_carte;
	private Date data_imprumut;
	private Date data_returnare;

	public Imprumuturi() {}

	public Imprumuturi(int id, int id_cititor, int id_carte, Date data_imprumut, Date data_returnare) {
		this.id = id;
		this.id_cititor = id_cititor;
		this.id_carte = id_carte;
		this.data_imprumut = data_imprumut;
		this.data_returnare = data_returnare;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_cititor() {
		return id_cititor;
	}

	public void setId_cititor(int id_cititor) {
		this.id_cititor = id_cititor;
	}

	public int getId_carte() {
		return id_carte;
	}

	public void setId_carte(int id_carte) {
		this.id_carte = id_carte;
	}

	public Date getData_imprumut() {
		return data_imprumut;
	}

	public void setData_imprumut(Date data_imprumut) {
		this.data_imprumut = data_imprumut;
	}

	public Date getData_returnare() {
		return data_returnare;
	}

	public void setData_returnare(Date data_returnare) {
		this.data_returnare = data_returnare;
	}
}
