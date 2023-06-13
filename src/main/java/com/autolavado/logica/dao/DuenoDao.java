package com.autolavado.logica.dao;

import javax.persistence.EntityManager;

import com.autolavado.logica.modelo.Dueno;
import com.autolavado.logica.modelo.Vehiculo;

public class DuenoDao {
	private EntityManager em;

	public DuenoDao(EntityManager em) {
		this.em = em;
	}

	public void guardar(Dueno dueno) {
		this.em.persist(dueno);
	}
	public void actualizar(Dueno dueno) {
		this.em.merge(dueno);
	}
	
	public Dueno consultarDuenoConVehiculo(int numeroCliente) {
		String jpql="SELECT v.dueno FROM Vehiculo v WHERE v.numeroCliente = :numeroCliente";
		return em.createQuery(jpql,Dueno.class).setParameter("numeroCliente", numeroCliente).getSingleResult();
	}
	
}
