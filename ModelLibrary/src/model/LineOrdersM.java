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
public class LineOrdersM {
    private int quantity;
    private double price;

    public LineOrdersM() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price;
    }

    public void setTotalPrice(double totalPrice) {
        this.price = totalPrice;
    }
    
    
}
