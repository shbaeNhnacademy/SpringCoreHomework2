package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.model.WaterBill;
import com.nhnacademy.edu.springframework.project.repository.BillRepository;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class CsvDataParser implements DataParser{


    @Override
    public Collection<WaterBill> parse(String path) {
        List<WaterBill> list = new ArrayList<>();
        ClassLoader classLoader = this.getClass().getClassLoader();
        try (
                InputStream inputStream = classLoader.getResource(path).openStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        ) {
            String line=null;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                if (Character.isDigit(split[0].trim().charAt(0))) {
                list.add(new WaterBill(split[1].trim(),split[2].trim(), Integer.parseInt(split[6])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("CsvScores.load - FileNotFoundException " + e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("CsvScores.load - IOException " + e);
            throw new RuntimeException(e);
        }
        return list;
    }
}
