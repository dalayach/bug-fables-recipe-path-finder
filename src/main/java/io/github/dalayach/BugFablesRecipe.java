package io.github.dalayach;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

   //Recipe(finalProduct, ingredientA, ingredientB)

   RECIPE_0001(BugFablesFoodItem.ABOMBINATION, BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.ABOMIHONEY),
   RECIPE_0002(BugFablesFoodItem.ABOMBINATION, BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.ABOMIHONEY),
   RECIPE_0003(BugFablesFoodItem.ABOMBINATION, BugFablesFoodItem.FROST_BOMB, BugFablesFoodItem.ABOMIHONEY),
   RECIPE_0004(BugFablesFoodItem.ABOMBINATION, BugFablesFoodItem.NUMB_BOMB, BugFablesFoodItem.ABOMIHONEY),
   RECIPE_0005(BugFablesFoodItem.ABOMBINATION, BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.ABOMIHONEY),
   RECIPE_0006(BugFablesFoodItem.ABOMBINATION, BugFablesFoodItem.SLEEP_BOMB, BugFablesFoodItem.ABOMIHONEY),
   RECIPE_0007(BugFablesFoodItem.ABOMBINATION, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.ABOMIHONEY),
   RECIPE_0008(BugFablesFoodItem.ABOMIHONEY, BugFablesFoodItem.GLAZED_HONEY, BugFablesFoodItem.GLAZED_HONEY),
   RECIPE_0009(BugFablesFoodItem.ABOMIHONEY, BugFablesFoodItem.GLAZED_HONEY, BugFablesFoodItem.HONEY_DROP),
   RECIPE_0010(BugFablesFoodItem.ABOMIHONEY, BugFablesFoodItem.GLAZED_HONEY, BugFablesFoodItem.MISTAKE),
   RECIPE_0011(BugFablesFoodItem.ABOMIHONEY, BugFablesFoodItem.GLAZED_HONEY, null),
   RECIPE_0012(BugFablesFoodItem.ABOMIHONEY, BugFablesFoodItem.HONEY_DROP, BugFablesFoodItem.HONEY_DROP),
   RECIPE_0013(BugFablesFoodItem.ABOMIHONEY, BugFablesFoodItem.HONEY_DROP, BugFablesFoodItem.MISTAKE),
   RECIPE_0014(BugFablesFoodItem.APHID_SHAKE, BugFablesFoodItem.APHID_DEW, BugFablesFoodItem.APHID_EGG),
   RECIPE_0015(BugFablesFoodItem.APHID_SHAKE, BugFablesFoodItem.APHID_DEW, BugFablesFoodItem.FRIED_EGG),
   RECIPE_0016(BugFablesFoodItem.BAKED_YAM, BugFablesFoodItem.DANGER_SPUD, null),
   RECIPE_0017(BugFablesFoodItem.BERRY_JAM, BugFablesFoodItem.SPICY_BERRY, BugFablesFoodItem.BURLY_BERRY),
   RECIPE_0018(BugFablesFoodItem.BERRY_JUICE, BugFablesFoodItem.BURLY_BERRY, BugFablesFoodItem.CLEAR_WATER),
   RECIPE_0019(BugFablesFoodItem.BERRY_JUICE, BugFablesFoodItem.HARD_SEED, BugFablesFoodItem.CLEAR_WATER),
   RECIPE_0020(BugFablesFoodItem.BERRY_JUICE, BugFablesFoodItem.SHOCK_BERRY, BugFablesFoodItem.CLEAR_WATER),
   RECIPE_0021(BugFablesFoodItem.BERRY_JUICE, BugFablesFoodItem.SPICY_BERRY, BugFablesFoodItem.CLEAR_WATER),
   RECIPE_0022(BugFablesFoodItem.BERRY_SMOOTHIE, BugFablesFoodItem.DARK_CHERRIES, BugFablesFoodItem.TANGY_BERRY),
   RECIPE_0023(BugFablesFoodItem.BIG_MISTAKE, BugFablesFoodItem.ABOMIHONEY, BugFablesFoodItem.ABOMIHONEY),
   RECIPE_0024(BugFablesFoodItem.BIG_MISTAKE, BugFablesFoodItem.MISTAKE, BugFablesFoodItem.MISTAKE),
   RECIPE_0025(BugFablesFoodItem.BIG_MISTAKE, BugFablesFoodItem.MISTAKE, null),
   RECIPE_0026(BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.BURLY_BERRY),
   RECIPE_0027(BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.HARD_SEED, BugFablesFoodItem.BURLY_BERRY),
   RECIPE_0028(BugFablesFoodItem.BURLY_CANDY, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.BURLY_BERRY),
   RECIPE_0029(BugFablesFoodItem.BURLY_CHIPS, BugFablesFoodItem.BAKED_YAM, BugFablesFoodItem.BURLY_BERRY),
   RECIPE_0030(BugFablesFoodItem.BURLY_CHIPS, BugFablesFoodItem.DANGER_SPUD, BugFablesFoodItem.BURLY_BERRY),
   RECIPE_0031(BugFablesFoodItem.BURLY_TEA, BugFablesFoodItem.PLAIN_TEA, BugFablesFoodItem.BURLY_BERRY),
   RECIPE_0032(BugFablesFoodItem.CHERRY_BOMBS, BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.DARK_CHERRIES),
   RECIPE_0033(BugFablesFoodItem.CHERRY_BOMBS, BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.DARK_CHERRIES),
   RECIPE_0034(BugFablesFoodItem.CHERRY_BOMBS, BugFablesFoodItem.SPICY_BERRY, BugFablesFoodItem.DARK_CHERRIES),
   RECIPE_0035(BugFablesFoodItem.CHERRY_BOMBS, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.DARK_CHERRIES),
   RECIPE_0036(BugFablesFoodItem.CHERRY_PIE, BugFablesFoodItem.DARK_CHERRIES, BugFablesFoodItem.BAG_OF_FLOUR),
   RECIPE_0037(BugFablesFoodItem.CLEAR_BOMB, BugFablesFoodItem.ABOMBINATION, BugFablesFoodItem.CLEAR_WATER),
   RECIPE_0038(BugFablesFoodItem.CLEAR_BOMB, BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.CLEAR_WATER),
   RECIPE_0039(BugFablesFoodItem.CLEAR_BOMB, BugFablesFoodItem.CHERRY_BOMBS, BugFablesFoodItem.CLEAR_WATER),
   RECIPE_0040(BugFablesFoodItem.CLEAR_BOMB, BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.CLEAR_WATER),
   RECIPE_0041(BugFablesFoodItem.CLEAR_BOMB, BugFablesFoodItem.FROST_BOMB, BugFablesFoodItem.CLEAR_WATER),
   RECIPE_0042(BugFablesFoodItem.CLEAR_BOMB, BugFablesFoodItem.NUMB_BOMB, BugFablesFoodItem.CLEAR_WATER),
   RECIPE_0043(BugFablesFoodItem.CLEAR_BOMB, BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.CLEAR_WATER),
   RECIPE_0044(BugFablesFoodItem.CLEAR_BOMB, BugFablesFoodItem.SLEEP_BOMB, BugFablesFoodItem.CLEAR_WATER),
   RECIPE_0045(BugFablesFoodItem.CLEAR_BOMB, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.CLEAR_WATER),
   RECIPE_0046(BugFablesFoodItem.COLD_SALAD, BugFablesFoodItem.MAGIC_ICE, BugFablesFoodItem.CRUNCHY_LEAF),
   RECIPE_0047(BugFablesFoodItem.COLD_SALAD, BugFablesFoodItem.MAGIC_ICE, BugFablesFoodItem.LEAF_SALAD),
   RECIPE_0048(BugFablesFoodItem.COLD_SALAD, BugFablesFoodItem.SHAVED_ICE, BugFablesFoodItem.CRUNCHY_LEAF),
   RECIPE_0049(BugFablesFoodItem.COLD_SALAD, BugFablesFoodItem.SHAVED_ICE, BugFablesFoodItem.LEAF_SALAD),
   RECIPE_0050(BugFablesFoodItem.COOKED_DANGER, BugFablesFoodItem.DANGER_SHROOM, null),
   RECIPE_0051(BugFablesFoodItem.COOKED_SHROOM, BugFablesFoodItem.AGARIC_SHROOM, null),
   RECIPE_0052(BugFablesFoodItem.COOKED_SHROOM, BugFablesFoodItem.MUSHROOM, null),
   RECIPE_0053(BugFablesFoodItem.CRISBEE_DONUT, BugFablesFoodItem.GLAZED_HONEY, BugFablesFoodItem.BAG_OF_FLOUR),
   RECIPE_0054(BugFablesFoodItem.DANGER_DISH, BugFablesFoodItem.DANGER_SHROOM, BugFablesFoodItem.POISON_CAKE),
   RECIPE_0055(BugFablesFoodItem.DANGER_DISH, BugFablesFoodItem.DANGER_SHROOM, BugFablesFoodItem.POISON_DART),
   RECIPE_0056(BugFablesFoodItem.DANGER_DISH, BugFablesFoodItem.DANGER_SPUD, BugFablesFoodItem.DANGER_SHROOM),
   RECIPE_0057(BugFablesFoodItem.DANGER_DISH, BugFablesFoodItem.DANGER_SPUD, BugFablesFoodItem.POISON_CAKE),
   RECIPE_0058(BugFablesFoodItem.DANGER_DISH, BugFablesFoodItem.DANGER_SPUD, BugFablesFoodItem.POISON_DART),
   RECIPE_0059(BugFablesFoodItem.DANGER_DISH, BugFablesFoodItem.DANGER_SPUD, BugFablesFoodItem.SWEET_DANGER),
   RECIPE_0060(BugFablesFoodItem.DROWSY_CAKE, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.NUMBNAIL_DART),
   RECIPE_0061(BugFablesFoodItem.DRY_BREAD, BugFablesFoodItem.BAG_OF_FLOUR, null),
   RECIPE_0062(BugFablesFoodItem.FRIED_EGG, BugFablesFoodItem.APHID_EGG, null),
   RECIPE_0063(BugFablesFoodItem.FROST_BOMB, BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.MAGIC_ICE),
   RECIPE_0064(BugFablesFoodItem.FROST_BOMB, BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.SHAVED_ICE),
   RECIPE_0065(BugFablesFoodItem.FROST_BOMB, BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.MAGIC_ICE),
   RECIPE_0066(BugFablesFoodItem.FROST_BOMB, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.CRUNCHY_LEAF),
   RECIPE_0067(BugFablesFoodItem.FROST_BOMB, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.MAGIC_ICE),
   RECIPE_0068(BugFablesFoodItem.FROST_BOMB, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.SHAVED_ICE),
   RECIPE_0069(BugFablesFoodItem.FROST_PIE, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.ICE_CREAM),
   RECIPE_0070(BugFablesFoodItem.FROST_PIE, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.MAGIC_ICE),
   RECIPE_0071(BugFablesFoodItem.FROST_PIE, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.SHAVED_ICE),
   RECIPE_0072(BugFablesFoodItem.GLAZED_HONEY, BugFablesFoodItem.HONEY_DROP, null),
   RECIPE_0073(BugFablesFoodItem.HEARTY_BREAKFAST, BugFablesFoodItem.COOKED_SHROOM, BugFablesFoodItem.APHID_EGG),
   RECIPE_0074(BugFablesFoodItem.HEARTY_BREAKFAST, BugFablesFoodItem.COOKED_SHROOM, BugFablesFoodItem.FRIED_EGG),
   RECIPE_0075(BugFablesFoodItem.HEARTY_BREAKFAST, BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.APHID_EGG),
   RECIPE_0076(BugFablesFoodItem.HEARTY_BREAKFAST, BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.FRIED_EGG),
   RECIPE_0077(BugFablesFoodItem.HONEY_ICE_CREAM, BugFablesFoodItem.ICE_CREAM, BugFablesFoodItem.GLAZED_HONEY),
   RECIPE_0078(BugFablesFoodItem.HONEY_ICE_CREAM, BugFablesFoodItem.ICE_CREAM, BugFablesFoodItem.HONEY_DROP),
   RECIPE_0079(BugFablesFoodItem.HONEY_ICE_CREAM, BugFablesFoodItem.MAGIC_ICE, BugFablesFoodItem.HONEY_DROP),
   RECIPE_0080(BugFablesFoodItem.HONEY_ICE_CREAM, BugFablesFoodItem.MAGIC_ICE, BugFablesFoodItem.SWEET_DEW),
   RECIPE_0081(BugFablesFoodItem.HONEY_ICE_CREAM, BugFablesFoodItem.SHAVED_ICE, BugFablesFoodItem.GLAZED_HONEY),
   RECIPE_0082(BugFablesFoodItem.HONEY_ICE_CREAM, BugFablesFoodItem.SHAVED_ICE, BugFablesFoodItem.HONEY_DROP),
   RECIPE_0083(BugFablesFoodItem.HONEY_ICE_CREAM, BugFablesFoodItem.SHAVED_ICE, BugFablesFoodItem.SWEET_DEW),
   RECIPE_0084(BugFablesFoodItem.HONEY_LEAF, BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.GLAZED_HONEY),
   RECIPE_0085(BugFablesFoodItem.HONEY_LEAF, BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.HONEY_DROP),
   RECIPE_0086(BugFablesFoodItem.HONEY_LEAF, BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.GLAZED_HONEY),
   RECIPE_0087(BugFablesFoodItem.HONEY_LEAF, BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.HONEY_DROP),
   RECIPE_0088(BugFablesFoodItem.HONEY_PANCAKES, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.ABOMIHONEY),
   RECIPE_0089(BugFablesFoodItem.HONEY_PANCAKES, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.HONEY_DROP),
   RECIPE_0090(BugFablesFoodItem.HOT_DRINK, BugFablesFoodItem.CLEAR_WATER, BugFablesFoodItem.HUSTLE_BERRY),
   RECIPE_0091(BugFablesFoodItem.HUSTLE_CANDY, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.HUSTLE_BERRY),
   RECIPE_0092(BugFablesFoodItem.ICE_CREAM, BugFablesFoodItem.MAGIC_ICE, BugFablesFoodItem.APHID_DEW),
   RECIPE_0093(BugFablesFoodItem.ICE_CREAM, BugFablesFoodItem.SHAVED_ICE, BugFablesFoodItem.APHID_DEW),
   RECIPE_0094(BugFablesFoodItem.LEAF_CROISSANT, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.CRUNCHY_LEAF),
   RECIPE_0095(BugFablesFoodItem.LEAF_CROISSANT, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.LEAF_SALAD),
   RECIPE_0096(BugFablesFoodItem.LEAF_OMELET, BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.APHID_EGG),
   RECIPE_0097(BugFablesFoodItem.LEAF_OMELET, BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.FRIED_EGG),
   RECIPE_0098(BugFablesFoodItem.LEAF_OMELET, BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.APHID_EGG),
   RECIPE_0099(BugFablesFoodItem.LEAF_OMELET, BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.FRIED_EGG),
   RECIPE_0100(BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.CRUNCHY_LEAF),
   RECIPE_0101(BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.CRUNCHY_LEAF, null),
   RECIPE_0102(BugFablesFoodItem.MIRACLE_SHAKE, BugFablesFoodItem.DARK_CHERRIES, BugFablesFoodItem.MAGIC_SEED),
   RECIPE_0103(BugFablesFoodItem.MISTAKE, BugFablesFoodItem.APHID_EGG, BugFablesFoodItem.CLEAR_WATER),
   RECIPE_0104(BugFablesFoodItem.MUSHROOM_GUMMIES, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.MUSHROOM_SKEWER),
   RECIPE_0105(BugFablesFoodItem.MUSHROOM_GUMMIES, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.MUSHROOM),
   RECIPE_0106(BugFablesFoodItem.MUSHROOM_SALAD, BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.AGARIC_SHROOM),
   RECIPE_0107(BugFablesFoodItem.MUSHROOM_SALAD, BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.COOKED_SHROOM),
   RECIPE_0108(BugFablesFoodItem.MUSHROOM_SALAD, BugFablesFoodItem.CRUNCHY_LEAF, BugFablesFoodItem.MUSHROOM),
   RECIPE_0109(BugFablesFoodItem.MUSHROOM_SALAD, BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.AGARIC_SHROOM),
   RECIPE_0110(BugFablesFoodItem.MUSHROOM_SALAD, BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.COOKED_SHROOM),
   RECIPE_0111(BugFablesFoodItem.MUSHROOM_SALAD, BugFablesFoodItem.LEAF_SALAD, BugFablesFoodItem.MUSHROOM),
   RECIPE_0112(BugFablesFoodItem.MUSHROOM_SKEWER, BugFablesFoodItem.COOKED_SHROOM, BugFablesFoodItem.COOKED_DANGER),
   RECIPE_0113(BugFablesFoodItem.MUSHROOM_SKEWER, BugFablesFoodItem.COOKED_SHROOM, BugFablesFoodItem.DANGER_SHROOM),
   RECIPE_0114(BugFablesFoodItem.MUSHROOM_SKEWER, BugFablesFoodItem.COOKED_SHROOM, BugFablesFoodItem.SWEET_DANGER),
   RECIPE_0115(BugFablesFoodItem.MUSHROOM_SKEWER, BugFablesFoodItem.DANGER_SHROOM, BugFablesFoodItem.AGARIC_SHROOM),
   RECIPE_0116(BugFablesFoodItem.MUSHROOM_SKEWER, BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.AGARIC_SHROOM),
   RECIPE_0117(BugFablesFoodItem.MUSHROOM_SKEWER, BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.COOKED_DANGER),
   RECIPE_0118(BugFablesFoodItem.MUSHROOM_SKEWER, BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.DANGER_SHROOM),
   RECIPE_0119(BugFablesFoodItem.MUSHROOM_SKEWER, BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.SWEET_DANGER),
   RECIPE_0120(BugFablesFoodItem.MUSHROOM_SKEWER, BugFablesFoodItem.SWEET_SHROOM, BugFablesFoodItem.COOKED_DANGER),
   RECIPE_0121(BugFablesFoodItem.MUSHROOM_SKEWER, BugFablesFoodItem.SWEET_SHROOM, BugFablesFoodItem.DANGER_SHROOM),
   RECIPE_0122(BugFablesFoodItem.MUSHROOM_SKEWER, BugFablesFoodItem.SWEET_SHROOM, BugFablesFoodItem.SWEET_DANGER),
   RECIPE_0123(BugFablesFoodItem.NUMB_BOMB, BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.SHOCK_BERRY),
   RECIPE_0124(BugFablesFoodItem.NUMB_BOMB, BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.SHOCK_CANDY),
   RECIPE_0125(BugFablesFoodItem.NUMB_BOMB, BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.SHOCK_BERRY),
   RECIPE_0126(BugFablesFoodItem.NUMB_BOMB, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.AGARIC_SHROOM),
   RECIPE_0127(BugFablesFoodItem.NUMB_BOMB, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.SHOCK_BERRY),
   RECIPE_0128(BugFablesFoodItem.NUMB_BOMB, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.SHOCK_CANDY),
   RECIPE_0129(BugFablesFoodItem.NUTTY_CAKE, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.HARD_SEED),
   RECIPE_0130(BugFablesFoodItem.NUTTY_CAKE, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.MYSTERY_BERRY),
   RECIPE_0131(BugFablesFoodItem.NUTTY_CAKE, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.ROASTED_BERRIES),
   RECIPE_0132(BugFablesFoodItem.PLAIN_TEA, BugFablesFoodItem.CLEAR_WATER, BugFablesFoodItem.CRUNCHY_LEAF),
   RECIPE_0133(BugFablesFoodItem.PLAIN_TEA, BugFablesFoodItem.CLEAR_WATER, BugFablesFoodItem.LEAF_SALAD),
   RECIPE_0134(BugFablesFoodItem.PLUMPLING_PIE, BugFablesFoodItem.SQUASH_CANDY, BugFablesFoodItem.BURLY_BERRY),
   RECIPE_0135(BugFablesFoodItem.PLUMPLING_PIE, BugFablesFoodItem.SQUASH_PUREE, BugFablesFoodItem.BURLY_BERRY),
   RECIPE_0136(BugFablesFoodItem.PLUMPLING_PIE, BugFablesFoodItem.SQUASH_TART, BugFablesFoodItem.BURLY_BERRY),
   RECIPE_0137(BugFablesFoodItem.PLUMPLING_PIE, BugFablesFoodItem.SQUASH, BugFablesFoodItem.BURLY_BERRY),
   RECIPE_0138(BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.DANGER_DISH),
   RECIPE_0139(BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.DANGER_SHROOM),
   RECIPE_0140(BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.DANGER_SPUD),
   RECIPE_0141(BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.DANGER_SHROOM),
   RECIPE_0142(BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.DANGER_SPUD),
   RECIPE_0143(BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.POISON_DART),
   RECIPE_0144(BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.SWEET_DANGER),
   RECIPE_0145(BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.COOKED_DANGER),
   RECIPE_0146(BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.DANGER_DISH),
   RECIPE_0147(BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.DANGER_SHROOM),
   RECIPE_0148(BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.DANGER_SPUD),
   RECIPE_0149(BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.POISON_DART),
   RECIPE_0150(BugFablesFoodItem.POISON_BOMB, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.SWEET_DANGER),
   RECIPE_0151(BugFablesFoodItem.POISON_CAKE, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.DANGER_SHROOM),
   RECIPE_0152(BugFablesFoodItem.POISON_CAKE, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.DANGER_SPUD),
   RECIPE_0153(BugFablesFoodItem.POISON_CAKE, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.POISON_DART),
   RECIPE_0154(BugFablesFoodItem.QUEENS_DINNER, BugFablesFoodItem.TANGY_CARPACCIO, BugFablesFoodItem.CRISBEE_DONUT),
   RECIPE_0155(BugFablesFoodItem.ROASTED_BERRIES, BugFablesFoodItem.BURLY_BERRY, null),
   RECIPE_0156(BugFablesFoodItem.ROASTED_BERRIES, BugFablesFoodItem.HARD_SEED, null),
   RECIPE_0157(BugFablesFoodItem.ROASTED_BERRIES, BugFablesFoodItem.HUSTLE_BERRY, null),
   RECIPE_0158(BugFablesFoodItem.ROASTED_BERRIES, BugFablesFoodItem.SPICY_BERRY, null),
   RECIPE_0159(BugFablesFoodItem.SHAVED_ICE, BugFablesFoodItem.MAGIC_ICE, null),
   RECIPE_0160(BugFablesFoodItem.SHOCK_CANDY, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.AGARIC_SHROOM),
   RECIPE_0161(BugFablesFoodItem.SHOCK_CANDY, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.SHOCK_BERRY),
   RECIPE_0162(BugFablesFoodItem.SLEEP_BOMB, BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.DROWSY_CAKE),
   RECIPE_0163(BugFablesFoodItem.SLEEP_BOMB, BugFablesFoodItem.BURLY_BOMB, BugFablesFoodItem.NUMBNAIL_DART),
   RECIPE_0164(BugFablesFoodItem.SLEEP_BOMB, BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.NUMBNAIL_DART),
   RECIPE_0165(BugFablesFoodItem.SLEEP_BOMB, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.DROWSY_CAKE),
   RECIPE_0166(BugFablesFoodItem.SLEEP_BOMB, BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.NUMBNAIL_DART),
   RECIPE_0167(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.FLAME_ROCK, BugFablesFoodItem.SPICY_BERRY),
   RECIPE_0168(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.FLAME_ROCK, null),
   RECIPE_0169(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.HARD_SEED, BugFablesFoodItem.SPICY_BERRY),
   RECIPE_0170(BugFablesFoodItem.SPICY_BOMB, BugFablesFoodItem.MYSTERY_BERRY, BugFablesFoodItem.SPICY_BERRY),
   RECIPE_0171(BugFablesFoodItem.SPICY_CANDY, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.FLAME_ROCK),
   RECIPE_0172(BugFablesFoodItem.SPICY_CANDY, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.SPICY_BERRY),
   RECIPE_0173(BugFablesFoodItem.SPICY_FRIES, BugFablesFoodItem.BAKED_YAM, BugFablesFoodItem.SPICY_BERRY),
   RECIPE_0174(BugFablesFoodItem.SPICY_FRIES, BugFablesFoodItem.DANGER_SPUD, BugFablesFoodItem.SPICY_BERRY),
   RECIPE_0175(BugFablesFoodItem.SPICY_TEA, BugFablesFoodItem.PLAIN_TEA, BugFablesFoodItem.SPICY_BERRY),
   RECIPE_0176(BugFablesFoodItem.SQUASH_CANDY, BugFablesFoodItem.SQUASH_PUREE, BugFablesFoodItem.BAG_OF_FLOUR),
   RECIPE_0177(BugFablesFoodItem.SQUASH_CANDY, BugFablesFoodItem.SQUASH, BugFablesFoodItem.BAG_OF_FLOUR),
   RECIPE_0178(BugFablesFoodItem.SQUASH_PUREE, BugFablesFoodItem.SQUASH, null),
   RECIPE_0179(BugFablesFoodItem.SQUASH_TART, BugFablesFoodItem.SQUASH_CANDY, BugFablesFoodItem.SPICY_BERRY),
   RECIPE_0180(BugFablesFoodItem.SQUASH_TART, BugFablesFoodItem.SQUASH_PUREE, BugFablesFoodItem.SPICY_BERRY),
   RECIPE_0181(BugFablesFoodItem.SQUASH_TART, BugFablesFoodItem.SQUASH, BugFablesFoodItem.SPICY_BERRY),
   RECIPE_0182(BugFablesFoodItem.SUCCULENT_COOKIES, BugFablesFoodItem.SUCCULENT_BERRY, BugFablesFoodItem.BAG_OF_FLOUR),
   RECIPE_0183(BugFablesFoodItem.SUCCULENT_COOKIES, BugFablesFoodItem.SUCCULENT_PLATTER, BugFablesFoodItem.BAG_OF_FLOUR),
   RECIPE_0184(BugFablesFoodItem.SUCCULENT_PLATTER, BugFablesFoodItem.DARK_CHERRIES, null),
   RECIPE_0185(BugFablesFoodItem.SUCCULENT_PLATTER, BugFablesFoodItem.SUCCULENT_BERRY, null),
   RECIPE_0186(BugFablesFoodItem.SWEET_DANGER, BugFablesFoodItem.DANGER_SHROOM, BugFablesFoodItem.GLAZED_HONEY),
   RECIPE_0187(BugFablesFoodItem.SWEET_DANGER, BugFablesFoodItem.DANGER_SHROOM, BugFablesFoodItem.HONEY_DROP),
   RECIPE_0188(BugFablesFoodItem.SWEET_DEW, BugFablesFoodItem.APHID_DEW, BugFablesFoodItem.GLAZED_HONEY),
   RECIPE_0189(BugFablesFoodItem.SWEET_DEW, BugFablesFoodItem.APHID_DEW, BugFablesFoodItem.HONEY_DROP),
   RECIPE_0190(BugFablesFoodItem.SWEET_PUDDING, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.APHID_DEW),
   RECIPE_0191(BugFablesFoodItem.SWEET_PUDDING, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.APHID_EGG),
   RECIPE_0192(BugFablesFoodItem.SWEET_PUDDING, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.FRIED_EGG),
   RECIPE_0193(BugFablesFoodItem.SWEET_SHROOM, BugFablesFoodItem.AGARIC_SHROOM, BugFablesFoodItem.HONEY_DROP),
   RECIPE_0194(BugFablesFoodItem.SWEET_SHROOM, BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.GLAZED_HONEY),
   RECIPE_0195(BugFablesFoodItem.SWEET_SHROOM, BugFablesFoodItem.MUSHROOM, BugFablesFoodItem.HONEY_DROP),
   RECIPE_0196(BugFablesFoodItem.TANGY_CARPACCIO, BugFablesFoodItem.TANGY_BERRY, null),
   RECIPE_0197(BugFablesFoodItem.TANGY_JAM, BugFablesFoodItem.TANGY_BERRY, BugFablesFoodItem.GLAZED_HONEY),
   RECIPE_0198(BugFablesFoodItem.TANGY_JAM, BugFablesFoodItem.TANGY_BERRY, BugFablesFoodItem.HONEY_DROP),
   RECIPE_0199(BugFablesFoodItem.TANGY_JUICE, BugFablesFoodItem.TANGY_BERRY, BugFablesFoodItem.BERRY_JUICE),
   RECIPE_0200(BugFablesFoodItem.TANGY_JUICE, BugFablesFoodItem.TANGY_BERRY, BugFablesFoodItem.CLEAR_WATER),
   RECIPE_0201(BugFablesFoodItem.TANGY_JUICE, BugFablesFoodItem.TANGY_JAM, BugFablesFoodItem.BERRY_JUICE),
   RECIPE_0202(BugFablesFoodItem.TANGY_PIE, BugFablesFoodItem.TANGY_BERRY, BugFablesFoodItem.BAG_OF_FLOUR),
   RECIPE_0203(BugFablesFoodItem.TANGY_PIE, BugFablesFoodItem.TANGY_JAM, BugFablesFoodItem.BAG_OF_FLOUR),
   RECIPE_0204(BugFablesFoodItem.YAM_BREAD, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.BAKED_YAM),
   RECIPE_0205(BugFablesFoodItem.YAM_BREAD, BugFablesFoodItem.BAG_OF_FLOUR, BugFablesFoodItem.DANGER_SPUD),

   ;

   /** Final product that this recipe is creating. */
   private final BugFablesFoodItem finalProduct;

	/** EnumBag of ingredients for the recipe. */
   private final EnumBag<BugFablesFoodItem> recipe = new EnumBag<BugFablesFoodItem>(BugFablesFoodItem.class);
   
   /**
    * 
    */
   private final Set<BugFablesLocation> tier1Locations;
   
   /**
    * 
    */
   private final Set<BugFablesLocation> tier2Locations;

   /** Constructor. */
   BugFablesRecipe(BugFablesFoodItem finalProduct, BugFablesFoodItem ingredientA, BugFablesFoodItem ingredientB)
   {
      
      this.finalProduct = finalProduct;
      
      this.recipe.add(ingredientA);
      this.recipe.add(ingredientB);
      
      this.tier1Locations = 
         Collections.unmodifiableSet(
            AlgorithmPathFinder.findTier1Locations(
               this.recipe.keySet())); // I really wanted to just hand over the recipe, but it didn't work when I tried.
   
      this.tier2Locations = 
         Collections.unmodifiableSet(
            AlgorithmPathFinder.findTier2Locations(
               this.recipe.keySet()));
   
   }
   
   public BugFablesFoodItem getFinalProduct()
   {
   
      return this.finalProduct;
   
   }
   
   /** This is too delicate to just hand out. So, we control access to this EnumBag by sending it out as an unmodifiableMap. */
   public Map<BugFablesFoodItem, Integer> getIngredients()
   {
   
      return this.recipe.toMap();
   
   }
   
   /** Returns a set of all locations that contain ALL ingredients from a recipe */
   public Set<BugFablesLocation> getTier1Locations()
   {
   
      return this.tier1Locations;
   
   }
   
   /** Returns a set of all locations that contain ALL ingredients from a recipe, but may require some extra cooking. */
   public Set<BugFablesLocation> getTier2Locations()
   {
   
      return this.tier2Locations;
   
   }
   
   public static Set<BugFablesRecipe> getAllRecipesForRecipeBook(String recipeBook)
   {
   
      Set<BugFablesRecipe> recipes = EnumSet.noneOf(BugFablesRecipe.class);
      
      if (recipeBook != null)
      {
      
         BugFablesFoodItem foodItem = BugFablesFoodItem.valueOf(recipeBook);
      
         for (BugFablesRecipe recipe : BugFablesRecipe.values())
         {
         
            if (recipe.getFinalProduct() == foodItem)
            {
            
               recipes.add(recipe);
            
            }
         
         }
      
      }
      
      return recipes;
   
   }
   
   public static Set<BugFablesRecipe> getAllRecipesForFinalProduct(BugFablesFoodItem finalProduct)
   {
   
      Set<BugFablesRecipe> recipes = EnumSet.noneOf(BugFablesRecipe.class);
      
      if (finalProduct != null)
      {
      
         for (BugFablesRecipe recipe : BugFablesRecipe.values())
         {
         
            if (recipe.getFinalProduct() == finalProduct)
            {
            
               recipes.add(recipe);
            
            }
         
         }
      
      }
      
      return recipes;
   
   }
   
   public String toString()
   {
   
      return this.finalProduct.name() + this.recipe.toString();
   
   }
   
}
