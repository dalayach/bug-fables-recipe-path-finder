package io.github.dalayach;

import java.util.EnumSet;

import org.junit.Assert;
import org.junit.Test;

/** Unit test for BugFablesCook. */
public class BugFablesCookTest {

   /** Tests that we can find all cooks in a certain location. */
   @Test
   public void findCooksByLocationTest() {
   
   	/** null */
      Assert.assertEquals(BugFablesCook.findCooksByLocation(null), EnumSet.noneOf(BugFablesCook.class));
      
   	/** ANT_CITY */
      Assert.assertEquals(EnumSet.of(BugFablesCook.FRY), BugFablesCook.findCooksByLocation(BugFablesLocation.ANT_CITY));
   	
   	/** GOLDEN_SETTLEMENT */
      Assert.assertEquals(EnumSet.of(BugFablesCook.KUT, BugFablesCook.ALL),
         BugFablesCook.findCooksByLocation(BugFablesLocation.GOLDEN_SETTLEMENT));
   	
   	/** DEFIANT_ROOT */
      Assert.assertEquals(EnumSet.of(BugFablesCook.CRISBEE), BugFablesCook.findCooksByLocation(BugFablesLocation.DEFIANT_ROOT));
   	
   	/** BEE_HIVE */
      Assert.assertEquals(EnumSet.noneOf(BugFablesCook.class), BugFablesCook.findCooksByLocation(BugFablesLocation.BEE_HIVE));
   	
   	/** METAL_ISLAND */
      Assert.assertEquals(EnumSet.noneOf(BugFablesCook.class), BugFablesCook.findCooksByLocation(BugFablesLocation.METAL_ISLAND));
   	
   	/** TERMITE_CAPITOL */
      Assert.assertEquals(EnumSet.of(BugFablesCook.MICROWAVE),
         BugFablesCook.findCooksByLocation(BugFablesLocation.TERMITE_CAPITOL));
   	
   	/** WASP_KINGDOM */
      Assert.assertEquals(EnumSet.noneOf(BugFablesCook.class), BugFablesCook.findCooksByLocation(BugFablesLocation.WASP_KINGDOM));
   	
   	/** DEAD_LANDS */
      Assert.assertEquals(EnumSet.noneOf(BugFablesCook.class), BugFablesCook.findCooksByLocation(BugFablesLocation.DEAD_LANDS));
   	
   }
}
