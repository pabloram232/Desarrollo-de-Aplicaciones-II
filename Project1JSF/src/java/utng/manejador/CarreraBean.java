package utng.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import utng.datos.CarreraDAO;
import utng.datos.FacultadDAO;
import utng.datos.UniversidadDAO;
import utng.modelo.Carrera;
import utng.modelo.Facultad;
import utng.modelo.Universidad;

@ManagedBean
@SessionScoped
public class CarreraBean implements Serializable {

	private List<Carrera> carreras;
	private Carrera carrera;
	private List<Facultad> facultades;
        private List<Universidad> universidades;

	public CarreraBean() {
		carrera = new Carrera();
		carrera.setFacultad(new Facultad());
                carrera.setUniversidad(new Universidad());
	}

	public String listar() {
		CarreraDAO dao = new CarreraDAO();
		try {
			carreras = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Carreras";
	}

	public String eliminar() {
		CarreraDAO dao = new CarreraDAO();
		try {
			dao.delete(carrera);
			carreras = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}

	public String agregar() {
		carrera = new Carrera();
		carrera.setFacultad(new Facultad());
                carrera.setUniversidad(new Universidad());
		try {
			facultades = new FacultadDAO().getAll();
                        universidades = new UniversidadDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Agregar";
	}

	public String guardar() {
		CarreraDAO dao = new CarreraDAO();
		try {
			if (carrera.getId() != 0) {
				dao.update(carrera);
			} else {
				dao.insert(carrera);
			}
			carreras = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}

	public String cancelar() {
		return "Cancelar";
	}

	public String editar(Carrera carrera) {
		this.carrera = carrera;
		try {
			facultades = new FacultadDAO().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Editar";
	}

	public List<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public List<Facultad> getFacultades() {
		return facultades;
	}

	public void setFacultades(List<Facultad> facultades) {
		this.facultades = facultades;
	}

    public List<Universidad> getUniversidades() {
        return universidades;
    }

    public void setUniversidades(List<Universidad> universidades) {
        this.universidades = universidades;
    }

}