/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.manejador;

import java.io.Serializable;
import java.util.List;
import utng.datos.TortaDAO;
import utng.modelo.Torta;

/**
 *
 * @author PabloRam
 */
public class TortaBean implements Serializable {
   private List<Torta> tortas;
	private Torta torta; 
        
        public String listar() {
		TortaDAO dao = new TortaDAO();
		try {
			tortas = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Facultades";
	}

	public String eliminar() {
		TortaDAO dao = new TortaDAO();
		try {
			dao.delete(torta);
			tortas = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}
	
	public String agregar(){
		torta = new Torta();	
		return "Agregar";
	}

	public String guardar() {
		TortaDAO dao = new TortaDAO();
		try {
			if (torta.getId() != 0) {
				dao.update(torta);
			} else {
				dao.insert(torta);
			}
			tortas = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}

	public String cancelar() {
		return "Cancelar";
	}

	public String editar(Torta facultad){
		this.torta = facultad;
		return "Editar";
	}

    public List<Torta> getTortas() {
        return tortas;
    }

    public void setTortas(List<Torta> tortas) {
        this.tortas = tortas;
    }

    public Torta getTorta() {
        return torta;
    }

    public void setTorta(Torta torta) {
        this.torta = torta;
    }
        
}
