/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Repositorio;

import com.example.demo.entidades.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author COMPAC
 */
@Repository
public interface PersonaRepositorio extends JpaRepository<Persona,String>{
    
    @Query("SELECT p FROM Persona p WHERE p.ciudad.nombre = :nombre")    
    public List<Persona> listarPorCiudad(@Param("nombre") String ciudad);
    
    
    @Query("SELECT p FROM Persona p WHERE p.id = :id")
    public Persona buscarPorId(@Param("id")String id);
 
    @Query("SELECT p FROM Persona p WHERE p.documento = :documento")
    public Persona busacrPorDNI(@Param("documento") Long documento);
}
