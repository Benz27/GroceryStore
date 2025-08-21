/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grocerystore.Entities;

import com.mycompany.grocerystore.Enumerators.SellingUnit;

/**
 *
 * @author Benz Samson
 */
public class Product {
    
    public String Name;
    public String Code;
    public SellingUnit SeU ;
    public float Price; 

    public Product(){
        SeU = SellingUnit.Piece;
    }
}
