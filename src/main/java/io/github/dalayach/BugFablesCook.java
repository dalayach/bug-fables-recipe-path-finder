package io.github.dalayach;

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

}
