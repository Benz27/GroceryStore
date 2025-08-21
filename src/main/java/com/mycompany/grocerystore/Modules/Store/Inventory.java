/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grocerystore.Modules.Store;

import com.mycompany.grocerystore.Exceptions.InvalidProductException;
import com.mycompany.grocerystore.Entities.Product;
import java.util.HashMap;

/**
 *
 * @author Benz Samson
 */
public class Inventory {

    public HashMap<String, Product> ProductRegistry;

    public Inventory() {
        ProductRegistry = new HashMap<>();
    }

    public void addProduct(Product product) {
        ProductRegistry.put(product.Code, product);
    }

    public Product getProduct(String code) throws InvalidProductException {
        Product product = ProductRegistry.get(code);
        if (product == null) {
            throw new InvalidProductException("Product with code " + code + " does not exists.");
        }
        return ProductRegistry.get(code);
    }

}
