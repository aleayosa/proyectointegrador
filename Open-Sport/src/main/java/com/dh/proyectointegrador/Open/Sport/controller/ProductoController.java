package com.dh.proyectointegrador.Open.Sport.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		
		//cuando entro POR POST al mismo endpoint le doy enviar al formulario 
		//de alta y me lleva al listado de productos, con el mensaje de que se ingresó exitosamente:
		
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
		//productos, resultado de iterar la tabla de productos que se ingresaron con el 
		//metodo anterior, con thymeleaf crea una row por cada producto:
		
		@GetMapping("todos")
		public String listarProductos(Model model) {
			List<Producto> listaDeProductos = productoJpaRepository.findAll();
			model.addAttribute("listaDeProductos", listaDeProductos);
			return "/productos/listadoProductos";
		}
		
		
		// al hacer click en editar (vinculo) en el listado de productos ejecuta el getById para el formulario de edicion
		@GetMapping("/editar/{id}")
		public String mostrarFormularioEditar(@PathVariable long id, Model model) {
		    model.addAttribute("producto", productoJpaRepository.findById(id).orElse(null));
		    return "productos/editarProducto";
		}
		
		
		// al hacer click en guardar se ejecuta el POST del formulario de edicion
		@PostMapping("/editar/{id}")
		public String actualizarProducto( Producto producto) {
			productoJpaRepository.save(producto);
			return "productos/listadoProducto";
		}
		
		@PostMapping("/eliminar")
		public String eliminarProducto(@ModelAttribute Producto producto, RedirectAttributes redirectAttrs) {
		    redirectAttrs
		            .addFlashAttribute("mensaje", "Eliminado correctamente")
		            .addFlashAttribute("clase", "warning");
		    productoJpaRepository.deleteById(producto.getId());
		    return "redirect:/producto/todos";
		}
		
		
}