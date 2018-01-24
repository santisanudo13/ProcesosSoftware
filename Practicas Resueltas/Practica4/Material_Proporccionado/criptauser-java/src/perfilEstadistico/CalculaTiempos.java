package perfilEstadistico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import usajni.JCriptInterface;



public class CalculaTiempos {


	private Map<Long, Integer> tiempos = new HashMap<Long, Integer>();
	private List<DatoHistograma> datos = new ArrayList<DatoHistograma>();
	private static final int NUM_EJECUCIONES=125;
	
	public  long mejorTiempoRespuesta;
	public  long peorTiempoRespuesta;
	public  long tiempoPromedio;
	public  double desviacionEstandar;
	public  long tiempoRespuestaPorDebajo99con5;

	/**
	 * Genera 8 criptaciones repetidas por un bucle de 313 iteraciones y a cada criptacion la añade al map
	 * @param criptaLink
	 */
	public CalculaTiempos(JCriptInterface criptaLink) {
		System.out.println("Calculado tiempos de criptar 2500 claves. espere porfavor...");


		String clave;
		String sal;
		String resultado;
		long tiempo_inicial, duracion;
		for(int i=0; i<NUM_EJECUCIONES; i++) {
			clave = new String("mipassword");
			sal   = new String("sa"); 

			tiempo_inicial = System.currentTimeMillis();
			resultado = criptaLink.crypta(clave,sal);
			duracion = System.currentTimeMillis() - tiempo_inicial;
			System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado+ "     \n ("+duracion+"ms)" );
			addDuracionToMap(duracion);

			//			Ejecucion
			clave = new String("mipassword");
			sal   = new String("sa"); 

			tiempo_inicial = System.currentTimeMillis();
			resultado = criptaLink.crypta(clave,sal);
			duracion = System.currentTimeMillis() - tiempo_inicial;
			System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado+ "     \n ("+duracion+"ms)" );

			addDuracionToMap(duracion);

			//			Ejecucion
			clave = new String("mi");
			sal   = new String("sa"); 

