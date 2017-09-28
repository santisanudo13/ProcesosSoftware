package es.unican.ps.banco.dominio.casoB;

import java.util.Date;

public class Debito extends Tarjeta
{
	public Debito(String numero, String titular, Date fechaCaducidad)
	{
		super(numero, titular, fechaCaducidad);
	}
	
	public void retirar(double x) throws OperacionNoAceptadaException 
	{
		this.mCuentaAsociada.retirar("Retirada en cajero automatico", x);
	}
	
	public void ingresar(double x) throws OperacionNoAceptadaException
	{
		
		this.mCuentaAsociada.ingresar("Ingreso en cajero automatico", x);
	}
	
	public void pagoEnEstablecimiento(String datos, double x) throws OperacionNoAceptadaException
	{
		this.mCuentaAsociada.retirar("Compra en " + datos, x);
	}
	
	public double getSaldo() 
	{
		return mCuentaAsociada.getSaldo();
	}
}