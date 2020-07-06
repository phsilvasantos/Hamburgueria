package br.com.hamburgueria.controller;

import br.com.hamburgueria.controller.form.AtualizacaoPedidoForm;
import br.com.hamburgueria.domain.Pedido;
import br.com.hamburgueria.dto.PedidoDto;
import br.com.hamburgueria.service.LancheService;
import br.com.hamburgueria.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PedidoController {

    private PedidoService pedidoService;
    private LancheService lancheService;

    public PedidoController(PedidoService pedidoService, LancheService lancheService) {
        this.pedidoService = pedidoService;
        this.lancheService = lancheService;
    }

    @PostMapping("/iniciar")
    public ResponseEntity<PedidoDto> iniciarComanda(@RequestBody Integer numeroMesa, UriComponentsBuilder uriComponentsBuilder) {
        Date data = new Date();
        data.getTime();
        Pedido pedido = new Pedido();
        pedido.setDataPedido(data.toString());
        pedido.setNumeroMesaPedido(numeroMesa);
        pedidoService.salvarMesa(pedido);

        URI uri = uriComponentsBuilder.path("/pedidos/{id]").buildAndExpand(pedido.getIdPedido()).toUri();
        return ResponseEntity.created(uri).body(new PedidoDto(pedido));
    }

    @GetMapping("/comandas")
    public List<PedidoDto> listarComandas() {
        List<Pedido> pedidos = pedidoService.listarComandas();
        return PedidoDto.converter(pedidos);
    }

    @GetMapping("comandas/{numeroMesaPedido}")
    public ResponseEntity<PedidoDto> detalhesComanda(@PathVariable Integer numeroMesaPedido) {
        Optional<Pedido> pedido = pedidoService.pesquisarComanda(numeroMesaPedido);
        if (pedido.isPresent()) {
            return ResponseEntity.ok(new PedidoDto(pedido.get()));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @Transactional
    @DeleteMapping("finalizar/{numeroMesaPedido}")
    public ResponseEntity<Void> finalizarComanda(@PathVariable Integer numeroMesaPedido) {
        Optional<Pedido> pedido = pedidoService.pesquisarComanda(numeroMesaPedido);
        if (pedido.isPresent()) {
            pedidoService.finalizarComanda(pedido.get().getIdPedido());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @PutMapping("/alteraPedido/{numeroMesaPedido}")
    public ResponseEntity<PedidoDto> alterarPedido(@PathVariable Integer numeroMesaPedido, @RequestBody AtualizacaoPedidoForm pedidoForm){
        Optional<Pedido> optionalPedido = pedidoService.pesquisarComanda(numeroMesaPedido);
        if (optionalPedido.isPresent()){
            Pedido pedidoAtualizado = optionalPedido.get();
            pedidoAtualizado = pedidoForm.atualizar(numeroMesaPedido, pedidoService, lancheService);
            return ResponseEntity.ok(new PedidoDto(pedidoAtualizado));
        }
        return ResponseEntity.notFound().build();
    }

}
