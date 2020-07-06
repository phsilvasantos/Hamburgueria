package br.com.hamburgueria.repository;

import br.com.hamburgueria.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Optional<Pedido> findByNumeroMesaPedido(Integer numeroMesaPedido);

}
