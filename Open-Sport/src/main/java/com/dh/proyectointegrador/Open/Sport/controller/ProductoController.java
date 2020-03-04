package com.dh.proyectointegrador.Open.Sport.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dh.proyectointegrador.Open.Sport.model.Categoria;
import com.dh.proyectointegrador.Open.Sport.model.Marca;
import com.dh.proyectointegrador.Open.Sport.model.Producto;
import com.dh.proyectointegrador.Open.Sport.repository.categoriaJpaRepository;
import com.dh.proyectointegrador.Open.Sport.repository.productoJpaRepository;
import com.dh.proyectointegrador.Open.Sport.repository.marcaJpaRepository;

@Controller
@RequestMapping("producto")
public class ProductoController {

		@Autowired
		private productoJpaRepository productoJpaRepository;
		
		@Autowired
		private categoriaJpaRepository categoriaJpaRepository;
		
		@Autowired
		private marcaJpaRepository marcaJpaRepository;
		
		//cuando entro POR GET en localhost:8080/producto/alta obtengo el formulario para 
		//ingresar un producto.
		
		@GetMapping("alta")
		public String getFormDeAlta(Producto producto, Model model) {
			List<Categoria> listaDeCategorias = categoriaJpaRepository.findAll();
			model.addAttribute("listaDeCategorias", listaDeCategorias);
			List<Marca> listaDeMarcas = marcaJpaRepository.findAll();
			model.addAttribute("listaDeMarcas", listaDeMarcas);
			return "/productos/nuevoProducto";
	    }
		
		//cuando entro POR POST en localhost:8080/producto/alta le doy enviar al formulario 
		//de al ta y me devuelve al home del administrador:
		
		@PostMapping("alta")
		public String ingresarProducto(@Valid Producto producto, BindingResult bindingResult, RedirectAttributes redirAtt ) {
			
			if (bindingResult.hasErrors()) {
				return "/productos/nuevoProducto";
			}
			productoJpaRepository.save(producto);
			redirAtt.addFlashAttribute("mensaje", "Producto guardado exitosamente");
			return "redirect:/producto/todos";
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
		
		@GetMapping("/edit/{id}")
		public String editarProducto(@PathVariable("id") Producto prod, Model model) {
			model.addAttribute("productos", prod);
			return "/productos/editarProducto";
		}
		
		//entro por GET a localhost:8080/producto/edit y obtengo el form para editar productos:
		
		@PostMapping("/edit/{id}")
		public String editadoProducto(@Valid Producto producto, BindingResult bindingResult, RedirectAttributes redirAtt) {
			if(bindingResult.hasErrors()) {
				return "registroProductos";
			}
			productoJpaRepository.save(producto);
			redirAtt.addFlashAttribute("mensaje", "Producto editado Exitosamente :)");
			return "redirect:/producto/todos";
		}
}
		
