package br.com.hamburgueria.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    private String dataPedido;
    private Integer numeroMesaPedido;
    private Double valorPedido = null;

}
