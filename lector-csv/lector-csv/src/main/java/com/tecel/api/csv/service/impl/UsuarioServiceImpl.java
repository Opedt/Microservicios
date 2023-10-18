package com.tecel.api.csv.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.tecel.api.csv.bean.CsvBean;
import com.tecel.api.csv.bean.UsuarioNamedBean;
import com.tecel.api.csv.bean.UsuarioPositionBean;
import com.tecel.api.csv.service.UsuarioService;
import com.tecel.api.csv.util.Util;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Override
    public List<String[]> getUsuarios(Path path) throws Exception {
        // CSVParser parser = new CSVParserBuilder()
        //         .withSeparator('|')
        //         .withIgnoreQuotations(true)
        //         .build();
        CSVParser parser = Util.getparser('|');
        try (Reader reader = Files.newBufferedReader(path)) {
            try (CSVReader csvReader = Util.getCsvReader(reader, parser))
                    // CSVReader csvReader = new CSVReaderBuilder(reader)
                    //         .withSkipLines(1)
                    //         .withCSVParser(parser)
                    //         .build())
                     {
                List<String[]> records = csvReader.readAll();

                return records;
            }
        }
    }

    @Override
    public String getUsuario(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsuario'");
    }

    @Override
    public String[] getUsuario(Path path, String noEmpl) throws Exception {
        CSVParser parser = Util.getparser('|');
        try (Reader reader = Files.newBufferedReader(path)) {
            try (CSVReader csvReader = Util.getCsvReader(reader, parser)) {
               String[] record = null;
               while((record = csvReader.readNext()) != null) {
                   if (record[1].equals(noEmpl)) {
                       return record;
                   }
               }
            }
        }

        return null;
    }

    @Override
    public String getUsuario2(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsuario2'");
    }

    @Override
    public String writerLineByLine(List<String[]> records, Path path) throws Exception {
        try(CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))){
            for (String[] line : records) {
                writer.writeNext(line);
                System.out.println(line[0]+" "+line[1]+" "+line[2]);
            }
        return Util.readFile(path);
        }
    }

    @Override
    public List<CsvBean> simplePositionBeanExample( Path path) throws Exception {     
    return Util.beanBuilderExample(path, UsuarioPositionBean.class);
    }

    @Override
    public List<CsvBean> namedColumnBeanExample( Path path) throws Exception { 
    return Util.beanBuilderExample(path, UsuarioNamedBean.class);
    }

    @Override
    public String writeCsvFromBeanExample(Path path, List<CsvBean> sampleData) throws Exception {
            return Util.writeCsvFromBean(path, sampleData); 
    }

}
