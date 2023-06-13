package com.autolavado.logica.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numeroCliente;
	private String modelo;
	private String marca;
	private String color;
	private String brillo;
	private String atencionEspecial;
	private String observaciones;
	@OneToOne
	private Dueno dueno;
	
	public Vehiculo() {
	}
	public Vehiculo(int numeroCliente, String modelo, String marca, String color, String brillo,
			String atencionEspecial, String observaciones, Dueno dueno) {
		this.numeroCliente = numeroCliente;
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
		this.brillo = brillo;
		this.atencionEspecial = atencionEspecial;
		this.observaciones = observaciones;
		this.dueno = dueno;
	}
	public int getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(int numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBrillo() {
		return brillo;
	}
	public void setBrillo(String brillo) {
		this.brillo = brillo;
	}
	public String getAtencionEspecial() {
		return atencionEspecial;
	}
	public void setAtencionEspecial(String atencionEspecial) {
		this.atencionEspecial = atencionEspecial;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Dueno getDueno() {
		return dueno;
	}
	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}
	
	
}
