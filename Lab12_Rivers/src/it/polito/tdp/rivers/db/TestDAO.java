package it.polito.tdp.rivers.db;

import java.util.List;

import it.polito.tdp.rivers.model.River;

public class TestDAO {
	
	public static void main(String args[]) {

		System.out.println("Elenco fiumi");
		RiverDAO rdao=new RiverDAO();
		List<River> rivers=rdao.getAllRivers();
		for(River r : rivers){
			System.out.println(r);
		}
		
		
	}

}
