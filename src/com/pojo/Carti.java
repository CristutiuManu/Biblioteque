package com.pojo;

import java.sql.Date;

public class Carti {

	private int id;
	private String titlu;
	private Date data_publicarii;
	private int numar_pagini;
	
	public Carti(int id, String titlu, Date data_publicarii, int numar_pagini) {
		super();
		this.id = id;
		this.titlu = titlu;
		this.data_publicarii = data_publicarii;
		this.numar_pagini = numar_pagini;
	}
	public Carti() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public Date getData_publicarii() {
		return data_publicarii;
	}

	public void setData_publicarii(Date data_publicarii) {
		this.data_publicarii = data_publicarii;
	}

	public int getNumar_pagini() {
		return numar_pagini;
	}

	public void setNumar_pagini(int numar_pagini) {
		this.numar_pagini = numar_pagini;
	}				
}
