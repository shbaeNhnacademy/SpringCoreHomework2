package com.nhnacademy.edu.springframework.project.report;

import com.nhnacademy.edu.springframework.project.model.WaterBill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ResultReportTest {

    ResultReport resultReport = new DefaultResultReport();


    @Test
    void report() {
        List<WaterBill> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            WaterBill bill = new WaterBill("창원", "공업용", 5-i);
            bill.setBillTotal(bill.getUnitPrice() * 10);
            list.add(bill);
        }
        boolean report = resultReport.report(list);
        org.assertj.core.api.Assertions.assertThat(report).isTrue();
    }

    @Test
    void report_예외발생() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            List<WaterBill> emptyList = new ArrayList<>();
            resultReport.report(emptyList);
        });

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            List<WaterBill>  oneList = new ArrayList<>();
            WaterBill bill = new WaterBill("창원", "공업용", 100);
            bill.setBillTotal(bill.getUnitPrice() * 10);
            oneList.add(bill);
            resultReport.report(oneList);
        });
    }
}
