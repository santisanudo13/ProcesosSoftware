

import static org.junit.Assert.*;

import java.util.Calendar;



import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;
import es.unican.ps.banco.dominio.casoB.Cuenta;
import es.unican.ps.banco.dominio.casoB.Debito;
import es.unican.ps.banco.dominio.casoB.OperacionNoAceptadaException;

public class DebitoTest {
	
	private static Cuenta cuenta = mock(Cuenta.class);
	private static Debito tarjeta;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		doThrow(new OperacionNoAceptadaException()).when(cuenta).retirar("Retirada en cajero automatico", 200.0);
		

		doThrow(new OperacionNoAceptadaException()).when(cuenta).ingresar(anyString(), eq(-50.0));
		//doThrow(new OperacionNoAceptadaException()).when(cuenta).ingresar("Ingreso en cajero autom�tico", -50);
		
		doThrow(new OperacionNoAceptadaException()).when(cuenta).retirar("Compra en Zara", 150);
		
		when(cuenta.getSaldo()).thenReturn(100.0);
		
		tarjeta = new Debito("1", "Pepe", Calendar.getInstance().getTime());
		tarjeta.setCuenta(cuenta);
		
		
	}
	
	@Test
	public void getSaldo() {
		assertTrue(tarjeta.getSaldo()==100);
		verify(cuenta).getSaldo();
	}
	
	@Test
	public void testRetirar() {	
		try {
			tarjeta.retirar(200);
			fail("Deberia lanzar la excepcion");
		} catch (OperacionNoAceptadaException e) {
		}
		
		try {
			tarjeta.retirar(50);
		} catch (OperacionNoAceptadaException e) {

			fail("No deberia lanzar la excepcion");
		}

		try {
			verify(cuenta).retirar("Retirada en cajero automatico", 50);
		} catch (OperacionNoAceptadaException e) {
			
		}
	}
	
	@Test
	public void testIngresar() {
		try {
			tarjeta.ingresar(-50);
			fail("Deber�a lanzar la excepcion");
		} catch (OperacionNoAceptadaException e) {
		}
		
		try {
			tarjeta.ingresar(50);
		} catch (OperacionNoAceptadaException e) {

			fail("No deber�a lanzar la excepcion");
		}

		try {
			verify(cuenta).ingresar("Ingreso en cajero automatico", 50.0);
		} catch (OperacionNoAceptadaException e) {
			
		}
	}
	
	@Test
	public void testPagoEnEstablecimiento() {
		try {
			tarjeta.pagoEnEstablecimiento("Zara", 150);
			fail("Deber�a lanzar la excepcion");
		} catch (OperacionNoAceptadaException e) {
		}
		
		try {
			tarjeta.pagoEnEstablecimiento("Zara", 50);
		} catch (OperacionNoAceptadaException e) {

			fail("No deber�a lanzar la excepcion");
		}

		try {
			verify(cuenta).retirar("Compra en Zara", 50.0);
		} catch (OperacionNoAceptadaException e) {
			
		}
		
	}
}
