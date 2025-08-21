/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grocerystore.Modules.CheckoutCounter;

import com.mycompany.grocerystore.Exceptions.InvalidProductException;
import com.mycompany.grocerystore.Entities.Product;
import com.mycompany.grocerystore.Enumerators.Discount;
import com.mycompany.grocerystore.Modules.Products.Rice;
import com.mycompany.grocerystore.Modules.Store.Inventory;
import com.mycompany.grocerystore.Modules.Store.SalesPromotion;

import java.util.HashMap;

/**
 *
 * @author Benz Samson
 */
public class Transaction {

    public Purchase Purchase;
    public Inventory Inventory;
    public SalesPromotion SalesPromotion;
    public float GrandTotal;

    public Summary ItemsSummary;
    public Summary DiscountedItemsSummary;
  

    public Transaction() {
        Purchase = new Purchase();
        ItemsSummary = new Summary();
        DiscountedItemsSummary = new Summary();
    }
    
    public void SetInventory(Inventory inventory){
        Inventory = inventory;
    }
    
    public void SalesPromotion(SalesPromotion salesPromotion){
        SalesPromotion = salesPromotion;
    }
    
    
    
    
    
    public void scan(String code, float quantity) throws InvalidProductException {
        Product product = Inventory.getProduct(code);
        addToPurchase(new Item(product, quantity));
    }
    
    public void scan(String code) throws InvalidProductException {
        scan(code, 1);
    }
    
    
    public void addToPurchase(Item item) {
        Purchase.add(item);
        GrandTotal += item.GetLineTotal();
        AddToSummary(item);
    }

       
       
    
    public void Finalize() throws InvalidProductException {
       ApplyDiscounts();
    }
 
    public void AddToSummary(Item item) {

        if (item.DiscountPercent > 0) {
            DiscountedItemsSummary.AddToSummaries(item);
            return;
        }
        ItemsSummary.AddToSummaries(item);
    }

    public void ApplyDiscounts() throws InvalidProductException {
        
        for(String code : SalesPromotion.ProductsOnDiscount.keySet()){
            if(!ItemsSummary.QuantitySummary.containsKey(code)){
                continue;
            }
            Discount discount = SalesPromotion.ProductsOnDiscount.get(code);
            switch(discount){
                case Discount.BuyOneGetOneFree -> ApplyBuyOneGetOneFree(Inventory.getProduct(code));
                case Discount.BuyTwoGetOneFree -> ApplyBuyTwoGetOneFree(Inventory.getProduct(code));
            }
        }
    }
    
    public void ApplyBuyOneGetOneFree(Product product) {
        String code = product.Code;
        addToPurchase(new Item(product, ItemsSummary.QuantitySummary.get(code) * 2, 100));
    }

    public void ApplyBuyTwoGetOneFree(Product product) {
        String code = product.Code;
        float quantity = ItemsSummary.QuantitySummary.get(code);
        float freeQuantity = ((quantity % 2 == 0) ? quantity : quantity - 1) / 2;
        addToPurchase(new Item(product, freeQuantity, 100));
    }

}
