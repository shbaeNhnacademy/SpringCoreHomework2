package com.nhnacademy.edu.springframework.project.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.springframework.project.model.BillWords;
import com.nhnacademy.edu.springframework.project.model.WaterBill;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Component
@Primary
public class JsonDataParser implements DataParser{

    public JsonDataParser() {
    }

    @Override
    public Collection<WaterBill> parse(String path) {
        ClassPathResource resource = new ClassPathResource(path);
        ObjectMapper mapper = new ObjectMapper();
        List<WaterBill> list = new ArrayList<>();
        try {
            File file = resource.getFile();
            List<Map<String,String>> mapList = mapper.readValue(file, List.class);
            for (var map : mapList) {
                list.add(new WaterBill(
                        map.get(BillWords.LOCAL.getKorDescription()), //BillWords.LOCAL.getKorDescription()
                        map.get(BillWords.CATEGORY.getKorDescription()),
                        Long.parseLong(String.valueOf(map.get(BillWords.PRICE.getKorDescription())))));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
