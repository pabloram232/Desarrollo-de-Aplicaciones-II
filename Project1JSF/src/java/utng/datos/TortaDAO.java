/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Torta;

/**
 *
 * @author PabloRam
 */
public class TortaDAO extends DAO<Torta>{
    public TortaDAO() {
		super(new Torta());	
	}
	
	public Torta getOneById(Torta torta) throws HibernateException {
		return super.getOneById(torta.getId());
	}
}
    

