/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Ingrediente;

/**
 *
 * @author PabloRam
 */
public class IngredienteDAO extends DAO<Ingrediente> {
    public IngredienteDAO(){
        super(new Ingrediente());
        
    }
    public Ingrediente getOneById(Ingrediente ingrediente) throws HibernateException {
		return super.getOneById(ingrediente.getIdIngrediente());
	}
    
}
