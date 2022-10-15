package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.model.WaterBill;
import com.nhnacademy.edu.springframework.project.repository.BillRepository;
import com.nhnacademy.edu.springframework.project.repository.DefaultBillRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class WaterBillServiceTest {
    Collection<WaterBill> waterBillList = new ArrayList<>();
    long usage = 1;
    @Mock
    BillRepository billRepository;

    WaterBillService waterBillService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        waterBillService = new DefaultWaterBillService(billRepository);
    }

    @Test
    void calculate() {
        for (int i = 0; i < 10; i++) {
            WaterBill bill = new WaterBill("창원", "공업용", 10-i);
            bill.setBillTotal(bill.getUnitPrice() * 10);
            waterBillList.add(bill);
        }
        when(billRepository.applyBillByUsage(usage)).thenReturn(waterBillList);

        Collection<WaterBill> calculate = waterBillService.calculate(usage);
        Assertions.assertThat(calculate).isNotEqualTo(waterBillList);

        List<WaterBill> collect = new ArrayList<>(calculate);
        Assertions.assertThat(collect.get(0).getBillTotal()).isEqualTo(10);
    }

    @Test
    void calculate_예외처리() {
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchElementException.class, () -> {
            waterBillService.calculate(usage);
        });
    }
}
