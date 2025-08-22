/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import Setup.StoreSetup;
import com.mycompany.grocerystore.Enumerators.SellingUnit;
import com.mycompany.grocerystore.Exceptions.InvalidProductException;
import com.mycompany.grocerystore.Modules.CheckoutCounter.Receipt;
import com.mycompany.grocerystore.Modules.CheckoutCounter.Transaction;
import com.mycompany.grocerystore.Modules.Store.Inventory;
import com.mycompany.grocerystore.Modules.Store.SalesPromotion;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Benz Samson
 */
public class MyFirstJUnitJupiterTests {

    Inventory Inventory;
    SalesPromotion SalesPromotion;
    Transaction Transaction;
    Receipt Receipt;
    //    Actuals
    float A_QuantityPerPieceSummary, A_TotalPricePerPieceSummary, A_QuantityPerWeightSummary, A_TotalPricePerWeightSummary, A_DiscountedItemsQuantity
            ,A_GrandTotal;
    void StartTransaction() throws InvalidProductException {
        Inventory = StoreSetup.InventorySetup();
        SalesPromotion = StoreSetup.SalesPromotionSetup();
        Transaction = new Transaction(Inventory);
        Receipt = new Receipt(Transaction);

        Transaction.SetSalesPromotion(SalesPromotion);
        Transaction.scan("1P");
        Transaction.scan("1P");
        Transaction.scan("2P");
        Transaction.scan("2P");
        Transaction.scan("3P");

        Transaction.scan("1W", 2.5f);
        Transaction.Finalize();
        
        A_QuantityPerPieceSummary = 5;
        A_TotalPricePerPieceSummary = 110;
        A_QuantityPerWeightSummary = 2.5f;
        A_TotalPricePerWeightSummary = 100;
        A_DiscountedItemsQuantity = 3;
        A_GrandTotal = 210;
    }


    
    @Test
    void QuantityPerPieceSummary() throws InvalidProductException {
        StartTransaction();
        assertEquals(Transaction.ItemsSummary.QuantityPerSeUSummary.get(SellingUnit.Piece), A_QuantityPerPieceSummary);
    }
    
    @Test
    void TotalPricePerPieceSummary() throws InvalidProductException {
        StartTransaction();
        assertEquals(Transaction.ItemsSummary.TotalPricePerSeUSummary.get(SellingUnit.Piece), A_TotalPricePerPieceSummary);
    }

    @Test
    void QuantityPerWeightSummary() throws InvalidProductException {
        StartTransaction();
        assertEquals(Transaction.ItemsSummary.QuantityPerSeUSummary.get(SellingUnit.Weight), A_QuantityPerWeightSummary);
    }
    
    @Test
    void TotalPricePerWeightSummary() throws InvalidProductException {
        StartTransaction();
        assertEquals(Transaction.ItemsSummary.TotalPricePerSeUSummary.get(SellingUnit.Weight), A_TotalPricePerWeightSummary);
    }

    @Test
    void DiscountedItemsQuantity() throws InvalidProductException {
        StartTransaction();
        assertEquals(Transaction.DiscountedItemsSummary.QuantityPerSeUSummary.get(SellingUnit.Piece), A_DiscountedItemsQuantity);
    }
    
    
    @Test
    void GrandTotal() throws InvalidProductException {
        StartTransaction();
        assertEquals(Transaction.GrandTotal, A_GrandTotal);
    }
    
    @Test
    void PrintReceipt() throws InvalidProductException {
       StartTransaction();
       Receipt.Print();
    }
}
