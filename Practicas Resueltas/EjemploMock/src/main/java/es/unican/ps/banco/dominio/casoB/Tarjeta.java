package es.unican.ps.banco.dominio.casoB;

import java.util.Date;

public abstract class Tarjeta 
{
	protected String mNumero, mTitular;
	protected Date mFechaDeCaducidad;
	/**
	 * Comment here
	 * @label Tarjeta_CuentaAsociada
	 */
	protected Cuenta mCuentaAsociada;

	public Tarjeta(String numero, String titular, Date fechaCaducidad)
	{
		mNumero=numero;
		mTitular=titular;
		mFechaDeCaducidad=fechaCaducidad;
	}
	
	public void setCuenta(Cuenta c) 
	{
		mCuentaAsociada=c;
	}
	
	public abstract void retirar(double x) throws OperacionNoAceptadaException;
	public abstract void ingresar(double x) throws OperacionNoAceptadaException;
	public abstract void pagoEnEstablecimiento(String datos, double x) throws OperacionNoAceptadaException;
	public abstract double getSaldo();
}