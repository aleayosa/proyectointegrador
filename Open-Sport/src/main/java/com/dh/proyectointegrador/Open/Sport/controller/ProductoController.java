package com.dh.proyectointegrador.Open.Sport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dh.proyectointegrador.Open.Sport.model.Producto;
import com.dh.proyectointegrador.Open.Sport.repository.productoJpaRepository;

@Controller
@RequestMapping("producto")
public class ProductoController {

		@Autowired
		private productoJpaRepository productoJpaRepository;
		
		//cuando entro POR GET en localhost:8080/producto/alta:
		
		@GetMapping("alta")
		public String getFormDeAlta() {
			return "/productos/nuevoProducto";
	}
		
		//cuando entro POR POST en localhost:8080/producto/alta:
		
		@PostMapping("alta")
		public String ingresarProducto(Producto unProducto) {
			productoJpaRepository.save(unProducto);
			return "/productos/ABMProductos";
		}

		//cuando entro POR GET en localhost:8080/producto/todos:
		@GetMapping("todos")
		public String listarProductos(Model model) {
			List<Producto> listaDeProductos = productoJpaRepository.findAll();
			model.addAttribute("listaDeProductos", listaDeProductos);
			return "productos/listadoProductos";
		}
}
