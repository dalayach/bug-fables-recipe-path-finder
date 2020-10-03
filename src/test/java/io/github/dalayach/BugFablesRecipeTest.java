package io.github.dalayach;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/** Unit test for BugFablesRecipe. */
public class BugFablesRecipeTest {

   /** A test to make sure the names for the foodItems and recipes match. */
   @Test
   public void testIfFoodItemNameMatchesRecipeName() {
   
      for (BugFablesRecipe recipe : BugFablesRecipe.values())
      {
      
         Assert.assertEquals(BugFablesFoodItem.findFoodItemByRecipe(recipe), BugFablesFoodItem.valueOf(recipe.name()));
      
      }
   
   }
   
}
