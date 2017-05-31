package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.List;

import it.polito.tdp.rivers.db.RiverDAO;

public class Model {
	
	List<River> rivers;
	RiverDAO rdao;
	
	public Model(){
		rdao=new RiverDAO();
	}
	
	public List<River> getRivers(){
		if(rivers==null){
			rivers=rdao.getAllRivers();
		}
		return rivers;
	}
	
	public LocalDate getDateFirstMeasure(int idRiver){
		return rdao.getDateFirstMeasure(idRiver);
	}
	
	public LocalDate getDateLastMeasure(int idRiver){
		return rdao.getDateLastMeasure(idRiver);
	}
	
	public int getNumberMesures(int idRiver){
		return rdao.getNumberMeasures(idRiver);
	}
	
	public float getAverageFlow(int idRiver){
		return rdao.getAverageFlow(idRiver);
	}

}
