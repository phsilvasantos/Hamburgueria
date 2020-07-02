package br.com.hamburgueria.service;

import br.com.hamburgueria.domain.Pedido;
import br.com.hamburgueria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void salvarMesa(Pedido pedido) {
        pedidoRepository.save(pedido);
    }
}
