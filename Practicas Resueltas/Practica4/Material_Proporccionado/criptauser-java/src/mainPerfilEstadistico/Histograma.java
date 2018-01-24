package mainPerfilEstadistico;

import java.util.List;
import perfilEstadistico.*;
import fundamentos.Grafica;
import perfilEstadistico.DatoHistograma;
import usajni.JCriptInterface;
import usajni.Jcripta;
import usajni.Jcripto;
import usajni.Jcriptu;

public class Histograma {

	


	/**
	 * Ejecutamos un proceso de criptado de 2400 claves, posteriormente calculamos los valores clave, y por ultimo mostramos un grafo con 
	 * el dataset empleado para la muestra.
	 * @param args
	 */
	public static void main(String[] args) {

		JCriptInterface criptaLink = new Jcripta();     //<-- para usar la clase java equivalente
		CalculaTiempos calcTiempos = new CalculaTiempos(criptaLink);

		System.out.println("\n\n----Dibujando Histograma----\n\n");

		List<DatoHistograma> datos = calcTiempos.getTiemposList();
		dibujaHistograma(datos);
	}
	
	/**
	 * Metodo encargado de dibujar el histograma con los resultados obtenidos
	 * @param datos
	 */
	private static void dibujaHistograma(List<DatoHistograma> datos) {
		//Configuramos la grafica
		Grafica g = new Grafica ("Histograma Tiempos de Criptación","Tiempo","N Ejecuciones");

		g.ponSimbolo(true);
		g.ponLineas(true);
		g.ponColor(Grafica.azul);


		//Insertamos los valores	
		for(DatoHistograma d: datos)
			g.inserta(d.getX(), d.getY());					

		//Pintamos la grafica
		g.pinta();

	}

	



}
