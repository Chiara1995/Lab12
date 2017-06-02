package it.polito.tdp.rivers.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.rivers.model.Flusso;
import it.polito.tdp.rivers.model.River;
import it.polito.tdp.rivers.model.RiverIdMap;

public class RiverDAO {

	public List<River> getAllRivers(RiverIdMap riverIdMap){
		List<River> rivers=new ArrayList<River>();
		final String sql = "SELECT * FROM river ORDER BY name";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				River r = new River(rs.getInt("id"), rs.getString("name"));	
				r=riverIdMap.put(r);
				rivers.add(r);
			}
			st.close();
			conn.close();

			return rivers;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}		
	}
	
	public LocalDate getDateFirstMeasure(int idRiver){
		LocalDate ld = null;
		final String sql = "SELECT MIN(DATE(day)) AS date "+
							"FROM flow "+
							"WHERE flow.river=? ";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, idRiver);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				ld=rs.getDate("date").toLocalDate();
			}
			st.close();
			conn.close();

			return ld;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}		
	}
	
	public LocalDate getDateLastMeasure(int idRiver){
		LocalDate ld = null;
		final String sql = "SELECT MAX(DATE(day)) AS date "+
							"FROM flow "+
							"WHERE flow.river=? ";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, idRiver);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				ld=rs.getDate("date").toLocalDate();
			}
			st.close();
			conn.close();

			return ld;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}		
	}
	
	public int getNumberMeasures(int idRiver){
		int numero=0;
		final String sql = "SELECT COUNT(*) AS num "+
							"FROM flow "+
							"WHERE flow.river=?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, idRiver);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				numero=rs.getInt("num");
			}
			st.close();
			conn.close();

			return numero;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}		
	}
	
	public float getAverageFlow(int idRiver){
		float fmed = 0;
		final String sql = "SELECT AVG(flow) AS fmed "+
							"FROM flow "+
							"WHERE river=?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, idRiver);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				fmed=rs.getFloat("fmed");
			}
			st.close();
			conn.close();

			return fmed;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}		
	}
	
	public List<Flusso> getAllFlows(int idRiver, RiverIdMap riverIdMap){
		List<Flusso> flussi=new ArrayList<Flusso>();
		final String sql = "SELECT flow.id AS idflusso, DATE(flow.day) AS day, flow.flow, river.name "+
							"FROM flow, river "+
							"WHERE river.id=flow.river AND river.id=? "+
							"ORDER BY DATE(day)";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,idRiver);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				River r = new River(idRiver, rs.getString("name"));	
				r=riverIdMap.put(r);
				Flusso f=new Flusso(rs.getInt("idflusso"), rs.getDate("day").toLocalDate(), rs.getFloat("flow"), r);
				flussi.add(f);
				
			}
			st.close();
			conn.close();

			return flussi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}		
	}
	
}
