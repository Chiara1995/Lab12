package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.rivers.model.Event.EventType;

public class Simulator {
	
	//Parametri di simulazione
	private float Q;
	private float C;
	private float f_out_min;
	
	//Stato del mondo
	
	//Variabili d'interesse
	private int numero_giorni_insoddisfatti=0;
	private List<Float> c_med;
	
	//Lista degli eventi
	private PriorityQueue<Event> queue;
	
	public Simulator(float k, float fmed){
		this.queue=new PriorityQueue<>();
		this.Q=k*fmed*30*24*60*60;
		this.C=Q/2;
		this.f_out_min=(float) (0.8*(fmed*24*60*60));
		this.c_med=new ArrayList<>();
	}
	
	public void addFlusso(LocalDate day, float f){
		queue.add(new Event(day, f,EventType.FLUSSO_IN_INGRESSO));
	}

	public int getNumero_giorni_insoddisfatti() {
		return numero_giorni_insoddisfatti;
	}
	
	public float getCmed(){
		float totale=0;
		for(Float f : c_med){
			totale+=f;
		}
		return totale/c_med.size();
	}
	
	public void run(){
		while(!queue.isEmpty()){
			Event e=queue.poll();
			switch(e.getType()){
			case FLUSSO_IN_INGRESSO:
				//flusso in ingresso
				float flusso_in=0;
				flusso_in=(float) (e.getFlusso()*24*60*60);
				//incremento occupazione
				C+=flusso_in;
				float flusso_out=0;
				//probabilità
				float p=(float) Math.random();
				//calcolo flusso out sulla base della probabilità
				if(p<=0.05)
					flusso_out+=this.f_out_min*10;
				else
					flusso_out+=this.f_out_min;
				C-=flusso_out;	
				if(C<0){
					this.numero_giorni_insoddisfatti++;
					C=0;
				}
				if(C>Q){
					//flusso in ingresso eccessivo 
					//tracimazione
					float tracimazione=C-Q;
					C-=tracimazione;					
				}
				c_med.add(C);
				System.out.println(e+"\n"+flusso_in+" "+flusso_out+" "+C);

				break;
			default:
				throw new IllegalArgumentException();
			}
		}
	}
	
}
