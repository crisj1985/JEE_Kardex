package com.todo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Productos")
public class Productos {
	
	@Id
	//@GeneratedValue //(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nombre;
	@Column
	private double valor;
	@Column
	private int cantidad;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Productos [id=" + id + ", nombre=" + nombre + ", valor="
				+ valor + ", cantidad=" + cantidad + "]";
	}

		

}
