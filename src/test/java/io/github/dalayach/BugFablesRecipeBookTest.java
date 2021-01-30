package io.github.dalayach;

import java.util.EnumSet;
import org.junit.Assert;
import org.junit.Test;


public class BugFablesRecipeBookTest
{

   @Test
   public void testNoDuplicateRecipeIds()
   {
   
      for (BugFablesRecipeBook recipeBook1 : EnumSet.allOf(BugFablesRecipeBook.class))
      {
      
         for (BugFablesRecipeBook recipeBook2 : EnumSet.allOf(BugFablesRecipeBook.class))
         {
         
            if (recipeBook1 != recipeBook2 && recipeBook1.getRecipeBookId() == recipeBook2.getRecipeBookId())
            {
            
               Assert.fail("No duplicate recipeIds allowed!"
                  + "\n" + recipeBook1.getRecipeBookId() + "\trecipeBook1 = " + recipeBook1.name() 
                  + "\n" + recipeBook2.getRecipeBookId() + "\trecipeBook2 = " + recipeBook2.name());
            
            }
         
         }
      
      }
   
   }
   
}
