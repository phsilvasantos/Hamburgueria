package br.com.hamburgueria.controller;

import br.com.hamburgueria.controller.form.AtualizacaoForm;
import br.com.hamburgueria.domain.Lanche;
import br.com.hamburgueria.dto.LancheDto;
import br.com.hamburgueria.service.LancheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class LanchesController {

    private LancheService lancheService;

    public LanchesController(LancheService lancheService){
        this.lancheService = lancheService;
    }

    @GetMapping("/lanches")
    public List<LancheDto> listarLanches(){
        List<Lanche> lanches = lancheService.listarLanchesDisponiveis();
        return LancheDto.converter(lanches);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<LancheDto> cadastrarLanche(@RequestBody LancheDto lancheDto, UriComponentsBuilder uriComponentsBuilder){
        Lanche lanche = new Lanche();
        lanche.setNomeLanche(lancheDto.getNome());
        lanche.setDisponibilidadeLanche(lancheDto.getDisponibilidade());
        lanche.setValorLanche(lancheDto.getValor());
        lancheService.salvarLanche(lanche);

        URI uri = uriComponentsBuilder.path("/lanches/{id}").buildAndExpand(lanche.getIdLanche()).toUri();
        return ResponseEntity.created(uri).body(new LancheDto(lanche));
    }

    @Transactional
    @DeleteMapping("/lanches/{id}")
    public ResponseEntity<Void> excluirLanche (@PathVariable Long id){
        Optional<Lanche> lanche = lancheService.procurarLanche(id);
        if (lanche.isPresent()){
            lancheService.deletarLanche(id);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("lanches/{id}")
    public ResponseEntity<LancheDto> detalhesLanche(@PathVariable Long id){
        Optional<Lanche> lanche = lancheService.procurarLanche(id);
        if (lanche.isPresent()){
            return ResponseEntity.ok(new LancheDto(lanche.get()));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/todosLanches")
    public List<LancheDto> listarTodosLanches(){
        List<Lanche> lanches = lancheService.listarTodosLanches();
        return LancheDto.converter(lanches);
    }

    @Transactional
    @PutMapping("/alterar/{id}")
    public ResponseEntity<LancheDto> atualizar (@PathVariable Long id, @RequestBody AtualizacaoForm lanche){
        Optional<Lanche> optionalLanche = lancheService.procurarLanche(id);
        if (optionalLanche.isPresent()){
            Lanche lancheAtualizado = lanche.atualizar(id, lancheService);
            return ResponseEntity.ok(new LancheDto(lancheAtualizado));
        }
        return ResponseEntity.notFound().build();
    }

}
