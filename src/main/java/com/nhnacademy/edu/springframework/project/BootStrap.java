package com.nhnacademy.edu.springframework.project;

import com.nhnacademy.edu.springframework.project.model.WaterBill;
import com.nhnacademy.edu.springframework.project.service.CsvDataParser;

import java.util.Collection;

public class BootStrap {
    public static void main(String[] args) {
        System.out.println("BootStrap.main");
        CsvDataParser dataParser = new CsvDataParser();
        Collection<WaterBill> parse = dataParser.parse("data/Tariff_20220331.csv");
        System.out.println("parse = " + parse);
    }
}
