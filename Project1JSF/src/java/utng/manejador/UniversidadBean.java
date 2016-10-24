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
import utng.datos.UniversidadDAO;
import utng.modelo.Universidad;

/**
 *
 * @author PabloRam
 */
@ManagedBean
@SessionScoped
public class UniversidadBean implements Serializable {
    private List<Universidad> universidades;
	private Universidad universidad;
	

	public String listar() {
		UniversidadDAO dao = new UniversidadDAO();
		try {
			universidades=dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Universidades";
	}

	public String eliminar() {
		UniversidadDAO dao = new UniversidadDAO();
		try {
			dao.delete(universidad);
			universidades = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}
	
	public String agregar(){
		universidad = new Universidad();	
		return "Agregar";
	}

	public String guardar() {
		UniversidadDAO dao = new UniversidadDAO();
		try {
			if (universidad.getId() != 0) {
				dao.update(universidad);
			} else {
				dao.insert(universidad);
			}
			universidades = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}

	public String cancelar() {
		return "Cancelar";
	}

	public String editar(Universidad universidad){
		this.universidad= universidad;
		return "Editar";
	}

    public List<Universidad> getUniversidades() {
        return universidades;
    }

    public void setUniversidades(List<Universidad> universidades) {
        this.universidades = universidades;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
        
        
}
