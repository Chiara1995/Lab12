package it.polito.tdp.rivers.model;

import java.util.List;

public class TestModel {
	
	public static void main(String args[]) {
		
		Model m=new Model();
		List<River> rivers=m.getRivers();
		for(River r : rivers){
			System.out.println(r);
		}
		
		System.out.println("Prima misurazione per il fiume "+rivers.get(5));
		System.out.println(m.getDateFirstMeasure(rivers.get(5).getId()));
		System.out.println("Ultima misurazione per il fiume "+rivers.get(5));
		System.out.println(m.getDateLastMeasure(rivers.get(5).getId()));
		
		System.out.println("Numero totale misurazioni per il fiume "+rivers.get(4).getName());
		System.out.println(m.getNumberMesures(rivers.get(4).getId()));
		System.out.println("Valore medio flusso per il fiume "+rivers.get(4).getName());
		System.out.println(m.getAverageFlow(rivers.get(4).getId()));
		
		System.out.println();
		System.out.println("Elenco misurazioni del fiume "+rivers.get(0).getName());
		List<Flusso> ftemp=m.getFlows(rivers.get(0).getId());
		for(Flusso f : ftemp){
			System.out.println(f);
		}
	}

}
