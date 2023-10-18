package com.tecel.api.csv.service.impl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.tecel.api.csv.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Override
    public List<String[]> getUsuarios(Path path) throws Exception {
        CSVParser parser = new CSVParserBuilder()
                .withSeparator('|')
                .withIgnoreQuotations(true)
                .build();
        try (Reader reader = Files.newBufferedReader(path)) {
            try (
                    CSVReader csvReader = new CSVReaderBuilder(reader)
                            .withSkipLines(1)
                            .withCSVParser(parser)
                            .build()) {
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
    public String getUsuario2(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsuario2'");
    }

}
