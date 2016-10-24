/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author PabloRam
 */
@Entity @Table(name="ingrediente")
public class Ingrediente implements Serializable{
    @Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ingrediente")
	private Long idIngrediente;
	@Column(length = 20)
	private String nombre;
	@Column(length = 20)
	private String clasificacion;
	@Column( length = 20)
	private String precio;
        @ManyToOne
	@JoinColumn(name="id_torta")
	private Torta torta;

    public Ingrediente(Long idIngrediente, String nombre, String clasificacion, String precio, Torta torta) {
        super();
        this.idIngrediente = idIngrediente;
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.precio = precio;
        this.torta = torta;
    }
        
        
        public Ingrediente(){
            this.idIngrediente = 0L;
        }

    public Long getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Long idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Torta getTorta() {
        return torta;
    }

    public void setTorta(Torta torta) {
        this.torta = torta;
    }
        
        
        
}
