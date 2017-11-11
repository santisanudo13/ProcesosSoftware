/**
 * 
 */
package usajni;

/**
 * @author julio
 *
 */
public class Codifica {

	/**
	 * 
	 */
	public Codifica() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String clave;
		String sal;
		String resultado;
		long tiempo_inicial, duracion;
		
		//Crypta criptaLink = new Crypta();     //<-- para usar las dll (de 32 bits)
		//System.out.println(System.getProperty("java.library.path"));
		
		Jcripta criptaLink = new Jcripta();     //<-- para usar la clase java equivalente
		
		//Jcriptu criptaLink = new Jcriptu();     //<-- para hacer el primer ensayo
		//Jcripto criptaLink = new Jcripto();     //<-- para hacer el segundo ensayo
			
		
		clave = new String("mipassword");
		sal   = new String("sa"); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("mipassword");
		sal   = new String("sa"); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("mi");
		sal   = new String("sa"); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("mipasswordtremebundo");
		sal   = new String("sa"); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("mipassword");
		sal   = new String("so"); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("");
		sal   = new String("so"); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("mipassword");
		sal   = new String(""); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("");
		sal   = new String(""); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
		clave = new String("1");
		sal   = new String("22"); 
		
		tiempo_inicial = System.currentTimeMillis();
		resultado = criptaLink.crypta(clave,sal);
		duracion = System.currentTimeMillis() - tiempo_inicial;
		System.out.println("Clave: "+clave+" y Sal: "+sal+" Resultan: "+resultado
				+ "     \n ("+duracion+"ms)" );
		
	}
	
	
	  
}
