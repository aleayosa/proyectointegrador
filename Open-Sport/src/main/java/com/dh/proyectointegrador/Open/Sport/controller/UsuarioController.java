package com.dh.proyectointegrador.Open.Sport.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dh.proyectointegrador.Open.Sport.repository.usuarioJpaRepository;
import com.dh.proyectointegrador.Open.Sport.model.Producto;
import com.dh.proyectointegrador.Open.Sport.model.Usuario;


@Controller
@RequestMapping
public class UsuarioController {
	@Autowired
	private usuarioJpaRepository usuarioJpaRepository;

	@GetMapping("registro")
	public String getFormDeRegistro() {
		return "registro/registro";
    }

	@PostMapping("registro")
	public String registrarUsuarios(Usuario usuario) {
		usuarioJpaRepository.save(usuario);
		return "/home/home";
	}
	
	@GetMapping("usuarios")
	public String listarUSuarios(Model model) {
		List<Usuario> listaDeUsuarios = usuarioJpaRepository.findAll();
		model.addAttribute("listaDeUsuarios", listaDeUsuarios);
		return "/registro/listaUsuarios";
	}
	
	@GetMapping("ver_carrito")
	public String getCarrito(Model model) {
		Optional<Usuario> usuario = this.usuarioJpaRepository.findById((Integer) 1);
		Usuario unUsuario = usuario.get();
		
	    List<Producto> listaDeProductosDelCarrito = unUsuario.verCarrito();
		
		model.addAttribute("listaDeProductosDelCarrito", listaDeProductosDelCarrito);
		
		double totalDeCompra = 0.0;
		for(int i = 0; i<listaDeProductosDelCarrito.size();i++) {
			totalDeCompra += unUsuario.getTotalDeCompra();
		} 
		
		model.addAttribute("totalDelCompra", totalDeCompra);		
		
		return "/carrito/carrito";
	}
}