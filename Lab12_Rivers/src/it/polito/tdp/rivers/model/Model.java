package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.List;

import it.polito.tdp.rivers.db.RiverDAO;

public class Model {
	
	private List<River> rivers;
	private RiverDAO rdao;
	private RiverIdMap riverIdMap;
	
	
	public Model(){
		rdao=new RiverDAO();
		riverIdMap=new RiverIdMap();
	}
	
	public List<Flusso> getFlows(int idRiver){
		return rdao.getAllFlows(idRiver, riverIdMap);
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

	public String simulazione(River r, float fmed, float k) {
		Simulator simulator=new Simulator(k,fmed);
		LocalDate ld = this.getFlows(r.getId()).get(0).getDay().minusDays(1);
		for(Flusso f : this.getFlows(r.getId())){
			ld.plusDays(1);
			simulator.addFlusso(ld, f.getFlow());
		}
		simulator.run();
		String result="Numero flussi in uscita non soddisfatti "+simulator.getNumero_giorni_insoddisfatti()+"\n";
		result+="Occupazione media bacino "+simulator.getCmed();
		return result;
	}

}
