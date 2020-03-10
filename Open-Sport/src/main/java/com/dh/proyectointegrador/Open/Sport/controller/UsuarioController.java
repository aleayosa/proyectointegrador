package com.dh.proyectointegrador.Open.Sport.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@PostMapping("alta")
	public String registrarUsuarios(@Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes redirAtt ) {

		if (bindingResult.hasErrors()) {
			return "/registro/registro";
		}

		usuarioJpaRepository.save(usuario);

		redirAtt.addFlashAttribute("mensaje", "Usuario guardado exitosamente");

		return "redirect:/home";
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
