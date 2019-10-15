package com.progWeb.exerc01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contador")
public class ContadorController {
    private int num = 0;
    
    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public int getContador() {
        return num;
    }
    
    @RequestMapping(path = "/post", method = RequestMethod.POST)
    public String postContador() {
        ++num;
        return "O número foi incrementado com sucesso.";
    }
    
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public String deleteContador() {
        num = 0;
        return "O número foi zerado com sucesso.";
    }
    
    @RequestMapping(path = "/put", method = RequestMethod.PUT)
    public String putContador() {
        --num;
        return "O número foi decrementado com sucesso.";
    }
    
}
