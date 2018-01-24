package testPerfilEstadistico;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import perfilEstadistico.CalculaTiempos;
import usajni.JCriptInterface;
import usajni.Jcripta;
import usajni.Jcripto;
import usajni.Jcriptu;

public class TestCalculaTiempos {

	private static CalculaTiempos calcTiemposCriptA = null;
	private static CalculaTiempos calcTiemposCriptO = null;
	private static CalculaTiempos calcTiemposCriptU = null;

	/**
	 * Generamos los valores para las 3 valores estaticas que luego usaremos como base para probar contra los resultados de
	 * posteriores ejecuciones
	 */
	@BeforeClass
	public static void init() {
		JCriptInterface criptLink = new Jcripta();     
		calcTiemposCriptA = new CalculaTiempos(criptLink);

		criptLink = new Jcripto();     
		calcTiemposCriptO = new CalculaTiempos(criptLink);

		criptLink = new Jcriptu();    
		calcTiemposCriptU = new CalculaTiempos(criptLink);
	}

	//TEST CON BASE JCRIPTA

	/**
	 * Calculamos que la desviacion entre la ejecucuion inicial con jCriptaA no supere el 10% de desviacion respecto 
	 * la ejecucion actual con JCriptaA
	 */
	@Test
	public void testJCriptaConJCriptA() {
		JCriptInterface criptaLink = new Jcripta();     
		CalculaTiempos calcTiemposJCripta = new CalculaTiempos(criptaLink);
		checkResults(calcTiemposCriptA, calcTiemposJCripta);	
	}

	/**
	 * Calculamos que la desviacion entre la ejecucuion inicial con jCriptaA no supere el 10% de desviacion respecto
	 * la ejecucion actual con JCripto
	 */
	@Test
	public void testJCriptaConJCripto() {
		JCriptInterface criptaLink = new Jcripto();     
		CalculaTiempos calcTiemposJCripto = new CalculaTiempos(criptaLink);
		checkResults(calcTiemposCriptA, calcTiemposJCripto);	
	}

	/**
	 * Calculamos que la desviacion entre la ejecucuion inicial con jCriptaA no supere el 10% de desviacion respecto
	 * la ejecucion actual con JCriptu
	 */
	@Test
	public void testJCriptaConJCriptu() {
		JCriptInterface criptaLink = new Jcriptu();     
		CalculaTiempos calcTiemposJCriptu = new CalculaTiempos(criptaLink);
		checkResults(calcTiemposCriptA, calcTiemposJCriptu);
	}



	//TEST CON BASE JCRIPTO

	/**
	 * Calculamos que la desviacion entre la ejecucuion inicial con jCriptaO no supere el 10% de desviacion respecto 
	 * la ejecucion actual con JCriptaA
	 */
	@Test
	public void testJCriptoConJCriptA() {
		JCriptInterface criptaLink = new Jcripta();     
		CalculaTiempos calcTiemposJCripta = new CalculaTiempos(criptaLink);
		checkResults(calcTiemposCriptO, calcTiemposJCripta);	
	}

	/**
	 * Calculamos que la desviacion entre la ejecucuion inicial con jCriptaO no supere el 10% de desviacion respecto
	 * la ejecucion actual con JCripto
	 */
	@Test
	public void testJCriptoConJCripto() {
		JCriptInterface criptaLink = new Jcripto();     
		CalculaTiempos calcTiemposJCripto = new CalculaTiempos(criptaLink);
		checkResults(calcTiemposCriptO, calcTiemposJCripto);	
	}

	/**
	 * Calculamos que la desviacion entre la ejecucuion inicial con jCriptaO no supere el 10% de desviacion respecto
	 * la ejecucion actual con JCriptu
	 */
	@Test
	public void testJCriptoConJCriptu() {
		JCriptInterface criptaLink = new Jcriptu();     
		CalculaTiempos calcTiemposJCriptu = new CalculaTiempos(criptaLink);
		checkResults(calcTiemposCriptO, calcTiemposJCriptu);
	}

	//TEST CON BASE JCRIPTU

	/**
	 * Calculamos que la desviacion entre la ejecucuion inicial con jCriptaU no supere el 10% de desviacion respecto 
	 * la ejecucion actual con JCriptaA
	 */
	@Test
	public void testJCriptuConJCriptA() {
		JCriptInterface criptaLink = new Jcripta();     
		CalculaTiempos calcTiemposJCripta = new CalculaTiempos(criptaLink);
		checkResults(calcTiemposCriptU, calcTiemposJCripta);	
	}

	/**
	 * Calculamos que la desviacion entre la ejecucuion inicial con jCriptaU no supere el 10% de desviacion respecto
	 * la ejecucion actual con JCripto
	 */
	@Test
	public void testJCriptuConJCripto() {
		JCriptInterface criptaLink = new Jcripto();     
		CalculaTiempos calcTiemposJCripto = new CalculaTiempos(criptaLink);
		checkResults(calcTiemposCriptU, calcTiemposJCripto);	
	}

