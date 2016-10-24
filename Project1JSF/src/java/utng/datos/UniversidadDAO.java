/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;

import utng.modelo.Universidad;

/**
 *
 * @author PabloRam
 */
public class UniversidadDAO extends DAO<Universidad>{
    
    public UniversidadDAO() {
		super(new Universidad());	
	}
	
	public Universidad getOneById(Universidad universidad) throws HibernateException {
		return super.getOneById(universidad.getId());
	}
}
