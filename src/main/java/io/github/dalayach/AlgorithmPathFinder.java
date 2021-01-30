package io.github.dalayach;

import java.util.EnumSet;
import java.util.Set;

/**
 * 
 * An algorithm that cycles through all possible pathways that can be taken, and chooses the best one.
 *
 */
public class AlgorithmPathFinder
{

   /** I do not want this class to be instantiated. */
   private AlgorithmPathFinder() { }
   
   /** We need a method that can give us a simple Map-like output with a location and Actions to do there. */
   public static void findBestPathway(Set<BugFablesRecipeBook> recipeBookList)
   {
   
      attempt1();
   
   }
   
   /** Let's try something else. */
   public static String attempt1()
   {
   
      BugFablesFoodItem foodItem = BugFablesFoodItem.ABOMIHONEY;
      
      BugFablesLocation location = BugFablesLocation.ANT_CITY;
      
      BugFablesRecipeBook recipeBook = BugFablesRecipeBook.getRespectiveRecipeBook(foodItem);
      
      for (BugFablesRecipe recipe : recipeBook.getRecipes())
      {
      
         if (!recipe.getTier1Locations().isEmpty())
         {
         
            System.out.println(recipe + "\t\tTIER 1\t\t" + recipe.getTier1Locations());
         //Set<BugFablesShop> shops = BugFablesShop.findShopsContainingBothIngredientsOfARecipe(recipe);
         
         }
         
         else
         {
         
            System.out.println(recipe + "\t\tTIER 2\t\t" + recipe.getTier2Locations());
         
         }
      
      }
      
      return BugFablesRecipe.RECIPE_0001.toString();
      
   }
   
   /**
    * 
    * Returns a Set of BugFablesLocations where each location has the following attributes.
    * 
    * <ul>
    *   <li>No cooking is required to create the given foodItems. They can be purchased as-is from stores at this location.</li>  
    *   <li>This location contains ALL given foodItems. You may need to walk into multiple stores at this location.</li>  
    * </ul>
    * 
    */
   protected static Set<BugFablesLocation> findTier1Locations(Set<BugFablesFoodItem> foodItems)
   {
   
      Set<BugFablesLocation> locations = EnumSet.noneOf(BugFablesLocation.class);
   
      if (foodItems != null && !foodItems.isEmpty())
      {
      
         for (BugFablesLocation location : BugFablesLocation.values())
         {
         
            if (BugFablesFoodItem.getPurchasableFoodItemsByLocation(location).containsAll(foodItems))
            {
            
               locations.add(location);
               continue;
            
            }
            
         }
      
      }
   
      return locations;
   
   }
   
   /**
    * 
    * Returns a Set of BugFablesLocations where each location has the following attributes.
    * 
    * <ul>
    *   <li>Cooking is required to create some/all of the given foodItems.</li>  
    *   <li>This location contains ALL given foodItems & sub-ingredients. You may need to go to multiple stores at this location.</li>
    * </ul>
    * 
    */
   public static Set<BugFablesLocation> findTier2Locations(Set<BugFablesFoodItem> foodItems)
   {
   
      Set<BugFablesLocation> locations = EnumSet.noneOf(BugFablesLocation.class);
   
      if (foodItems != null && !foodItems.isEmpty())
      {
      
         for (BugFablesLocation location : BugFablesLocation.values())
         {
         
         //if ()
         
         }
         
      }   
   
      return locations;
   
   }

}
