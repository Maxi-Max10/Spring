
package com.example.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Persona {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private Long documento;
    private String nombre;
    private String apellido;
    
    
    @ManyToOne
    private Ciudad ciudad;

    public Persona() {
    }

    public Persona(String id, Long documento, String nombre, String apellido, Ciudad ciudad) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    

}
