package io.github.dalayach;

/** Enum containing all of the food items relevant for unlocking all entries in the Recipe Book. */
public enum BugFablesFoodItem
{

	// food(ingredient 1, ingredient 2, who can make it)
	  
	// no cooking necessary, just buy these
   AGARIC_SHROOM(null, null, null),
   APHID_DEW(null, null, null),
   APHID_EGG(null, null, null),
   BAG_OF_FLOUR(null, null, null),
   BURLY_BERRY(null, null, null),
   CLEAR_WATER(null, null, null),
   CRUNCHY_LEAF(null, null, null),
   DANGER_SHROOM(null, null, null),
   DANGER_SPUD(null, null, null),
   DARK_CHERRIES(null, null, null),
   FLAME_ROCK(null, null, null),
   HARD_SEED(null, null, null),
   HONEY_DROP(null, null, null),
   HUSTLE_BERRY(null, null, null),
   JAYDE_STEW(null, null, null),
   MAGIC_ICE(null, null, null),
   MAGIC_SEED(null, null, null),
   MEGA_RUSH(null, null, null),
   MITE_BURGER(null, null, null),
   MUSHROOM(null, null, null),
   MYSTERY_BERRY(null, null, null),
   NUMBNAIL_DART(null, null, null),
   POISON_DART(null, null, null),
   SHELL_OINTMENT(null, null, null),
   SHOCK_BERRY(null, null, null),
   SPICY_BERRY(null, null, null),
   SQUASH(null, null, null),
   SUCCULENT_BERRY(null, null, null),
   TANGY_BERRY(null, null, null),
   
   // 1 round of cooking, if you didn't already buy or have this ingredient
   ABOMIHONEY(HONEY_DROP, HONEY_DROP, BugFablesCook.ALL),
   APHID_SHAKE(APHID_DEW, APHID_EGG, BugFablesCook.ALL),
   BAKED_YAM(DANGER_SPUD, null, BugFablesCook.ALL),
   BERRY_JAM(SPICY_BERRY, BURLY_BERRY, BugFablesCook.ALL),
   BERRY_JUICE(HARD_SEED, CLEAR_WATER, BugFablesCook.ALL),
   BERRY_SMOOTHIE(DARK_CHERRIES, TANGY_BERRY, BugFablesCook.ALL),
   BURLY_BOMB(HARD_SEED, BURLY_BERRY, BugFablesCook.ALL),
   BURLY_CANDY(BAG_OF_FLOUR, BURLY_BERRY, BugFablesCook.ALL),
   BURLY_CHIPS(DANGER_SPUD, BURLY_BERRY, BugFablesCook.ALL),
   CHERRY_PIE(DARK_CHERRIES, BAG_OF_FLOUR, BugFablesCook.ALL),
   COLD_SALAD(MAGIC_ICE, CRUNCHY_LEAF, BugFablesCook.ALL),
   COOKED_DANGER(DANGER_SHROOM, null, BugFablesCook.ALL),
   COOKED_SHROOM(MUSHROOM, null, BugFablesCook.ALL),
   DANGER_DISH(DANGER_SPUD, DANGER_SHROOM, BugFablesCook.ALL),
   DROWSY_CAKE(BAG_OF_FLOUR, NUMBNAIL_DART, BugFablesCook.ALL),
   DRY_BREAD(BAG_OF_FLOUR, null, BugFablesCook.ALL),
   FRIED_EGG(APHID_EGG, null, BugFablesCook.ALL),
   FROST_PIE(BAG_OF_FLOUR, MAGIC_ICE, BugFablesCook.ALL),
   GLAZED_HONEY(HONEY_DROP, null, BugFablesCook.ALL),
   HEARTY_BREAKFAST(MUSHROOM, APHID_EGG, BugFablesCook.ALL),
   HONEY_ICE_CREAM(MAGIC_ICE, HONEY_DROP, BugFablesCook.ALL),
   HONEY_LEAF(CRUNCHY_LEAF, HONEY_DROP, BugFablesCook.ALL),
   HONEY_PANCAKES(BAG_OF_FLOUR, HONEY_DROP, BugFablesCook.ALL),
   HOT_DRINK(CLEAR_WATER, HUSTLE_BERRY, BugFablesCook.ALL),
   HUSTLE_CANDY(BAG_OF_FLOUR, HUSTLE_BERRY, BugFablesCook.ALL),
   ICE_CREAM(MAGIC_ICE, APHID_DEW, BugFablesCook.ALL),
   LEAF_CROISSANT(BAG_OF_FLOUR, CRUNCHY_LEAF, BugFablesCook.ALL),
   LEAF_OMELET(CRUNCHY_LEAF, APHID_EGG, BugFablesCook.ALL),
   LEAF_SALAD(CRUNCHY_LEAF, CRUNCHY_LEAF, BugFablesCook.ALL),
   MIRACLE_SHAKE(DARK_CHERRIES, MAGIC_SEED, BugFablesCook.ALL),
   MISTAKE(APHID_EGG, CLEAR_WATER, BugFablesCook.ALL),
   MUSHROOM_GUMMIES(BAG_OF_FLOUR, MUSHROOM, BugFablesCook.ALL),
   MUSHROOM_SALAD(CRUNCHY_LEAF, MUSHROOM, BugFablesCook.ALL),
   MUSHROOM_SKEWER(MUSHROOM, DANGER_SHROOM, BugFablesCook.ALL),
   NUTTY_CAKE(BAG_OF_FLOUR, HARD_SEED, BugFablesCook.ALL),
   PLAIN_TEA(CLEAR_WATER, CRUNCHY_LEAF, BugFablesCook.ALL),
   PLUMPLING_PIE(SQUASH, BURLY_BERRY, BugFablesCook.ALL),
   POISON_CAKE(BAG_OF_FLOUR, DANGER_SHROOM, BugFablesCook.ALL),
   ROASTED_BERRIES(HARD_SEED, null, BugFablesCook.ALL),
   SHAVED_ICE(MAGIC_ICE, null, BugFablesCook.ALL),
   SHOCK_CANDY(BAG_OF_FLOUR, AGARIC_SHROOM, BugFablesCook.ALL),
   SPICY_BOMB(HARD_SEED, SPICY_BERRY, BugFablesCook.ALL),
   SPICY_CANDY(BAG_OF_FLOUR, SPICY_BERRY, BugFablesCook.ALL),
   SPICY_FRIES(DANGER_SPUD, SPICY_BERRY, BugFablesCook.ALL),
   SQUASH_CANDY(SQUASH, BAG_OF_FLOUR, BugFablesCook.ALL),
   SQUASH_PUREE(SQUASH, null, BugFablesCook.ALL),
   SQUASH_TART(SQUASH, SPICY_BERRY, BugFablesCook.ALL),
   SUCCULENT_COOKIES(SUCCULENT_BERRY, BAG_OF_FLOUR, BugFablesCook.ALL),
   SUCCULENT_PLATTER(SUCCULENT_BERRY, null, BugFablesCook.FRY),
   SWEET_DANGER(DANGER_SHROOM, HONEY_DROP, BugFablesCook.ALL),
   SWEET_DEW(APHID_DEW, HONEY_DROP, BugFablesCook.ALL),
   SWEET_PUDDING(BAG_OF_FLOUR, APHID_EGG, BugFablesCook.ALL),
   SWEET_SHROOM(MUSHROOM, HONEY_DROP, BugFablesCook.ALL),
   TANGY_JAM(TANGY_BERRY, HONEY_DROP, BugFablesCook.ALL),
   TANGY_JUICE(TANGY_BERRY, CLEAR_WATER, BugFablesCook.ALL),
   TANGY_PIE(TANGY_BERRY, BAG_OF_FLOUR, BugFablesCook.ALL),
   YAM_BREAD(BAG_OF_FLOUR, DANGER_SPUD, BugFablesCook.FRY),
   
