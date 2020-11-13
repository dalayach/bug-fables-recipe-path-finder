package io.github.dalayach;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
 * 
 * Enum to represent the possible recipes to create the respective BugFablesFoodItem. Please remember that recipes
 * are 1 or 2 items that, when cooked, will create a specific BugFablesFoodItem. Most foodItems have more than
 * 1 way to be created, so having this enum will allow us to be better optimized when choosing the best path forward.
 * 
 */
public enum BugFablesRecipe
{

   // foodItem(
   //    recipe1,
   //    recipe2,
   //    ...
   // )

   MISTAKE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.APHID_EGG, BugFablesFoodItem.CLEAR_WATER))
   	))
   ),
   LEAF_SALAD(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.CRUNCHY_LEAF)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.CRUNCHY_LEAF, null))
   	))
   ),
   GLAZED_HONEY(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.HONEY_DROP, null))
   	))
   ),
   ABOMIHONEY(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.HONEY_DROP, BugFablesFoodItem.HONEY_DROP)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.HONEY_DROP, BugFablesFoodItem.MISTAKE)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.GLAZED_HONEY, null)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.GLAZED_HONEY, BugFablesFoodItem.HONEY_DROP)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.GLAZED_HONEY, BugFablesFoodItem.MISTAKE)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.GLAZED_HONEY, BugFablesFoodItem.GLAZED_HONEY))
   	))
   ),
   COOKED_SHROOM(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MUSHROOM, null)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.AGARIC_SHROOM, null))
   	))
   ),
   COOKED_DANGER(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DANGER_SHROOM, null))
   	))
   ),
   SWEET_SHROOM(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.HONEY_DROP)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.GLAZED_HONEY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.AGARIC_SHROOM, BugFablesFoodItem.HONEY_DROP))
   	))
   ),
   SWEET_DANGER(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DANGER_SHROOM, BugFablesFoodItem.HONEY_DROP)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DANGER_SHROOM, BugFablesFoodItem.GLAZED_HONEY))
   	))
   ),
   FRIED_EGG(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.APHID_EGG, null))
   	))
   ),
   LEAF_OMELET(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.APHID_EGG)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.FRIED_EGG)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.APHID_EGG)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.FRIED_EGG))
   	))
   ),
   HONEY_LEAF(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.HONEY_DROP)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.GLAZED_HONEY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.HONEY_DROP)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.GLAZED_HONEY))
   	))
   ),
   ROASTED_BERRIES(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BERRY, null)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BURLY_BERRY, null)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.HARD_SEED, null)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.HUSTLE_BERRY, null))
   	))
   ),
   SUCCULENT_PLATTER(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SUCCULENT_BERRY, null)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DARK_CHERRIES, null))
   	))
   ),
   SUCCULENT_COOKIES(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SUCCULENT_BERRY, BugFablesFoodItem.BAG_OF_FLOUR)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SUCCULENT_PLATTER, BugFablesFoodItem.BAG_OF_FLOUR))
   	))
   ),
   BERRY_JUICE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.HARD_SEED, BugFablesFoodItem.CLEAR_WATER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BURLY_BERRY, BugFablesFoodItem.CLEAR_WATER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BERRY, BugFablesFoodItem.CLEAR_WATER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SHOCK_BERRY, BugFablesFoodItem.CLEAR_WATER))
   	))
   ),
   MUSHROOM_SKEWER(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.DANGER_SHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.COOKED_DANGER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.SWEET_DANGER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.AGARIC_SHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.COOKED_SHROOM, BugFablesFoodItem.DANGER_SHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.COOKED_SHROOM, BugFablesFoodItem.COOKED_DANGER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.COOKED_SHROOM, BugFablesFoodItem.SWEET_DANGER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SWEET_SHROOM, BugFablesFoodItem.DANGER_SHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SWEET_SHROOM, BugFablesFoodItem.COOKED_DANGER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SWEET_SHROOM, BugFablesFoodItem.SWEET_DANGER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DANGER_SHROOM, BugFablesFoodItem.AGARIC_SHROOM))
   	))
   ),
   HEARTY_BREAKFAST(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.APHID_EGG)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.FRIED_EGG)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.COOKED_SHROOM, BugFablesFoodItem.APHID_EGG)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.COOKED_SHROOM, BugFablesFoodItem.FRIED_EGG))
   	))
   ),
   MUSHROOM_SALAD(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.MUSHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.AGARIC_SHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.COOKED_SHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.MUSHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.AGARIC_SHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.COOKED_SHROOM))
   	))
   ),
   SWEET_DEW(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.APHID_DEW, BugFablesFoodItem.HONEY_DROP)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.APHID_DEW, BugFablesFoodItem.GLAZED_HONEY))
   	))
   ),
   BAKED_YAM(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DANGER_SPUD, null))
   	))
   ),
   SPICY_FRIES(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DANGER_SPUD, BugFablesFoodItem.SPICY_BERRY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAKED_YAM, BugFablesFoodItem.SPICY_BERRY))
   	))
   ),
   BURLY_CHIPS(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DANGER_SPUD, BugFablesFoodItem.BURLY_BERRY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAKED_YAM, BugFablesFoodItem.BURLY_BERRY))
   	))
   ),
   DANGER_DISH(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DANGER_SPUD, BugFablesFoodItem.DANGER_SHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DANGER_SPUD, BugFablesFoodItem.POISON_DART)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DANGER_SPUD, BugFablesFoodItem.POISON_CAKE)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DANGER_SPUD, BugFablesFoodItem.SWEET_DANGER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DANGER_SHROOM, BugFablesFoodItem.POISON_DART)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DANGER_SHROOM, BugFablesFoodItem.POISON_CAKE))
   	))
   ),
   SHAVED_ICE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MAGIC_ICE, null))
   	))
   ),
   COLD_SALAD(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MAGIC_ICE, BugFablesFoodItem.CRUNCHY_LEAF)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MAGIC_ICE, BugFablesFoodItem.LEAF_SALAD)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SHAVED_ICE, BugFablesFoodItem.CRUNCHY_LEAF)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SHAVED_ICE, BugFablesFoodItem.LEAF_SALAD))
   	))
   ),
   ICE_CREAM(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MAGIC_ICE, BugFablesFoodItem.APHID_DEW)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SHAVED_ICE, BugFablesFoodItem.APHID_DEW))
   	))
   ),
   HONEY_ICE_CREAM(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MAGIC_ICE, BugFablesFoodItem.HONEY_DROP)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MAGIC_ICE, BugFablesFoodItem.SWEET_DEW)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SHAVED_ICE, BugFablesFoodItem.HONEY_DROP)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SHAVED_ICE, BugFablesFoodItem.SWEET_DEW)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SHAVED_ICE, BugFablesFoodItem.GLAZED_HONEY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.ICE_CREAM, BugFablesFoodItem.HONEY_DROP)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.ICE_CREAM, BugFablesFoodItem.GLAZED_HONEY))
   	))
   ),
   DRY_BREAD(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, null))
   	))
   ),
   NUTTY_CAKE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.HARD_SEED)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.ROASTED_BERRIES)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.MYSTERY_BERRY))
   	))
   ),
   POISON_CAKE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.DANGER_SHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.DANGER_SPUD)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.POISON_DART))
   	))
   ),
   FROST_PIE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.MAGIC_ICE)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.SHAVED_ICE)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.ICE_CREAM))
   	))
   ),
   YAM_BREAD(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.DANGER_SPUD)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.BAKED_YAM))
   	))
   ),
   SHOCK_CANDY(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.SHOCK_BERRY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.AGARIC_SHROOM))
   	))
   ),
   MUSHROOM_GUMMIES(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.MUSHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.MUSHROOM_SKEWER))
   	))
   ),
   SWEET_PUDDING(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.APHID_EGG)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.FRIED_EGG)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.APHID_DEW))
   	))
   ),
   LEAF_CROISSANT(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.CRUNCHY_LEAF)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.LEAF_SALAD))
   	))
   ),
   HONEY_PANCAKES(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.HONEY_DROP)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.ABOMIHONEY))
   	))
   ),
   DROWSY_CAKE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.NUMBNAIL_DART))
   	))
   ),
   HUSTLE_CANDY(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.HUSTLE_BERRY))
   	))
   ),
   SPICY_CANDY(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.SPICY_BERRY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.FLAME_ROCK))
   	))
   ),
   BURLY_CANDY(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.BURLY_BERRY))
   	))
   ),
   BERRY_JAM(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BERRY, BugFablesFoodItem.BURLY_BERRY))
   	))
   ),
   HOT_DRINK(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.CLEAR_WATER, BugFablesFoodItem.HUSTLE_BERRY))
   	))
   ),
   PLAIN_TEA(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.CLEAR_WATER, BugFablesFoodItem.CRUNCHY_LEAF)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.CLEAR_WATER, BugFablesFoodItem.LEAF_SALAD))
   	))
   ),
   SPICY_TEA(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.PLAIN_TEA, BugFablesFoodItem.SPICY_BERRY))
   	))
   ),
   BURLY_TEA(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.PLAIN_TEA, BugFablesFoodItem.BURLY_BERRY))
   	))
   ),
   APHID_SHAKE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.APHID_DEW, BugFablesFoodItem.APHID_EGG)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.APHID_DEW, BugFablesFoodItem.FRIED_EGG))
   	))
   ),
   SQUASH_PUREE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SQUASH, null))
   	))
   ),
   SQUASH_CANDY(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SQUASH, BugFablesFoodItem.BAG_OF_FLOUR)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SQUASH_PUREE, BugFablesFoodItem.BAG_OF_FLOUR))
   	))
   ),
   SQUASH_TART(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SQUASH, BugFablesFoodItem.SPICY_BERRY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SQUASH_PUREE, BugFablesFoodItem.SPICY_BERRY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SQUASH_CANDY, BugFablesFoodItem.SPICY_BERRY))
   	))
   ),
   PLUMPLING_PIE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SQUASH, BugFablesFoodItem.BURLY_BERRY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SQUASH_PUREE, BugFablesFoodItem.BURLY_BERRY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SQUASH_CANDY, BugFablesFoodItem.BURLY_BERRY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SQUASH_TART, BugFablesFoodItem.BURLY_BERRY))
   	))
   ),
   TANGY_JAM(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.TANGY_BERRY, BugFablesFoodItem.HONEY_DROP)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.TANGY_BERRY, BugFablesFoodItem.GLAZED_HONEY))
   	))
   ),
   TANGY_JUICE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.TANGY_BERRY, BugFablesFoodItem.CLEAR_WATER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.TANGY_BERRY, BugFablesFoodItem.BERRY_JUICE)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.TANGY_JAM, BugFablesFoodItem.BERRY_JUICE))
   	))
   ),
   TANGY_PIE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.TANGY_BERRY, BugFablesFoodItem.BAG_OF_FLOUR)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.TANGY_JAM, BugFablesFoodItem.BAG_OF_FLOUR))
   	))
   ),
   SPICY_BOMB(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.HARD_SEED, BugFablesFoodItem.SPICY_BERRY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.FLAME_ROCK, null)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.SPICY_BERRY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MYSTERY_BERRY, BugFablesFoodItem.SPICY_BERRY))
   	))
   ),
   BURLY_BOMB(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.HARD_SEED, BugFablesFoodItem.BURLY_BERRY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.BURLY_BERRY))
   	))
   ),
   POISON_BOMB(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.POISON_DART)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.DANGER_SHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.DANGER_SPUD)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.COOKED_DANGER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.SWEET_DANGER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.DANGER_DISH)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.DANGER_SHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.DANGER_SPUD)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.DANGER_DISH)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.POISON_DART)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.DANGER_SHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.DANGER_SPUD)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.SWEET_DANGER))
   	))
   ),
   SLEEP_BOMB(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.NUMBNAIL_DART)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.DROWSY_CAKE)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.NUMBNAIL_DART)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.DROWSY_CAKE)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.NUMBNAIL_DART))
   	))
   ),
   NUMB_BOMB(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.SHOCK_BERRY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.AGARIC_SHROOM)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.SHOCK_CANDY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.SHOCK_BERRY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.SHOCK_CANDY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.SHOCK_BERRY))
   	))
   ),
   FROST_BOMB(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.MAGIC_ICE)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.SHAVED_ICE)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.CRUNCHY_LEAF)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.MAGIC_ICE)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.SHAVED_ICE)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.MAGIC_ICE))
   	))
   ),
   CLEAR_BOMB(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.CLEAR_WATER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.CLEAR_WATER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.CLEAR_WATER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.FROST_BOMB, BugFablesFoodItem.CLEAR_WATER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.NUMB_BOMB, BugFablesFoodItem.CLEAR_WATER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SLEEP_BOMB, BugFablesFoodItem.CLEAR_WATER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.CHERRY_BOMBS, BugFablesFoodItem.CLEAR_WATER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.ABOMBINATION, BugFablesFoodItem.CLEAR_WATER)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.CLEAR_WATER))
   	))
   ),
   ABOMBINATION(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.ABOMIHONEY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.ABOMIHONEY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.ABOMIHONEY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.FROST_BOMB, BugFablesFoodItem.ABOMIHONEY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.NUMB_BOMB, BugFablesFoodItem.ABOMIHONEY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SLEEP_BOMB, BugFablesFoodItem.ABOMIHONEY)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.ABOMIHONEY))
   	))
   ),
   CHERRY_BOMBS(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.DARK_CHERRIES)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.DARK_CHERRIES)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.DARK_CHERRIES)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.SPICY_BERRY, BugFablesFoodItem.DARK_CHERRIES))
   	))
   ),
   CHERRY_PIE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DARK_CHERRIES, BugFablesFoodItem.BAG_OF_FLOUR))
   	))
   ),
   BERRY_SMOOTHIE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DARK_CHERRIES, BugFablesFoodItem.TANGY_BERRY))
   	))
   ),
   MIRACLE_SHAKE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.DARK_CHERRIES, BugFablesFoodItem.MAGIC_SEED))
   	))
   ),
   TANGY_CARPACCIO(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.TANGY_BERRY, null))
   	))
   ),
   CRISBEE_DONUT(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.GLAZED_HONEY, BugFablesFoodItem.BAG_OF_FLOUR))
   	))
   ),
   QUEENS_DINNER(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.TANGY_CARPACCIO, BugFablesFoodItem.CRISBEE_DONUT))
   	))
   ),
   BIG_MISTAKE(
   	new HashSet<>(Arrays.asList(
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MISTAKE, null)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.MISTAKE, BugFablesFoodItem.MISTAKE)),
   		Collections.unmodifiableList(Arrays.asList(BugFablesFoodItem.ABOMIHONEY, BugFablesFoodItem.ABOMIHONEY))
   	))
   )
   ;

	/** List of possible recipes. */
   private final Set<List<BugFablesFoodItem>> possibleRecipes;

   /** Constructor. */
   BugFablesRecipe(Set<List<BugFablesFoodItem>> possibleRecipes)
   {
      
      this.possibleRecipes = possibleRecipes;
         
   }
   
   /** Returns a Set of possible recipes. */
   public Set<List<BugFablesFoodItem>> getPossibleRecipes()
   {
   
      return this.possibleRecipes;
   
   }
   
   /** Return the BugFablesRecipe associated with this foodItem, or simply return null if there is none. */
   public static BugFablesRecipe getRespectiveRecipe(BugFablesFoodItem foodItem)
   {
   
      if (foodItem.getRecipeId() != 0)
      {
      
         return BugFablesRecipe.valueOf(foodItem.name());
      
      }
   
      return null;
   
   }
   
   /** Returns an alphabetically ordered array of recipes. */
   public static BugFablesRecipe[] listOfOrderedRecipes()
   {
   
      BugFablesRecipe[] recipes = BugFablesRecipe.values();
      
      Arrays.sort(
         recipes, 
         new Comparator<BugFablesRecipe>() 
         {
         
            /** Orders by alphabetical order. */
            public int compare(BugFablesRecipe o1, BugFablesRecipe o2)
            {
            
               return o1.name().compareTo(o2.name());
            
            }
         
         });
         
      return recipes;
   
   }
   
}
