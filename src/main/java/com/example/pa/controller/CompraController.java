package com.example.pa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pa.service.CompraService;

@RestController
@RequestMapping("/api/Compra")
public class CompraController {
    @Autowired
    private CompraService compraService;
    
}
