package ar.edu.unlam.pb2.parcial2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Taller {
	private static final long TIEMPO_DE_SIMULACION_NO_ATENDIDOS = 15; 
	private static final long TIEMPO_DE_SIMULACION_ATENDIDOS = 30; 

	private Set<Cliente> listaClientesNoAtendidos;
	private List<Cliente> listaClientesAtendidos;

	public Taller() {
		this.listaClientesNoAtendidos = new HashSet<Cliente>();
		this.listaClientesAtendidos = new LinkedList<Cliente>();
	}

	public void nuevoCliente(Cliente cliente) {
		this.listaClientesNoAtendidos.add(cliente);
	}

	public Set<Cliente> getNoAtendidos() {
		return this.listaClientesNoAtendidos;
	}

	public List<Cliente> getAtendidos() {
		return this.listaClientesAtendidos;
	}

	public Cliente atenderCliente(Cliente cliente) throws NoHayClientesException {

		if (this.listaClientesNoAtendidos.size() == 0) {
			throw new NoHayClientesException("No hay clientes");
		} else {
			this.listaClientesNoAtendidos.remove(cliente);
			this.listaClientesAtendidos.add(cliente);
			cliente.setAtencion(Reloj.ahora());
			return cliente;
		}

	}

	public long getTiempoEntreNoAtendidos() {
		long tiempo = 0;

		for (Cliente cliente : this.listaClientesNoAtendidos) {
			tiempo += Reloj.ahora() - cliente.getHoraLlegada() + TIEMPO_DE_SIMULACION_NO_ATENDIDOS * 60000;
		}

		return (tiempo / 60000) / this.listaClientesNoAtendidos.size();

	}

	public long getTiempoEntreAtendidos() {
		long tiempo = 0;

		for (Cliente cliente : this.listaClientesAtendidos) {
			tiempo += Reloj.ahora() - cliente.getHoraLlegada() + TIEMPO_DE_SIMULACION_ATENDIDOS * 60000;
		}

		return (tiempo / 60000) / this.listaClientesAtendidos.size();
	}

	public Integer getClientesEnEspera() {
		return this.listaClientesNoAtendidos.size();
	}

	public Integer getClientesAtendidos() {
		return this.listaClientesAtendidos.size();
	}

}
