package org.fasttrackit;

import java.time.LocalDateTime;

public class AnimalFood {
    private String name;
    private int price;
    private double quantity;
    private LocalDateTime expiryDate;
    private boolean availabilityStock;
    private double weight;

    AnimalFood(String name,double quantity, LocalDateTime expiryDate,boolean availabilityStock,double weight)
    {
        this.name=name;
        this.quantity=quantity;
        this.expiryDate=expiryDate;
        this.availabilityStock=availabilityStock;
        this.weight=weight;
    }

    public String getName()
    {
        return name;
    }
}

