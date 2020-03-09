package com.dh.proyectointegrador.Open.Sport.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PostMapping("alta")
	public String registrarUsuario(@Valid Usuario usuario, BindingResult bindingResult) {
	
		if(bindingResult.hasErrors()) {
			return "registro/registro";
		}
		
		usuarioJpaRepository.save(usuario);
		
		return "/home/home";
	}
	
	@GetMapping("usuarios")
	public String listarUSuarios(Model model) {
		List<Usuario> listaDeUsuarios = usuarioJpaRepository.findAll();
		model.addAttribute("listaDeUsuarios", listaDeUsuarios);
		return "/registro/listaUsuarios";
	}
}