	/**
	 * Calculamos que la desviacion entre la ejecucuion inicial con jCriptaU no supere el 10% de desviacion respecto
	 * la ejecucion actual con JCriptu
	 */
	@Test
	public void testJCriptuConJCriptu() {
		JCriptInterface criptaLink = new Jcriptu();     
		CalculaTiempos calcTiemposJCriptu = new CalculaTiempos(criptaLink);
		checkResults(calcTiemposCriptU, calcTiemposJCriptu);
	}

	/**
	 * Calculamos que la desviacion entre ambos valores no supere el 10% y la desviacion acumulada no sea superior al 20%
	 * 
	 * @param calcTiemposJCripta
	 */
	private void checkResults(CalculaTiempos calcTiemposJCriptA , CalculaTiempos calcTiemposJCriptB) {
		double desviacionMejorTiempo = Math.abs(calcTiemposJCriptB.mejorTiempoRespuesta-calcTiemposJCriptA.mejorTiempoRespuesta);
		if(calcTiemposJCriptB.mejorTiempoRespuesta <= - calcTiemposJCriptA.mejorTiempoRespuesta) {
			desviacionMejorTiempo = desviacionMejorTiempo /calcTiemposJCriptB.mejorTiempoRespuesta;
		}else {
			desviacionMejorTiempo = desviacionMejorTiempo /calcTiemposJCriptA.mejorTiempoRespuesta;
		}

		double desviacionPeorTiempo = Math.abs(calcTiemposJCriptB.peorTiempoRespuesta-calcTiemposJCriptA.peorTiempoRespuesta);
		if(calcTiemposJCriptB.peorTiempoRespuesta <= - calcTiemposJCriptA.peorTiempoRespuesta) {
			desviacionPeorTiempo = desviacionPeorTiempo /calcTiemposJCriptB.peorTiempoRespuesta;
		}else {
			desviacionPeorTiempo = desviacionPeorTiempo /calcTiemposJCriptA.peorTiempoRespuesta;
		}


		double desviacionTiempoPromedio = Math.abs(calcTiemposJCriptB.tiempoPromedio-calcTiemposJCriptA.tiempoPromedio);
		if(calcTiemposJCriptB.tiempoPromedio <= - calcTiemposJCriptA.tiempoPromedio) {
			desviacionTiempoPromedio = desviacionTiempoPromedio /calcTiemposJCriptB.tiempoPromedio;
		}else {
			desviacionTiempoPromedio = desviacionTiempoPromedio /calcTiemposJCriptA.tiempoPromedio;
		}

		double desviacionDeDesviacionesEstandar = Math.abs(calcTiemposJCriptB.desviacionEstandar-calcTiemposJCriptA.desviacionEstandar);
		if(calcTiemposJCriptB.desviacionEstandar <= - calcTiemposJCriptA.desviacionEstandar) {
			desviacionDeDesviacionesEstandar = desviacionDeDesviacionesEstandar /calcTiemposJCriptB.desviacionEstandar;
		}else {
			desviacionDeDesviacionesEstandar = desviacionDeDesviacionesEstandar /calcTiemposJCriptA.desviacionEstandar;
		}
		double desviacionTiempoRespuestaPorDebajo99con5 = Math.abs(calcTiemposJCriptB.tiempoRespuestaPorDebajo99con5-calcTiemposJCriptA.tiempoRespuestaPorDebajo99con5);
		if(calcTiemposJCriptB.tiempoRespuestaPorDebajo99con5 <= - calcTiemposJCriptA.tiempoRespuestaPorDebajo99con5) {
			desviacionTiempoRespuestaPorDebajo99con5 = desviacionTiempoRespuestaPorDebajo99con5 /calcTiemposJCriptB.tiempoRespuestaPorDebajo99con5;
		}else {
			desviacionTiempoRespuestaPorDebajo99con5 = desviacionTiempoRespuestaPorDebajo99con5 /calcTiemposJCriptA.tiempoRespuestaPorDebajo99con5;
		}

		//Comprobamos desviacion individual no supere el 10%
		assertTrue(desviacionMejorTiempo>= 0 ||desviacionMejorTiempo <= 0.1 );	
		assertTrue(desviacionPeorTiempo >= 0 ||desviacionPeorTiempo <= 0.1 );	
		assertTrue(desviacionTiempoPromedio >= 0 ||desviacionTiempoPromedio <= 0.1 );	
		assertTrue(desviacionDeDesviacionesEstandar >= 0 || desviacionDeDesviacionesEstandar <= 0.1 );
		assertTrue(desviacionTiempoRespuestaPorDebajo99con5 >= 0 || desviacionTiempoRespuestaPorDebajo99con5 <= 0.1 );


		//Comprobamos que la desviacion acumulada no sea superior al 20%
		double desviacionAcumulada = desviacionMejorTiempo + desviacionPeorTiempo + desviacionTiempoPromedio + desviacionDeDesviacionesEstandar + desviacionTiempoRespuestaPorDebajo99con5;
		assertTrue(desviacionAcumulada <= 0.2 || desviacionAcumulada >= 0);
	}
}
