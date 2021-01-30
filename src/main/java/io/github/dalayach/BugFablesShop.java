package io.github.dalayach;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 *
 * Enum containing the shops in Bug Fables.
 * 
 * 20200816 -- will likely be updated to include relevant info, but we'll see
 *
 */
public enum BugFablesShop
{

	/** Madame Butterfly's Shop -- found in the Ant City Commercial Area. */
   MADAME_BUTTERFLY(
   BugFablesLocation.ANT_CITY,
   BugFablesFoodItem.MUSHROOM,
   BugFablesFoodItem.DANGER_SHROOM,
   BugFablesFoodItem.APHID_EGG,
   BugFablesFoodItem.HONEY_DROP,
   BugFablesFoodItem.CRUNCHY_LEAF
   ),
   
	/** Ant City Caravan -- found south of the Ant City Plaza. */
   ANT_CITY_CARAVAN(
   BugFablesLocation.ANT_CITY,
   BugFablesFoodItem.SPICY_BERRY,
   BugFablesFoodItem.BURLY_BERRY,
   BugFablesFoodItem.MAGIC_SEED
   ),
   
	/** Doppel's Berry Juice Bar -- found underground the Ant City Commercial Area. */
   DOPPEL_BERRY_JUICE_BAR(
   BugFablesLocation.ANT_CITY,
   BugFablesFoodItem.BERRY_JUICE
   ),
   
	/** Dark Cherry Salesman -- found underground the Ant City Commercial Area. */
   DARK_CHERRY_SALESMAN(
   BugFablesLocation.ANT_CITY,
   BugFablesFoodItem.DARK_CHERRIES
   ),
   
	/** Golden Emporium -- found in the Golden Settlement Plaza. */
   GOLDEN_EMPORIUM(
   BugFablesLocation.GOLDEN_SETTLEMENT,
   BugFablesFoodItem.APHID_EGG,
   BugFablesFoodItem.APHID_DEW,
   BugFablesFoodItem.HONEY_DROP,
   BugFablesFoodItem.CLEAR_WATER,
   BugFablesFoodItem.HARD_SEED
   ),
   
	/** Golden Settlement Berry Juice Stand -- found in the Golden Settlement Plaza. */
   GOLDEN_SETTLEMENT_BERRY_JUICE_STAND(
   BugFablesLocation.GOLDEN_SETTLEMENT,
   BugFablesFoodItem.BERRY_JUICE
   ),
   
	/** Golden Settlement Caravan -- found in the Golden Settlement Entrance. */
   GOLDEN_SETTLEMENT_CARAVAN(
   BugFablesLocation.GOLDEN_SETTLEMENT,
   BugFablesFoodItem.NUMBNAIL_DART,
   BugFablesFoodItem.SLEEP_BOMB,
   BugFablesFoodItem.DROWSY_CAKE
   ),
	
   /** Defiant Root Caravan -- found at the South Entrance to Defiant Root. */
   DEFIANT_ROOT_CARAVAN(
   BugFablesLocation.DEFIANT_ROOT,
   BugFablesFoodItem.MAGIC_SEED,
   BugFablesFoodItem.BURLY_BERRY,
   BugFablesFoodItem.SUCCULENT_BERRY
   ),
	
	/** Defiant Root Outdoor Stand -- found immediately outside of Crisbee Bakery. */
   DEFIANT_ROOT_OUTDOOR_STAND(
   BugFablesLocation.DEFIANT_ROOT,
   BugFablesFoodItem.DRY_BREAD,
   BugFablesFoodItem.CRUNCHY_LEAF,
   BugFablesFoodItem.CLEAR_WATER,
   BugFablesFoodItem.AGARIC_SHROOM,
   BugFablesFoodItem.HUSTLE_BERRY
   ),
   
	/** Crisbee Bakery -- found in Defiant Root's Commercial District. */
   CRISBEE_BAKERY(
   BugFablesLocation.DEFIANT_ROOT,
   BugFablesFoodItem.HONEY_DROP,
   BugFablesFoodItem.BAG_OF_FLOUR,
   BugFablesFoodItem.NUTTY_CAKE
   ),
   
