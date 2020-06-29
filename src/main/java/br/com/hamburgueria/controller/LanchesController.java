package br.com.hamburgueria.controller;

import br.com.hamburgueria.domain.Lanche;
import br.com.hamburgueria.dto.ListaLanchesDto;
import br.com.hamburgueria.service.LancheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/lanches")
@RestController
public class LanchesController {

    private LancheService lancheService;

    LanchesController(LancheService lancheService){
        this.lancheService = lancheService;
    }

    @GetMapping("/lista")
    public List<ListaLanchesDto> listarLanches(){
        List<Lanche> lanches = lancheService.listarLanches();
        return ListaLanchesDto.converter(lanches);
    }

}
