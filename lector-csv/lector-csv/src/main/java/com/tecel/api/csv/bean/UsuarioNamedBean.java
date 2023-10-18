package com.tecel.api.csv.bean;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import lombok.Data;

@Data
public class UsuarioNamedBean extends CsvBean {
    
    @CsvBindByName(column = "id")
    private String id;

    @CsvBindByName(column = "numEmp")
    private String numEmp;

    @CsvBindByName(column = "nombre")
    private String nombre;
}