			tiempo_inicial = System.currentTimeMillis();
			resultado = criptaLink.crypta(clave,sal);
			duracion = System.currentTimeMillis() - tiempo_inicial;
			System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado+ "     \n ("+duracion+"ms)" );

			addDuracionToMap(duracion);		

			//			Ejecucion	
			clave = new String("mipasswordtremebundo");
			sal   = new String("sa"); 

			tiempo_inicial = System.currentTimeMillis();
			resultado = criptaLink.crypta(clave,sal);
			duracion = System.currentTimeMillis() - tiempo_inicial;
			System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado+ "     \n ("+duracion+"ms)" );

			addDuracionToMap(duracion);

			//			Ejecucion		
			clave = new String("mipassword");
			sal   = new String("so"); 

			tiempo_inicial = System.currentTimeMillis();
			resultado = criptaLink.crypta(clave,sal);
			duracion = System.currentTimeMillis() - tiempo_inicial;
			System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado+ "     \n ("+duracion+"ms)" );

			addDuracionToMap(duracion);

			//			Ejecucion		
			clave = new String("");
			sal   = new String("so"); 

			tiempo_inicial = System.currentTimeMillis();
			resultado = criptaLink.crypta(clave,sal);
			duracion = System.currentTimeMillis() - tiempo_inicial;
			System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado+ "     \n ("+duracion+"ms)" );

			addDuracionToMap(duracion);

			//			Ejecucion		
			clave = new String("mipassword");
			sal   = new String(""); 

			tiempo_inicial = System.currentTimeMillis();
			resultado = criptaLink.crypta(clave,sal);
			duracion = System.currentTimeMillis() - tiempo_inicial;
			System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado+ "     \n ("+duracion+"ms)" );

			addDuracionToMap(duracion);

			//			Ejecucion			
			clave = new String("");
			sal   = new String(""); 

			tiempo_inicial = System.currentTimeMillis();
			resultado = criptaLink.crypta(clave,sal);
			duracion = System.currentTimeMillis() - tiempo_inicial;
			System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado+ "     \n ("+duracion+"ms)" );

			addDuracionToMap(duracion);

			//			Ejecucion
			clave = new String("1");
			sal   = new String("22"); 

			tiempo_inicial = System.currentTimeMillis();
			resultado = criptaLink.crypta(clave,sal);
			duracion = System.currentTimeMillis() - tiempo_inicial;
			System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado+ "     \n ("+duracion+"ms)" );

			addDuracionToMap(duracion);
		}
		
		calculaValores();
	}

	/**
	 * Si ya existia una duracion previa, le suma 1 a su valor, si no crea una nueva con valor 1.
	 * @param duracion
	 */
	private void addDuracionToMap(long duracion) {
		//Dejamos -1 si no habia valor con esa clave, si lo habia guardamos el valor.
		int value = -1;

		if(tiempos.get(duracion) != null) {
			value = tiempos.get(duracion);
		}


		if(value == -1) {
			tiempos.put(duracion, 1);
		}else {
			tiempos.remove(duracion);
			tiempos.put(duracion, value+1);
		}

	}

	public Map<Long, Integer> getTiempos() {
		return tiempos;
	}

	public List<DatoHistograma> getTiemposList() {
		
		return datos;
	}

	/**
	 * Calculamos los valores clave a partir de una lista ordenada la cual 
	 * ha sido rellenada con los valores del mapa pasado como parametro
	 * @param tiempos
	 * @return
	 */
	private  void calculaValores() {
		long tiempo;
		int numRepeticiones;
		


		//Transformamos el mapa en un arrayList ordenado de mayor a menor segun el tiempo de ejecucion
		for (Entry<Long, Integer> entry : tiempos.entrySet())
		{
			tiempo = entry.getKey();
			numRepeticiones = entry.getValue();

			datos.add(new DatoHistograma(tiempo, numRepeticiones));	
		}
		Collections.sort(datos);

		//Calculamos el mejor tiempo, en este caso sera el primer elemento de la lista
		mejorTiempoRespuesta = datos.get(0).getX();

		//Calculamos el peor tiempo, en este caso sera el ultimo elemento de la lista
		peorTiempoRespuesta = datos.get(datos.size()-1).getX();

		//Calculamos el tiempo promedio de respuesta
		for(DatoHistograma d: datos) {
			tiempoPromedio = tiempoPromedio + d.getX();
		}
		tiempoPromedio = tiempoPromedio / datos.size();

		//Calculamos la Desviacion Estandar
		long sumatorio = 0;
		for(DatoHistograma d: datos) {
			sumatorio = (long) (sumatorio + Math.pow(Math.abs(d.getX() - tiempoPromedio),2));
		}
		desviacionEstandar = sumatorio / datos.size();
		desviacionEstandar = Math.sqrt(desviacionEstandar);

		//Calculamos el tiempo de respuesta que se encuentra por debajo del 99.5% de los tiempos de respuesta
		ArrayList<Long> data = new ArrayList<Long>();
		for(DatoHistograma d: datos) {
			for(int i=0; i<d.getY();i++)
				data.add(d.getX());
		}
		int posElemento =  (int) (data.size() * 0.995)-1;
		tiempoRespuestaPorDebajo99con5 = data.get(posElemento);
		imprimirDatosClave();

	}
	/**
	 * Imprimimos los datos clave calculados previamente con un formato apropiado
	 */
	public  void imprimirDatosClave() {
		System.out.println("\n\n--------------------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------------------------");

		System.out.println(
				"Mejor Tiempo de Respuesta: " + mejorTiempoRespuesta + "\n"
						+ "Peor Tiempo de Respuesta: " + peorTiempoRespuesta + "\n"
						+ "Tiempo Promedio de Respuesta: " + tiempoPromedio + "\n"
						+ "Desviacion Estándar del Tiempo de Respuesta: " + desviacionEstandar + "\n"
						+ "Tiempo de Respuesta por debajo del cual se han obtenido el 99,5% de los Tiempos de Respuesta: " + tiempoRespuestaPorDebajo99con5
				);

		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------------------------\n");

	}




}
