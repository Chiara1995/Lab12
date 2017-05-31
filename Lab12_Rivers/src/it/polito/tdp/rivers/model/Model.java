package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.List;

import it.polito.tdp.rivers.db.RiverDAO;

public class Model {
	
	private List<River> rivers;
	private List<Flusso> flows;
	private RiverDAO rdao;
	private RiverIdMap riverIdMap;
	private FlussoIdMap flussoIdMap;
	
	
	public Model(){
		rdao=new RiverDAO();
		riverIdMap=new RiverIdMap();
		flussoIdMap=new FlussoIdMap();
	}
	
	public List<Flusso> getFlows(){
		if(flows==null){
			flows=rdao.getAllFlows(flussoIdMap);
		}
		return flows;
	}
	
	public List<River> getRivers(){
		if(rivers==null){
			rivers=rdao.getAllRivers(riverIdMap);
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
