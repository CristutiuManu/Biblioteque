package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import com.helper.DBHelper;
import com.pojo.Carti;

public class CartiDAO {

	public static void insert(Carti carti) throws SQLException {
		Connection con =  DBHelper.getConnection();
		String insertString = "INSERT INTO carti(titlu, data_publicarii, numar_pagini)" + "VALUES(?,?,?)";
		PreparedStatement stmt = con.prepareStatement(insertString);
		stmt.setString(1, carti.getTitlu());
		stmt.setDate(2, carti.getData_publicarii());
		stmt.setInt(3, carti.getNumar_pagini());
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	public static LinkedList<Carti> getAllCarti() throws SQLException {
		Connection con = (Connection) DBHelper.getConnection();
		String query = "SELECT * FROM carti";
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    LinkedList<Carti> results = new LinkedList<Carti>();
	    while(rs.next()) {
	    	int id = rs.getInt("id");
	    	String titlu= rs.getString("titlu");
	    	Date data_publicarii = rs.getDate("data_publicarii");
	    	int numar_pagini = rs.getInt("numar_pagini");
	    	Carti carti = new Carti(id, titlu, data_publicarii, numar_pagini);
	    	results.add(carti);
	    }
	    DBHelper.closeConnection(con);
	    return results;
	}

	public static Carti getCartiById(int id) throws SQLException {
		Connection con = DBHelper.getConnection();
		String query = "SELECT * FROM carti WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Carti carti = null;
		if (rs.next()) {
			int idCarti = rs.getInt("id");
			String titlu = rs.getString("titlu");
			Date data_publicarii = rs.getDate("data_publicarii");
			int numar_pagini = rs.getInt("numar_pagini");
			carti = new Carti(idCarti, titlu, data_publicarii, numar_pagini);
		}

		DBHelper.closeConnection(con);
		return carti;

	}
	
	public static void updateCarti(Carti carti) throws SQLException {
		Connection con = (Connection) DBHelper.getConnection();
		
		String updateString = "UPDATE carti SET titlu = ?, data_publicarii= ?," + "numar_pagini = ? WHERE id = ?"; 
		PreparedStatement stmt = con.prepareStatement(updateString);
		stmt.setString(1, carti.getTitlu());
		stmt.setDate(2, carti.getData_publicarii());
		stmt.setInt(3, carti.getNumar_pagini());
		stmt.setInt(4, carti.getId());
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	
	public static void deleteCarte(int idCarte) throws SQLException {
		
		Connection con =  DBHelper.getConnection();
		String deleteString = "DELETE FROM carti WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1, idCarte);
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	
	public static void deleteCarte(Carti carte) throws SQLException {
		CartiDAO.deleteCarte(carte.getId());
	}
	
	
}
