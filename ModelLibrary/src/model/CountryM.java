/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class CountryM {
    private String nameTranslated;
    private String label;
    private double shippingCost;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public CountryM() {
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getNameTranslated() {
        return nameTranslated;
    }

    public void setNameTranslated(String nameTranslated) {
        this.nameTranslated = nameTranslated;
    }
    
    
}
