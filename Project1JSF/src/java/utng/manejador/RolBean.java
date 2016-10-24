package utng.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import utng.datos.RolDAO;
import utng.datos.UsuarioDAO;
import utng.modelo.Rol;
import utng.modelo.Usuario;

@ManagedBean
@SessionScoped
public class RolBean implements Serializable {

	private List<Rol> roles;
	private Rol rol;

	/**
	 * @return the roles
	 */
	public List<Rol> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	/**
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * @param rol
	 *            the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String listar() {
		RolDAO dao = new RolDAO();
		try {
			roles = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Roles";
	}

	public String eliminar() {
		RolDAO dao = new RolDAO();
		try {
			dao.delete(rol);
			roles = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}

	public String agregar() {
		rol = new Rol();
		return "Agregar";
	}

	public String guardar() {
		RolDAO dao = new RolDAO();
		try {
			if (rol.getIdRol() != 0) {
				dao.update(rol);
			} else {
				dao.insert(rol);
			}
			roles = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}

	public String cancelar() {
		return "Cancelar";
	}

	public String editar(Rol rol) {
		this.rol = rol;
		return "Editar";
	}
}