	/** Magic Ice Salesman -- found in Defiant Root's Commercial District. */
   MAGIC_ICE_SALESBUG(
   BugFablesLocation.DEFIANT_ROOT,
   BugFablesFoodItem.MAGIC_ICE
   ),
	
	/** Poison Emporium -- found in Defiant Root's back alleys. */
   POISON_EMPORIUM(
   BugFablesLocation.DEFIANT_ROOT,
   BugFablesFoodItem.DANGER_SPUD,
   BugFablesFoodItem.DANGER_SHROOM,
   BugFablesFoodItem.POISON_BOMB,
   BugFablesFoodItem.POISON_DART
   ),
	
	/** Factory Gift Shop -- found in the Honey Factory. */
   FACTORY_GIFT_SHOP(
   BugFablesLocation.BEE_HIVE,
   BugFablesFoodItem.HONEY_LEAF,
   BugFablesFoodItem.LEAF_OMELET,
   BugFablesFoodItem.GLAZED_HONEY,
   BugFablesFoodItem.HONEY_ICE_CREAM,
   BugFablesFoodItem.SHOCK_BERRY
   ),
	
	/** Skirby's Tangy Berry Stand -- found in Metal Island's Commercial Area. */
   SKIRBY_STAND(
   BugFablesLocation.METAL_ISLAND,
   BugFablesFoodItem.TANGY_BERRY
   ),
	
	/** Tea Heaven -- found in Metal Island's Commercial Area. */
   TEA_HEAVEN(
   BugFablesLocation.METAL_ISLAND,
   BugFablesFoodItem.BURLY_TEA,
   BugFablesFoodItem.SPICY_TEA
   ),
	
	/** T-Mart -- found on the nearside of the Termite Capitol Entrance Room. */
   T_MART(
   BugFablesLocation.TERMITE_CAPITOL,
   BugFablesFoodItem.SQUASH,
   BugFablesFoodItem.SHELL_OINTMENT,
   BugFablesFoodItem.APHID_SHAKE,
   BugFablesFoodItem.MEGA_RUSH
   ),
	
	/** DineMite -- found on the farside of the Termite Capitol Entrance Room. */
   DINE_MITE(
   BugFablesLocation.TERMITE_CAPITOL,
   BugFablesFoodItem.MITE_BURGER,
   BugFablesFoodItem.SPICY_FRIES
   ),
	
   /** Bomb Shop -- found outside the Colliseum in the Termite Capitol. */
   BOMB_SHOP(
   BugFablesLocation.TERMITE_CAPITOL,
   BugFablesFoodItem.POISON_BOMB,
   BugFablesFoodItem.BURLY_BOMB,
   BugFablesFoodItem.SPICY_BOMB,
   BugFablesFoodItem.FROST_BOMB,
   BugFablesFoodItem.NUMB_BOMB,
   BugFablesFoodItem.SLEEP_BOMB,
   BugFablesFoodItem.CLEAR_BOMB
   ),
	
	/** Colliseum Caravan -- found inside the Colliseum in the Termite Capitol. */
   COLLISEUM_CARAVAN(
   BugFablesLocation.TERMITE_CAPITOL,
   BugFablesFoodItem.CRUNCHY_LEAF,
   BugFablesFoodItem.HONEY_DROP,
   BugFablesFoodItem.MAGIC_SEED,
   BugFablesFoodItem.BURLY_BERRY,
   BugFablesFoodItem.SPICY_BERRY
   ),
	
	/** Roach Stand -- found in the Roach Village in the Giant's Lair. */
   ROACH_STAND(
   BugFablesLocation.DEAD_LANDS,
   BugFablesFoodItem.FLAME_ROCK,
   BugFablesFoodItem.MYSTERY_BERRY,
   BugFablesFoodItem.MAGIC_SEED
   ),
   
	//
   JAYDE_SHOP(
   BugFablesLocation.WASP_KINGDOM,
   BugFablesFoodItem.JAYDE_STEW
   )
   ;
   
