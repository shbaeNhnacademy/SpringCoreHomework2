package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.model.WaterBill;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class CsvDataParser implements DataParser{

    public CsvDataParser() {
    }

    @Override
    public Collection<WaterBill> parse(String path) {
        List<WaterBill> list = new ArrayList<>();

        ClassPathResource resource = new ClassPathResource(path);
        try(
                InputStream inputStream = resource.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            ) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                if (Character.isDigit(split[0].trim().charAt(0))) {
                    list.add(new WaterBill(split[1].trim(), split[2].trim(), Integer.parseInt(split[6])));
                }
            }

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
