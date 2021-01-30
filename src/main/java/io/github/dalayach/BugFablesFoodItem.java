package io.github.dalayach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.EnumSet;

/**
 * 
 * Enum containing all of the food items in the game.
 * 
 */
public enum BugFablesFoodItem
{

   ABOMBINATION,
   ABOMIHONEY,
   AGARIC_SHROOM,
   APHID_DEW,
   APHID_EGG,
   APHID_SHAKE,
   BAG_OF_FLOUR,
   BAKED_YAM,
   BERRY_JAM,
   BERRY_JUICE,
   BERRY_SMOOTHIE,
   BIG_MISTAKE,
   BURLY_BERRY,
   BURLY_BOMB,
   BURLY_CANDY,
   BURLY_CHIPS,
   BURLY_TEA,
   CHERRY_BOMBS,
   CHERRY_PIE,
   CLEAR_BOMB,
   CLEAR_WATER,
   COLD_SALAD,
   COOKED_DANGER,
   COOKED_SHROOM,
   CRISBEE_DONUT,
   CRUNCHY_LEAF,
   DANGER_DISH,
   DANGER_SHROOM,
   DANGER_SPUD,
   DARK_CHERRIES,
   DROWSY_CAKE,
   DRY_BREAD,
   FLAME_ROCK,
   FRIED_EGG,
   FROST_BOMB,
   FROST_PIE,
   GLAZED_HONEY,
   HARD_SEED,
   HEARTY_BREAKFAST,
   HONEY_DROP,
   HONEY_ICE_CREAM,
   HONEY_LEAF,
   HONEY_PANCAKES,
   HOT_DRINK,
   HUSTLE_BERRY,
   HUSTLE_CANDY,
   ICE_CREAM,
   JAYDE_STEW,
   LEAF_CROISSANT,
   LEAF_OMELET,
   LEAF_SALAD,
   MAGIC_ICE,
   MAGIC_SEED,
   MEGA_RUSH,
   MIRACLE_SHAKE,
   MISTAKE,
   MITE_BURGER,
   MUSHROOM,
   MUSHROOM_GUMMIES,
   MUSHROOM_SALAD,
   MUSHROOM_SKEWER,
   MYSTERY_BERRY,
   NUMBNAIL_DART,
   NUMB_BOMB,
   NUTTY_CAKE,
   PLAIN_TEA,
   PLUMPLING_PIE,
   POISON_BOMB,
   POISON_CAKE,
   POISON_DART,
   QUEENS_DINNER,
   ROASTED_BERRIES,
   SHAVED_ICE,
   SHELL_OINTMENT,
   SHOCK_BERRY,
   SHOCK_CANDY,
   SLEEP_BOMB,
   SPICY_BERRY,
   SPICY_BOMB,
   SPICY_CANDY,
   SPICY_FRIES,
   SPICY_TEA,
   SQUASH,
   SQUASH_CANDY,
   SQUASH_PUREE,
   SQUASH_TART,
   SUCCULENT_BERRY,
   SUCCULENT_COOKIES,
   SUCCULENT_PLATTER,
   SWEET_DANGER,
   SWEET_DEW,
   SWEET_PUDDING,
   SWEET_SHROOM,
   TANGY_BERRY,
   TANGY_CARPACCIO,
   TANGY_JAM,
   TANGY_JUICE,
   TANGY_PIE,
   YAM_BREAD,
   
   ;
   
   /** Returns a Set of all purchasable foodItems found at the given locations. */
   protected static Set<BugFablesFoodItem> getPurchasableFoodItemsByLocations(Set<BugFablesLocation> locations)
   {
   
      Set<BugFablesFoodItem> foodItems = EnumSet.noneOf(BugFablesFoodItem.class);
   
      if (locations != null)
      {
      
         for (BugFablesLocation location : locations)
         {
         
            foodItems.addAll(BugFablesFoodItem.getPurchasableFoodItemsByLocation(location));
         
         }
      
      }
   
      return foodItems;
   
   }
	
   /** Returns a Set of all purchasable foodItems found at the given location. */
   protected static Set<BugFablesFoodItem> getPurchasableFoodItemsByLocation(BugFablesLocation location)
   {
   
      Set<BugFablesFoodItem> totalSetOfFoodItems = EnumSet.noneOf(BugFablesFoodItem.class);
      
      for (BugFablesShop shop : BugFablesShop.findShopsByLocation(location))
      {
      
         totalSetOfFoodItems.addAll(shop.getPurchasableItems());
      
      }
   
      return totalSetOfFoodItems;	
   
   }
   
