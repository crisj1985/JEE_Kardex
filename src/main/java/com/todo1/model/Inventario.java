package com.todo1.model;

import java.util.Date;

import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Inventario")
@Table
public class Inventario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInventario;
	@Column
	private Date fecha;
	@Column
	private String detalle;
	@Column
	private double valor;
	@Column
	private int cantidad;
	@Column
	private double total;
	@Column
	private int saldo;
	/*@Column
	private Long idProducto;*/
	
	public Long getIdInventario() {
		return idInventario;
	}
	public void setIdInventario(Long idInventario) {
		this.idInventario = idInventario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	
	
}
