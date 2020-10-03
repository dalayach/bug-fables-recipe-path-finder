package io.github.dalayach;

import java.util.EnumMap;
import java.util.Map;

public class BugFablesPersonalInventory
{

   private final int maxNumberOfFreeSlots;

   private Map<BugFablesFoodItem, Integer> foodItems = new EnumMap<>(BugFablesFoodItem.class);
   
   private BugFablesPersonalInventory() { maxNumberOfFreeSlots = 0; /** Do NOT instantiate without a GIVEN maxNumberOfFreeSlots (there can be no default). */ }
   
   public BugFablesPersonalInventory(int maxNumberOfFreeSlots)
   {
   
      this.maxNumberOfFreeSlots = maxNumberOfFreeSlots;
   
   }
   
   public BugFablesPersonalInventory(Map<BugFablesFoodItem, Integer> map, int maxNumberOfFreeSlots)
   {
   
      this.maxNumberOfFreeSlots = maxNumberOfFreeSlots;
   
      for (Map.Entry<BugFablesFoodItem, Integer> pair : map.entrySet())
      {
      
         if (pair.getValue() != null && pair.getValue() != 0)
         {
         
            this.foodItems.put(pair.getKey(), pair.getValue());
         
         }
      
      }
   
   }
   
   public int getNumOfFoodItemsInBackpack()
   {
   
      int numOfFoodItems = 0;
   
      if (this.foodItems != null && !this.foodItems.isEmpty())
      {
      
         for (Integer count : this.foodItems.values())
         {
         
            numOfFoodItems += count;
         
         }
      
      }
   
      return numOfFoodItems;
   
   }

   public void addFoodItem(BugFablesFoodItem foodItem) throws OutOfBoundsException
   {
   
      this.addFoodItem(foodItem, new Integer(1));
   
   }
   
   public void addFoodItem(BugFablesFoodItem foodItem, Integer addend) throws OutOfBoundsException
   {
   
      if (!this.foodItems.containsKey(foodItem))
      {
      
         this.foodItems.put(foodItem, new Integer(addend));
      
      } else if (this.foodItems.containsKey(foodItem) && this.getNumOfFoodItemsInBackpack() + addend <= this.maxNumberOfFreeSlots)
      {
      
         this.foodItems.put(foodItem, new Integer(this.foodItems.get(foodItem).intValue() + addend.intValue()));
      
      } else
      {
      
         throw new OutOfBoundsException("maxNumberOfFreeSlots = " + this.maxNumberOfFreeSlots + " addend = " + addend);
      
      }
   
   }

   public void removeFoodItem(BugFablesFoodItem foodItem) throws OutOfBoundsException
   {
   
      if (this.foodItems.containsKey(foodItem))
      {
      
         this.removeFoodItem(foodItem, new Integer(1));
      
      }
   
   }

   public void removeFoodItem(BugFablesFoodItem foodItem, Integer minuend) throws OutOfBoundsException
   {
   
      if (this.foodItems.containsKey(foodItem) && this.foodItems.get(foodItem).compareTo(minuend) > 0)
      {
      
         this.foodItems.put(foodItem, new Integer(this.foodItems.get(foodItem).intValue() - minuend.intValue()));
      
      } else if (this.foodItems.containsKey(foodItem) && this.foodItems.get(foodItem).compareTo(minuend) == 0)
      {
      
         this.foodItems.remove(foodItem);
      
      } else {
      
         throw new OutOfBoundsException("maxNumberOfFreeSlots = " + this.maxNumberOfFreeSlots + " minuend = " + minuend);
      
      }
      
   }

}