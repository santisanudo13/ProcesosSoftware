package testPerfilEstadistico;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import perfilEstadistico.CalculaTiempos;
import usajni.Jcripta;
import usajni.Jcripto;
import usajni.Jcriptu;

public class TestCalculaTiempos {

	private static CalculaTiempos calcTiempos = null;

	@BeforeClass
	public static void init() {
		Jcripta criptaLink = new Jcripta();     
		calcTiempos = new CalculaTiempos(criptaLink);
	}
	
	/**
	 * Calculamos que la desviacion entre la ejecucuion inicial con jCriptaA no supere el 10% de desviacion respecto 
	 * la ejecucion actual con JCriptaA
	 */
	@Test
	public void testJCripta() {
		Jcripta criptaLink = new Jcripta();     
		CalculaTiempos calcTiemposJCripta = new CalculaTiempos(criptaLink);
		
		checkResults(calcTiemposJCripta);
		
	}
	
	/**
	 * Calculamos que la desviacion entre la ejecucuion inicial con jCriptaA no supere el 10% de desviacion respecto
	 * la ejecucion actual con JCripto
	 */
	@Test
	public void testJCripto() {
		Jcripto criptaLink = new Jcripto();     
		CalculaTiempos calcTiemposJCripto = new CalculaTiempos(criptaLink);
		
		checkResults(calcTiemposJCripto);
		
	}
	
	/**
	 * Calculamos que la desviacion entre la ejecucuion inicial con jCriptaA no supere el 10% de desviacion respecto
	 * la ejecucion actual con JCriptu
	 */
	@Test
	public void testJCriptu() {
		Jcriptu criptaLink = new Jcriptu();     
		CalculaTiempos calcTiemposJCriptu = new CalculaTiempos(criptaLink);
		
		checkResults(calcTiemposJCriptu);
		
	}
	
	/**
	 * Calculamos que la desviacion entre ambos valores no supere el 10%
	 * 
	 * @param calcTiemposJCripta
	 */
	private void checkResults(CalculaTiempos calcTiemposJCripta) {
		assertTrue(calcTiemposJCripta.mejorTiempoRespuesta/calcTiempos.mejorTiempoRespuesta >= 0.9 || calcTiemposJCripta.mejorTiempoRespuesta/calcTiempos.mejorTiempoRespuesta <= 1.1 );	
		assertTrue(calcTiemposJCripta.peorTiempoRespuesta/calcTiempos.peorTiempoRespuesta >= 0.9 || calcTiemposJCripta.peorTiempoRespuesta/calcTiempos.peorTiempoRespuesta <= 1.1 );	
		assertTrue(calcTiemposJCripta.tiempoPromedio/calcTiempos.tiempoPromedio >= 0.9 || calcTiemposJCripta.tiempoPromedio/calcTiempos.tiempoPromedio <= 1.1 );	
		assertTrue(calcTiemposJCripta.desviacionEstandar/calcTiempos.desviacionEstandar >= 0.9 || calcTiemposJCripta.desviacionEstandar/calcTiempos.desviacionEstandar <= 1.1 );
		assertTrue(calcTiemposJCripta.tiempoRespuestaPorDebajo99con5/calcTiempos.tiempoRespuestaPorDebajo99con5 >= 0.9 || calcTiemposJCripta.tiempoRespuestaPorDebajo99con5/calcTiempos.tiempoRespuestaPorDebajo99con5 <= 1.1 );
	}
}
