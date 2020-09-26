package io.github.dalayach;

import org.junit.Assert;
import org.junit.Test;

/** Unit test for BugFablesRecipe. */
public class BugFablesRecipeTest {

   /** A test that always fails. */
   @Test
   public void testIfOrdinalMatchesBugFablesFoodItem() {
   
      for (BugFablesRecipe recipe : BugFablesRecipe.values())
      {
      
         Assert.assertEquals(BugFablesFoodItem.findFoodItemByRecipe(recipe), BugFablesFoodItem.valueOf(recipe.name()));
      
      }
   
   }
}
