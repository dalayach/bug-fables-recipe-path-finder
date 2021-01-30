package io.github.dalayach;

import java.util.Set;
import java.util.EnumSet;

import org.junit.Assert;
import org.junit.Test;

/** Unit test for BugFablesShop. */
public class BugFablesShopTest
{

   @Test
   public void testFindShopsByLocation()
   {
   
   	/** Always test the null case! */
      Assert.assertEquals(BugFablesShop.findShopsByLocation(null), EnumSet.noneOf(BugFablesShop.class));
   
      for (BugFablesLocation location : BugFablesLocation.values())
      {
      
         this.testFindShopsByLocation(location);
      
      }
   
   }
   
   private void testFindShopsByLocation(BugFablesLocation location)
   {
   
      Set<BugFablesShop> shops = BugFablesShop.findShopsByLocation(location);
   
      for (BugFablesShop shop : shops)
      {
      
         Assert.assertEquals(location, shop.getLocation());
      
      }
   
      for (BugFablesShop shop : EnumSet.complementOf(EnumSet.copyOf(shops)))
      {
      
         Assert.assertNotEquals(location, shop.getLocation());
      
      }
   
   }
	
   @Test
   public void testFindShopsByPurchasableItem()
   {
   
   	/** Always test the null case! */
      Assert.assertEquals(BugFablesShop.findShopsContainingAnyPurchasableItems(null), EnumSet.noneOf(BugFablesShop.class));
   
      for (BugFablesFoodItem foodItem : BugFablesFoodItem.values())
      {
      
         this.testFindShopsByPurchasableItem(foodItem);
      
      }
   
   }
   
   private void testFindShopsByPurchasableItem(BugFablesFoodItem foodItem)
   {
   
      Set<BugFablesShop> shops = BugFablesShop.findShopsByPurchasableItem(foodItem);
   
      for (BugFablesShop shop : shops)
      {
      
         Assert.assertTrue(shop.getPurchasableItems().contains(foodItem));
      
      }
   
      for (BugFablesShop shop : EnumSet.complementOf(EnumSet.copyOf(shops)))
      {
      
         Assert.assertFalse(shop.getPurchasableItems().contains(foodItem));
      
      }
   
   }
	
}
