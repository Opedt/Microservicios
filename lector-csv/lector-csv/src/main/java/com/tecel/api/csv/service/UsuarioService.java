package com.tecel.api.csv.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import com.tecel.api.csv.bean.CsvBean;

public interface UsuarioService {

    public List<String[]> getUsuarios(Path path) throws Exception;

    public String getUsuario(String id);

    public String[] getUsuario(Path path, String noEmpl) throws Exception;

    public String getUsuario2(String id);

    String writerLineByLine(List<String[]> records, Path path) throws Exception;

    public List<CsvBean> simplePositionBeanExample( Path path) throws Exception;

    List<CsvBean> namedColumnBeanExample(Path path) throws Exception;

    public String writeCsvFromBeanExample(Path path,List<CsvBean> sampleData)throws Exception;
}
