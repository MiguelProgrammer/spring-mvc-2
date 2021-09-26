package br.estudandoemcasa.mvc.loja.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.estudandoemcasa.mvc.loja.enums.StatusPedido;
import br.estudandoemcasa.mvc.loja.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedido status);

}
