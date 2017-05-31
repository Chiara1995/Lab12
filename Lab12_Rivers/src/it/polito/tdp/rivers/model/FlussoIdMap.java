package it.polito.tdp.rivers.model;

import java.util.HashMap;
import java.util.Map;

public class FlussoIdMap {
	
	private Map<Integer, Flusso> mappa;
	
	public FlussoIdMap(){
		mappa=new HashMap<>();
	}
	
	public Flusso getFlusso(int id){
		return mappa.get(id);
	}
	
	public Flusso put(Flusso flusso){
		Flusso old=mappa.get(flusso.getId());
		if(old==null){
			mappa.put(flusso.getId(), flusso);
			return flusso;
		}
		else
			return old;
	}

}
