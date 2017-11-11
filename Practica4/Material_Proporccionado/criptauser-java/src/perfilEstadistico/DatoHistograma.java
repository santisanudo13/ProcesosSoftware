package perfilEstadistico;


/**
 * Clase encargada de almacenar el valor tiempo en X y el numero de veces que se repite este tiempo de ejecucion en Y
 * Asi mismo implementa un comparador para poder ordenar las listas de este objeto de modo que esten de mayor a menor basandonos 
 * en el tiempo de ejecucion, es decir, la X
 * @author Tiago
 *
 */
public class DatoHistograma implements Comparable<DatoHistograma>{
	public long tiempoEjecucion;
	int numRepeticiones;

	public DatoHistograma(long x, int y) {
		this.tiempoEjecucion = x;
		this.numRepeticiones = y;
	}

	public long getX() {
		return tiempoEjecucion;
	}

	public void setX(long x) {
		this.tiempoEjecucion = x;
	}

	public int getY() {
		return numRepeticiones;
	}

	public void setY(int y) {
		this.numRepeticiones = y;
	}

	/**
	 * Metodo encargado de realizar la comparacion, ordena de mayor a menor los elementos
	 */
	@Override
	public int compareTo(DatoHistograma other) {
		if(this.getX() > other.getX())
			return 1;
		if(this.getX() < other.getX())
			return -1;
		return 0;
	}


}