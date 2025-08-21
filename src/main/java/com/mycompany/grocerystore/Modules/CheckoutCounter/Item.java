/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grocerystore.Modules.CheckoutCounter;

import com.mycompany.grocerystore.Entities.Product;

/**
 *
 * @author Benz Samson
 */
public class Item {

    public Product Product;
    
    // Can also sub as weight when Product UoM Exists   
    public float Quantity;
    
    public float LineTotal = 0;
    public float RawTotal = 0;    
    public float DiscountPercent = 0;

    public String UoM;
    
    public Item(Product product, float quantity){
        Product = product;    
        Quantity = quantity;
    }
    
    public Item(Product product, float quantity, float discountPercent){
        Product = product;       
        Quantity = quantity;       
        DiscountPercent = discountPercent;
    }
    
    public float GetRawTotal() {
        RawTotal = Product.Price * Quantity;
        return LineTotal;
    }
     
    public float GetLineTotal() {
        GetRawTotal();
        LineTotal = RawTotal - (RawTotal * (DiscountPercent / 100));
        return LineTotal;
    }
}
