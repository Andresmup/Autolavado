package com.autolavado.persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import com.autolavado.logica.dao.DuenoDao;
import com.autolavado.logica.dao.VehiculoDao;
import com.autolavado.logica.modelo.Dueno;
import com.autolavado.logica.modelo.Vehiculo;
import com.autolavado.persistencia.utils.JPAUtils;

public class Controladora {
	EntityManager em = JPAUtils.getEntityManager();
	VehiculoDao vehiculoDao = new VehiculoDao(em);
	DuenoDao duenoDao = new DuenoDao(em);

	
	
	public void guardar(String modelo, String marca, String color, String brillo, String atencion, String observaciones,
			String nombreDueno, String telefonoDueno) {
		Dueno dueno = new Dueno();
		dueno.setNombre(nombreDueno);
		dueno.setTelefono(telefonoDueno);
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setModelo(modelo);
		vehiculo.setMarca(marca);
		vehiculo.setColor(color);
		vehiculo.setObservaciones(observaciones);
		vehiculo.setBrillo(brillo);
		vehiculo.setAtencionEspecial(atencion);
		vehiculo.setDueno(dueno);
		
		em.getTransaction().begin();
		
		duenoDao.guardar(dueno);
		vehiculoDao.guardar(vehiculo);
		
		em.getTransaction().commit();
		
	}



	public List<Vehiculo> traerVehiculos() {
		em.getTransaction().begin();
		

		List<Vehiculo> vehiculoList =  vehiculoDao.consultarTodos();
		
		em.getTransaction().commit();
		
		return vehiculoList;
		
	}



	public void borrarConIdCliente(int numeroCliente) {
		em.getTransaction().begin();
		Vehiculo vehiculo = vehiculoDao.consultaPorId(numeroCliente);
		
		vehiculoDao.borrarConIdCliente(vehiculo);
		
		em.getTransaction().commit();
		
	}



	public Vehiculo traerVehiculo(int numeroCliente) {
		em.getTransaction().begin();
		Vehiculo vehiculo = vehiculoDao.consultaPorId(numeroCliente);
		em.getTransaction().commit();
		return vehiculo;
	}



	public void editar(Integer numeroCliente, String modelo, String marca, String color, String brillo, String atencion, String observaciones,
			String nombreDueno, String telefonoDueno) {
		
		em.getTransaction().begin();
		
		Vehiculo vehiculo = vehiculoDao.consultaPorId(numeroCliente);
		vehiculo.setModelo(modelo);
		vehiculo.setMarca(marca);
		vehiculo.setColor(color);
		vehiculo.setObservaciones(observaciones);
		vehiculo.setBrillo(brillo);
		vehiculo.setAtencionEspecial(atencion);
		
		
		Dueno dueno = duenoDao.consultarDuenoConVehiculo(vehiculo.getNumeroCliente());
		dueno.setNombre(nombreDueno);
		dueno.setTelefono(telefonoDueno);
		

		vehiculoDao.actualizar(vehiculo);
		duenoDao.actualizar(dueno);
		
		em.getTransaction().commit();
		
	}


}
