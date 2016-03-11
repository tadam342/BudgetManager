package com.simplesqlite.List;

import java.util.ArrayList;

/**
 * Created by fff on 08.12.2015.
 */
public class Task {
    private String description;
    private double cost;

    public Task(){

    }

    public Task(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
