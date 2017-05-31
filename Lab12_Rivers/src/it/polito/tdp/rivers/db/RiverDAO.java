package it.polito.tdp.rivers.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.rivers.model.River;

public class RiverDAO {

	public List<River> getAllRivers(){
		List<River> rivers=new ArrayList<River>();
		final String sql = "SELECT * FROM river";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				River r = new River(rs.getInt("id"), rs.getString("name"));	
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
	

	
}
