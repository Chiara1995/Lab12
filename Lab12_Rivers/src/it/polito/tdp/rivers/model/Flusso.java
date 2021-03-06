package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Flusso {
	
	private int id;
	private LocalDate day;
	private float flow;
	private River river;
	
	public Flusso(int id, LocalDate day, float flow, River river) {
		super();
		this.id = id;
		this.day = day;
		this.flow = flow;
		this.river = river;
	}

	public int getId() {
		return id;
	}

	public void setId(int idFlusso) {
		this.id = idFlusso;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public float getFlow() {
		return flow;
	}

	public void setFlow(float flow) {
		this.flow = flow;
	}

	public River getRiver() {
		return river;
	}

	public void setRiver(River river) {
		this.river = river;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flusso other = (Flusso) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flusso [id=" + id + ", day=" + day + ", flow=" + flow + ", river=" + river + "]";
	}

}

