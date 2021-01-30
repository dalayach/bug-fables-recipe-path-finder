package io.github.dalayach;

import java.lang.UnsupportedOperationException;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * A Collection that tells you how many times a specific value of an enum is found in the Collection.
 * 
 * This a memory-efficient alternative to using a List. Not to mention, much faster.
 * 
 */
public class EnumBag<T extends Enum<T>> implements Collection<T>
{

   /** The inner implementation of this Bag will be a Map. */
   private final Map<T, Integer> bag;
   
   private final Class<T> clazz;

   /** Constructor */
   public EnumBag(Class<T> clazz)
   {
   
      //I choose EnumMap as my implementation, as it is even faster than HashMap
      this.bag = new EnumMap<T, Integer>(clazz);
      this.clazz = clazz;
   
   }
   
   /**
    * 
    * Adds a single element to the Bag.
    * 
    * Returns true if the Bag has been successfully modified. 
    * 
    */
   public boolean add(T element)
   {
   
      return this.add(element, 1);
   
   }
   
   /**
    * 
    * Adds a specified amount of an element to the Bag.
    * 
    * The element is not allowed to be null.
    * The amount must be greater than zero.
    * 
    * Returns true if the Bag has been successfully modified.
    * 
    */
   public boolean add(T element, int amount)
   {
   
      if (amount > 0 && element != null)
      {
      
         //fetch the originalAmount within the bag
         Integer originalAmount = this.bag.get(element);
      
         //if we get null, turn it into a 0 and store into originalAmount. Otherwise, store what we get into originalAmount
         originalAmount = (originalAmount == null ? 0 : originalAmount);
      
         //add amount to originalAmount and put it back in the bag.
         this.bag.put(element, originalAmount + amount);
         
         return true;
      
      /**
       *
       * The purpose of all of this is to simulate a bag. A bag simply has a set of objects, and the count of each object.
       * This is an efficient data type because it allows us to store large numbers of completely identical objects (for
       * example, enums) into a collection while remaining very conservative with memory.
       *
       */
      
      }
      
      else
      {
      
         return false;
      
      }
   
   }
   
   /**
    * 
    * Iterates through the collection, and adds each element from the Collection to this bag.
    * 
    * The Collection must not be null.
    * The Collection must not be empty.
    * 
    * Returns true if the Bag has been successfully modified.
    * 
    */
   public boolean addAll(Collection<? extends T> elements)
   {
   
      boolean result = true;
      boolean addedAtLeastOne = false;
   
      if (elements != null)
      {
      
         for (T element : elements)
         {
         
            result = result && this.add(element);
            addedAtLeastOne = true;
         
         }
         
      }
      
      return result && addedAtLeastOne;
      
   }
   
   /** Clears out the Bag, making it empty. */
   public void clear()
   {
   
      this.bag.clear();
   
   }
   
   /**
    * 
    * Returns true if the specified element is contained within the Bag.
    * 
    */
   public boolean contains(Object obj)
   {
   // 
      // if (obj.getClass().isInstance(this.clazz.getClass()))
      // {
         // return this.bag.keySet().contains(element);
      // }
      // 
      // else
      // {
      // 
      throw new UnsupportedOperationException("This EnumBag has a key type of " + this.clazz.getClass() 
            + ", but you are attempting to check if it contains an object of type " + obj.getClass());
      // 
      // }
   // 
   }
   
   /**
    * 
    * Returns true if the Bag contains all elements in the specified Collection.
    * 
    */
   public boolean containsAll(Collection<? extends Object> elements)
   {
    
      //TODO - fix this
      return this.bag.keySet().containsAll(elements);
    
   }
   
   /**
    * 
    * Typical equals method.
    * 
    */
   public boolean equals(Object o)
   {
    
      return this.bag.equals(o);
    
   }

   /**
    * 
    * Typical hashCode method.
    * 
    */
   public int hashCode()
   {
    
      return this.bag.hashCode();
    
   }
         
   /**
    * 
    * Returns true if this Bag is empty.
    * 
    */
   public boolean isEmpty()
   {
    
      return this.bag.isEmpty();
    
   }
   
