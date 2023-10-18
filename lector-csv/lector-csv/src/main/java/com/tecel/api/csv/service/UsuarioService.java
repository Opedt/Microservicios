package com.tecel.api.csv.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;



public interface UsuarioService {
    public List<String[]> getUsuarios(Path path)throws Exception;
    public String getUsuario(String id);
    public String getUsuario2(String id);
}
