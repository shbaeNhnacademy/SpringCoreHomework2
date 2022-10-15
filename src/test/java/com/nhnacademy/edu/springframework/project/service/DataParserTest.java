package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.model.WaterBill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class DataParserTest {

    @Test
    void parse() {

        String path = "data/Tariff_20220331.csv";
        DataParser dataParser = new CsvDataParser();
        Collection<WaterBill> parse = dataParser.parse(path);
        List<WaterBill> collect = new ArrayList<>(parse);
        //list가 비었는지 확인
        org.assertj.core.api.Assertions.assertThat(collect.isEmpty()).isFalse();
        //string으로 입력 제대로 받았는지
        org.assertj.core.api.Assertions.assertThat(collect.get(0).getCity()).isInstanceOf(String.class);
    }


    @Test
    void parse_경로오류() {

        DataParser dataParser = new CsvDataParser();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dataParser.parse("잘못된경로");
        });
    }

}