	/** Location of the shop. */
   private final BugFablesLocation location;
   /** Set of purchasable items at each shop. */
   private final Set<BugFablesFoodItem> purchasableItems;
   
   /** Constructor. */
   BugFablesShop(BugFablesLocation location, BugFablesFoodItem... purchasableItems)
   {
   
      this.location = location;
      /** EnumSet makes this very space efficient. */
      this.purchasableItems = Collections.unmodifiableSet(EnumSet.copyOf(Arrays.asList(purchasableItems)));
   
   }
   
   /** Returns the location for this shop. */
   public BugFablesLocation getLocation()
   {
   
      return this.location;
   
   }
	
   /** Returns the set of purchasable foodItems for this shop. */
   public Set<BugFablesFoodItem> getPurchasableItems()
   {
   
      return this.purchasableItems;
   
   }
   
   /** Returns a Set of shops located at any of the given locations. */
   protected static Set<BugFablesShop> findShopsByLocations(Set<BugFablesLocation> locations)
   {
   
      Set<BugFablesShop> shops = EnumSet.noneOf(BugFablesShop.class);
   
      if (locations != null)
      {
      
         for (BugFablesLocation location : locations)
         {
         
            shops.addAll(BugFablesShop.findShopsByLocation(location));
         
         }
      
      }
      
      return shops;
   
   }
   
	/**
	 * 
	 * Finds shops located at the location in the parameter.
	 * 
	 * @param	location	location we want to find shops within.
	 * @return	returns the set of shops that exist at the location specified in the parameters. It's a
	 *					Set because we don't expect any duplicates.
	 *
	 */
   protected static Set<BugFablesShop> findShopsByLocation(BugFablesLocation location)
   {
   
      Set<BugFablesShop> shops = EnumSet.noneOf(BugFablesShop.class);
   
      if (location != null)
      {
      
         for (BugFablesShop shop : BugFablesShop.values())
         {
         
            if (shop.getLocation() == location)
            {
            
               shops.add(shop);
            
            }
         
         }
      
      }
      
      return shops;
   
   }
   
   /** Returns a Set of shops, with each containing ALL of the given foodItems. */
   protected static Set<BugFablesShop> findShopsContainingAllPurchasableItems(Set<BugFablesFoodItem> foodItems)
   {
   
      Set<BugFablesShop> shops = EnumSet.noneOf(BugFablesShop.class);
   
      if (foodItems != null)
      {
      
         for (BugFablesShop shop : BugFablesShop.values())
         {
         
            if (shop.getPurchasableItems().containsAll(foodItems))
            {
            
               shops.add(shop);
            
            }
         
         }
      
      }
   
      return shops;
   
   }
   
   /** Returns a Set of shops, with each containing ONE OR MORE of the given foodItems. */
   protected static Set<BugFablesShop> findShopsContainingAnyPurchasableItems(Set<BugFablesFoodItem> foodItems)
   {
   
      Set<BugFablesShop> shops = EnumSet.noneOf(BugFablesShop.class);
   
      if (foodItems != null)
      {
      
         for (BugFablesFoodItem foodItem : foodItems)
         {
         
            shops.addAll(BugFablesShop.findShopsByPurchasableItem(foodItem));
         
         }
      
      }
   
      return shops;
   
   }
   
   /** Returns a Set of shops, with each containing the given foodItems. */
   protected static Set<BugFablesShop> findShopsByPurchasableItem(BugFablesFoodItem foodItem)
   {
   
      Set<BugFablesShop> shops = EnumSet.noneOf(BugFablesShop.class);
   
      for (BugFablesShop shop : BugFablesShop.values())
      {
      
         if (shop.getPurchasableItems().contains(foodItem))
         {
         
            shops.add(shop);
         
         }
      
      }
   
      return shops;
   
   }
   
   /** Returns a string representation in the format of name(location, purchasableItems). */
   public String toString()
   {
   
      return this.name();
   
   }

}
