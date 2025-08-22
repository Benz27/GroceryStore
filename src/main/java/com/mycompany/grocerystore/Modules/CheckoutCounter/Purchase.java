/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grocerystore.Modules.CheckoutCounter;

import com.mycompany.grocerystore.Entities.Product;
import com.mycompany.grocerystore.Enumerators.SellingUnit;
import java.util.ArrayList;

/**
 *
 * @author Benz Samson
 */
public class Purchase {
    
    public ArrayList<Item> Items;
    public float Total = 0.0f;
    
    public Purchase(){
        Items = new ArrayList<Item>();
    }
    
    public float Summarize(){
        for (Item item : Items) {
            Total += item.GetLineTotal();
        }
        return Total;
    }
    
    public void add(Item item){
        
        if(item.Product.SeU == SellingUnit.Piece){
            item.Quantity = (int) item.Quantity;
        }
        
        Items.add(item);
        Summarize();
    }
    
}