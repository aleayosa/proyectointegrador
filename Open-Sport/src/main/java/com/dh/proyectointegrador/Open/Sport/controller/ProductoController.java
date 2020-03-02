package com.dh.proyectointegrador.Open.Sport.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		
		//cuando entro POR GET en localhost:8080/producto/alta obtengo el formulario para 
		//ingresar un producto.
		
		@GetMapping("alta")
		public String getFormDeAlta(Producto producto) {
			return "/productos/nuevoProducto";
	    }
		
		//cuando entro POR POST en localhost:8080/producto/alta le doy enviar al formulario 
		//de al ta y me devuelve al home del administrador:
		
		@PostMapping("alta")
		public String ingresarProducto(@Valid Producto producto, BindingResult bindingResult ) {
			
			if (bindingResult.hasErrors()) {
				return "/productos/nuevoProducto";
			}
			productoJpaRepository.save(producto);
			return "/productos/ABMProductos";
		}

		//cuando entro POR GET en localhost:8080/producto/todos obtengo el listado de 
		//productos, resultado de iterar la tabla de productos que s eingresaron con el 
		//metodo anterior, con thymeleaf crea una row por cada producto:
		
		@GetMapping("todos")
		public String listarProductos(Model model) {
			List<Producto> listaDeProductos = productoJpaRepository.findAll();
			model.addAttribute("listaDeProductos", listaDeProductos);
			return "/productos/listadoProductos";
		}
}
		
