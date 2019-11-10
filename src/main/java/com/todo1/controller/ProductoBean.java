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
		/*Productos p = new Productos ();
		p.setId(55L);
		p.setNombre("camisetas");
		p.setValor(10.5);
		p.setCantidad(5);
		Productos p1 = new Productos ();
		p1.setId(6L);
		p1.setNombre("tazas");
		p1.setValor(5.8);
		p1.setCantidad(12);
		ProductoDao obj= new ProductoDao();
		obj.guardar(p);
//		obj.guardar(p1);
		//productos.add(p);
		productos.add(p1);*/
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
	
}
