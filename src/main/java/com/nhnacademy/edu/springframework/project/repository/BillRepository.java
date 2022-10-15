package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.model.WaterBill;

import java.util.Collection;

public interface BillRepository {
    boolean load(String path);

    Collection<WaterBill> applyBillByUsage(long usage);
}
