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
   public void test_FIX_THIS_NAME() {
   
      for (BugFablesRecipeBook recipeBook : BugFablesRecipeBook.values())
      {
      
         Assert.assertEquals(BugFablesFoodItem.getRespectiveFoodItem(recipeBook), BugFablesFoodItem.valueOf(recipeBook.name()));
      
      }
   
   }
   
}
