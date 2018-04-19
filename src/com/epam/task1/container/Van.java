package com.epam.task1.container;
import com.epam.task1.products.Coffee;
import java.util.ArrayList;


public class Van {
    private double maxCost;
    private double balanceCost;
    private double vanAmount;
    private double balanceAmount;
    private ArrayList<Coffee> van;

    public Van(double vanAmount, double maxCost){
        this.vanAmount = vanAmount;
        this.maxCost = maxCost;
        balanceAmount=vanAmount;
        balanceCost=maxCost;
        van = new ArrayList<>();
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public double getBalanceCost() {
        return balanceCost;
    }

    public void setBalanceCost(double balanceCost) {
        this.balanceCost = balanceCost;
    }

    public ArrayList<Coffee> getVan() {
        return van;
    }

    public double getVanAmount() {
        return vanAmount;
    }

    public double getMaxCost() {
        return maxCost;
    }
}