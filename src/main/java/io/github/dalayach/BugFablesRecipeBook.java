package io.github.dalayach;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Set;

public enum BugFablesRecipeBook
{

   //DO NOT CARELESSLY REORDER!
   
   //The ordinal of the enum directly corresponds to the recipeId. Basically, the first enum will have a recipeId of 1,
   //and the second enum will have a recipeId of 2. Therefore, if you reorder the enums, you are changing the recipeIds!
   //Do it if it is necessary, that's not a problem, but just be sharply aware that the order affects the results!
   
   //recipeBook
   MISTAKE,
   LEAF_SALAD,
   GLAZED_HONEY,
   ABOMIHONEY,
   COOKED_SHROOM,
   COOKED_DANGER,
   SWEET_SHROOM,
   SWEET_DANGER,
   FRIED_EGG,
   LEAF_OMELET,
   HONEY_LEAF,
   ROASTED_BERRIES,
   SUCCULENT_PLATTER,
   SUCCULENT_COOKIES,
   BERRY_JUICE,
   MUSHROOM_SKEWER,
   HEARTY_BREAKFAST,
   MUSHROOM_SALAD,
   SWEET_DEW,
   BAKED_YAM,
   SPICY_FRIES,
   BURLY_CHIPS,
   DANGER_DISH,
   SHAVED_ICE,
   COLD_SALAD,
   ICE_CREAM,
   HONEY_ICE_CREAM,
   DRY_BREAD,
   NUTTY_CAKE,
   POISON_CAKE,
   FROST_PIE,
   YAM_BREAD,
   SHOCK_CANDY,
   MUSHROOM_GUMMIES,
   SWEET_PUDDING,
   LEAF_CROISSANT,
   HONEY_PANCAKES,
   DROWSY_CAKE,
   HUSTLE_CANDY,
   SPICY_CANDY,
   BURLY_CANDY,
   BERRY_JAM,
   HOT_DRINK,
   PLAIN_TEA,
   SPICY_TEA,
   BURLY_TEA,
   APHID_SHAKE,
   SQUASH_PUREE,
   SQUASH_CANDY,
   SQUASH_TART,
   PLUMPLING_PIE,
   TANGY_JAM,
   TANGY_JUICE,
   TANGY_PIE,
   SPICY_BOMB,
   BURLY_BOMB,
   POISON_BOMB,
   SLEEP_BOMB,
   NUMB_BOMB,
   FROST_BOMB,
   CLEAR_BOMB,
   ABOMBINATION,
   CHERRY_BOMBS,
   CHERRY_PIE,
   BERRY_SMOOTHIE,
   MIRACLE_SHAKE,
   TANGY_CARPACCIO,
   CRISBEE_DONUT,
   QUEENS_DINNER,
   BIG_MISTAKE,
   
   ;
   
	/** Contains the id number for this recipeBook. */
   private final int recipeBookId;
   
   /** Contains the finalProduct created by the recipeBook. */
   private final BugFablesFoodItem finalProduct;
   
   /** Contains the Cook that can cook the recipes in the recipeBook. ALL represents that they are all capable of cooking it. */
   private final Set<BugFablesCook> cooks;
   
   /** Contains all the recipes within this recipeBook. */
   private final Set<BugFablesRecipe> recipes;
   
   BugFablesRecipeBook()
   {
   
      this.recipeBookId = this.ordinal() + 1; //ordinals start at 0, so +1 is necessary in order to start at 1.
      
      this.finalProduct = BugFablesFoodItem.getRespectiveFoodItem(this.name());
      
      this.cooks =
         Collections.unmodifiableSet(
            BugFablesCook.fetchCooksContainingAFinalProduct(this.finalProduct));
               
      this.recipes =
         Collections.unmodifiableSet(
            BugFablesRecipe.getAllRecipesForFinalProduct(this.finalProduct));
   
   }
   
   public int getRecipeBookId()
   {
   
      return this.recipeBookId;
   
   }
   
   public BugFablesFoodItem getFinalProduct()
   {
   
      return this.finalProduct;
   
   }
   
   public Set<BugFablesCook> getCooks()
   {
   
      return this.cooks;
   
   }
   
   public Set<BugFablesRecipe> getRecipes()
   {
   
      return this.recipes;
   
   }
   
   public static BugFablesRecipeBook getRespectiveRecipeBook(BugFablesFoodItem foodItem)
   {
   
      return BugFablesRecipeBook.valueOf(foodItem.name());
   
   }
   
   /** Returns an alphabetically ordered array of recipeBooks. */
   public static BugFablesRecipeBook[] listOfOrderedRecipeBooks()
   {
   
      BugFablesRecipeBook[] recipeBooks = BugFablesRecipeBook.values();
      
      Arrays.sort(
         recipeBooks, 
         new Comparator<BugFablesRecipeBook>() 
         {
         
            /** Orders by alphabetical order. */
            public int compare(BugFablesRecipeBook o1, BugFablesRecipeBook o2)
            {
            
               return o1.name().compareTo(o2.name());
            
            }
         
         });
         
      return recipeBooks;
   
   }
   
}
