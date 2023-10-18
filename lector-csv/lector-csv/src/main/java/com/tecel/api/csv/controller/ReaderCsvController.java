package com.tecel.api.csv.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tecel.api.csv.service.UsuarioService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/usuario")
public class ReaderCsvController {

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/{id}")
    public String pruebametodo(@PathVariable("id") String i) {
        return "Hola Aldo desde la tierra "+i;
    }

    @GetMapping("/")
    public String pruebametodo2(@RequestParam(required = true,defaultValue = "2",name = "nom") String i) {
        return "Hola Aldo desde la tierra "+i;
    }
    @GetMapping("/all")
    public List<String[]> pruebametodo3() throws Exception{
        Path path = Paths.get(ClassLoader.getSystemResource("usuarios.csv").toURI());
        System.out.println(path);
    //    final Path path = Paths.get(ClassLoader.getSystemResource("usuarios.csv").toURI());
        return usuarioService.getUsuarios(path);
    }
    
    
}
