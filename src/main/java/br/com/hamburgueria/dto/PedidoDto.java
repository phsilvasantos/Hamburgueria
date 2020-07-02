package br.com.hamburgueria.dto;

import br.com.hamburgueria.domain.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data;
    private Integer numeroMesa;
    private Double valor;

    public PedidoDto(Pedido pedido){
        this.id = pedido.getIdPedido();
        this.valor = pedido.getValorPedido();
        this.numeroMesa = pedido.getNumeroMesaPedido();
        this.data = pedido.getDataPedido();
    }
}
