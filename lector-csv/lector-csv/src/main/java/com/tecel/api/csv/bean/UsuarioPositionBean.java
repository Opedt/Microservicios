package com.tecel.api.csv.bean;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Data;

@Data
public class UsuarioPositionBean extends CsvBean{

    @CsvBindByPosition(position = 0)
    private String id;

    @CsvBindByPosition(position = 1)
    private String numEmp;

    @CsvBindByPosition(position = 2)
    private String nombre;
    
}
