/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grocerystore.Modules.CheckoutCounter;

import com.mycompany.grocerystore.Entities.Product;
import com.mycompany.grocerystore.Enumerators.SellingUnit;
import com.mycompany.grocerystore.Exceptions.InvalidProductException;
import com.mycompany.grocerystore.Modules.Store.Inventory;


/**
 *
 * @author benriquez
 */
public class Receipt {
    
    public Transaction Transaction;
    public Inventory Inventory;

    public Receipt(Transaction transaction){
        Transaction = transaction;
        Inventory = transaction.Inventory;
    }
    
    public void Print() throws InvalidProductException{
        String result = "";
        result += "-------------------PURCHASE----------------------\n";
        result += "-----Items-----\n\n";

        for(String code : Transaction.ItemsSummary.QuantitySummary.keySet()){
            float quantity = Transaction.ItemsSummary.QuantitySummary.get(code);
            float totalPrice = Transaction.ItemsSummary.TotalPriceSummary.get(code);
            Product product = Inventory.getProduct(code);
            if(product.SeU == SellingUnit.Piece){
                result += (product.Name+ " x "+(int) quantity + ": PHP " + totalPrice +  "\n");
                continue;
            }
            result += (product.Name+ " x "+quantity + product.UnitOfMeasurement + ": PHP " + totalPrice +  "\n");
            
        }
        
        result += "\n\n-----Discounts-----\n";

        for(String code : Transaction.DiscountedItemsSummary.QuantitySummary.keySet()){
            float quantity = Transaction.DiscountedItemsSummary.QuantitySummary.get(code);
            float totalPrice = Transaction.DiscountedItemsSummary.TotalPriceSummary.get(code);
            result += ((Inventory.getProduct(code).Name+ " x "+quantity) + ": PHP " + totalPrice +  "\n");
        }
        
        result += ("\n\nTotal: PHP " + Transaction.GrandTotal);
        System.out.println(result);

    }
    
}
