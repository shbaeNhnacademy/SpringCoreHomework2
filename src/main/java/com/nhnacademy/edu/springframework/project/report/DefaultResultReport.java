package com.nhnacademy.edu.springframework.project.report;

import com.nhnacademy.edu.springframework.project.model.WaterBill;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DefaultResultReport implements ResultReport{

    public DefaultResultReport() {
    }

    @Override
    public boolean report(Collection<WaterBill> waterBills) {
        if (waterBills.isEmpty()) {
            throw new NoSuchElementException("입력된 Collection 이 비었습니다.");
        }
        List<WaterBill> collect = new ArrayList<>(waterBills);

        for (int i = 0; i < 5; i++) {
            System.out.println(collect.get(i));
        }
        return true;
    }
}
