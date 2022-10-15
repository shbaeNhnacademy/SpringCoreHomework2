package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.model.WaterBill;
import com.nhnacademy.edu.springframework.project.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class DefaultWaterBillService implements WaterBillService{

    private BillRepository repository;

    public DefaultWaterBillService(BillRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<WaterBill> calculate(long usage) {
        Collection<WaterBill> waterBills = repository.applyBillByUsage(usage);
        if (waterBills.isEmpty()) {
            throw new NoSuchElementException("repository의 메소드에서 빈 컬랙션을 반환하였습니다");
        }
        return waterBills.stream()
                .sorted(Comparator.comparing(WaterBill::getBillTotal))
                .collect(Collectors.toList());
    }
}
