package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.model.WaterBill;
import com.nhnacademy.edu.springframework.project.service.DataParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BillRepositoryTest {


    String path = "경로";
    @Mock
    DataParser dataParser;

    BillRepository billRepository;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        List<WaterBill> waterBillList = new ArrayList<>();
        waterBillList.add(new WaterBill("창원", "공업용", 100));
        when(dataParser.parse(path)).thenReturn(waterBillList);
        billRepository = new DefaultBillRepository(dataParser);
    }



    @Test
    void load() {
        boolean load = billRepository.load(path);
        Assertions.assertThat(load).isTrue();
    }

    @Test
    void applyBillByUsage() {
        long usage = 1;
        billRepository.load(path);
        Collection<WaterBill> waterBills = billRepository.applyBillByUsage(usage);
        List<WaterBill> collect = new ArrayList<>(waterBills);
        Assertions.assertThat(collect.get(0).getBillTotal()).isEqualTo(100);
    }

    @Test
    void applyBillByUsage_예외발생() {
        long usage = -1;
        // load 메서드 실행전일때, 예외 발생
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchElementException.class, () -> {
            Collection<WaterBill> waterBills = billRepository.applyBillByUsage(usage);
        });

        billRepository.load(path);
        // usage가 음수 값일때, 예외 발생
        org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> {
            Collection<WaterBill> waterBills = billRepository.applyBillByUsage(usage);
        });

    }
}
