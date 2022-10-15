package com.nhnacademy.edu.springframework.project.report;

import com.nhnacademy.edu.springframework.project.model.WaterBill;

import java.util.Collection;

public interface ResultReport {
    boolean report(Collection<WaterBill> waterBills);
}
