package br.com.hamburgueria.controller;

import br.com.hamburgueria.domain.Pedido;
import br.com.hamburgueria.dto.PedidoDto;
import br.com.hamburgueria.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/iniciar")
    public ResponseEntity<PedidoDto> iniciarComanda(@RequestBody Integer numeroMesa, UriComponentsBuilder uriComponentsBuilder){
        Date data = new Date();
        data.getTime();
        Pedido pedido = new Pedido();
        pedido.setDataPedido(data.toString());
        pedido.setNumeroMesaPedido(numeroMesa);
        pedidoService.salvarMesa(pedido);

        URI uri = uriComponentsBuilder.path("/pedidos/{id]").buildAndExpand(pedido.getIdPedido()).toUri();
        return ResponseEntity.created(uri).body(new PedidoDto(pedido));

    }

}
