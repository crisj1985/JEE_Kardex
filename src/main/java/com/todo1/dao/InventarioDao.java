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
		try {
			entity.getTransaction().begin();
			entity.persist(inv);
			entity.getTransaction().commit();
		} catch (Exception e) {
			entity.getTransaction().rollback();
		}
		
	}
	
	public void editar (Inventario inv)
	{
		try {
			entity.getTransaction().begin();
			entity.merge(inv);
			entity.getTransaction().commit();;
		} catch (Exception e) {
			entity.getTransaction().rollback();
		}
	}
	
	public Inventario buscarInventario(Long id)
	{
		Inventario objInventario = new Inventario();
		
		try {
			objInventario = entity.find(Inventario.class, id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return objInventario;
	}

	
	public List<Inventario> listar()
	{
		List<Inventario> objInventario = new ArrayList<Inventario>();
		Query q = entity.createQuery("SELECT p FROM Inventario p");
		objInventario = q.getResultList();
		objInventario.size();
		return objInventario;
		
	}

}
