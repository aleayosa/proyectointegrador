package com.dh.proyectointegrador.Open.Sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dh.proyectointegrador.Open.Sport.model.Usuario;

@Repository
public interface usuarioJpaRepository extends JpaRepository<Usuario, Integer > {

}
