package br.com.hamburgueria.dto;

import br.com.hamburgueria.domain.Lanche;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ListaLanchesDto {

    private Long id;
    private String nome;
    private Double valor;
    private Boolean disponibilidade;

    public ListaLanchesDto(Lanche lanche) {
        this.id = lanche.getIdLanche();
        this.nome = lanche.getNomeLanche();
        this.valor = lanche.getValorLanche();
        this.disponibilidade = lanche.getDisponibilidadeLanche();
    }

    public static List<ListaLanchesDto> converter(List<Lanche> lanches){
        return lanches.stream().map(ListaLanchesDto::new).collect(Collectors.toList());
    }

}
