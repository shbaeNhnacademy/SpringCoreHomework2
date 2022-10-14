package com.nhnacademy.edu.springframework.project.model;

public class WaterBill {
    private String city;
    private String sector;
    private long unitPrice;
    private long billTotal;

    private static long price;

    public WaterBill(String city, String sector, long unitPrice) {
        this.city = city;
        this.sector = sector;
        this.unitPrice = unitPrice;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public long getBillTotal() {
        return billTotal;
    }

    public static long getPrice() {
        return price;
    }

    public static void setPrice(long price) {
        WaterBill.price = price;
    }

    @Override
    public String toString() {
        return "WaterBill{" +
                "city='" + city + '\'' +
                ", sector='" + sector + '\'' +
                ", unitPrice=" + unitPrice +
                ", billTotal=" + billTotal +
                '}';
    }
}
