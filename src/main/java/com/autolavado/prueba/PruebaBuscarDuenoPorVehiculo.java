package com.autolavado.prueba;

import javax.persistence.EntityManager;

import com.autolavado.logica.dao.DuenoDao;
import com.autolavado.logica.dao.VehiculoDao;
import com.autolavado.logica.modelo.Dueno;
import com.autolavado.logica.modelo.Vehiculo;

import com.autolavado.persistencia.utils.JPAUtils;

public class PruebaBuscarDuenoPorVehiculo {

	public static void main(String[] args) {
		EntityManager em = JPAUtils.getEntityManager();
		VehiculoDao vehiculoDao = new VehiculoDao(em);
		DuenoDao duenoDao = new DuenoDao(em);

		em.getTransaction().begin();
		Vehiculo vehiculo = vehiculoDao.consultaPorId(30);
		Dueno dueno = duenoDao.consultarDuenoConVehiculo(vehiculo.getNumeroCliente());
		System.out.println(dueno.getNombre());
		
		em.getTransaction().commit();
		
	}

}
