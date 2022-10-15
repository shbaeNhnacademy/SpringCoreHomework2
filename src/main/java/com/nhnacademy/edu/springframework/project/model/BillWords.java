package com.nhnacademy.edu.springframework.project.model;

public enum BillWords {
    LOCAL("지자체명"),
    CATEGORY("업종"),
    PRICE("구간금액(원)");


    private String korDescription;

    BillWords(String korDescription) {
        this.korDescription = korDescription;
    }

    public String getKorDescription() {
        return korDescription;
    }
}
