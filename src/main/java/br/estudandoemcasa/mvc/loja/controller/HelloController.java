package br.estudandoemcasa.mvc.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Minhas Actions
 * Métodos que atendem requisições HTTP são chamados de action
 */
@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(Model resquest) {
		resquest.addAttribute("nameCampo", "Olá mundo Spring MVC!");
		return "hello";
	}
}
