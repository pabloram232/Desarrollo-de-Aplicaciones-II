package utng.datos;

import org.hibernate.HibernateException;

import utng.modelo.Carrera;


public class CarreraDAO extends DAO<Carrera> {

	public CarreraDAO() {
		super(new Carrera());	
	}
	
	public Carrera getOneById(Carrera carrera) throws HibernateException {
		return super.getOneById(carrera.getId());
	}
}
