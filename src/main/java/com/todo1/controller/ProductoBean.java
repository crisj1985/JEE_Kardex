package com.todo1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import java.util.*;

import com.todo1.dao.ProductoDao;
import com.todo1.model.Productos;

@ManagedBean(name = "productoBean")
@RequestScoped
public class ProductoBean 
{
	
	public String nuevo(){
		Productos p= new Productos();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("Productos", p);
		 return "faces/nuevo.xhtml";
	}
	
	public List<Productos> listarProductos()
	{
		List<Productos> productos = new ArrayList<>();
		ProductoDao obj= new ProductoDao();
		productos = obj.listar();
		
		return productos;
	}
	
	public String guardar(Productos p)
	{
		ProductoDao obj= new ProductoDao();
		obj.guardar(p);
		return "faces/index.xhtml";
	}
	
	//public Productos buscar
	
	public String editar(Long id)
	{
		ProductoDao obj= new ProductoDao();
		Productos p = new Productos();
		p = obj.buscarProducto(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("Productos", p);
		return "faces/editar.xhtml";
	}
	
	public String actualizar(Productos p)
	{
		ProductoDao obj= new ProductoDao();
		obj.editar(p);
		return "faces/index.xhtml";
	}
	
}
