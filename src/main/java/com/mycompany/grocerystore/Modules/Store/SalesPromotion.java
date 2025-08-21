/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grocerystore.Modules.Store;
import com.mycompany.grocerystore.Entities.Product;
import com.mycompany.grocerystore.Enumerators.Discount;
import com.mycompany.grocerystore.Modules.CheckoutCounter.Transaction;
import java.util.HashMap;
/**
 *
 * @author Benz Samson
 */
public class SalesPromotion {
      
    public HashMap<String, Discount> ProductsOnDiscount; 
    
    public SalesPromotion(){
        ProductsOnDiscount = new HashMap<>();
    }
    
    public void addDiscountedProduct(Product product, Discount discount){
        ProductsOnDiscount.put(product.Code, discount);
    }
        
    public void addDiscountedProduct(String code, Discount discount){
        ProductsOnDiscount.put(code, discount);
    }
}
