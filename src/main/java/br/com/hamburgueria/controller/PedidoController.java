package br.com.hamburgueria.controller;

import br.com.hamburgueria.service.PedidoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


}
