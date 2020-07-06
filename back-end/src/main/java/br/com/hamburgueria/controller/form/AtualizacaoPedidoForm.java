package br.com.hamburgueria.controller.form;

import br.com.hamburgueria.domain.Lanche;
import br.com.hamburgueria.domain.Pedido;
import br.com.hamburgueria.service.LancheService;
import br.com.hamburgueria.service.PedidoService;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class AtualizacaoPedidoForm {

    private Integer numeroMesaPedido;
    private List<Long> lanches;

    public Pedido atualizar(Integer numeroMesaPedido, PedidoService pedidoService, LancheService lancheService){
        Pedido pedido = pedidoService.pesquisarComanda(numeroMesaPedido).get();
        List<Lanche> lancheList = pedido.getLanches();
        Double totalPedido = pedido.getValorPedido();
        if (this.numeroMesaPedido != null){
            pedido.setNumeroMesaPedido(this.numeroMesaPedido);
        }
        if (this.lanches != null) {
            for (int id = 0; id < lanches.size(); id++) {
                Lanche lancheSelecionado = lancheService.procurarLanche(lanches.get(id)).get();
                lancheList.add(lancheSelecionado);
                totalPedido += lancheSelecionado.getValorLanche();
            }
            pedido.setValorPedido(totalPedido);
        }
        pedido.setLanches(lancheList);
        return pedido;
    }

}
