package io.github.dalayach;

import java.util.Set;
import java.util.EnumSet;

/** Enum containing the different cooks, as well as where they are located. */
public enum BugFablesCook
{

	/** Fry the fly. */
   FRY(BugFablesLocation.ANT_CITY),
   /** Kut the mantis. */
   KUT(BugFablesLocation.GOLDEN_SETTLEMENT),
   /** Crisbee the bee. */
   CRISBEE(BugFablesLocation.DEFIANT_ROOT),
   /** Microwave the machine. */
   MICROWAVE(BugFablesLocation.TERMITE_CAPITOL),
   /** Kut happens to be the fastest one to reach from the tunnel system. Should that change, this field should too. */
   ALL(BugFablesLocation.GOLDEN_SETTLEMENT)
   ;
   
	/** Contains the location of the cook. */
   private BugFablesLocation location;
   
	/**
	 * 
	 * Constructor.
	 * 
	 * @param location location
	 * 
	 */
   BugFablesCook(BugFablesLocation location)
   {
   
      this.location = location;
   
   }
   
   /** Getter for location. */
   public BugFablesLocation getLocation()
   {
   
      return this.location;
   
   }
   
   /** Finds all cooks located in the given locations. Returns an empty set if there are none there. */
   protected static Set<BugFablesCook> findCooksByLocations(Set<BugFablesLocation> locations)
   {
   
      Set<BugFablesCook> cooks = EnumSet.noneOf(BugFablesCook.class);
   
      if (locations != null)
      {
      
         for (BugFablesLocation location : locations)
         {
         
            cooks.addAll(BugFablesCook.findCooksByLocation(location));
         
         }
      
      }
      
      return cooks;
   
   }
   
	/**
	 * 
	 * Finds cooks located at the location in the parameter.
	 * 
	 * @param	location	location we want to find cooks within.
	 * @return	returns the set of cooks that exist at the location specified in the parameters. It's a
	 *					Set because we don't expect any duplicates.
	 *
	 */
   protected static Set<BugFablesCook> findCooksByLocation(BugFablesLocation location)
   {
   
      Set<BugFablesCook> cooks = EnumSet.noneOf(BugFablesCook.class);
   
      if (location != null)
      {
      
         for (BugFablesCook cook : BugFablesCook.values())
         {
         
            if (cook.getLocation() == location)
            {
            
               cooks.add(cook);
            
            }
         
         }
      
      }
      
      return cooks;
   
   }
   
}
