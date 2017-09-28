

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;




import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.unican.ps.banco.dominio.casoA.Cuenta;
import es.unican.ps.banco.dominio.casoA.Movimiento;

public class CuentaCasoATest {

	private static Cuenta cuenta;
	
	//////// Pruebas con Mock /////////
	private static Movimiento movimientoa = mock(Movimiento.class);
	private static Movimiento movimientob = mock(Movimiento.class);
	private static Movimiento movimientoc = mock(Movimiento.class);

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		when(movimientoa.getImporte()).thenReturn(100.0);
		when(movimientob.getImporte()).thenReturn(300.0);
		when(movimientoc.getImporte()).thenReturn(-100.0);
	}
	
	@Before
	public void setUpBefore() throws Exception {
		cuenta=new Cuenta("794311","Juan Gomez");
	}

	@Test
	public void testAddMovimientoYGetSaldo() {
	
		//Test getSaldo() y addMovimiento()
		assertTrue(cuenta.getSaldo()==0);
		cuenta.addMovimiento(movimientoa);
		assertTrue(cuenta.getSaldo()==100);
		
		cuenta.addMovimiento(movimientob);
		assertTrue(cuenta.getSaldo()==400);
		
		cuenta.addMovimiento(movimientoc);
		assertTrue(cuenta.getSaldo()==300);
	}
	
	@Test
	public void testIngresar() {
		// Ingresar una cantidad positiva
		try {
			cuenta.ingresar(500);
			cuenta.ingresar(300);
			System.out.println(cuenta.getSaldo());
		} catch (Exception e) {
			fail("No deber�a lanzar excepci�n");
		}
		assertTrue(cuenta.getSaldo()==800);
		
		try {
			cuenta.ingresar(-200);
			fail("Deber�a lanzar excepci�n por ingresar cantidad negativa");
		} catch (Exception e) {
			
		}
	}
	
}
