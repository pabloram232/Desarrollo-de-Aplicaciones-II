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
import javax.persistence.Table;

/**
 *
 * @author PabloRam
 */
@Entity
@Table(name = "torta")
public class Torta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_torta")
    private Long id;
    @Column(length=30)
    private String nombre;

    private int precio;
    @Column(length=30)
    private String tipo_torta;

    public Torta(Long id, String nombre, int precio, String tipo_torta) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo_torta = tipo_torta;
    }
    
    public Torta(){
        this(0L,"",0,"");
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTipo_torta() {
        return tipo_torta;
    }

    public void setTipo_torta(String tipo_torta) {
        this.tipo_torta = tipo_torta;
    }
    
    

   
    
}
