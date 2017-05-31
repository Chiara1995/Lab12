package it.polito.tdp.rivers.model;

import java.util.List;

public class TestModel {
	
	public static void main(String args[]) {
		
		Model m=new Model();
		List<River> rivers=m.getRivers();
		for(River r : rivers){
			System.out.println(r);
		}
		
	}

}
