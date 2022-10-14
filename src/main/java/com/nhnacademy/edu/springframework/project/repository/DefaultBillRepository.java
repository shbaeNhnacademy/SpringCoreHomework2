package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.model.WaterBill;
import com.nhnacademy.edu.springframework.project.service.DataParser;

import java.util.Collection;

public class DefaultBillRepository implements BillRepository{
    private DataParser dataParser;

    public DefaultBillRepository(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    @Override
    public boolean load(String path) {
        Collection<WaterBill> parse = dataParser.parse(path);
        return false;
    }

    @Override
    public long findFeeByUsage(long usage) {
        return 0;
    }
}
