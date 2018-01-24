package usajni;

public class Jcriptu implements JCriptInterface{


	void minidoWork(long cuentas){
		double acum = 356.12;
				int n, k;

				for (n = 0; n < cuentas ; n++)
				{
					for (k = 0 ; k < 500 ; k++)
					{
						acum = acum * 3.12;
		//				acum = 356.12;
					}
				}
	}

	void doWork(long cuentas)
		{
		int mis_cuentas=0;
		//int numeroDeBarras=30;
		//int i;
			
			//C for (i=0; i<numeroDeBarras; i++) mis_cuentas += (rand()>=RAND_MAX/2)?1:0;
		    //J for (i=0; i<numeroDeBarras; i++) mis_cuentas += Math.round(Math.random());
		
			//C mis_cuentas = cuentas * rand()/RAND_MAX;  <-- esta sería uniforme
		    mis_cuentas = (int)((double)cuentas * Math.random());  //<-- esta es uniforme
		    minidoWork(mis_cuentas * 2);

			//printf("barra(de 30) = %d",mis_cuentas);
			//minidoWork(cuentas * 2 * mis_cuentas/numeroDeBarras);

		}

	
		

	boolean valido(char c){
		return(	(c >= '.' && c <= '9') ||
				(c >= 'A' && c <= 'Z') ||
				(c >= 'a' && c <= 'z')     ) ;

	}

	public  String crypta(String key, String salt){
		
	final int SALIDASIZE = 13;
	
	char [] buffer = new char[SALIDASIZE];
	long [] tmp = new long[SALIDASIZE];
    if (key != null && salt != null && key.length()>0 && salt.length()>0) {
	
	   
	/*
	char [] clave_cc = key.toCharArray();
	char [] salt_cc = salt.toCharArray();
	System.out.println(key + salt);
	if (clave_cc.length == 0 || salt_cc.length ==0 ) {
		
		   System.out.println("La longitud de alg_cc es 0");
		   return null;
	    }
*/
	byte [] clave_c = new byte[key.length()];
	for (int k=0; k<key.length();k++) clave_c[k] = (byte)key.charAt(k);

	byte [] salt_c = new byte[salt.length()];
	for (int k=0; k<salt.length();k++) salt_c[k] = (byte)salt.charAt(k);



	
	int i,j;
		long x=0;

		
		/*Aqui uso clave y salt para generar la salida en buffer*/

		for (i=0; i<SALIDASIZE; i++ ){
			buffer[i]= '\0';
			tmp[i]='\0';	
		}


		if(!(salt_c[0] > (char)126   ||
			salt_c[1] >126   ||
			salt_c[0] < 33   ||
			salt_c[1] < 33   ||
			clave_c.length == 0 ) ) {

			buffer[0]=(char)salt_c[0];
			buffer[1]=(char)salt_c[1];
			/*valores iniciales para cada posicion a devolver*/
			x=salt_c[0]+salt_c[1];
			j=0;
			while (j<clave_c.length){
				x+=clave_c[j++];
			}
			x = x%256; /* Los inicio con un valor alrededor del checksum de la clave*/

			/* j queda con el tamaño de clave */

			for (i=0; (i<j && i<SALIDASIZE); i++ ) tmp[i]=((int)'P'+i+(int)salt_c[0]*i+(int)salt_c[1]*(i+1)+x+clave_c[i]);

			for (i=j; i<SALIDASIZE; i++ ) tmp[i]=((int)'P'+i+(int)salt_c[0]*i+(int)salt_c[1]*(i+1)+x);

			/*Se cambian ahora convenientemente */
			for (i=2; i<SALIDASIZE; i++ ){
				x=(tmp[i] + tmp[i-1] + tmp[i-2]);
				j=0;
				do{
					j++;
					x=(x+j +(x%128)*j+i)%(1<<16);
				}while (!valido((char) ((char)x%128)));  /*[a-zA-Z0-9./]*/
				tmp[i]=x%128;
			}

			for (i=2; i<SALIDASIZE; i++ ){
				buffer[i]=(char)(tmp[i]%128);
			}

			/*
			i=0;

			while (clave_c[i]) {
				buffer[i+2]=clave_c[i];
				i++;
			}
			*/
		/*por ahora solo retorno algo válido para probar
		buffer[0]='H';
		buffer[1]='o';
		buffer[2]='l';
		buffer[3]='a';
		buffer[4]='\0';
		*/
		}
		/* Aquí me tardo un tiempo adicional con una distribución de poisson aproximada */
    }
    else {System.out.println("Alguno es nulo");
    doWork(100000);
    return null;
 }
		doWork(100000);  //aprox 110 ms
		
		return new String(buffer);
	}

	
	
}
