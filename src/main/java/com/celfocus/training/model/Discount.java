package com.celfocus.training.model;

public class Discount extends AbstractModel {

    private double percentageOfDiscount;

    public Discount(int id, double percentageOfDiscount) {
        super(id);
        this.percentageOfDiscount = percentageOfDiscount;
    }

}
