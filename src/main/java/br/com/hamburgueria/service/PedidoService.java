package br.com.hamburgueria.service;

import br.com.hamburgueria.domain.Pedido;
import br.com.hamburgueria.repository.PedidoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Pedido> listarComandas() {
        return pedidoRepository.findAll();
    }

    public Pedido pesquisarComanda(Integer numeroMesaPedido) {
        Optional<Pedido> pedido = pedidoRepository.findByNumeroMesaPedido(numeroMesaPedido);
        return pedido.orElseThrow(() -> new ObjectNotFoundException("Comanda da mesa " + numeroMesaPedido + " não encontrada!", PedidoService.class.getName()));
    }
}
