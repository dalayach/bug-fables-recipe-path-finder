package io.github.dalayach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.EnumSet;

/**
 * 
 * Enum containing all of the food items relevant for unlocking all entries in the Recipe Book.
 * 
 */
public enum BugFablesFoodItem
{

	// foodItem(recipeId, recipe, cook)
	  
	// no cooking necessary, just buy these
   AGARIC_SHROOM(0, null, null),
   APHID_DEW(0, null, null),
   APHID_EGG(0, null, null),
   BAG_OF_FLOUR(0, null, null),
   BURLY_BERRY(0, null, null),
   CLEAR_WATER(0, null, null),
   CRUNCHY_LEAF(0, null, null),
   DANGER_SHROOM(0, null, null),
   DANGER_SPUD(0, null, null),
   DARK_CHERRIES(0, null, null),
   FLAME_ROCK(0, null, null),
   HARD_SEED(0, null, null),
   HONEY_DROP(0, null, null),
   HUSTLE_BERRY(0, null, null),
   JAYDE_STEW(0, null, null),
   MAGIC_ICE(0, null, null),
   MAGIC_SEED(0, null, null),
   MEGA_RUSH(0, null, null),
   MITE_BURGER(0, null, null),
   MUSHROOM(0, null, null),
   MYSTERY_BERRY(0, null, null),
   NUMBNAIL_DART(0, null, null),
   POISON_DART(0, null, null),
   SHELL_OINTMENT(0, null, null),
   SHOCK_BERRY(0, null, null),
   SPICY_BERRY(0, null, null),
   SQUASH(0, null, null),
   SUCCULENT_BERRY(0, null, null),
   TANGY_BERRY(0, null, null),
   
