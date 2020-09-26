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
   public void testFindFoodItemsByCook()
   {
   
      /** Always test the null case! */
      Assert.assertEquals(EnumSet.noneOf(BugFablesFoodItem.class), BugFablesFoodItem.findFoodItemsByCook(null));
      
      for (BugFablesCook cook : BugFablesCook.values())
      {
      
         this.testFindFoodItemsByCook(cook);
      
      }
   
   }
   
   public void testFindFoodItemsByCook(BugFablesCook cook)
   {
   
      Set<BugFablesFoodItem> foodItems = BugFablesFoodItem.findFoodItemsByCook(cook);
      
      for (BugFablesFoodItem foodItem : foodItems)
      {
      
         Assert.assertTrue(foodItem.getCook() == cook || foodItem.getCook() == BugFablesCook.ALL);
      
      }
      
      for (BugFablesFoodItem foodItem : EnumSet.complementOf(EnumSet.copyOf(foodItems)))
      {
      
         Assert.assertFalse(foodItem.getCook() == cook || foodItem.getCook() == BugFablesCook.ALL);
      
      }
   
   }
   
   @Test
   public void testNoDuplicateRecipeIds()
   {
   
      final BugFablesFoodItem lastItem = BugFablesFoodItem.values()[BugFablesFoodItem.values().length - 1];
   
      for (BugFablesFoodItem foodItem1 : BugFablesFoodItem.values())
      {
      
         for (BugFablesFoodItem foodItem2 : EnumSet.range(foodItem1, lastItem))
         {
         
         //remember, 0 represents an item that cannot be made. Therefore, several items have 0, and thus, no need to compare.
            if (foodItem1 != foodItem2 && foodItem1.getRecipeId() != 0 && foodItem1.getRecipeId() == foodItem2.getRecipeId())
            {
            
               Assert.fail("No duplicate recipeIds allowed!"
                  + "\n" + foodItem1.getRecipeId() + "\tfoodItem1 = " + foodItem1.name() 
                  + "\n" + foodItem2.getRecipeId() + "\tfoodItem2 = " + foodItem2.name());
            
            }
         
         }
      
      }
   
   }
   
   @Test
   public void testGetAllFoodItemsContainingRecipes()
   {
   
      Set<BugFablesFoodItem> foodItems = BugFablesFoodItem.getAllFoodItemsContainingRecipes();
   
      for (BugFablesFoodItem foodItem : foodItems)
      {
      
         Assert.assertTrue(foodItem.getRecipeId() != 0);
      
      }
      
      for (BugFablesFoodItem foodItem : EnumSet.complementOf(EnumSet.copyOf(foodItems)))
      {
      
         Assert.assertTrue(foodItem.getRecipeId() == 0);
      
      }
   
   }
   
}
