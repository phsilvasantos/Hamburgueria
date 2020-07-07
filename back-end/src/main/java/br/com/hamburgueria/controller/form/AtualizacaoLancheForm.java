package br.com.hamburgueria.controller.form;

import br.com.hamburgueria.domain.Lanche;
import br.com.hamburgueria.service.LancheService;
import lombok.Setter;

@Setter
public class AtualizacaoLancheForm {

    private String nomeLanche;
    private Double valorLanche;
    private Boolean disponibilidadeLanche;

    public Lanche atualizar(Long id, LancheService lancheService) {
        Lanche lanche = lancheService.getOne(id);

        lanche.setIdLanche(id);
        lanche.setValorLanche(this.valorLanche);
        lanche.setDisponibilidadeLanche(this.disponibilidadeLanche);
        lanche.setNomeLanche(this.nomeLanche);
        return lanche;
    }

}
