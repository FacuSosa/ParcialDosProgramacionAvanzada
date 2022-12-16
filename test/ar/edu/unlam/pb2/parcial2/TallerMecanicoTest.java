package ar.edu.unlam.pb2.parcial2;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.pb2.parcial2.Cliente;
import ar.edu.unlam.pb2.parcial2.NoHayClientesException;
import ar.edu.unlam.pb2.parcial2.Reloj;
import ar.edu.unlam.pb2.parcial2.Taller;

public class TallerMecanicoTest {

	private static final long TIEMPO_MEDIO_NO_ATENDIDOS = 15;
	private static final long TIEMPO_MEDIO_ATENDIDOS = 30;

	@Test
	public void sePuedeAgregarCliente() {
		Taller taller = new Taller();
		Cliente cliente = new Cliente(12345, "Ariel");

		taller.nuevoCliente(cliente);

		Assert.assertEquals(taller.getNoAtendidos().size(), 1);
	}

	@Test(expected = NoHayClientesException.class)
	public void atenderClienteTiraException() throws NoHayClientesException {
		Taller taller = new Taller();
		Cliente cliente = new Cliente(12345, "Ariel");
		

		Cliente clienteAtendido = taller.atenderCliente(cliente);
	}

	@Test
	public void atenderCliente() throws NoHayClientesException {
		Taller taller = new Taller();
		Cliente cliente = new Cliente(12345, "Ariel");
		taller.nuevoCliente(cliente);

		taller.atenderCliente(cliente);

		Assert.assertTrue(taller.getAtendidos().size() == 1 && taller.getNoAtendidos().size() == 0);
	}

	@Test
	public void tiempoEntreNoAtendidos() throws NoHayClientesException {
		Taller taller = new Taller();

		Cliente cliente = new Cliente(12345, "Ariel", Reloj.ahora());

		Cliente cliente2 = new Cliente(54321, "Pablo", Reloj.ahora());

		taller.nuevoCliente(cliente);
		taller.nuevoCliente(cliente2);

		long tiempo = taller.getTiempoEntreNoAtendidos();

		Assert.assertEquals(tiempo, TIEMPO_MEDIO_NO_ATENDIDOS);
	}

	@Test
	public void tiempoEntreAtendidos() throws NoHayClientesException {
		Taller taller = new Taller();
		Cliente cliente = new Cliente(12345, "Ariel", Reloj.ahora());
		Cliente cliente2 = new Cliente(54321, "Pablo", Reloj.ahora());

		taller.nuevoCliente(cliente);
		taller.nuevoCliente(cliente2);

		taller.atenderCliente(cliente2);
		taller.atenderCliente(cliente);

		long tiempo = taller.getTiempoEntreAtendidos();

		Assert.assertEquals(tiempo, TIEMPO_MEDIO_ATENDIDOS);
	}

	@Test
	public void cantidadClientesEnEspera() {
		Taller taller = new Taller();
		Cliente cliente = new Cliente(12345, "Ariel", Reloj.ahora());
		Cliente cliente2 = new Cliente(54321, "Pablo", Reloj.ahora());

		taller.nuevoCliente(cliente);
		taller.nuevoCliente(cliente2);

		Assert.assertEquals(taller.getClientesEnEspera(), (Integer) 2);
	}

	@Test
	public void cantidadClientesAtendidos() throws NoHayClientesException {
		Taller taller = new Taller();
		Cliente cliente = new Cliente(12345, "Ariel", Reloj.ahora());
		Cliente cliente2 = new Cliente(54321, "Pablo", Reloj.ahora());

		taller.nuevoCliente(cliente);
		taller.nuevoCliente(cliente2);

		taller.atenderCliente(cliente2);
		taller.atenderCliente(cliente);

		Assert.assertEquals(taller.getClientesAtendidos(), (Integer) 2);
	}

}