   // 1 round of cooking if you already bought all the ingredients
   ABOMIHONEY(4, BugFablesRecipe.ABOMIHONEY, BugFablesCook.ALL),
   APHID_SHAKE(47, BugFablesRecipe.APHID_SHAKE, BugFablesCook.ALL),
   BAKED_YAM(20, BugFablesRecipe.BAKED_YAM, BugFablesCook.ALL),
   BERRY_JAM(42, BugFablesRecipe.BERRY_JAM, BugFablesCook.ALL),
   BERRY_JUICE(15, BugFablesRecipe.BERRY_JUICE, BugFablesCook.ALL),
   BERRY_SMOOTHIE(65, BugFablesRecipe.BERRY_SMOOTHIE, BugFablesCook.ALL),
   BURLY_BOMB(56, BugFablesRecipe.BURLY_BOMB, BugFablesCook.ALL),
   BURLY_CANDY(41, BugFablesRecipe.BURLY_CANDY, BugFablesCook.ALL),
   BURLY_CHIPS(22, BugFablesRecipe.BURLY_CHIPS, BugFablesCook.ALL),
   CHERRY_PIE(64, BugFablesRecipe.CHERRY_PIE, BugFablesCook.ALL),
   COLD_SALAD(25, BugFablesRecipe.COLD_SALAD, BugFablesCook.ALL),
   COOKED_DANGER(6, BugFablesRecipe.COOKED_DANGER, BugFablesCook.ALL),
   COOKED_SHROOM(5, BugFablesRecipe.COOKED_SHROOM, BugFablesCook.ALL),
   DANGER_DISH(23, BugFablesRecipe.DANGER_DISH, BugFablesCook.ALL),
   DROWSY_CAKE(38, BugFablesRecipe.DROWSY_CAKE, BugFablesCook.ALL),
   DRY_BREAD(28, BugFablesRecipe.DRY_BREAD, BugFablesCook.ALL),
   FRIED_EGG(9, BugFablesRecipe.FRIED_EGG, BugFablesCook.ALL),
   FROST_PIE(31, BugFablesRecipe.FROST_PIE, BugFablesCook.ALL),
   GLAZED_HONEY(3, BugFablesRecipe.GLAZED_HONEY, BugFablesCook.ALL),
   HEARTY_BREAKFAST(17, BugFablesRecipe.HEARTY_BREAKFAST, BugFablesCook.ALL),
   HONEY_ICE_CREAM(27, BugFablesRecipe.HONEY_ICE_CREAM, BugFablesCook.ALL),
   HONEY_LEAF(11, BugFablesRecipe.HONEY_LEAF, BugFablesCook.ALL),
   HONEY_PANCAKES(37, BugFablesRecipe.HONEY_PANCAKES, BugFablesCook.ALL),
   HOT_DRINK(43, BugFablesRecipe.HOT_DRINK, BugFablesCook.ALL),
   HUSTLE_CANDY(39, BugFablesRecipe.HUSTLE_CANDY, BugFablesCook.ALL),
   ICE_CREAM(26, BugFablesRecipe.ICE_CREAM, BugFablesCook.ALL),
   LEAF_CROISSANT(36, BugFablesRecipe.LEAF_CROISSANT, BugFablesCook.ALL),
   LEAF_OMELET(10, BugFablesRecipe.LEAF_OMELET, BugFablesCook.ALL),
   LEAF_SALAD(2, BugFablesRecipe.LEAF_SALAD, BugFablesCook.ALL),
   MIRACLE_SHAKE(66, BugFablesRecipe.MIRACLE_SHAKE, BugFablesCook.ALL),
   MISTAKE(1, BugFablesRecipe.MISTAKE, BugFablesCook.ALL),
   MUSHROOM_GUMMIES(34, BugFablesRecipe.MUSHROOM_GUMMIES, BugFablesCook.ALL),
   MUSHROOM_SALAD(18, BugFablesRecipe.MUSHROOM_SALAD, BugFablesCook.ALL),
   MUSHROOM_SKEWER(16, BugFablesRecipe.MUSHROOM_SKEWER, BugFablesCook.ALL),
   NUTTY_CAKE(29, BugFablesRecipe.NUTTY_CAKE, BugFablesCook.ALL),
   PLAIN_TEA(44, BugFablesRecipe.PLAIN_TEA, BugFablesCook.ALL),
   PLUMPLING_PIE(51, BugFablesRecipe.PLUMPLING_PIE, BugFablesCook.ALL),
   POISON_CAKE(30, BugFablesRecipe.POISON_CAKE, BugFablesCook.ALL),
   ROASTED_BERRIES(12, BugFablesRecipe.ROASTED_BERRIES, BugFablesCook.ALL),
   SHAVED_ICE(24, BugFablesRecipe.SHAVED_ICE, BugFablesCook.ALL),
   SHOCK_CANDY(33, BugFablesRecipe.SHOCK_CANDY, BugFablesCook.ALL),
   SPICY_BOMB(55, BugFablesRecipe.SPICY_BOMB, BugFablesCook.ALL),
   SPICY_CANDY(40, BugFablesRecipe.SPICY_CANDY, BugFablesCook.ALL),
   SPICY_FRIES(21, BugFablesRecipe.SPICY_FRIES, BugFablesCook.ALL),
   SQUASH_CANDY(49, BugFablesRecipe.SQUASH_CANDY, BugFablesCook.ALL),
   SQUASH_PUREE(48, BugFablesRecipe.SQUASH_PUREE, BugFablesCook.ALL),
   SQUASH_TART(50, BugFablesRecipe.SQUASH_TART, BugFablesCook.ALL),
   SUCCULENT_COOKIES(14, BugFablesRecipe.SUCCULENT_COOKIES, BugFablesCook.ALL),
   SUCCULENT_PLATTER(13, BugFablesRecipe.SUCCULENT_PLATTER, BugFablesCook.FRY),
   SWEET_DANGER(8, BugFablesRecipe.SWEET_DANGER, BugFablesCook.ALL),
   SWEET_DEW(19, BugFablesRecipe.SWEET_DEW, BugFablesCook.ALL),
   SWEET_PUDDING(35, BugFablesRecipe.SWEET_PUDDING, BugFablesCook.ALL),
   SWEET_SHROOM(7, BugFablesRecipe.SWEET_SHROOM, BugFablesCook.ALL),
   TANGY_CARPACCIO(67, BugFablesRecipe.TANGY_CARPACCIO, BugFablesCook.KUT),
   TANGY_JAM(52, BugFablesRecipe.TANGY_JAM, BugFablesCook.ALL),
   TANGY_JUICE(53, BugFablesRecipe.TANGY_JUICE, BugFablesCook.ALL),
   TANGY_PIE(54, BugFablesRecipe.TANGY_PIE, BugFablesCook.ALL),
   YAM_BREAD(32, BugFablesRecipe.YAM_BREAD, BugFablesCook.FRY),
   
	// 2 rounds of cooking
   BIG_MISTAKE(70, BugFablesRecipe.BIG_MISTAKE, BugFablesCook.ALL),
   BURLY_TEA(46, BugFablesRecipe.BURLY_TEA, BugFablesCook.ALL),
   CHERRY_BOMBS(63, BugFablesRecipe.CHERRY_BOMBS, BugFablesCook.ALL),
   CRISBEE_DONUT(68, BugFablesRecipe.CRISBEE_DONUT, BugFablesCook.CRISBEE),
   FROST_BOMB(60, BugFablesRecipe.FROST_BOMB, BugFablesCook.ALL),
   NUMB_BOMB(59, BugFablesRecipe.NUMB_BOMB, BugFablesCook.ALL),
   POISON_BOMB(57, BugFablesRecipe.POISON_BOMB, BugFablesCook.ALL),
   SLEEP_BOMB(58, BugFablesRecipe.SLEEP_BOMB, BugFablesCook.ALL),
   SPICY_TEA(45, BugFablesRecipe.SPICY_TEA, BugFablesCook.ALL),
   
   // 3 rounds of cooking
   ABOMBINATION(62, BugFablesRecipe.ABOMBINATION, BugFablesCook.FRY),
   CLEAR_BOMB(61, BugFablesRecipe.CLEAR_BOMB, BugFablesCook.ALL),
   QUEENS_DINNER(69, BugFablesRecipe.QUEENS_DINNER, BugFablesCook.FRY)
   ;
   
