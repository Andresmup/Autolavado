package com.autolavado.logica.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.autolavado.logica.modelo.Vehiculo;

public class VehiculoDao {
	private EntityManager em;

	public VehiculoDao(EntityManager em) {
		this.em = em;
	}

	public void guardar(Vehiculo vehiculo) {
		this.em.persist(vehiculo);
	}
	
	public void borrarConIdCliente(Vehiculo vehiculo) {
		vehiculo = this.em.merge(vehiculo);
		this.em.remove(vehiculo);
		
	}
	
	public List<Vehiculo> consultarTodos() {
		String jpql = "SELECT P FROM Vehiculo AS P";
		return em.createQuery(jpql, Vehiculo.class).getResultList();
	}

	public Vehiculo consultaPorId(int numeroCliente) {
		return em.find(Vehiculo.class, numeroCliente);
	}
	public void actualizar(Vehiculo vehiculo) {
		this.em.merge(vehiculo);
	}
	

}
