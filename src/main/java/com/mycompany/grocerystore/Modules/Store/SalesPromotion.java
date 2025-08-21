/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grocerystore.Modules.Store;
import com.mycompany.grocerystore.Modules.CheckoutCounter.Transaction;
import java.util.HashMap;
/**
 *
 * @author Benz Samson
 */
public class SalesPromotion {
   public enum Discount {
        None,
        BuyOneGetOneFree,
        BuyTwoGetOneFree
    }
      
    public HashMap<String, Discount> ProductsOnDiscount; 
    
    public SalesPromotion(){
        ProductsOnDiscount = new HashMap<>();
    }
    
    
    public void addDiscountedProduct(String name, Discount discount){
        ProductsOnDiscount.put(name, discount);
    }
}
