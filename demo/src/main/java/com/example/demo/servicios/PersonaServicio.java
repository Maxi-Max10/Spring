
package com.example.demo.servicios;

import com.example.demo.Repositorio.PersonaRepositorio;
import com.example.demo.entidades.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServicio {
    
    @Autowired
    PersonaRepositorio pr;
    @Autowired
    CiudadServicio cs;
    
    
    @Transactional
    public Persona crearPersona(Persona persona) throws Exception{
        validacion(persona.getDocumento(), persona.getNombre(), persona.getApellido());
        
        return pr.save(persona); // usando este metodo  nos queda guardada la persona
    }
    
    @Transactional
    public void validacion(Long documento, String nombre, String apellido) throws Exception{
        
        if (documento < 0 || documento == null) {
            throw new Exception("El documento no puede ser negativo o nulo");
        }
        
        Persona p = pr.busacrPorDNI(documento);
        if (p != null) {
            throw new Exception("Ya existe una persona con ese documento en la base de datos");
        }
        
        if (nombre == null || nombre.isEmpty()) {
            throw new Exception("El nombre no puede estar vacio");
        }
        
    }
    
    @Transactional
    public Persona modificarPersona(Persona persona) throws Exception{
        Persona p = pr.busacrPorDNI(persona.getDocumento()); //Vemos si la persona esta en la base de datos
        if (p != null) {
             validacion(persona.getDocumento(), persona.getNombre(), persona.getApellido());
             p.setNombre(persona.getNombre());
             p.setApellido(persona.getApellido());
             return pr.save(p);
        }else{
            throw new Exception("No se encontro la persona en la base de datos");
        }
        
    }
    
    @Transactional
    public void eliminarPersona(Persona persona) throws Exception{
        
        Persona p = pr.busacrPorDNI(persona.getDocumento()); //Vemos si la persona esta en la base de datos
        if (p != null) {
            pr.delete(p);
        }else{
            throw new Exception("No se encontro la persona en la base de datos");
        }
        
    }
    
//    public Persona buscarPorID(String id) throws Exception{
//        
//        Optional<Persona> p = pr.findById(id);
//        
//        if (p.isPresent()) {
//            Persona per = p.get();
//            return per;
//        }else{
//            throw new Exception("No se encontro la persona");
//        }
//        
//    }
    @Transactional
    public Persona BuscarPorID(String id){
        return pr.buscarPorId(id);
    }
    
    public List<Persona> listarTodas(){        
        return pr.findAll();
    }
}
