package com.todo1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.todo1.model.Inventario;
import com.todo1.model.JPAUtil;


public class InventarioDao {
EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void guardar(Inventario inv)
	{
		entity.getTransaction().begin();
		entity.persist(inv);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public void editar (Inventario inv)
	{
		entity.getTransaction().begin();
		entity.merge(inv);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public Inventario buscarInventario(Long id)
	{
		Inventario objInventario = new Inventario();
		objInventario = entity.find(Inventario.class, id);
		return objInventario;
	}

	
	public List<Inventario> listar()
	{
		List<Inventario> objInventario = new ArrayList<Inventario>();
		Query q = entity.createQuery("SELECT p FROM Inventario p");
		objInventario = q.getResultList();
		return objInventario;
		
	}

}
