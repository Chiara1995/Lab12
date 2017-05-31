package it.polito.tdp.rivers.model;

import java.util.HashMap;
import java.util.Map;

public class RiverIdMap {
	
	private Map<Integer, River> mappa;
	
	public RiverIdMap(){
		mappa=new HashMap<>();
	}
	
	public River getRiver(int id){
		return mappa.get(id);
	}
	
	public River put(River r){
		River old=mappa.get(r.getId());
		if(old==null){
			mappa.put(r.getId(),  r);
			return r;
		}
		else 
			return old;
	}

}
