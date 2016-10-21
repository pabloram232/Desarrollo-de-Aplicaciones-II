/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.IngredienteDAO;
import utng.datos.TortaDAO;
import utng.modelo.Ingrediente;
import utng.modelo.Torta;

/**
 *
 * @author PabloRam
 */
@ManagedBean
@SessionScoped
public class IngredienteBean implements Serializable{
    private List<Ingrediente> ingredientes;
	private Ingrediente ingrediente;
	private List<Torta> tortas;
        
        
	public IngredienteBean() {
		ingrediente = new Ingrediente();
		ingrediente .setTorta(new Torta());
	}

	public String listar() {
		IngredienteDAO dao = new IngredienteDAO();
		try {
			ingredientes=dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ingredientes";
	}

	public String eliminar() {
		IngredienteDAO dao = new IngredienteDAO();
		try {
			dao.delete(ingrediente );
			ingredientes  = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}

	public String agregar() {
		ingrediente  = new Ingrediente();
		ingrediente .setTorta(new Torta());
		try {
			tortas = new TortaDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Agregar";
	}

	public String guardar() {
		IngredienteDAO dao = new IngredienteDAO();
		try {
			if (ingrediente .getId() != 0) {
				dao.update(ingrediente );
			} else {
				dao.insert(ingrediente );
			}
			ingredientes  = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}

	public String cancelar() {
		return "Cancelar";
	}

	public String editar(Ingrediente ingrediente) {
		this.ingrediente  = ingrediente;
		try {
			tortas = new TortaDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Editar";
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes ;
	}

	public void setIngredientes(List<Ingrediente> carreras) {
		this.ingredientes  = ingredientes;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setCarrera(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public List<Torta> getFacultades() {
		return tortas;
	}

	public void setFacultades(List<Torta> facultades) {
		this.tortas = facultades;
	}
}
 
