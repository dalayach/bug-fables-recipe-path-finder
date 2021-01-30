package io.github.dalayach;

import java.util.Set;
import java.util.EnumSet;

import org.junit.Assert;
import org.junit.Test;

/** Unit test for BugFablesFoodItem. */
public class BugFablesFoodItemTest {
   
   @Test
   public void testFindPurchasableFoodItemsByLocation()
   {
   
   	/** Always test the null case! */
      Assert.assertEquals(BugFablesFoodItem.findPurchasableFoodItemsByLocations(null), EnumSet.noneOf(BugFablesLocation.class));
   
      for (BugFablesLocation location : BugFablesLocation.values())
      {
      
         this.testFindPurchasableFoodItemsByLocation(location);
      
      }
   
   }
   
   private void testFindPurchasableFoodItemsByLocation(BugFablesLocation location)
   {
         
      Set<BugFablesFoodItem> foodItems = BugFablesFoodItem.findPurchasableFoodItemsByLocation(location);
      
      for (BugFablesFoodItem foodItem : foodItems)
      {
               
         Assert.assertTrue(this.findShopsByFoodItemsAndLocation(foodItem, location));
      
      }
      
      for (BugFablesFoodItem foodItem : EnumSet.complementOf(EnumSet.copyOf(foodItems)))
      {
      
         Assert.assertFalse(this.findShopsByFoodItemsAndLocation(foodItem, location));
      
      }
            	
   }
   
   /** Finds shops that sell the specific foodItem AND are located at the specific location. */
   private boolean findShopsByFoodItemsAndLocation(BugFablesFoodItem foodItem, BugFablesLocation location)
   {
   
      boolean hasFoodItem = false;
      
      for (BugFablesShop shop : BugFablesShop.values())
      {
         
         if (shop.getLocation() == location && shop.getPurchasableItems().contains(foodItem))
         {
            
            hasFoodItem = true;
            break;
            
         }
         
      }
      
      return hasFoodItem;
   	
   }
   
   @Test
   public void testGetAllFoodItemsContainingRecipes()
   {
   
      Set<BugFablesFoodItem> foodItems = BugFablesFoodItem.getAllFoodItemsContainingRecipes();
   
      for (BugFablesFoodItem foodItem : EnumSet.complementOf(EnumSet.copyOf(foodItems)))
      {
      
         boolean threwException = false;
      
         try
         {
         
            BugFablesRecipeBook.getRespectiveRecipeBook(foodItem);
         
         } catch (IllegalArgumentException iae)
         {
         
            threwException = true;
         
         }
      
         Assert.assertTrue(threwException);
      
      }
   
   }
   
}
