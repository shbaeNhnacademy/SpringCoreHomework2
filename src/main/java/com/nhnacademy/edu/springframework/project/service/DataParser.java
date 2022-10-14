package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.model.WaterBill;

import java.util.Collection;
import java.util.List;

public interface DataParser {
    Collection<WaterBill> parse(String path);
}
