package com.nhnacademy.edu.springframework.project;

import com.nhnacademy.edu.springframework.project.config.JavaConfig;
import com.nhnacademy.edu.springframework.project.model.WaterBill;
import com.nhnacademy.edu.springframework.project.report.DefaultResultReport;
import com.nhnacademy.edu.springframework.project.report.ResultReport;
import com.nhnacademy.edu.springframework.project.repository.BillRepository;
import com.nhnacademy.edu.springframework.project.repository.DefaultBillRepository;
import com.nhnacademy.edu.springframework.project.service.CsvDataParser;
import com.nhnacademy.edu.springframework.project.service.DataParser;
import com.nhnacademy.edu.springframework.project.service.DefaultWaterBillService;
import com.nhnacademy.edu.springframework.project.service.WaterBillService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collection;
import java.util.Scanner;

public class BootStrap {
    public static void main(String[] args) {
        String path = "data/Tariff_20220331.csv";

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        BillRepository billRepository = context.getBean(BillRepository.class);
        billRepository.load(path);

        int input=0;
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("> ");
            input = scanner.nextInt();

            if (input != -1) {
                WaterBillService waterBillService = context.getBean(WaterBillService.class);
                Collection<WaterBill> calculate = waterBillService.calculate(input);

                ResultReport resultReport = context.getBean(ResultReport.class);
                resultReport.report(calculate);
            }else{
                break;
            }

            System.out.println("\n If you want to finish, Insert \"-1\"");
        }
        System.out.println("Program finished!!");
    }
}
