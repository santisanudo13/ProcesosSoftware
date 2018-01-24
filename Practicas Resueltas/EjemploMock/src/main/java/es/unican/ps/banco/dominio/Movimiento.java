package es.unican.ps.banco.dominio;

import java.util.Date;

public class Movimiento {
	private String mConcepto;
	private double mImporte;
	private Date mFecha;
	
	public Movimiento(String mConcepto, double mImporte, Date mFecha) {
		this.mConcepto = mConcepto;
		this.mImporte = mImporte;
		this.mFecha = mFecha;
	}
	public String getConcepto() {
		return mConcepto;
	}
	public double getImporte() {
		return mImporte;
	}
	public Date getFecha() {
		return mFecha;
	}
	
	
}
