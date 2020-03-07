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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.dh.proyectointegrador.Open.Sport.model.Compra;
import com.dh.proyectointegrador.Open.Sport.model.Producto;
import com.dh.proyectointegrador.Open.Sport.repository.compraJpaRepository;
import com.dh.proyectointegrador.Open.Sport.repository.productoJpaRepository;

@Controller
@RequestMapping("carrito")
public class CompraController {

	@Autowired
	private compraJpaRepository compraJpaRepository;
	
	@Autowired
	private productoJpaRepository productoJpaRepository; 

	
	@GetMapping("ver_carrito")
	public String getCarrito(Model model) {
		Optional<Compra> unaCompra = this.compraJpaRepository.findById((Integer) 1);
		Compra compra = unaCompra.get();
		
		List<Producto> listaDeProductosDelCarrito = compra.verCarrito();
		
		model.addAttribute("listaDeProductosDelCarrito", listaDeProductosDelCarrito);
		return "/carrito/carrito";
	}
	
	
	
	
	
}
