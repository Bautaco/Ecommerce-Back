package com.example.pa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pa.service.PedidosService;

@RestController
@RequestMapping("/api/Compra")
public class PedidosController {
    @Autowired
    private PedidosService pedidosService;
    
}
