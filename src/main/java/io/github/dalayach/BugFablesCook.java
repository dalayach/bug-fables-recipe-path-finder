package io.github.dalayach;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/** Enum containing the different cooks, as well as where they are located. */
public enum BugFablesCook
{

   /**
    * 
    * PLEASE NOTE - The parameters for each cook should ONLY include foodItems that are specific to THAT COOK, or specific to
    * SOME of the cooks. Do not include recipes that EVERY cook can cook! You won't break anything, but it can mislead others
    * who have to work on this too.
    * 
    */

   /** Fry the fly. */
   FRY(
      BugFablesLocation.ANT_CITY,
      BugFablesFoodItem.SUCCULENT_PLATTER,
      BugFablesFoodItem.YAM_BREAD,
      BugFablesFoodItem.ABOMBINATION,
      BugFablesFoodItem.QUEENS_DINNER
   ),
   
   /** Crisbee the bee. */
   CRISBEE(
      BugFablesLocation.DEFIANT_ROOT,
      BugFablesFoodItem.CRISBEE_DONUT
   ),
   
   /** Kut the mantis. */
   KUT(
      BugFablesLocation.GOLDEN_SETTLEMENT,
      BugFablesFoodItem.SUCCULENT_PLATTER,
      BugFablesFoodItem.YAM_BREAD,
      BugFablesFoodItem.ABOMBINATION,
      BugFablesFoodItem.TANGY_CARPACCIO
   ),
   
   /** Microwave the machine. */
   MICROWAVE(
      BugFablesLocation.TERMITE_CAPITOL,
      BugFablesFoodItem.SUCCULENT_PLATTER,
      BugFablesFoodItem.YAM_BREAD,
      BugFablesFoodItem.ABOMBINATION
   ),
   
   ;
   
	/** Contains the location of the cook. */
   private final BugFablesLocation location;
   
   /** Contains the foodItems that the cook can create. */
   private final Set<BugFablesFoodItem> finalProducts;
   
   /**
    * 
    * Contains the foodItems that can be created by this cook, at this cook's location by purchasing and cooking foodItems
    * from shops and cooks found ONLY AT THIS COOK'S LOCATION.
    * <br><br>
    * Please note - this Set MUST be a subset of finalProducts! That is because this Set only considers the foodItems
    * contained within the Set finalProducts.
    * 
    */
   private final Set<BugFablesFoodItem> localFinalProducts;
   
	/**
	 * 
	 * Constructor.
	 * 
	 * @param location location
	 * 
	 */
   BugFablesCook(BugFablesLocation location, BugFablesFoodItem... finalProducts)
   {
   
      this.location = location;
      
      Set<BugFablesFoodItem> sharedFinalProducts = this.createSharedFinalProducts();
      
      sharedFinalProducts.addAll(Arrays.asList(finalProducts));
         
      this.finalProducts = Collections.unmodifiableSet(sharedFinalProducts);
      
      this.localFinalProducts = Collections.unmodifiableSet(this.createLocalFinalProducts());
   
   }
   
   /** Getter for location. */
   public BugFablesLocation getLocation()
   {
   
      return this.location;
   
   }
   
   /** Getter for finalProducts. */
   public Set<BugFablesFoodItem> getFinalProducts()
   {
   
      return this.finalProducts;
   
   }
   
   /** Getter for localFinalProducts. */
   public Set<BugFablesFoodItem> getLocalFinalProducts()
   {
   
      return this.localFinalProducts;
   
   }
   
   /** Finds all cooks located in the given locations. Returns an empty set if there are none there. */
   protected static Set<BugFablesCook> findCooksByLocations(Set<BugFablesLocation> locations)
   {
   
      Set<BugFablesCook> cooks = EnumSet.noneOf(BugFablesCook.class);
   
      if (locations != null)
      {
      
         for (BugFablesCook cook : BugFablesCook.values())
         {
         
            if (locations.contains(cook.getLocation()))
            {
            
               cooks.add(cook);
            
            }
         
         }
      
      }
      
      return cooks;
   
   }
   
	/**
	 * 
	 * Finds cooks located at the location in the parameter.
	 * 
	 * @param	location	location we want to find cooks within.
	 * @return	returns the set of cooks that exist at the location specified in the parameters. It's a
	 *					Set because we don't expect any duplicates.
	 *
	 */
   protected static Set<BugFablesCook> findCooksByLocation(BugFablesLocation location)
   {
   
      Set<BugFablesCook> cooks = EnumSet.noneOf(BugFablesCook.class);
   
      if (location != null)
      {
      
         return BugFablesCook.findCooksByLocations(EnumSet.of(location));
      
      }
   
      return cooks;
      
   }
   
   /** Fetches a Set of cooks who can cook the given foodItem. */
   public static Set<BugFablesCook> fetchCooksContainingAFinalProduct(BugFablesFoodItem finalProduct)
   {
   
      Set<BugFablesCook> cooks = EnumSet.noneOf(BugFablesCook.class);
   
      if (finalProduct != null)
      {
      
         for (BugFablesCook cook : BugFablesCook.values())
         {
         
            if (cook.getFinalProducts().contains(finalProduct))
            {
            
               cooks.add(cook);
            
            }
         
         }
      
      }
      
      return cooks;
   
   }
     
   /** Fetches a Set of cooks who can cook any of the given foodItems. */
   public static Set<BugFablesCook> fetchCooksContainingAnyFinalProducts(Set<BugFablesFoodItem> finalProducts)
   {
   
      Set<BugFablesCook> cooks = EnumSet.noneOf(BugFablesCook.class);
   
      if (finalProducts != null)
      {
      
         for (BugFablesCook cook : BugFablesCook.values())
         {
         
            if (Collections.disjoint(cook.getFinalProducts(), finalProducts))
            {
            
               cooks.add(cook);
            
            }
         
         }
      
      }
      
      return cooks;
   
   }
       
