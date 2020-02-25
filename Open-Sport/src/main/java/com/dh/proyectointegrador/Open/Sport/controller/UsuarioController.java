package com.dh.proyectointegrador.Open.Sport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dh.proyectointegrador.Open.Sport.repository.usuarioJpaRepository;
import com.dh.proyectointegrador.Open.Sport.model.Usuario;


@Controller
public class UsuarioController {
	@Autowired
	private usuarioJpaRepository usuarioJpaRepository;
	
	@GetMapping("registro")
	public String getFormDeRegistro() {
		return "registro/registro";
}
	@PostMapping("")
	public String registrarUsuario(@RequestBody Usuario unUsuario) {
		Usuario usuarioRegistrado = usuarioJpaRepository.save(unUsuario);
		return "/home/home";
	}
}
