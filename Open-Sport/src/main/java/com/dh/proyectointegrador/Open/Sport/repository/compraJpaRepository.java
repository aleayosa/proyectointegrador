package com.dh.proyectointegrador.Open.Sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dh.proyectointegrador.Open.Sport.model.Compra;

@Repository
public interface compraJpaRepository extends JpaRepository<Compra, Integer>{

}
