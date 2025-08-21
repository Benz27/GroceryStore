/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grocerystore.Modules.CheckoutCounter;

import com.mycompany.grocerystore.Entities.Product;
import com.mycompany.grocerystore.Modules.Products.Rice;

import java.util.HashMap;

/**
 *
 * @author Benz Samson
 */
public class Transaction {

    public Purchase Purchase;
    public float GrandTotal;
    public HashMap<String, Float> QuantitySummary;
    public HashMap<String, Float> TotalSummary;

    public HashMap<String, Float> DiscountedQuantitySummary;
    public HashMap<String, Float> DiscountedTotalSummary;

  

    public Transaction() {
        Purchase = new Purchase();
        QuantitySummary = new HashMap<>();
        TotalSummary = new HashMap<>();

        DiscountedQuantitySummary = new HashMap<>();
        DiscountedTotalSummary = new HashMap<>();

    }
    
    
    public void Summarize() {
       ApplyBuyTwoGetOneFree(new Rice());
    }
    
//    public float Refresh() {
//        for (Item item : Purchase.Items) {
//            GrandTotal += item.GetLineTotal();
//        }
//        return GrandTotal;
//    }

    public void scan(Item item) {
        Purchase.add(item);
        GrandTotal += item.GetLineTotal();
        AddToSummary(item);
    }

    public void scan(Product product) {
        scan(new Item(product, 1));
    }

    public void scan(Product product, float quantity) {
        scan(new Item(product, quantity));
    }

    public void AddToSummary(Item item) {

        var qtySumm = QuantitySummary;
        var totSumm = TotalSummary;
        if (item.DiscountPercent > 0) {
            qtySumm = DiscountedQuantitySummary;
            totSumm = DiscountedTotalSummary;
        }

        String name = item.Product.Name;

        float collectiveQuantity = item.Quantity;
        float collectiveLineTotal = item.GetLineTotal();

        if (qtySumm.containsKey(name)) {
            collectiveQuantity += (float) qtySumm.get(name);
            collectiveLineTotal += (float) totSumm.get(name);
        }
        qtySumm.put(name, collectiveQuantity);
        totSumm.put(name, collectiveLineTotal);
    }

    
    
    
    
    public void ApplyBuyOneGetOneFree(Product product) {
        String name = product.Name;
        scan(new Item(product, QuantitySummary.get(name) * 2, 100));
    }

    public void ApplyBuyTwoGetOneFree(Product product) {
        String name = product.Name;
        float quantity = QuantitySummary.get(name);
        float freeQuantity = ((quantity % 2 == 0) ? quantity : quantity - 1) / 2;
        scan(new Item(product, freeQuantity, 100));
    }

}
