package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.helper.DBHelper;
import com.pojo.Autori;


public class AutoriDAO {

	public static void insert(Autori autori) throws SQLException {
		Connection con =  DBHelper.getConnection();
		String insertString = "INSERT INTO autori(nume, prenume, data_nasterii, data_decesului)" + "VALUES(?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(insertString);
		stmt.setString(1, autori.getNume());
		stmt.setString(2, autori.getPrenume());
		stmt.setDate(3, autori.getData_nasterii());
		stmt.setDate(4, autori.getData_decesului());
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	
	public static LinkedList<Autori> getAllAutori() throws SQLException {
		Connection con = (Connection) DBHelper.getConnection();
		String query = "SELECT * FROM autori";
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    LinkedList<Autori> results = new LinkedList<Autori>();
	    while(rs.next()) {
	    	int id = rs.getInt("id");
	    	String nume= rs.getString("nume");
	    	String prenume = rs.getString("prenume");
	    	Date data_nasterii = rs.getDate("data_nasterii");
	    	Date data_decesului = rs.getDate("data_decesului");
	    	Autori autori = new Autori(id, nume, prenume, data_nasterii, data_decesului);
	    	results.add(autori);
	    }
	    DBHelper.closeConnection(con);
	    return results;
	}
	
	
	public static Autori getAutoriById(int id) throws SQLException {
		Connection con = DBHelper.getConnection();
		String query = "SELECT * FROM autori WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Autori autori = null;
		if (rs.next()) {
			int idAutori = rs.getInt("id");
			String nume = rs.getString("nume");
			String prenume = rs.getString("prenume");
			Date data_nasterii = rs.getDate("data_nasterii");
			Date data_decesului = rs.getDate("data_decesului");
			autori = new Autori(idAutori, nume, prenume, data_nasterii, data_decesului);
		}

		DBHelper.closeConnection(con);
		return autori;
	}
	
	public static void updateAutori(Autori autori) throws SQLException {
		Connection con = (Connection) DBHelper.getConnection();
		
		String updateString = "UPDATE autori SET  nume = ?, prenume = ?," + "data_nasterii = ?, data_decesului = ? WHERE id = ?"; 
		PreparedStatement stmt = con.prepareStatement(updateString);
		stmt.setString(1, autori.getNume());
		stmt.setString(2, autori.getPrenume());
		stmt.setDate(3, autori.getData_nasterii());
		stmt.setDate(4, autori.getData_decesului());
		stmt.setInt(5, autori.getId());
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	
	public static void deleteAutor(int idAutor) throws SQLException {
		
		Connection con =  DBHelper.getConnection();
		String deleteString = "DELETE FROM autori WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1, idAutor);
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	
	public static void deleteAutor(Autori autor) throws SQLException {
		AutoriDAO.deleteAutor(autor.getId());
	}
	
	
}
