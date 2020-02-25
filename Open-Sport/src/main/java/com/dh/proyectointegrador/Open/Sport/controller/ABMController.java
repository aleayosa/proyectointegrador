package com.dh.proyectointegrador.Open.Sport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ABMController {

		@GetMapping()
		public String irAlABM(){
			return "/productos/ABMProductos";
		}
}
