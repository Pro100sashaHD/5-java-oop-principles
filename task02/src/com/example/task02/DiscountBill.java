package com.example.task02;

public class DiscountBill extends Bill{
    private double Discount;

    @Override
    public long getPrice(){
        return (long)(super.getPrice() - super.getPrice() * (Discount / 100));
    }

    public long getAbsDiscount(){
        return super.getPrice() - getPrice();
    }

    public void setDiscount(double discount){
        this.Discount = discount;
    }
    public String  getDiscount(){
        return this.Discount + "%";
    }
}
