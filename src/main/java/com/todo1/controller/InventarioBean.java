package com.todo1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.todo1.dao.InventarioDao;
import com.todo1.dao.ProductoDao;
import com.todo1.model.Inventario;
import com.todo1.model.Productos;

@ManagedBean(name="inventarioBean")
@RequestScoped
public class InventarioBean {
	
	private ArrayList<SelectItem> productos=null;
	private Long producto;
	

	public Long getProducto() {
		return producto;
	}

	public void setProducto(Long producto) {
		this.producto = producto;
	}

	public ArrayList <SelectItem> getProductos ()
	{
		if(productos==null)
			productos	= new ArrayList<SelectItem>();
		
		ProductoDao obj= new ProductoDao();	
		
		for(Productos p : obj.listar())
		{
			SelectItem s = new SelectItem(p.getId(),p.getNombre());
			productos.add(s);
		}
		
		return productos;
	} 	
	
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
		for(Inventario i : objInventario)
		{
			System.out.println( i.toString());
		}
		
		return objInventario;
	}
	
	public String guardar(Inventario inv)
	{
		InventarioDao obj= new InventarioDao();
		//inv.setProducto(producto);
		ProductoDao objProducto= new ProductoDao();
		Productos p = new Productos();
		p = objProducto.buscarProducto(producto);
		inv.setProducto(p);
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
