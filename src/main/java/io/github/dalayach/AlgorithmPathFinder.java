package io.github.dalayach;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
   public static void findBestPathway(Set<BugFablesRecipe> recipeList)
   {
   
      Set<Set<List<BugFablesFoodItem>>> allPossibleCombinations = AlgorithmPathFinder.fetchAllPossibleCombinations(recipeList);
        
      System.out.println(allPossibleCombinations.size());
     
   }
   
   /** Method that fetches all possible combinations. Private because this method is too complex for the outside world. */
   private static Set<Set<List<BugFablesFoodItem>>> fetchAllPossibleCombinations(Set<BugFablesRecipe> recipeList)
   {
   
      Set<Set<List<BugFablesFoodItem>>> finalList = new HashSet<Set<List<BugFablesFoodItem>>>();
      AlgorithmPathFinder.fetchAllPossibleCombinations(new ArrayList<>(recipeList), 0, new HashSet<List<BugFablesFoodItem>>(), finalList);
      
      return finalList;
   
   }

   /** Recursive method that goes through Set<BugFablesRecipe> and uses it to fetch all possible combinations. */
   private static void fetchAllPossibleCombinations(List<BugFablesRecipe> recipeList, int index,
      Set<List<BugFablesFoodItem>> gatheredRecipes, Set<Set<List<BugFablesFoodItem>>> allPossibleCombinations)
   {
   
      if (index < recipeList.size())
      {
      
         for (List<BugFablesFoodItem> foodItems : recipeList.get(index).getPossibleRecipes())
         {
         
            Set<List<BugFablesFoodItem>> newGatheredRecipes = new HashSet<>();
            newGatheredRecipes.addAll(gatheredRecipes);
            newGatheredRecipes.add(foodItems);
         
            AlgorithmPathFinder.fetchAllPossibleCombinations(
               recipeList,
               (index + 1),
               newGatheredRecipes,
               allPossibleCombinations);
         
         }
      
      } else {
      
         allPossibleCombinations.add(gatheredRecipes);
      
      }
   
   }
   
   /** Let's try something else. */
   public void attempt2()
   {
   
      /**
      //let's say we are given an item.
      BugFablesFoodItem foodItem = BugFablesFoodItem.HONEY_DROP;
      
      //Ok, now let's put that item aside and get a location
      BugFablesLocation location = BugFablesLocation.ANT_CITY;
      */
      //Alright, let's see if we can put these together and get something.
      
      //For example, what if we were given a foodItem and a location, and asked what the most efficient way (or ways) were to fetch that foodItem?
      
      //The problem with this is that there are multiple ways of fetching a foodItem. Those ways are
      // - Purchase from a store
      // - Cook it yourself using items that you have cooked or purchased from a store, depending on the recipe and the foodItem itself
      
      //Ideally, purchasing from a store is always preferred over cooking it.
      
      //That said, there are times where purchasing from a store can get rather long winded, especially if only one store has the item you are looking.
      
      //For example, assume that you can purchase the ingredients and cook the item at the location you are currently at, vs traveling to another
      //location to buy ingredients from a store. Which would take longer?
      
      //Well, let's see.
      
      //We need to separate the items that can be cooked, and the items that cannot be cooked from each other, so that we do not include unnecessary end states
      //in our calculations. Thankfully, BugFablesFoodItem has already done the work for us.
      
      //After some work in Notepad++, I now have 2 lists
      // - list of items that can be purchased at shops
      // - list of items that can be cooked
      
      //These 2 lists are useful because, there are some foodItems that require more than 1 round of cooking in order to create. This is important because,
      //for recipes that require 2 or more rounds of cooking, you may run into the question of "Should I cook the ingredient necessary for this recipe? Or
      //should I buy it?"
      
      //One would think that buying would always be the faster option, but that's not always the case. For an example, if I want to make a CRISBEE_DONUT,
      //I need a GLAZED_HONEY and a BAG_OF_FLOUR. This is the only recipe for creating a CRISBEE_DONUT. Crisbee (the only cook who can make this item) is
      //in Defiant Root, while the GLAZED_HONEY can only be purchased from the Bee Hive. Now, for the sake of argument, let's ignore the fact that Crisbee
      //is the only one who can cook this item. Furthermore, let's ignore the fact that the Bee Hive is the farthest "location" to reach from the tunnel
      //systems. Let's just assume that Crisbee (located in Defiant Root) is trying to make a CRISBEE_DONUT, but the only shop that sells the item
      //GLAZED_HONEY is in the DEAD_LANDS. That would require me to go to the Dead Lands to get the GLAZED_HONEY, then Defiant Root to get the BAG_OF_FLOUR,
      //then make Crisbee cook it for me. What if I just went to Crisbee's shop, purchased a HONEY_DROP (the single ingredient required to make a
      //GLAZED_HONEY), cooked a GLAZED_HONEY, purchased a BAG_OF_FLOUR, then cooked a CRISBEE_DONUT? That would be much faster than going out to purchase
      //foodItems.
      
      //PLEASE NOTE, this example brought up 2 rather valuable optimizations
      // - If you're cooking to create a foodItem that you can use as an ingredient to create another foodItem, then there is the possibility that gathering
      //   and cooking ingredients to create a foodItem that will be used as an ingredient to create another foodItem may take up inventory space unnecessarily,
      //   thus resulting in a loss of time that would forgo any benefit you would get from cooking the items rather than purchasing. There needs to be a
      //   threshold which decides where going any further than this means it would be wiser to purchase rather than cook. Perhaps if all the purchasable ingredients exist at the
      //   same location? Or maybe, a cook is at one of the shops that you need to buy the ingredients from? There are several different edge cases to consider
      //
      // - When cooking a recipe with 2 ingredients, which ingredient should you gather first? Maybe you should let the second ingredient you pick be one that
      //   is located in the same location as a shop? Or maybe you should choose an ingredient that is the same location as a cook? Well, one would think that
      //   when gathering the batch of ingredients, you would want to stop at a shop, to increase your chances of landing on a shop that has the next item you
      //   need. But what about when you are cooking ingredients? Yes, you have to buy those sub-ingredients, but like mentioned before, just holding 2
      //   sub-ingredients will take up more space unless you cook it into a main ingredient some point before your inventory is full. So that means that
      //   sometimes, it makes sense to cook along the way, and thus, it is good to stop at a cook along the way, and maybe prioritize them. But there's a good
      //   chance that, as you are stopping by multiple shops, that at least one of them will have a cook nearby. So then by that logic, it would make sense to
      //   prioritize shops, as one of them is bound to have a cook. But again, where is the threshold? Where do you draw the line when prioritizing order? On
      //   top of it all, we really have to watch out for optimization. I know the new thought process is not to brute force things, but to instead map out
      //   the optimal way to accomplish a set of goals from a given location, then build it upon run, and let the program go from there. And while that sounds
      //   even more optimal, that may not be enough. Remember, the acceptable threshold that the user should be allowed to wait is roughly 30-45 seconds.
      //   Anything more than a minute is asking way too much of the user, and might as well be overkill. At that point, it would be better off if you just
      //   ran the calculation at home, let it run its course, come up with the most optimal solutions for ALL combinations, then post them. THAT, could easily
      //   be done using nothing but HTML and CSS, which would make the front end portion of this MUCH easier.
      
      //Looking at this, we can naturally assume that, if a foodItem cannot be purchased in a store, then it is entirely pointless to try and search for
      //ingredients to cook this with. More importantly, this can optimize the process because - if a foodItem is not contained within the
      //cookable/non-cookable list, then we can simply choose the correct branch to follow down.
      
      //This is valuable, as we can simply keep this list in memory, as opposed to recalculating it each time we use it. And since it can tell us what path
      //to go down, we do not have to concern ourselves with trying to rerun the same calculations over and over again. Simply ask if the list contains the 
      //foodItem, then act accordingly.
      
      
      
      //But anyways, let's start putting some of this thought process into place. Let's start with the basic one - if I am in location X and want to create
      //foodItem Y, then this is the best way.
      
      //However, that doesn't work. What if instead, we said - if I am in location X and want to create foodItem Y, here are the possible ways?
      //Let's try that first.
      
      //Here is the item we want to create
      BugFablesFoodItem foodItem = BugFablesFoodItem.ABOMIHONEY;
      
      //Ok, now let's put that item aside and get a location
      BugFablesLocation location = BugFablesLocation.ANT_CITY;
      
      //Now, what are the possible ways that we could create this foodItem?
      //Well, we can pull that info from BugFablesRecipe.
      BugFablesRecipe recipe = BugFablesRecipe.getRespectiveRecipe(foodItem);
      
      //But this is just the recipes, not the VIABLE ways to create this item.
      //And furthermore, would it not be to our benefit to order these tactics by most useful?
      
      //But then that sort raises the question - shouldn't we hold the concept of a tactic inside an object? I REALLY don't want to, but it sounds like a good
      //idea
      
      //For right now, let's just focus on getting the tactics
      
      //Ok, so what is a tactic?
      
      //A tactic is telling us what the possible ways to fetch/create this item.
      //So, we could store the shop that is used to buy the foodItem.
      
      //But then, there is also the tactic of creating the foodItem, right? How will we store that?
      
      //For right now, let's just focus on purchasing the ingredients to the recipe and nothing else.
      
      //So, that leads us to the question - what should we return to the user?
      //Well, it would be nice to be able to return a List of shops. And we would want to use list, such that we can maintain the order.
      
      //But that would get pretty ugly. How do we refer to a specific recipe? With the index of the recipe? No, BugFablesRecipe in its current condition just
      //CANNOT WORK. Let's change things into a BugFablesRecipe, and a BugFablesRecipeBook.
      
   }
   
}
