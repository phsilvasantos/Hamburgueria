package br.com.hamburgueria.dto;

import br.com.hamburgueria.domain.Lanche;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LancheDto {

    private Long id;
    private String nome;
    private Double valor;
    private Boolean disponibilidade;

    public LancheDto(Lanche lanche) {
        this.id = lanche.getIdLanche();
        this.nome = lanche.getNomeLanche();
        this.valor = lanche.getValorLanche();
        this.disponibilidade = lanche.getDisponibilidadeLanche();
    }

    public static List<LancheDto> converter(List<Lanche> lanches){
        return lanches.stream().map(LancheDto::new).collect(Collectors.toList());
    }

}
