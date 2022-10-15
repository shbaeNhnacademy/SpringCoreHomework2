package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.model.WaterBill;
import com.nhnacademy.edu.springframework.project.service.DataParser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

@Repository
public class DefaultBillRepository implements BillRepository{

    private Collection<WaterBill> waterBillList = new ArrayList<>();
    private DataParser dataParser;


    public DefaultBillRepository(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    @Override
    public boolean load(String path) {
        waterBillList = dataParser.parse(path);
        if (waterBillList.isEmpty()) {
            throw new NoSuchElementException("파일 parsing 실패");
        }
        return true;
    }

    @Override
    public Collection<WaterBill> applyBillByUsage(long usage) {
        if (waterBillList.isEmpty()) {
            throw new NoSuchElementException("파일 load가 되지않았습니다.");
        }
        if(usage < 0){
            throw new IllegalStateException();
        }
        for (WaterBill waterBill : waterBillList) {
            waterBill.setBillTotal(waterBill.getUnitPrice() * usage);
        }
        return waterBillList;
    }
}
