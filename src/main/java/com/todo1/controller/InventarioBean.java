package com.todo1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.todo1.dao.InventarioDao;
import com.todo1.dao.ProductoDao;
import com.todo1.model.Inventario;;

@ManagedBean(name="inventarioBean")
@RequestScoped
public class InventarioBean {
	
	public String nuevo(){
		Inventario inv= new Inventario();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("Inventario", inv);
		 return "faces/registrarInventario.xhtml";
	}
	
	public List<Inventario> listarInventario()
	{
		List<Inventario> objInventario = new ArrayList<>();
		InventarioDao obj= new InventarioDao();
		objInventario = obj.listar();
		
		return objInventario;
	}
	
	public String guardar(Inventario inv)
	{
		InventarioDao obj= new InventarioDao();
		obj.guardar(inv);
		return "faces/inventario.xhtml";
	}
	
	//public Productos buscar
	
	public String editar(Long id)
	{
		InventarioDao obj= new InventarioDao();
		Inventario inv = new Inventario();
		inv = obj.buscarInventario(id);//  buscarInventario(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("Inventario", inv);
		return "faces/editarInventario.xhtml";
	}
	
	public String actualizar(Inventario inv)
	{
		InventarioDao obj= new InventarioDao();
		obj.editar(inv);
		return "faces/inventario.xhtml";
	}

}
