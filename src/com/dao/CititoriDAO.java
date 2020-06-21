package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import com.helper.DBHelper;
import com.pojo.Cititori;

public class CititoriDAO {

	public static void insert(Cititori cititori) throws SQLException {
		Connection con =  DBHelper.getConnection();
		String insertString = "INSERT INTO cititori(nume, prenume, adresa, localitate, judet, telefon, email)" + "VALUES(?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(insertString);
		stmt.setString(1, cititori.getNume());
		stmt.setString(2, cititori.getPrenume());
		stmt.setString(3, cititori.getAdresa());
		stmt.setString(4, cititori.getLocalitate());
		stmt.setString(5, cititori.getJudet());
		stmt.setString(6, cititori.getTelefon());
		stmt.setString(7, cititori.getEmail());
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	public static LinkedList<Cititori> getAllCititori() throws SQLException {
		Connection con = (Connection) DBHelper.getConnection();
		String query = "SELECT * FROM cititori";
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    LinkedList<Cititori> results = new LinkedList<Cititori>();
	    while(rs.next()) {
	    	int id = rs.getInt("id");
	    	String nume= rs.getString("nume");
	    	String prenume = rs.getString("prenume");
	    	String adresa = rs.getString("adresa");
	    	String localitate = rs.getString("localitate");
	    	String judet = rs.getString("judet");
	    	String telefon= rs.getString("telefon");
	    	String email = rs.getString("email");
	    	Cititori cititori = new Cititori(id, nume, prenume, adresa, localitate, judet, telefon, email);
	    	results.add(cititori);
	    }
	    DBHelper.closeConnection(con);
	    return results;
	}

	public static Cititori getCititoriById(int id) throws SQLException {
		Connection con = DBHelper.getConnection();
		String query = "SELECT * FROM cititori WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Cititori cititori = null;
		if (rs.next()) {
			int idCititori = rs.getInt("id");
			String nume = rs.getString("nume");
			String prenume = rs.getString("prenume");
			String adresa = rs.getString("adresa");
			String localitate = rs.getString("localitate");
			String judet = rs.getString("judet");
			String telefon = rs.getString("telefon");
			String email = rs.getString("email");
			cititori = new Cititori(idCititori, nume, prenume, adresa, localitate, judet, telefon, email);
		}

		DBHelper.closeConnection(con);
		return cititori;

	}
	
	public static void updateCititori(Cititori cititori) throws SQLException {
		Connection con = (Connection) DBHelper.getConnection();
		String updateString = "UPDATE cititori SET nume = ?, prenume= ?,adresa = ?, localitate = ?, judet = ?, telefon = ?, email = ? WHERE id = ?"; 
		PreparedStatement stmt = con.prepareStatement(updateString);
		stmt.setString(1, cititori.getNume());
		stmt.setString(2, cititori.getPrenume());
		stmt.setString(3, cititori.getAdresa());
		stmt.setString(4, cititori.getLocalitate());
		stmt.setString(5, cititori.getJudet());
		stmt.setString(6, cititori.getTelefon());
		stmt.setString(7, cititori.getEmail());
		stmt.setInt(8, cititori.getId());
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	
	public static void deleteCarte(int idCititori) throws SQLException {
		
		Connection con =  DBHelper.getConnection();
		String deleteString = "DELETE FROM cititori WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1, idCititori);
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	
	public static void deleteCarte(Cititori carte) throws SQLException {
		CititoriDAO.deleteCarte(carte.getId());
	}
	
	
}
