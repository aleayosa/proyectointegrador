package com.dh.proyectointegrador.Open.Sport.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dh.proyectointegrador.Open.Sport.model.Compra;
import com.dh.proyectointegrador.Open.Sport.model.Producto;
import com.dh.proyectointegrador.Open.Sport.repository.compraJpaRepository;
import com.dh.proyectointegrador.Open.Sport.repository.productoJpaRepository;

@Controller
public class HomeController {

	@Autowired
	private productoJpaRepository productoJpaRepository;
	
	@Autowired
	private compraJpaRepository compraJpaRepository;

	
	@GetMapping("home")
	public String irAlHome(Model model) {
		List<Producto> listaDeProductos = productoJpaRepository.findAll();
		model.addAttribute("listaDeProductos", listaDeProductos);
		return "/home/home";
	}
	
	@PostMapping("agregar/{productos_id}")
	public String agregarProductoAlCarrito(@PathVariable("productos_id") Long productos_id, BindingResult bindingResult, RedirectAttributes redirAtt) {
		Optional<Producto> unProducto = this.productoJpaRepository.findById(productos_id);
		Producto producto = unProducto.get();
		Optional<Compra> unaCompra = this.compraJpaRepository.findById((Integer) 1);
		Compra compra = unaCompra.get();
		
		compra.agregarProductos(producto);
		if (bindingResult.hasErrors()) {
			return "/home/home";
		}
		this.compraJpaRepository.save(compra);
		redirAtt.addFlashAttribute("mensaje", "Producto agregado exitosamente");
		return "redirect:/carrito/ver_carrito";
	}	
}