	/** Contains the recipe id for the recipe. 0 represents that this recipe has no id. */
   private int recipeId;
	/** Contains the recipe. Can be null. */
   private BugFablesRecipe recipe;
	/** Contains the cook who can make this meal. Can be null. */
   private BugFablesCook cook;
   
   /** Constructor. */
   BugFablesFoodItem(int recipeId, BugFablesRecipe recipe, BugFablesCook cook)
   {
   
      this.recipeId = recipeId;
      this.recipe = recipe;
      this.cook = cook;
   
   }
   
   /** Fetches the recipeId for this foodItem. */
   public int getRecipeId()
   {
   
      return this.recipeId;
   
   }
   
   /** Returns the recipe for this foodItem. */
   public BugFablesRecipe getRecipe()
   {
   
      return this.recipe;
   
   }
   
   /** Returns the cook for this foodItem. */
   public BugFablesCook getCook()
   {
   
      return this.cook;
   
   }
   
   /** Returns a Set of all purchasable foodItems found at the given locations. */
   protected static Set<BugFablesFoodItem> findPurchasableFoodItemsByLocations(Set<BugFablesLocation> locations)
   {
   
      Set<BugFablesFoodItem> foodItems = EnumSet.noneOf(BugFablesFoodItem.class);
   
      if (locations != null)
      {
      
         for (BugFablesLocation location : locations)
         {
         
            foodItems.addAll(BugFablesFoodItem.findPurchasableFoodItemsByLocation(location));
         
         }
      
      }
   
      return foodItems;
   
   }
	
   /** Returns a Set of all purchasable foodItems found at the given location. */
   protected static Set<BugFablesFoodItem> findPurchasableFoodItemsByLocation(BugFablesLocation location)
   {
   
      Set<BugFablesFoodItem> totalSetOfFoodItems = EnumSet.noneOf(BugFablesFoodItem.class);
      
      for (BugFablesShop shop : BugFablesShop.findShopsByLocation(location))
      {
      
         totalSetOfFoodItems.addAll(shop.getPurchasableItems());
      
      }
   
      return totalSetOfFoodItems;	
   
   }
   
   /** Returns a Set of foodItems that can be created by the given cook. */
   protected static Set<BugFablesFoodItem> findFoodItemsByCook(BugFablesCook cook)
   {
   
      Set<BugFablesFoodItem> foodItems = EnumSet.noneOf(BugFablesFoodItem.class);
      
      if (cook != null)
      {
      
         for (BugFablesFoodItem foodItem : BugFablesFoodItem.values())
         {
         
            if (foodItem.getCook() == cook || foodItem.getCook() == BugFablesCook.ALL)
            {
            
               foodItems.add(foodItem);
            
            }
         
         }
      
      }
   
      return foodItems;
   
   }
   
   /** Returns a Set of foodItems purchasable at the given shops. */
   protected static Set<BugFablesFoodItem> findPurchasableItemsByShops(Set<BugFablesShop> shops)
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
   
   /** Returns the foodItem that a recipe makes. */
   protected static BugFablesFoodItem findFoodItemByRecipe(BugFablesRecipe recipe)
   {
   
      if (recipe != null)
      {
      
         for (BugFablesFoodItem foodItem : BugFablesFoodItem.values())
         {
         	//Remember, ordinal starts with 0, so +1 to make it match.
            if (foodItem.getRecipeId() == recipe.ordinal() + 1)
            {
            
               return foodItem;
            
            }
         
         }
      
      }
   
      return null;
   
   }
   
   /** Fetches the highest recipeId. */
   protected static int getMaxRecipeId()
   {
   
      return BugFablesFoodItem.values().length - 1;
   
   }
   
   /** Returns a Set of foodItems that can be created through a BugFablesRecipe. */
   protected static Set<BugFablesFoodItem> getAllFoodItemsContainingRecipes()
   {
   
      Set<BugFablesFoodItem> foodItems = EnumSet.noneOf(BugFablesFoodItem.class);
   
      for (BugFablesFoodItem foodItem : BugFablesFoodItem.values())
      {
      
         if (foodItem.getRecipeId() != 0)
         {
         
            foodItems.add(foodItem);
         
         }
      
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
   
   /** Returns a set of BugFablesFoodItem that is not used in any recipe, but is also not the result of a recipe. */
   protected static Set<BugFablesFoodItem> getUnnecessaryItems()
   {
   
      Set<BugFablesFoodItem> foodItems = EnumSet.allOf(BugFablesFoodItem.class);
      
      for (BugFablesRecipe recipes : BugFablesRecipe.values())
      {
      
         foodItems.remove(recipes.getRespectiveFoodItem());
      
         for (List<BugFablesFoodItem> recipe : recipes.getPossibleRecipes())
         {
         
            foodItems.removeAll(recipe);
         
         }
      
      }
      
      return foodItems;
   
   }
   
}
