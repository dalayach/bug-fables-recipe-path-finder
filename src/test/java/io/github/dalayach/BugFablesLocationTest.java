package io.github.dalayach;

import java.util.Set;
import java.util.EnumSet;

import org.junit.Assert;
import org.junit.Test;

/** Unit test for BugFablesLocation. */
public class BugFablesLocationTest {

   /**
	 * 
	 * Tests that at least a certain set of locations still exist in the enum.
	 * 
	 * This is important because, should the game ever be updated to include a new location, we may have to edit the enum to
	 * include the new location. That is fine, but we need to remember that EVERY single value in BugFablesLocation is used
	 * in AT LEAST ONE of the other classes, enums, or unit tests. Therefore, to protect the stability of the build (and to
	 * limit the amount of work that will need to be done later), this unit test will stand to prevent the removal of a value
	 * from BugFablesLocation.
	 * 
	 * If a new location is added to BugFablesLocation, it is important to add that location to this unit test as well!
	 * 
	 * Normally, I wouldn't go to this length to protect an enum (especially since the other classes won't compile if we take
	 * away an enum value), but this particular enum is the bedrock for EVERYTHING, so it is INTEGRAL that we DO NOT REMOVE
	 * VALUES FROM BugFablesLocation!
	 * 
	 * And finally, DO NOT EVER REMOVE LOCATIONS FROM THIS UNIT TEST!
	 *
	 */
   @Test
   public void testIfLocationIsMissingValues() {
   
   	/**
   	 * 
   	 * Yes, this may seem redundant, as this unit test itself will not even compile if we are missing one, but that is how
   	 * important it is, that this standard is maintained.
   	 * 
   	 */
      Assert.assertTrue(
         "HAS A BugFablesLocation ENUM VALUE BEEN REMOVED?", 
         	EnumSet.allOf(BugFablesLocation.class).containsAll(EnumSet.of(
         	BugFablesLocation.ANT_CITY,
         	BugFablesLocation.GOLDEN_SETTLEMENT,
         	BugFablesLocation.DEFIANT_ROOT,
         	BugFablesLocation.BEE_HIVE,
         	BugFablesLocation.METAL_ISLAND,
         	BugFablesLocation.TERMITE_CAPITOL,
         	BugFablesLocation.WASP_KINGDOM,
         	BugFablesLocation.DEAD_LANDS
         	)));
         	
   }
   
   @Test
   public void testFindLocationsByPurchasableItem()
   {
   
   	/** Always test the null case! */
      Assert.assertEquals(BugFablesLocation.findLocationsByPurchasableItems(null), EnumSet.noneOf(BugFablesLocation.class));
   
      for (BugFablesFoodItem foodItem : BugFablesFoodItem.values())
      {
      
         this.testFindLocationsByPurchasableItem(foodItem);
      
      }
   
   }
	
   private void testFindLocationsByPurchasableItem(BugFablesFoodItem foodItem)
   {
   
      Set<BugFablesLocation> locations = BugFablesLocation.findLocationsByPurchasableItem(foodItem);
   
      for (BugFablesLocation location : locations)
      {
      
         Assert.assertTrue(this.testFindLocationsByPurchasableItem(location, foodItem));
      
      }
      
      for (BugFablesLocation location : EnumSet.complementOf(EnumSet.copyOf(locations)))
      {
      
         Assert.assertFalse(this.testFindLocationsByPurchasableItem(location, foodItem));
      
      }
   
   }
   
   private boolean testFindLocationsByPurchasableItem(BugFablesLocation location, BugFablesFoodItem foodItem)
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
   
}
