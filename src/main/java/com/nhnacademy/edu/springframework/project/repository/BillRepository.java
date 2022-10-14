package com.nhnacademy.edu.springframework.project.repository;

public interface BillRepository {
    boolean load(String path);

    long findFeeByUsage(long usage);
}
