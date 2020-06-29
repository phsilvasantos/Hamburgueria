package br.com.hamburgueria.dto;

import br.com.hamburgueria.domain.Lanche;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalhesContaDto {

    private Long numeroMesa;
    private Double valor;
    private ArrayList<Lanche> lanches;

}