	// 2 rounds of cooking, if you didn't already buy or have some of these ingredients
   BIG_MISTAKE(MISTAKE, null, BugFablesCook.ALL),
   BURLY_TEA(PLAIN_TEA, BURLY_BERRY, BugFablesCook.ALL),
   CHERRY_BOMBS(SPICY_BOMB, DARK_CHERRIES, BugFablesCook.ALL),
   FROST_BOMB(SPICY_BOMB, MAGIC_ICE, BugFablesCook.ALL),
   NUMB_BOMB(SPICY_BOMB, AGARIC_SHROOM, BugFablesCook.ALL),
   POISON_BOMB(SPICY_BOMB, DANGER_SHROOM, BugFablesCook.ALL),
   SLEEP_BOMB(SPICY_BOMB, NUMBNAIL_DART, BugFablesCook.ALL),
   SPICY_TEA(PLAIN_TEA, SPICY_BERRY, BugFablesCook.ALL),
   
   // 3 rounds of cooking, if you didn't already buy or have some of the ingredients
   ABOMBINATION(SLEEP_BOMB, ABOMIHONEY, BugFablesCook.FRY),
   CLEAR_BOMB(SLEEP_BOMB, CLEAR_WATER, BugFablesCook.ALL),
   ;
   
	/** Contains the first ingredient. Can be null. */
   private BugFablesFoodItem ingredient1;
   /** Contains the second ingredient. Can be null. */
   private BugFablesFoodItem ingredient2;
	/** Contains the cook who can make this meal. Can be null. */
   private BugFablesCook cook;
   
   BugFablesFoodItem() { /** This should never be used. */ }
   
	/**
	 * 
	 * Constructor. Null implies that that attribute is not required in order to attain the food item.
	 * 
	 * Example - null ingredient1 and null ingredient2 implies that you do not use ingredients in order to get this food item.
	 * Example - null cook implies that you cannot cook ingredients to get this food item.
	 *
	 * Therefore, if a constructor has ingredient1, ingredient2, and cook all null, it implies that it is an item that cannot
	 * be created or cooked. Instead, it must be purchased or found. Unless otherwise mentioned, assume all items of this
	 * format can be easily purchased (aside from maybe Dark Cherries).
	 *
	 * @param	ingredient1	the first (and potentially only) ingredient of the food item. Can be null.
	 * @param	ingredient2	the second ingredient of the food item. Can be null.
	 * @param	cook			the cook who can make this items
	 * 
	 */
   BugFablesFoodItem(BugFablesFoodItem ingredient1, BugFablesFoodItem ingredient2, BugFablesCook cook)
   {
         
      this.ingredient1 = ingredient1;
      this.ingredient2 = ingredient2;
      this.cook = cook;
         
   }
   
   public BugFablesFoodItem getIngredient1()
   {
   
      return this.ingredient1;
   
   }

   public BugFablesFoodItem getIngredient2()
   {
   
      return this.ingredient2;
   
   }

   public BugFablesCook getCook()
   {
   
      return this.cook;
   
   }
   
	/** No setters, as these objects should effectively operate as constants. Once they are set, that's it. */

}