   /** Returns a Set of foodItems purchasable at the given shops. */
   protected static Set<BugFablesFoodItem> getPurchasableFoodItemsByShops(Set<BugFablesShop> shops)
   {
   
      Set<BugFablesFoodItem> foodItems = EnumSet.noneOf(BugFablesFoodItem.class);
   
      if (shops != null)
      {
      
         for (BugFablesShop shop : shops)
         {
         
            foodItems.addAll(shop.getPurchasableItems());
         
         }
      
      }
   
      return foodItems;
   
   }
   
   /** Returns a Set of foodItems that can be created through a BugFablesRecipeBook. */
   protected static Set<BugFablesFoodItem> getAllFoodItemsContainingRecipes()
   {
   
      Set<BugFablesFoodItem> foodItems = EnumSet.noneOf(BugFablesFoodItem.class);
      
      for (BugFablesRecipeBook recipeBook : BugFablesRecipeBook.values())
      {
      
         foodItems.add(BugFablesFoodItem.getRespectiveFoodItem(recipeBook));
      
      }
   
      return foodItems;
   
   }
   
   public static Set<BugFablesFoodItem> getAllFoodItemsThatCanBeCreatedFromScratchEntirelyAtASingleLocation(BugFablesLocation location)
   {
   
      Set<BugFablesFoodItem> foodItems = EnumSet.noneOf(BugFablesFoodItem.class);
      
      Set<BugFablesShop> shops = BugFablesShop.findShopsByLocation(location);
      Set<BugFablesCook> cooks = BugFablesCook.findCooksByLocation(location);
      
      if (!shops.isEmpty() && !cooks.isEmpty())
      {
            
         for (BugFablesFoodItem foodItem : BugFablesFoodItem.getFinalProductsByCooks(cooks))
         {
         
            Set<BugFablesRecipe> recipes = BugFablesRecipe.getAllRecipesForFinalProduct(foodItem);
            Set<BugFablesFoodItem> purchasableFoodItems = BugFablesFoodItem.getPurchasableFoodItemsByShops(shops);
         
            for (BugFablesRecipe recipe : recipes)
            {
            
               //if (BugFablesCook.getLocalFinalProducts(cooks))
               {
               
               
               
               }
            
            }
         
         }
      
      }
   
   
   
   
   
   
      for (BugFablesFoodItem foodItem : BugFablesFoodItem.values())
      {
      
      
      
      }
   
      return foodItems;
   
   }
   
   protected static Set<BugFablesFoodItem> getFinalProductsByCooks(Set<BugFablesCook> cooks)
   {
   
      Set<BugFablesFoodItem> foodItems = EnumSet.noneOf(BugFablesFoodItem.class);
   
      for (BugFablesCook cook : cooks)
      {
      
         foodItems.addAll(cook.getFinalProducts());
      
      }
   
      return foodItems;
   
   }
   
   /** Returns an alphabetically ordered list of the foodItems. */
   protected static List<String> getAlphabeticallyOrderedListOfFoodItems()
   {
   
      List<String> foodItems = new ArrayList<>();
      
      for (BugFablesFoodItem each : BugFablesFoodItem.values())
      {
      
         foodItems.add(each.name());
      
      }
   
      Collections.sort(foodItems, String.CASE_INSENSITIVE_ORDER);
      
      return foodItems;
   
   }
   
   /** Returns the foodItem that represents the result of this recipe. */
   public static BugFablesFoodItem getRespectiveFoodItem(BugFablesRecipeBook recipe)
   {
   
      return BugFablesFoodItem.valueOf(recipe.name());
      
   }

   /** Returns the foodItem that represents the result of this recipe. */
   public static BugFablesFoodItem getRespectiveFoodItem(String recipe)
   {
   
      return BugFablesFoodItem.valueOf(recipe);
      
   }

   /** Returns a set of BugFablesFoodItem that is not used in any recipe, but is also not the result of a recipe. */
   protected static Set<BugFablesFoodItem> getUnnecessaryItems()
   {
   
      Set<BugFablesFoodItem> foodItems = EnumSet.allOf(BugFablesFoodItem.class);
      
      for (BugFablesRecipeBook recipeBook : BugFablesRecipeBook.values())
      {
      
         foodItems.remove(BugFablesFoodItem.getRespectiveFoodItem(recipeBook));
         
         //for (BugFablesFoodItem foodItem : recipeBook.get)
      
      }
      
      return foodItems;
   
   }
   
}
