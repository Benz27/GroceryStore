/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Setup;

import com.mycompany.grocerystore.Entities.Product;
import com.mycompany.grocerystore.Enumerators.Discount;
import com.mycompany.grocerystore.Enumerators.SellingUnit;
import com.mycompany.grocerystore.Modules.Store.Inventory;
import com.mycompany.grocerystore.Modules.Store.SalesPromotion;

/**
 *
 * @author benriquez
 */
public class StoreSetup {
    
    public static Inventory InventorySetup(){
        Inventory inventory = new Inventory();
        
        Product rice = new Product();
        rice.SeU = SellingUnit.Weight;
        rice.Name = "Rice";
        rice.Price = 40;
        rice.Code = "1W";

        Product cupcake = new Product();
        cupcake.Name = "Cupcake";
        cupcake.Price = 30;
        cupcake.Code = "1P";
      
        Product lemonSoda = new Product();
        lemonSoda.Name = "Lemon Soda";
        lemonSoda.Price = 20;
        lemonSoda.Code = "2P";
        
        Product chips = new Product();
        chips.Name = "Chips";
        chips.Price = 10;
        chips.Code = "3P";
        
        inventory.addProduct(rice);
        inventory.addProduct(cupcake);
        inventory.addProduct(lemonSoda);
        inventory.addProduct(chips);
        
        return inventory;
    };
    
    
     public static SalesPromotion SalesPromotionSetup(){
        SalesPromotion salesPromotion = new SalesPromotion();
        salesPromotion.addDiscountedProduct("1P", Discount.BuyTwoGetOneFree);
        salesPromotion.addDiscountedProduct("2P", Discount.BuyOneGetOneFree);
        return salesPromotion;
    };
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
