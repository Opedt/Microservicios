package com.tecel.api.csv.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.tecel.api.csv.bean.CsvBean;
import com.tecel.api.csv.pojo.CsvTransfer;

public class Util {

    public static CSVParser getparser(Character character) {
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(character)
                .withIgnoreQuotations(true)
                .build();
        return parser;
    }

    public static CSVReader getCsvReader(Reader reader, CSVParser parser) {
        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(1)
                .withCSVParser(parser)
                .build();
        return csvReader;
    }

    public static String readFile(Path path) throws IOException {
        System.out.println(IOUtils.toString(path.toUri(), "UTF-8"));
        return IOUtils.toString(path.toUri(), "UTF-8");
    }

    public static List<CsvBean> beanBuilderExample(Path path, Class clazz) throws Exception {
        CsvTransfer csvTransfer = new CsvTransfer();

        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean<CsvBean> cb = new CsvToBeanBuilder<CsvBean>(reader)
                    .withType(clazz)
                    .build();

            csvTransfer.setCsvList(cb.parse());
        }
        return csvTransfer.getCsvList();
    }

    public static String writeCsvFromBean(Path path, List<CsvBean> sampleData) throws Exception {
        try (Writer writer = new FileWriter(path.toString())) {

            StatefulBeanToCsv<CsvBean> sbc = new StatefulBeanToCsvBuilder<CsvBean>(writer)
                    .withQuotechar('\'')
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();

            sbc.write(sampleData);
        }
        return readFile(path);
    }
}
