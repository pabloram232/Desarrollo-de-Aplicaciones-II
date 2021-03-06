package utng.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="facultad")
public class Facultad implements Serializable{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_facultad")
	private Long id;
	
	private String nombre;
	
	
	private String descripcion;
	
	private String edificio;
	
	private String politica;
	
	
	public Facultad() {
		id = 0L;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public String getPolitica() {
		return politica;
	}

	public void setPolitica(String politica) {
		this.politica = politica;
	}

	



	
}
