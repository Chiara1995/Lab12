package it.polito.tdp.rivers.db;

import java.util.List;

import it.polito.tdp.rivers.model.Flusso;
import it.polito.tdp.rivers.model.River;
import it.polito.tdp.rivers.model.RiverIdMap;

public class TestDAO {
	
	public static void main(String args[]) {

		System.out.println("Elenco fiumi");
		RiverDAO rdao=new RiverDAO();
		RiverIdMap riverIdMap=new RiverIdMap();
		List<River> rivers=rdao.getAllRivers(riverIdMap);
		for(River r : rivers){
			System.out.println(r);
		}
		
		System.out.println("Prima misurazione disponibile per il fiume "+rivers.get(0).getName());
		System.out.println(rdao.getDateFirstMeasure(rivers.get(0).getId()));
		
		System.out.println("Ultima misurazione disponibile per il fiume "+rivers.get(0).getName());
		System.out.println(rdao.getDateLastMeasure(rivers.get(0).getId()));
		
		System.out.println("Numero totale misurazioni per il fiume "+rivers.get(0).getName());
		System.out.println(rdao.getNumberMeasures(rivers.get(0).getId()));
		
		System.out.println("Valore medio del flusso per il fiume "+rivers.get(0).getName());
		System.out.println(rdao.getAverageFlow(rivers.get(0).getId()));
		
		System.out.println();
		System.out.println("Misurazionizi del fiume "+rivers.get(0).getName());
		List<Flusso> ftemp=rdao.getAllFlows(rivers.get(0).getId(), riverIdMap);
		for(Flusso f : ftemp){
			System.out.println(f);
		}
		
	}

}
