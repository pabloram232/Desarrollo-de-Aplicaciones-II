package utng.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import utng.datos.FacultadDAO;

import utng.modelo.Facultad;



@ManagedBean
@SessionScoped
public class FacultadBean implements Serializable {

	private List<Facultad> facultades;
	private Facultad facultad;
	

	public String listar() {
		FacultadDAO dao = new FacultadDAO();
		try {
			facultades = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Facultades";
	}

	public String eliminar() {
		FacultadDAO dao = new FacultadDAO();
		try {
			dao.delete(facultad);
			facultades = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}
	
	public String agregar(){
		facultad = new Facultad();	
		return "Agregar";
	}

	public String guardar() {
		FacultadDAO dao = new FacultadDAO();
		try {
			if (facultad.getId() != 0) {
				dao.update(facultad);
			} else {
				dao.insert(facultad);
			}
			facultades = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}

	public String cancelar() {
		return "Cancelar";
	}

	public String editar(Facultad facultad){
		this.facultad = facultad;
		return "Editar";
	}

	public List<Facultad> getFacultades() {
		return facultades;
	}

	public void setFacultades(List<Facultad> facultades) {
		this.facultades = facultades;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	
	
	
	
}
