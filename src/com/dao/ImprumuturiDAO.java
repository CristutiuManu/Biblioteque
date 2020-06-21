package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import com.helper.DBHelper;
import com.pojo.Imprumuturi;

public class ImprumuturiDAO {

	public static void insert(Imprumuturi imprumuturi) throws SQLException {
		Connection con =  DBHelper.getConnection();
		String insertString = "INSERT INTO imprumuturi(id_cititor, id_carte, data_imprumut, data_returnare)" + "VALUES(?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(insertString);
		stmt.setInt(1, imprumuturi.getId_cititor());
		stmt.setInt(2, imprumuturi.getId_carte());
		stmt.setDate(3, imprumuturi.getData_imprumut());
		stmt.setDate(4, imprumuturi.getData_returnare());
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	public static LinkedList<Imprumuturi> getAllImprumuturi() throws SQLException {
		Connection con = (Connection) DBHelper.getConnection();
		String query = "SELECT * FROM imprumuturi";
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    LinkedList<Imprumuturi> results = new LinkedList<Imprumuturi>();
	    while(rs.next()) {
	    	int id = rs.getInt("id");
	    	int id_cititor= rs.getInt("id_cititor");
	    	int id_carte = rs.getInt("id_carte");
	    	Date data_imprumut = rs.getDate("data_imprumut");
	    	Date data_returnare = rs.getDate("data_returnare");
	    	Imprumuturi imprumuturi = new Imprumuturi(id, id_cititor, id_carte, data_imprumut, data_returnare);
	    	results.add(imprumuturi);
	    }
	    DBHelper.closeConnection(con);
	    return results;
	}

	public static Imprumuturi getImprumuturiById(int id) throws SQLException {
		Connection con = DBHelper.getConnection();
		String query = "SELECT * FROM imprumuturi WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Imprumuturi imprumuturi = null;
		if (rs.next()) {
			int idImprumuturi = rs.getInt("id");
			int id_cititor = rs.getInt("id_cititor");
			int id_carte = rs.getInt("id_carte");
			Date data_imprumut = rs.getDate("data_imprumut");
			Date data_returnare = rs.getDate("data_returnare");
			imprumuturi = new Imprumuturi(idImprumuturi, id_cititor, id_carte, data_imprumut, data_returnare);
		}

		DBHelper.closeConnection(con);
		return imprumuturi;
	}

	public static void updateImprumuturi(Imprumuturi imprumuturi) throws SQLException {
		Connection con = (Connection) DBHelper.getConnection();
		String updateString = "UPDATE imprumuturi SET id_cititor=?, id_carte=?, data_imprumut=?, data_returnare=? WHERE id=?"; 
		PreparedStatement stmt = con.prepareStatement(updateString);
		stmt.setInt(1, imprumuturi.getId_cititor());
		stmt.setInt(2, imprumuturi.getId_carte());
		stmt.setDate(3, imprumuturi.getData_imprumut());
		stmt.setDate(4, imprumuturi.getData_returnare());
		stmt.setInt(5, imprumuturi.getId());
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	
	public static void deleteImprumut(int idImprumuturi) throws SQLException {
		
		Connection con =  DBHelper.getConnection();
		String deleteString = "DELETE FROM imprumuturi WHERE id=?";
		PreparedStatement stmt = con.prepareStatement(deleteString);
		stmt.setInt(1, idImprumuturi);
		stmt.executeUpdate();
		DBHelper.closeConnection(con);
	}
	
	public static void deleteImprumut(Imprumuturi imprumut) throws SQLException {
		ImprumuturiDAO.deleteImprumut(imprumut.getId());
	}
	
	
}