   /**
    * 
    * Unsupported operation. This class uses a Map as it's underlying implementation, and you cannot iterate through a Map.
    * 
    * If iteration is necessary, call keySet(), or entrySet(), or valueSet(). Iterate through one of those.
    * 
    */
   public Iterator<T> iterator()
   {
    
      throw new UnsupportedOperationException("We cannot use iterator() on a Map because iterator is only supposed to return"
         + " a key value, where as we want to iterate through the entry set!");
    
   }
   
   public boolean remove(Object obj)
   {
   
   return false;
   
   }
   
   /**
    * 
    * Removes a single element from the Bag.
    * 
    * Returns true if the Bag has been successfully modified. 
    * 
    */
   public boolean remove(T type) throws OutOfBoundsException
   {
   
      return this.remove(type, 1);
   
   }
   
   /**
    * 
    * Removes a specified amount of an element from the Bag.
    * 
    * The element is not allowed to be null.
    * The amount must be greater than zero.
    * 
    * Returns true if the Bag has been successfully modified.
    * 
    */
   public boolean remove(T type, int newAmount) throws OutOfBoundsException
   {
   
      boolean result;
   
      if (newAmount > 0 && type != null)
      {
      
         //fetch the originalAmount within the bag
         Integer originalAmount = this.bag.get(type);
      
         if (originalAmount != null && newAmount < originalAmount)
         {
         
            this.bag.put(type, originalAmount - newAmount);
            result = true;
         
         }
         
         else if (originalAmount != null && newAmount == originalAmount)
         {
         
            //It's important that we remove BOTH the key and the value. That is because, when it comes time to check equality,
            //having left over keys might result in our equals method giving us misleading info.
            this.bag.remove(type);
            result = true;
         
         }
         
         else if (originalAmount != null && newAmount > originalAmount)
         {
         
            throw new OutOfBoundsException("Cannot remove " + newAmount + " " + type + "'s from the EnumBag when there are only "
               + originalAmount + " " + type + "'s to start with.");
                  
         }
         
         else //if (originalAmount == null)
         {
         
            throw new OutOfBoundsException("Cannot remove " + newAmount + " " + type + "'s from the EnumBag when there are no "
               + type + "'s in the bag to start with.");
         
         }
      
      }
      
      else if (newAmount <= 0 && type != null)
      {
      
         throw new OutOfBoundsException("Cannot remove " + newAmount + " " + type + "'s from the EnumBag because " + newAmount
            + " is not a positive number!");
      
      }
      
      else //if (type == null)
      {
      
         throw new OutOfBoundsException("Cannot remove a null!");
      
      }
      
      return result;
      
   }
   
   /**
    * 
    * Iterates through the collection, and adds each element from the Collection to this bag.
    * 
    * The Collection must not be null.
    * The Collection must not be empty.
    * 
    * Returns true if the Bag has been successfully modified.
    *
    */
   public boolean removeAll(Collection<? extends Object> elements)
   {
    // 
      // boolean result = true;
      // boolean removedAtLeastOne = false;
   //  
      // if (elements != null)
      // {
      // 
         // for (Object each : elements)
         // {
         // 
            // boolean b = this.clazz.isInstance(each.getClass());
         // 
            // T element = (T)each;
            // result = result && this.remove(element);
            // removedAtLeastOne = true;
         //    
         // }
      // 
      // }
   //  
      // return result && removedAtLeastOne;
   //  
   
      return false;
   
   }
   
   //
   public boolean retainAll(Collection<? extends Object> elements)
   {
   
   return false;
   
   }
   
   public int size()
   {
   
   return -1;
   
   }
   
   //
   public Object[] toArray()
   {
   
   return null;
   
   }
    
   //
   public <T> T[] toArray(T[] array)
   {
   
   return null;
   
   }
    
   public Integer getCount(T type)
   {
   
      return this.bag.get(type);
   
   }
   
   public Set<T> keySet()
   {
   
      return this.bag.keySet();
   
   }
   
   public Map<T, Integer> toMap()
   {
   
      return Collections.unmodifiableMap(this.bag);
   
   }
   
   public String toString()
   {
   
      return this.bag.toString();
   
   }

}
