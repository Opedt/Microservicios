package com.tecel.api.csv.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tecel.api.csv.bean.CsvBean;
import com.tecel.api.csv.bean.UsuarioNamedBean;
import com.tecel.api.csv.service.UsuarioService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/usuario")
public class ReaderCsvController {

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/{id}")
    public String pruebametodo(@PathVariable("id") String i) {
        return "Hola Aldo desde la tierra "+i;
    }


    @GetMapping("/beanpos")
       public List<CsvBean> obtieneUsuarioPos() throws Exception{
        Path path = Paths.get(ClassLoader.getSystemResource("usuarios.csv").toURI());
        System.out.println(path);
    //    final Path path = Paths.get(ClassLoader.getSystemResource("usuarios.csv").toURI());
        return usuarioService.simplePositionBeanExample(path);
    }

    @GetMapping("/beannamed")
       public List<CsvBean> obtieneUsuarionamed() throws Exception{
        Path path = Paths.get(ClassLoader.getSystemResource("usuarios.csv").toURI());
        System.out.println(path);
    //    final Path path = Paths.get(ClassLoader.getSystemResource("usuarios.csv").toURI());
        return usuarioService.namedColumnBeanExample(path);
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
    @GetMapping("/reader/{noEmpl}")
    public String[] getUsuario(@PathVariable("noEmpl") String noEmpl) throws Exception{
        Path path = Paths.get(ClassLoader.getSystemResource("usuarios.csv").toURI());
        return usuarioService.getUsuario(path, noEmpl);
    }
    @PostMapping("/writer1")
    public String writerLineByLine(@RequestBody List<String[]> data) throws Exception{
        Path path = Paths.get("src/main/resources/usuarios2.csv");
        return usuarioService.writerLineByLine(data, path);
    }

    @PostMapping("/writer2")
    public String saveWriterBean(@RequestBody List<UsuarioNamedBean> data) throws Exception{
        Path path = Paths.get("src/main/resources/usuarios3.csv");
        List<CsvBean> sampleData = Arrays.asList((data.stream().toArray(UsuarioNamedBean[]::new)));
        return usuarioService.writeCsvFromBeanExample(path, sampleData);
    }

    
    
}
