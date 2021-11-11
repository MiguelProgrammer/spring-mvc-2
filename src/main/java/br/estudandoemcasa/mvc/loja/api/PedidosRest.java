package br.estudandoemcasa.mvc.loja.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.estudandoemcasa.mvc.loja.enums.StatusPedido;
import br.estudandoemcasa.mvc.loja.model.Pedido;
import br.estudandoemcasa.mvc.loja.repositories.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {
	
	@Autowired 
	private PedidoRepository pedidoRepository;

	@GetMapping("aguardando")
	public List<Pedido> getPedidosAguardando() {
		
		Sort sort = Sort.by("id").descending();
		PageRequest pagination = PageRequest.of(0,1,sort);
		
		return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, pagination);
	}
}
