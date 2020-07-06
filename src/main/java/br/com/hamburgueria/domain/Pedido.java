package br.com.hamburgueria.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    private Double valorPedido;
    @ManyToMany
    @JoinTable(name="PEDIDO_LANCHES", joinColumns=
            {@JoinColumn(name="ID_PEDIDO")}, inverseJoinColumns=
            {@JoinColumn(name="ID_LANCHE")})
    private List<Lanche> lanches;

}
