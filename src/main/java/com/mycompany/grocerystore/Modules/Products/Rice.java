/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grocerystore.Modules.Products;
import com.mycompany.grocerystore.Entities.Product;
import com.mycompany.grocerystore.Enumerators.SellingUnit;
/**
 *
 * @author Benz Samson
 */
public class Rice extends Product {
    
    public Rice(){
        Name = "Rice";        
        Price = 20;  
        SeU = SellingUnit.Weight;
    }
}
