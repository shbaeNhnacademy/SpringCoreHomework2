package com.nhnacademy.edu.springframework.project.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonDataParserTest {

    @Test
    void parse() {
        DataParser dataParser = new JsonDataParser();
        dataParser.parse("data/Tariff_20220331.json");
    }
}
