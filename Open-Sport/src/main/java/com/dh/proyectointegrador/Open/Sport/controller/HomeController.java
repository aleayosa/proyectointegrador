package com.dh.proyectointegrador.Open.Sport.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dh.proyectointegrador.Open.Sport.model.Producto;
import com.dh.proyectointegrador.Open.Sport.model.Usuario;
import com.dh.proyectointegrador.Open.Sport.repository.usuarioJpaRepository;
import com.dh.proyectointegrador.Open.Sport.repository.productoJpaRepository;

@Controller
public class HomeController {

	@Autowired
	private productoJpaRepository productoJpaRepository;
	
	@Autowired
	private usuarioJpaRepository usuarioJpaRepository;

	
	@GetMapping("home")
	public String irAlHome(Model model) {
		List<Producto> listaDeProductos = productoJpaRepository.findAll();
		model.addAttribute("listaDeProductos", listaDeProductos);
		return "/home/home";
	}
	
	@PostMapping("agregar/{productos_id}")
	public String agregarProductoAlCarrito(@PathVariable("productos_id") Long productos_id,RedirectAttributes redirAtt) {
		Optional<Producto> unProducto = this.productoJpaRepository.findById(productos_id);
		Producto producto = unProducto.get();
		
		Optional<Usuario> usuario = this.usuarioJpaRepository.findById((Integer) 1);
		Usuario unUsuario = usuario.get();
		
//		unUsuario.agregarProductos(producto);
		
		this.usuarioJpaRepository.save(unUsuario);
		
		redirAtt.addFlashAttribute("mensaje", "Producto agregado exitosamente");
		
		return "redirect:/ver_carrito";
	}
	
	
}
