package it.polito.tdp.rivers.model;

import java.util.List;

import it.polito.tdp.rivers.db.RiverDAO;

public class Model {
	
	List<River> rivers;
	
	public List<River> getRivers(){
		if(rivers==null){
			RiverDAO rdao=new RiverDAO();
			rivers=rdao.getAllRivers();
		}
		return rivers;
	}

}
