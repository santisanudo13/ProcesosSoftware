package es.unican.ps.banco.dominio.casoB;

import java.util.Calendar;
import java.util.Vector;
import java.util.Date;

public class Credito extends Tarjeta
{
	protected double mCredito;
	protected Vector<Movimiento> mMovimientos;

	public Credito(String numero, String titular, Date fechaCaducidad, double credito)
	{
		super(numero, titular, fechaCaducidad);
		mCredito=credito;
		mMovimientos=new Vector<Movimiento>();
	}
	
	public void retirar(double x) throws OperacionNoAceptadaException 
	{
		
		x=(x*0.05<3.0 ? 3 : x*0.05);  // A�adimos una comisi�n de un 5%, m�nimo de 3 euros.
		Movimiento m = new Movimiento("Retirada en cajero autom�tico", x, Calendar.getInstance().getTime());

		// mMovimientos.addElement(m); //ERROR
		if (x>getCreditoDisponible())
			throw new OperacionNoAceptadaException();
		mMovimientos.addElement(m);
	}
	
	public void ingresar(double x) throws OperacionNoAceptadaException 
	{
		Movimiento m=new Movimiento("Ingreso en cuenta asociada (cajero autom�tico)", x, Calendar.getInstance().getTime());
		mMovimientos.addElement(m);
		mCuentaAsociada.ingresar(x);
	}
	
	public void pagoEnEstablecimiento(String datos, double x) throws OperacionNoAceptadaException 
	{
		Movimiento m=new Movimiento("Compra a cr�dito en: " + datos, x, Calendar.getInstance().getTime());
		mMovimientos.addElement(m);
	}
	
	public double getSaldo() 
	{
		double r=0.0;
		for (int i=0; i<this.mMovimientos.size(); i++) 
		{
			Movimiento m=(Movimiento) mMovimientos.elementAt(i);
			r+=m.getImporte();
		}
		return r;
	}
	
	public double getCreditoDisponible() 
	{
		return mCredito-getSaldo();
	}
	
	public void liquidar(int mes, int anho) 
	{
		
		double r=0.0;
		for (int i=0; i<this.mMovimientos.size(); i++) 
		{
			Movimiento m=(Movimiento) mMovimientos.elementAt(i);
			if (m.getFecha().getMonth()+1==mes && m.getFecha().getYear()+1900==anho)
				r+=m.getImporte();
		}
		
		
		Movimiento liq=new Movimiento("Liquidaci�n de operaciones tarj. cr�dito, " + (mes+1) + " de " + (anho+1900), r, Calendar.getInstance().getTime());
		
		if (r!=0)
			mCuentaAsociada.addMovimiento(liq);
	}
}