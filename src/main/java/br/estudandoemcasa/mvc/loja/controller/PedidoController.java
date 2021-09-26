package br.estudandoemcasa.mvc.loja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.estudandoemcasa.mvc.loja.dto.PedidoDTO;
import br.estudandoemcasa.mvc.loja.model.Pedido;
import br.estudandoemcasa.mvc.loja.repositories.PedidoRepository;

/*
 * Minhas Actions
 * Métodos que atendem requisições HTTP são chamados de action
 */
@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/formulario")
	public String formulario(PedidoDTO pedidoDTO) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid PedidoDTO pedidoDTO, BindingResult result) {

		Pedido pedido = pedidoDTO.toPedido();
		pedidoRepository.save(pedido);
		return result.hasErrors() ? "pedido/formulario" : "redirect:/home";
	}
}
