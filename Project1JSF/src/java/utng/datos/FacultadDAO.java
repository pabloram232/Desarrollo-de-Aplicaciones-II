package utng.datos;

import java.io.Serializable;
import org.hibernate.HibernateException;

import utng.modelo.Facultad;


public class FacultadDAO extends DAO<Facultad> {

	public FacultadDAO() {
		super(new Facultad());	
	}
	
	public Facultad getOneById(Facultad facultad) throws HibernateException {
		return super.getOneById(facultad.getId());
	}
}
