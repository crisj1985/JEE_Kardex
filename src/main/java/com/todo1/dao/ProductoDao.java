package com.todo1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.todo1.model.JPAUtil;
import com.todo1.model.Productos;

public class ProductoDao {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void guardar(Productos p)
	{
		entity.getTransaction().begin();
		entity.persist(p);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public void editar (Productos p)
	{
		entity.getTransaction().begin();
		entity.merge(p);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public Productos buscarProducto(Long id)
	{
		Productos producto = new Productos();
		producto = entity.find(Productos.class, id);
		return producto;
	}

	
	public List<Productos> listar()
	{
		List<Productos> productos = new ArrayList<Productos>();
		Query q = entity.createQuery("SELECT p FROM Productos p");
		productos = q.getResultList();
		return productos;
		
	}
}
