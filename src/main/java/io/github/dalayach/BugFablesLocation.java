package io.github.dalayach;

import java.util.Set;
import java.util.EnumSet;

/**
 *
 * Enum containing the locations in Bug Fables. DO NOT REMOVE LOCATIONS, EVEN IF UPDATES TO THE GAME MEANS THAT
 * CERTAIN LOCATIONS ARE IRRELEVANT. Simply removing locations as they become irrelevant will be extra work
 * downstream, so it might be wise to simply set the flag to false, in order to notify downstream processes that
 * there are no points of importance at this location (relative to the PathFinder).
 *
 */
public enum BugFablesLocation
{

   /** Ant City Plaza -- houses Madame Butterfly's shop, the caravan, and Fry the fly. */
   ANT_CITY(true),
   /** Golden Settlement -- houses Golden Emporium, a caravan, and Kut. */
   GOLDEN_SETTLEMENT(true),
   /** Defiant Root -- houses several shops and Crisbee. */
   DEFIANT_ROOT(true),
   /** Bee Hive Factory -- houses a shop. */
   BEE_HIVE(true),
   /** Metal Island -- houses Skirby's shop and the Tea shop. */
   METAL_ISLAND(true),
   /** Termite Capitol -- houses several shops and a microwave. */
   TERMITE_CAPITOL(true),
   /** Wasp Kingdom Hive -- houses Jayde's shop. */
   WASP_KINGDOM(true),
   /** Dead Lands -- houses the Roach Stand. */
   DEAD_LANDS(true)
	
   ;
	
	/**
	 * 
	 * boolean to represent whether or not a location contains containsPointsOfImportance.
	 * 
	 * Examples include, but may not be limited to:
	 * - shops
	 * - cooks
	 * - purchasableFoodItems
	 * 
	 */
   private boolean containsPointsOfImportance;
	
   /** Constructor. */
   BugFablesLocation(boolean containsPointsOfImportance)
   {
   
      this.containsPointsOfImportance = containsPointsOfImportance;
   
   }
	
   /** Returns whether or not this location contains any points of importance. */
   public boolean containsPointsOfImportance()
   {
   
      return this.containsPointsOfImportance;
   
   }
   
   /** Returns a Set of locations containing the given Set of purchasable foodItems. */
   public static Set<BugFablesLocation> findLocationsByPurchasableItems(Set<BugFablesFoodItem> foodItems)
   {
   
      Set<BugFablesLocation> locations = EnumSet.noneOf(BugFablesLocation.class);
   
      if (foodItems != null)
      {
      
         for (BugFablesShop shop : BugFablesShop.findShopsByPurchasableItems(foodItems))
         {
         
            locations.add(shop.getLocation());
         
         }
      
      }
   
      return locations;
   
   }
   
   /** Returns a Set of locations containing the given purchasable foodItems. */
   public static Set<BugFablesLocation> findLocationsByPurchasableItem(BugFablesFoodItem foodItem)
   {
   
      Set<BugFablesLocation> locations = EnumSet.noneOf(BugFablesLocation.class);
   
      for (BugFablesShop shop : BugFablesShop.findShopsByPurchasableItem(foodItem))
      {
      
         locations.add(shop.getLocation());
      
      }
      
      return locations;
   
   }
   
   /** Returns the Set of locations that contain points of importance. */
   public static Set<BugFablesLocation> importantLocations()
   {
   
      Set<BugFablesLocation> locations = EnumSet.noneOf(BugFablesLocation.class);
   
      for (BugFablesLocation location : BugFablesLocation.values())
      {
      
         if (location.containsPointsOfImportance())
         {
         
            locations.add(location);
         
         }
      
      }
   
      return locations;
   
   }
   
}
