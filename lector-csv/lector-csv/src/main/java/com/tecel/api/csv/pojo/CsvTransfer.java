package com.tecel.api.csv.pojo;

import java.util.List;

import com.tecel.api.csv.bean.CsvBean;

import lombok.Data;

@Data
public class CsvTransfer {

    
    private List<String[]> csvStringList;
    private List<CsvBean> csvList;
}