   /** Fetches a Set of cooks who can cook all of the given foodItems. */
   public static Set<BugFablesCook> fetchCooksContainingAllFinalProducts(Set<BugFablesFoodItem> finalProducts)
   {
   
      Set<BugFablesCook> cooks = EnumSet.noneOf(BugFablesCook.class);
   
      if (finalProducts != null)
      {
      
         for (BugFablesCook cook : BugFablesCook.values())
         {
         
            if (cook.getFinalProducts().containsAll(finalProducts))
            {
            
               cooks.add(cook);
            
            }
         
         }
      
      }
      
      return cooks;
   
   }
   
   private Set<BugFablesFoodItem> createLocalFinalProducts()
   {
   
      Set<BugFablesFoodItem> localFinalProducts = EnumSet.noneOf(BugFablesFoodItem.class);
   
      for (BugFablesRecipe recipe : BugFablesRecipe.values())
      {
      
         if (this.getFinalProducts().contains(recipe.getFinalProduct()) && !localFinalProducts.contains(recipe.getFinalProduct()))
         {
         
            Set<BugFablesFoodItem> localPurchasableFoodItems =
               BugFablesFoodItem.getPurchasableFoodItemsByLocation(
                  this.getLocation());
                  
            if (localPurchasableFoodItems.contains(recipe.getIngredients()))
            {
            
               localFinalProducts.add(recipe.getFinalProduct());
                  
            }
         
         }
      
      }
   
      return localFinalProducts;
   
   }
  
   private Set<BugFablesFoodItem> createSharedFinalProducts()
   {
   
      return EnumSet.of(
         BugFablesFoodItem.ABOMIHONEY,
         BugFablesFoodItem.APHID_SHAKE,
         BugFablesFoodItem.BAKED_YAM,
         BugFablesFoodItem.BERRY_JAM,
         BugFablesFoodItem.BERRY_JUICE,
         BugFablesFoodItem.BERRY_SMOOTHIE,
         BugFablesFoodItem.BIG_MISTAKE,
         BugFablesFoodItem.BURLY_BOMB,
         BugFablesFoodItem.BURLY_CANDY,
         BugFablesFoodItem.BURLY_CHIPS,
         BugFablesFoodItem.BURLY_TEA,
         BugFablesFoodItem.CHERRY_BOMBS,
         BugFablesFoodItem.CHERRY_PIE,
         BugFablesFoodItem.CLEAR_BOMB,
         BugFablesFoodItem.COLD_SALAD,
         BugFablesFoodItem.COOKED_DANGER,
         BugFablesFoodItem.COOKED_SHROOM,
         BugFablesFoodItem.DANGER_DISH,
         BugFablesFoodItem.DROWSY_CAKE,
         BugFablesFoodItem.DRY_BREAD,
         BugFablesFoodItem.FRIED_EGG,
         BugFablesFoodItem.FROST_BOMB,
         BugFablesFoodItem.FROST_PIE,
         BugFablesFoodItem.GLAZED_HONEY,
         BugFablesFoodItem.HEARTY_BREAKFAST,
         BugFablesFoodItem.HONEY_ICE_CREAM,
         BugFablesFoodItem.HONEY_LEAF,
         BugFablesFoodItem.HONEY_PANCAKES,
         BugFablesFoodItem.HOT_DRINK,
         BugFablesFoodItem.HUSTLE_CANDY,
         BugFablesFoodItem.ICE_CREAM,
         BugFablesFoodItem.LEAF_CROISSANT,
         BugFablesFoodItem.LEAF_OMELET,
         BugFablesFoodItem.LEAF_SALAD,
         BugFablesFoodItem.MIRACLE_SHAKE,
         BugFablesFoodItem.MISTAKE,
         BugFablesFoodItem.MUSHROOM_GUMMIES,
         BugFablesFoodItem.MUSHROOM_SALAD,
         BugFablesFoodItem.MUSHROOM_SKEWER,
         BugFablesFoodItem.NUMB_BOMB,
         BugFablesFoodItem.NUTTY_CAKE,
         BugFablesFoodItem.PLAIN_TEA,
         BugFablesFoodItem.PLUMPLING_PIE,
         BugFablesFoodItem.POISON_BOMB,
         BugFablesFoodItem.POISON_CAKE,
         BugFablesFoodItem.ROASTED_BERRIES,
         BugFablesFoodItem.SHAVED_ICE,
         BugFablesFoodItem.SHOCK_CANDY,
         BugFablesFoodItem.SLEEP_BOMB,
         BugFablesFoodItem.SPICY_BOMB,
         BugFablesFoodItem.SPICY_CANDY,
         BugFablesFoodItem.SPICY_FRIES,
         BugFablesFoodItem.SPICY_TEA,
         BugFablesFoodItem.SQUASH_CANDY,
         BugFablesFoodItem.SQUASH_PUREE,
         BugFablesFoodItem.SQUASH_TART,
         BugFablesFoodItem.SUCCULENT_COOKIES,
         BugFablesFoodItem.SWEET_DANGER,
         BugFablesFoodItem.SWEET_DEW,
         BugFablesFoodItem.SWEET_PUDDING,
         BugFablesFoodItem.SWEET_SHROOM,
         BugFablesFoodItem.TANGY_JAM,
         BugFablesFoodItem.TANGY_JUICE,
         BugFablesFoodItem.TANGY_PIE
         );
         
   }

}
