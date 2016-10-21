package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="carrera")
public class Carrera implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_carrera")
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String ubicacion;
	
	@Column(name = "cantidad_alumno")
	private int cantidadAlumno;

	
	private int cuatrimestre;
	
	@ManyToOne
	@JoinColumn(name="id_facultad")
	private Facultad facultad;
        
        @ManyToOne
	@JoinColumn(name="id_universidad")
	private Universidad universidad;

    public Carrera(Long id, String nombre, String descripcion, String ubicacion, int cantidadAlumno, int cuatrimestre, Facultad facultad, Universidad universidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.cantidadAlumno = cantidadAlumno;
        this.cuatrimestre = cuatrimestre;
        this.facultad = facultad;
        this.universidad = universidad;
    }
        
        
	
	public Carrera() {
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


	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public int getCantidadAlumno() {
		return cantidadAlumno;
	}


	public void setCantidadAlumno(int cantidadAlumno) {
		this.cantidadAlumno = cantidadAlumno;
	}


	public int getCuatrimestre() {
		return cuatrimestre;
	}


	public void setCuatrimestre(int cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}


	public Facultad getFacultad() {
		return facultad;
	}


	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

	
}

