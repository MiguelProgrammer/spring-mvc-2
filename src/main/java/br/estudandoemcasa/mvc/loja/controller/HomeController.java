package br.estudandoemcasa.mvc.loja.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.estudandoemcasa.mvc.loja.enums.StatusPedido;
import br.estudandoemcasa.mvc.loja.model.Pedido;
import br.estudandoemcasa.mvc.loja.repositories.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model request, Principal principal) {
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE);
		request.addAttribute("pedidos", pedidos);
		return "usuario/home";
	}

}
