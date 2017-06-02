package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Event implements Comparable<Event>{
	
	public enum EventType{FLUSSO_IN_INGRESSO};
	
	private LocalDate day;
	private float flusso;
	private EventType type;
	
	public Event(LocalDate day , float flusso, EventType type) {
		super();
		this.day = day;
		this.flusso = flusso;
		this.type = type;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDate(LocalDate day) {
		this.day = day;
	}

	public double getFlusso() {
		return flusso;
	}

	public void setFlusso(float flusso) {
		this.flusso = flusso;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Event [time=" + day + ", flusso=" + flusso + ", type=" + type + "]";
	}

	@Override
	public int compareTo(Event other) {
		//TODO
		return 0;
	}
}

