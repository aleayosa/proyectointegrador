package com.dh.proyectointegrador.Open.Sport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.dh.proyectointegrador.Open.Sport.repository.usuarioJpaRepository;
import com.dh.proyectointegrador.Open.Sport.model.Producto;
import com.dh.proyectointegrador.Open.Sport.model.Usuario;


@Controller
public class UsuarioController {
	@Autowired
	private usuarioJpaRepository usuarioJpaRepository;
	
	@GetMapping("registro")
	public String getFormDeRegistro() {
		return "registro/registro";
}
	@PostMapping("registro")
	public String registrarUsuario(Usuario unUsuario) {
		usuarioJpaRepository.save(unUsuario);
		return "/home/home";
	}
	
	@GetMapping("usuarios")
	public String listarUSuarios(Model model) {
		List<Usuario> listaDeUsuarios = usuarioJpaRepository.findAll();
		model.addAttribute("listaDeUsuarios", listaDeUsuarios);
		return "/registro/listaUsuarios";
	}
}
