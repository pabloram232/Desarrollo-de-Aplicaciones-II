package utng.datos;

import java.io.Serializable;
import org.hibernate.HibernateException;

import utng.modelo.Modulo;

public class ModuloDAO extends DAO<Modulo> {

	public ModuloDAO() {
		super(new Modulo());	
	}
	
	public Modulo getOneById(Modulo modulo) throws HibernateException {
		return super.getOneById(modulo.getIdModulo());
	}
}
