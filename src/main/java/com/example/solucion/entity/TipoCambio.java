package com.example.solucion.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoCambio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float monto;
	private String monedaOrigen;
	private String monedaDestino;
	private float tipoCambio;
	private float montoCambiado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getMonedaOrigen() {
		return monedaOrigen;
	}
	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}
	public String getMonedaDestino() {
		return monedaDestino;
	}
	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}
	
	public float getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(float tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public float getMontoCambiado() {
		return montoCambiado;
	}
	public void setMontoCambiado(float montoCambiado) {
		this.montoCambiado = montoCambiado;
	}
	

}
