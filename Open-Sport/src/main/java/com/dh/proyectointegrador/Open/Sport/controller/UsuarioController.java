package com.dh.proyectointegrador.Open.Sport.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.bapro.Rest.model.Usuario;
import com.dh.bapro.Rest.repository.CustomUsuarioRepository;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private CustomUsuarioRepository usuarioRepository;
	
	@GetMapping("")
	public List<Usuario> getUsuario(){
		return usuarioRepository.getAll();
	}
    
	@GetMapping("{position}")
	public Usuario getUsuario(@PathVariable("position") int id) {
		Usuario unUsuario = usuarioRepository.getUsuario(id);
		return unUsuario;
	}
	
	/**
	 * RequestBody es para que los datos viajen por el BODY
	 * @param unUsuarioARegistrar
	 * @return
	 */
	@PostMapping("")
	public String postUsuario(@RequestBody Usuario unUsuarioARegistrar) {
		usuarioRepository.addUsuario(unUsuarioARegistrar);
		return "Usuario registrado con exito";
	}
	
	@PutMapping("{id}")
	public Usuario updateUsuario(@PathVariable("id") int position,
			@RequestBody Usuario unUsuario) {
		return null;
	}
	
	@DeleteMapping("{id}")
	public Usuario deleteUsuario(@PathVariable("id") int position) {
		Usuario usuarioEliminado = usuarioRepository.deleteUsuario(position);
		return usuarioEliminado;
	}
}
