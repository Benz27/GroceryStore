/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grocerystore.Modules.CheckoutCounter;

import com.mycompany.grocerystore.Enumerators.SellingUnit;
import java.util.HashMap;

/**
 *
 * @author Benz Samson
 */
public class Summary {
    public HashMap<String, Float> QuantitySummary;
    public HashMap<String, Float> TotalPriceSummary;
    
    public HashMap<SellingUnit, Float> QuantityPerSeUSummary;
    public HashMap<SellingUnit, Float> TotalPricePerSeUSummary;

    
    
    public void AddToSummaries(Item item) {
        AddToPerProductSummaries(item);
        AddToPerSeUSummaries(item);
    }
    
    
    
    
    public void AddToPerProductSummaries(Item item) {

        SellingUnit sellingUnit = item.Product.SeU;

        float collectiveQuantity = item.Quantity;
        float collectiveLineTotal = item.GetLineTotal();

        if (QuantityPerSeUSummary.containsKey(sellingUnit)) {
            collectiveQuantity += (float) QuantityPerSeUSummary.get(sellingUnit);
            collectiveLineTotal += (float) TotalPricePerSeUSummary.get(sellingUnit);
        }
        QuantityPerSeUSummary.put(sellingUnit, collectiveQuantity);
        TotalPricePerSeUSummary.put(sellingUnit, collectiveLineTotal);
    }
    
      public void AddToPerSeUSummaries(Item item) {

        String code = item.Product.Code;

        float collectiveQuantity = item.Quantity;
        float collectiveLineTotal = item.GetLineTotal();

        if (QuantitySummary.containsKey(code)) {
            collectiveQuantity += (float) QuantitySummary.get(code);
            collectiveLineTotal += (float) TotalPriceSummary.get(code);
        }
        QuantitySummary.put(code, collectiveQuantity);
        TotalPriceSummary.put(code, collectiveLineTotal);
    }
}
