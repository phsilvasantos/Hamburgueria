package br.com.hamburgueria.dto;

import br.com.hamburgueria.domain.Lanche;
import br.com.hamburgueria.domain.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoDto {

    private Long id;
    private String data;
    private Integer numeroMesa;
    private Double valor;
    private List<Lanche> lanches;

    public PedidoDto(Pedido pedido){
        this.id = pedido.getIdPedido();
        this.valor = pedido.getValorPedido();
        this.numeroMesa = pedido.getNumeroMesaPedido();
        this.data = pedido.getDataPedido();
        this.lanches = pedido.getLanches();
    }

    public static List<PedidoDto> converter(List<Pedido> pedidos){
        return pedidos.stream().map(PedidoDto::new).collect(Collectors.toList());
    }

}
