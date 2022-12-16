package ar.edu.unlam.pb2.parcial2;

import java.util.Calendar;

public class Cliente {
	
	private Integer movil;
	private String nombre;

	private long llegada;
	private long atencion;

	public Cliente(Integer movil, String nombre) {
		this.movil = movil;
		this.nombre = nombre;
	}

	public Cliente(Integer movil, String nombre, long llegada) {
		this.movil = movil;
		this.nombre = nombre;
		this.llegada = llegada;
	}

	public void setAtencion(long hora) {
		this.atencion = hora;

	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	public long getHoraLlegada() {
		return this.llegada;
	}

}
