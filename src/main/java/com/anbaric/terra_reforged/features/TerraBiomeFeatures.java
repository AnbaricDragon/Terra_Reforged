package com.anbaric.terra_reforged.features;

import com.anbaric.terra_reforged.TerraReforged;
import com.anbaric.terra_reforged.util.init.TerraBlockRegistry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.sun.org.apache.xpath.internal.operations.Or;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TerraBiomeFeatures
{
    //Vanilla Blocks
    public static final BlockState STONE = Blocks.STONE.getDefaultState();
    public static final BlockState GRANITE = Blocks.GRANITE.getDefaultState();
    public static final BlockState DIORITE = Blocks.DIORITE.getDefaultState();
    public static final BlockState ANDESITE = Blocks.ANDESITE.getDefaultState();
    public static final BlockState DIRT = Blocks.DIRT.getDefaultState();
    public static final BlockState SAND = Blocks.SAND.getDefaultState();
    public static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
    public static final BlockState CLAY = Blocks.CLAY.getDefaultState();
    public static final BlockState SNOW = Blocks.SNOW_BLOCK.getDefaultState();
    public static final BlockState ICE = Blocks.ICE.getDefaultState();
    public static final BlockState PACKED_ICE = Blocks.PACKED_ICE.getDefaultState();

    //Terra Blocks
    public static final BlockState SOIL_MUD = TerraBlockRegistry.SOIL_MUD.get().getDefaultState();
    public static final BlockState GRASS_JUNGLE = TerraBlockRegistry.GRASS_JUNGLE.get().getDefaultState();
    public static final BlockState SLUSH = TerraBlockRegistry.SAND_SLUSH.get().getDefaultState();
    public static final BlockState THIN_ICE = TerraBlockRegistry.ICE_THIN.get().getDefaultState();
    public static final BlockState BOREAL_LOG = TerraBlockRegistry.LOG_BOREAL.get().getDefaultState();
    public static final BlockState BOREAL_LEAF = TerraBlockRegistry.LEAF_BOREAL.get().getDefaultState();
    public static final BlockState PALM_LOG = TerraBlockRegistry.LOG_PALM.get().getDefaultState();
    public static final BlockState PALM_LEAF = TerraBlockRegistry.LEAF_PALM.get().getDefaultState();
    public static final BlockState MAHOGANY_LOG = TerraBlockRegistry.LOG_MAHOGANY.get().getDefaultState();
    public static final BlockState MAHOGANY_LEAF = TerraBlockRegistry.LEAF_MAHOGANY.get().getDefaultState();
    public static final BlockState EBON_LOG = TerraBlockRegistry.LOG_EBON.get().getDefaultState();
    public static final BlockState EBON_LEAF = TerraBlockRegistry.LEAF_EBON.get().getDefaultState();
    public static final BlockState SHADE_LOG = TerraBlockRegistry.LOG_SHADE.get().getDefaultState();
    public static final BlockState SHADE_LEAF = TerraBlockRegistry.LEAF_SHADE.get().getDefaultState();
    public static final BlockState PEARL_LOG = TerraBlockRegistry.LOG_PEARL.get().getDefaultState();
    public static final BlockState PEARL_LEAF_BLUE = TerraBlockRegistry.LEAF_PEARL_BLUE.get().getDefaultState();
    public static final BlockState PEARL_LEAF_CYAN = TerraBlockRegistry.LEAF_PEARL_CYAN.get().getDefaultState();
    public static final BlockState PEARL_LEAF_GREEN = TerraBlockRegistry.LEAF_PEARL_GREEN.get().getDefaultState();
    public static final BlockState PEARL_LEAF_MAGENTA = TerraBlockRegistry.LEAF_PEARL_MAGENTA.get().getDefaultState();
    public static final BlockState PEARL_LEAF_PINK = TerraBlockRegistry.LEAF_PEARL_PINK.get().getDefaultState();
    public static final BlockState PEARL_LEAF_PURPLE = TerraBlockRegistry.LEAF_PEARL_PURPLE.get().getDefaultState();
    public static final BlockState PEARL_LEAF_RED = TerraBlockRegistry.LEAF_PEARL_RED.get().getDefaultState();
    public static final BlockState PEARL_LEAF_YELLOW = TerraBlockRegistry.LEAF_PEARL_YELLOW.get().getDefaultState();
    public static final BlockState HELLSTONE_ORE = TerraBlockRegistry.ORE_HELLSTONE.get().getDefaultState();
    public static final BlockState CHLOROPHYTE_ORE = TerraBlockRegistry.ORE_CHLOROPHYTE.get().getDefaultState();

    //Pure Blocks
    public static final BlockState COPPER_ORE = TerraBlockRegistry.ORE_COPPER_PURE.get().getDefaultState();
    public static final BlockState TIN_ORE = TerraBlockRegistry.ORE_TIN_PURE.get().getDefaultState();
    public static final BlockState IRON_ORE = Blocks.IRON_ORE.getDefaultState();
    public static final BlockState LEAD_ORE = TerraBlockRegistry.ORE_LEAD_PURE.get().getDefaultState();
    public static final BlockState SILVER_ORE = TerraBlockRegistry.ORE_SILVER_PURE.get().getDefaultState();
    public static final BlockState TUNGSTEN_ORE = TerraBlockRegistry.ORE_TUNGSTEN_PURE.get().getDefaultState();
    public static final BlockState GOLD_ORE = Blocks.GOLD_ORE.getDefaultState();
    public static final BlockState PLATINUM_ORE = TerraBlockRegistry.ORE_PLATINUM_PURE.get().getDefaultState();
    public static final BlockState DEMONITE_ORE = TerraBlockRegistry.ORE_DEMONITE_PURE.get().getDefaultState();
    public static final BlockState CRIMTANE_ORE = TerraBlockRegistry.ORE_CRIMTANE_PURE.get().getDefaultState();
    public static final BlockState COAL_ORE = Blocks.COAL_ORE.getDefaultState();
    public static final BlockState REDSTONE_ORE = Blocks.REDSTONE_ORE.getDefaultState();
    public static final BlockState LAPIS_ORE = Blocks.LAPIS_ORE.getDefaultState();
    public static final BlockState DIAMOND_ORE = Blocks.DIAMOND_ORE.getDefaultState();
    public static final BlockState EMERALD_ORE = Blocks.EMERALD_ORE.getDefaultState();
    public static final BlockState AMETHYST_ORE = TerraBlockRegistry.ORE_AMETHYST_PURE.get().getDefaultState();
    public static final BlockState SAPPHIRE_ORE = TerraBlockRegistry.ORE_SAPPHIRE_PURE.get().getDefaultState();
    public static final BlockState TOPAZ_ORE = TerraBlockRegistry.ORE_TOPAZ_PURE.get().getDefaultState();
    public static final BlockState RUBY_ORE = TerraBlockRegistry.ORE_RUBY_PURE.get().getDefaultState();

    //Corrupt Blocks
    public static final BlockState CORRUPT_SNOW = TerraBlockRegistry.SNOW_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_ICE = TerraBlockRegistry.ICE_PURPLE.get().getDefaultState();
    public static final BlockState CORRUPT_PACKED_ICE = TerraBlockRegistry.ICE_HARD_PURPLE.get().getDefaultState();
    public static final BlockState CORRUPT_COPPER_ORE = TerraBlockRegistry.ORE_COPPER_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_TIN_ORE = TerraBlockRegistry.ORE_TIN_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_IRON_ORE = TerraBlockRegistry.ORE_IRON_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_LEAD_ORE = TerraBlockRegistry.ORE_LEAD_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_SILVER_ORE = TerraBlockRegistry.ORE_SILVER_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_TUNGSTEN_ORE = TerraBlockRegistry.ORE_TUNGSTEN_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_GOLD_ORE = TerraBlockRegistry.ORE_GOLD_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_PLATINUM_ORE = TerraBlockRegistry.ORE_PLATINUM_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_DEMONITE_ORE = TerraBlockRegistry.ORE_DEMONITE_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_CRIMTANE_ORE = TerraBlockRegistry.ORE_CRIMTANE_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_COAL_ORE = TerraBlockRegistry.ORE_COAL_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_REDSTONE_ORE = TerraBlockRegistry.ORE_REDSTONE_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_LAPIS_ORE = TerraBlockRegistry.ORE_LAPIS_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_DIAMOND_ORE = TerraBlockRegistry.ORE_DIAMOND_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_EMERALD_ORE = TerraBlockRegistry.ORE_EMERALD_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_AMETHYST_ORE = TerraBlockRegistry.ORE_AMETHYST_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_SAPPHIRE_ORE = TerraBlockRegistry.ORE_SAPPHIRE_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_TOPAZ_ORE = TerraBlockRegistry.ORE_TOPAZ_CORRUPT.get().getDefaultState();
    public static final BlockState CORRUPT_RUBY_ORE = TerraBlockRegistry.ORE_RUBY_CORRUPT.get().getDefaultState();

    //Crimson Blocks
    public static final BlockState CRIMSON_SNOW = TerraBlockRegistry.SNOW_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_ICE = TerraBlockRegistry.ICE_RED.get().getDefaultState();
    public static final BlockState CRIMSON_PACKED_ICE = TerraBlockRegistry.ICE_HARD_RED.get().getDefaultState();
    public static final BlockState CRIMSON_COPPER_ORE = TerraBlockRegistry.ORE_COPPER_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_TIN_ORE = TerraBlockRegistry.ORE_TIN_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_IRON_ORE = TerraBlockRegistry.ORE_IRON_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_LEAD_ORE = TerraBlockRegistry.ORE_LEAD_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_SILVER_ORE = TerraBlockRegistry.ORE_SILVER_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_TUNGSTEN_ORE = TerraBlockRegistry.ORE_TUNGSTEN_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_GOLD_ORE = TerraBlockRegistry.ORE_GOLD_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_PLATINUM_ORE = TerraBlockRegistry.ORE_PLATINUM_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_DEMONITE_ORE = TerraBlockRegistry.ORE_DEMONITE_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_CRIMTANE_ORE = TerraBlockRegistry.ORE_CRIMTANE_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_COAL_ORE = TerraBlockRegistry.ORE_COAL_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_REDSTONE_ORE = TerraBlockRegistry.ORE_REDSTONE_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_LAPIS_ORE = TerraBlockRegistry.ORE_LAPIS_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_DIAMOND_ORE = TerraBlockRegistry.ORE_DIAMOND_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_EMERALD_ORE = TerraBlockRegistry.ORE_EMERALD_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_AMETHYST_ORE = TerraBlockRegistry.ORE_AMETHYST_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_SAPPHIRE_ORE = TerraBlockRegistry.ORE_SAPPHIRE_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_TOPAZ_ORE = TerraBlockRegistry.ORE_TOPAZ_CRIMSON.get().getDefaultState();
    public static final BlockState CRIMSON_RUBY_ORE = TerraBlockRegistry.ORE_RUBY_CRIMSON.get().getDefaultState();

    //Hallowed Blocks
    public static final BlockState HALLOWED_SNOW = TerraBlockRegistry.SNOW_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_ICE = TerraBlockRegistry.ICE_PINK.get().getDefaultState();
    public static final BlockState HALLOWED_PACKED_ICE = TerraBlockRegistry.ICE_HARD_PINK.get().getDefaultState();
    public static final BlockState HALLOWED_COPPER_ORE = TerraBlockRegistry.ORE_COPPER_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_TIN_ORE = TerraBlockRegistry.ORE_TIN_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_IRON_ORE = TerraBlockRegistry.ORE_IRON_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_LEAD_ORE = TerraBlockRegistry.ORE_LEAD_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_SILVER_ORE = TerraBlockRegistry.ORE_SILVER_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_TUNGSTEN_ORE = TerraBlockRegistry.ORE_TUNGSTEN_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_GOLD_ORE = TerraBlockRegistry.ORE_GOLD_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_PLATINUM_ORE = TerraBlockRegistry.ORE_PLATINUM_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_DEMONITE_ORE = TerraBlockRegistry.ORE_DEMONITE_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_CRIMTANE_ORE = TerraBlockRegistry.ORE_CRIMTANE_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_COAL_ORE = TerraBlockRegistry.ORE_COAL_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_REDSTONE_ORE = TerraBlockRegistry.ORE_REDSTONE_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_LAPIS_ORE = TerraBlockRegistry.ORE_LAPIS_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_DIAMOND_ORE = TerraBlockRegistry.ORE_DIAMOND_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_EMERALD_ORE = TerraBlockRegistry.ORE_EMERALD_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_AMETHYST_ORE = TerraBlockRegistry.ORE_AMETHYST_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_SAPPHIRE_ORE = TerraBlockRegistry.ORE_SAPPHIRE_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_TOPAZ_ORE = TerraBlockRegistry.ORE_TOPAZ_HALLOWED.get().getDefaultState();
    public static final BlockState HALLOWED_RUBY_ORE = TerraBlockRegistry.ORE_RUBY_HALLOWED.get().getDefaultState();

    public static final TreeFeatureConfig BOREAL_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BOREAL_LOG), new SimpleBlockStateProvider(BOREAL_LEAF), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) TerraBlockRegistry.SAPLING_BOREAL.get()).build();
    public static final TreeFeatureConfig PALM_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PALM_LOG), new SimpleBlockStateProvider(PALM_LEAF), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) TerraBlockRegistry.SAPLING_PALM.get()).build();
    public static final TreeFeatureConfig MAHOGANY_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(MAHOGANY_LOG), new SimpleBlockStateProvider(MAHOGANY_LEAF), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) TerraBlockRegistry.SAPLING_MAHOGANY.get()).build();
    public static final TreeFeatureConfig EBON_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(EBON_LOG), new SimpleBlockStateProvider(EBON_LEAF), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) TerraBlockRegistry.SAPLING_EBON.get()).build();
    public static final TreeFeatureConfig SHADE_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(SHADE_LOG), new SimpleBlockStateProvider(SHADE_LEAF), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) TerraBlockRegistry.SAPLING_SHADE.get()).build();
    public static final TreeFeatureConfig PEARL_TREE_BLUE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PEARL_LOG), new SimpleBlockStateProvider(PEARL_LEAF_BLUE), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) TerraBlockRegistry.SAPLING_PEARL.get()).build();
    public static final TreeFeatureConfig PEARL_TREE_CYAN_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PEARL_LOG), new SimpleBlockStateProvider(PEARL_LEAF_CYAN), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) TerraBlockRegistry.SAPLING_PEARL.get()).build();
    public static final TreeFeatureConfig PEARL_TREE_GREEN_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PEARL_LOG), new SimpleBlockStateProvider(PEARL_LEAF_GREEN), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) TerraBlockRegistry.SAPLING_PEARL.get()).build();
    public static final TreeFeatureConfig PEARL_TREE_MAGENTA_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PEARL_LOG), new SimpleBlockStateProvider(PEARL_LEAF_MAGENTA), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) TerraBlockRegistry.SAPLING_PEARL.get()).build();
    public static final TreeFeatureConfig PEARL_TREE_PINK_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PEARL_LOG), new SimpleBlockStateProvider(PEARL_LEAF_PINK), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) TerraBlockRegistry.SAPLING_PEARL.get()).build();
    public static final TreeFeatureConfig PEARL_TREE_PURPLE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PEARL_LOG), new SimpleBlockStateProvider(PEARL_LEAF_PURPLE), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) TerraBlockRegistry.SAPLING_PEARL.get()).build();
    public static final TreeFeatureConfig PEARL_TREE_RED_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PEARL_LOG), new SimpleBlockStateProvider(PEARL_LEAF_RED), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) TerraBlockRegistry.SAPLING_PEARL.get()).build();
    public static final TreeFeatureConfig PEARL_TREE_YELLOW_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PEARL_LOG), new SimpleBlockStateProvider(PEARL_LEAF_YELLOW), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) TerraBlockRegistry.SAPLING_PEARL.get()).build();

    public static void addEbonTrees(Biome biome)
    {

    }

    public static void addPearlTrees(Biome biomeIn)
    {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.FANCY_TREE.withConfiguration(PEARL_TREE_BLUE_CONFIG).withChance(0.1F), Feature.FANCY_TREE.withConfiguration(PEARL_TREE_CYAN_CONFIG).withChance(0.1F), Feature.FANCY_TREE.withConfiguration(PEARL_TREE_GREEN_CONFIG).withChance(0.1F), Feature.FANCY_TREE.withConfiguration(PEARL_TREE_MAGENTA_CONFIG).withChance(0.1F), Feature.FANCY_TREE.withConfiguration(PEARL_TREE_PINK_CONFIG).withChance(0.1F), Feature.FANCY_TREE.withConfiguration(PEARL_TREE_PURPLE_CONFIG).withChance(0.1F), Feature.FANCY_TREE.withConfiguration(PEARL_TREE_RED_CONFIG).withChance(0.1F)), Feature.FANCY_TREE.withConfiguration(PEARL_TREE_YELLOW_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));
    }

    public static void addPureOres(Biome biomeIn)
    {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, COPPER_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(15, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, TIN_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(15, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, IRON_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(13, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, LEAD_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(13, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, SILVER_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, TUNGSTEN_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, GOLD_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(6, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, PLATINUM_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(6, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, DEMONITE_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 4))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, CRIMTANE_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 4))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, COAL_ORE, 12)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, REDSTONE_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 16))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, DIAMOND_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, EMERALD_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, RUBY_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, SAPPHIRE_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, TOPAZ_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, AMETHYST_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(PURE, LAPIS_ORE, 7)).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 16, 16))));
    }

    public static void addCorruptOres(Biome biomeIn)
    {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_COPPER_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(15, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_TIN_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(15, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_IRON_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(13, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_LEAD_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(13, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_SILVER_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_TUNGSTEN_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_GOLD_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(6, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_PLATINUM_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(6, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_DEMONITE_ORE, 6)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 8))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_CRIMTANE_ORE, 3)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 4))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_COAL_ORE, 12)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_REDSTONE_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 16))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_DIAMOND_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_EMERALD_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_RUBY_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_SAPPHIRE_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_TOPAZ_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_AMETHYST_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CORRUPT, CORRUPT_LAPIS_ORE, 7)).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 16, 16))));
    }

    public static void addCrimsonOres(Biome biomeIn)
    {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_COPPER_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(15, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_TIN_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(15, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_IRON_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(13, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_LEAD_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(13, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_SILVER_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_TUNGSTEN_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_GOLD_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(6, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_PLATINUM_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(6, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_DEMONITE_ORE, 3)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 4))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_CRIMTANE_ORE, 6)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 8))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_COAL_ORE, 12)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_REDSTONE_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 16))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_DIAMOND_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_EMERALD_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_RUBY_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_SAPPHIRE_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_TOPAZ_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_AMETHYST_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(CRIMSON, CRIMSON_LAPIS_ORE, 7)).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 16, 16))));
    }

    public static void addHallowedOres(Biome biomeIn)
    {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_COPPER_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(15, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_TIN_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(15, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_IRON_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(13, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_LEAD_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(13, 0, 0, 64))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_SILVER_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_TUNGSTEN_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_GOLD_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(6, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_PLATINUM_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(6, 0, 0, 32))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_COAL_ORE, 12)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_REDSTONE_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 16))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_DIAMOND_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_EMERALD_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_RUBY_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_SAPPHIRE_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_TOPAZ_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_AMETHYST_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 7))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(HALLOWED, HALLOWED_LAPIS_ORE, 7)).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 16, 16))));
    }

    public static void addSedimentDisks(Biome biomeIn, BlockState gravel)
    {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(SAND, 7, 2, Lists.newArrayList(SNOW, ICE, PACKED_ICE, SOIL_MUD, GRASS_JUNGLE))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(3))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(CLAY, 4, 1, Lists.newArrayList(SNOW, ICE, PACKED_ICE, SOIL_MUD, CLAY))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(gravel, 6, 2, Lists.newArrayList(SNOW, ICE, PACKED_ICE, SOIL_MUD, GRASS_JUNGLE))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
    }

    public static void addStoneVariants(Biome biomeIn, OreFeatureConfig.FillerBlockType type)
    {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(type, DIRT, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 256))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(type, GRAVEL, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(5, 0, 0, 256))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(type, GRANITE, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(6, 0, 0, 80))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(type, DIORITE, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(6, 0, 0, 80))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(type, ANDESITE, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(6, 0, 0, 80))));
    }

    public static void addIceVariants(Biome biomeIn, OreFeatureConfig.FillerBlockType type, BlockState snow, BlockState ice, BlockState packedIce)
    {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(type, DIRT, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 256))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(type, SLUSH, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(5, 0, 0, 256))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(type, THIN_ICE, 66)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 20))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(type, snow, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 256))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(type, ice, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 256))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(type, packedIce, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 256))));
    }

    public static final Predicate<BlockState>
        PURE_PREDICATE = blockState -> blockState.getBlock() == Blocks.STONE ||
           blockState.getBlock() == Blocks.ANDESITE ||
           blockState.getBlock() == Blocks.DIORITE ||
           blockState.getBlock() == Blocks.GRANITE ||
           blockState.getBlock() == Blocks.SANDSTONE ||
           blockState.getBlock() == Blocks.ICE ||
           blockState.getBlock() == Blocks.PACKED_ICE ||
           blockState.getBlock() == TerraBlockRegistry.SOIL_MUD.get();
    public static final Predicate<BlockState>
            CORRUPT_PREDICATE =
            blockState -> blockState.getBlock() == TerraBlockRegistry.STONE_EBON.get() ||
                          blockState.getBlock() == TerraBlockRegistry.SAND_EBON.get() ||
                          blockState.getBlock() == TerraBlockRegistry.SANDSTONE_EBON.get() ||
                          blockState.getBlock() == TerraBlockRegistry.SAND_HARDEBON.get() ||
                          blockState.getBlock() == TerraBlockRegistry.ICE_PURPLE.get() ||
                          blockState.getBlock() == TerraBlockRegistry.ICE_HARD_PURPLE.get();
    public static final Predicate<BlockState>
            CRIMSON_PREDICATE =
            blockState -> blockState.getBlock() == TerraBlockRegistry.STONE_CRIM.get() ||
                          blockState.getBlock() == TerraBlockRegistry.SAND_CRIM.get() ||
                          blockState.getBlock() == TerraBlockRegistry.SANDSTONE_CRIM.get() ||
                          blockState.getBlock() == TerraBlockRegistry.SAND_HARDCRIM.get() ||
                          blockState.getBlock() == TerraBlockRegistry.ICE_RED.get() ||
                          blockState.getBlock() == TerraBlockRegistry.ICE_HARD_RED.get();
    public static final Predicate<BlockState>
            HALLOWED_PREDICATE =
            blockState -> blockState.getBlock() == TerraBlockRegistry.STONE_PEARL.get() ||
                          blockState.getBlock() == TerraBlockRegistry.SAND_PEARL.get() ||
                          blockState.getBlock() == TerraBlockRegistry.SANDSTONE_PEARL.get() ||
                          blockState.getBlock() == TerraBlockRegistry.SAND_HARDPEARL.get() ||
                          blockState.getBlock() == TerraBlockRegistry.ICE_PINK.get() ||
                          blockState.getBlock() == TerraBlockRegistry.ICE_HARD_PINK.get();

    public static final OreFeatureConfig.FillerBlockType PURE = OreFeatureConfig.FillerBlockType.create("JUNGLE", null, PURE_PREDICATE);
    public static final OreFeatureConfig.FillerBlockType CORRUPT = OreFeatureConfig.FillerBlockType.create("CORRUPT", null, CORRUPT_PREDICATE);
    public static final OreFeatureConfig.FillerBlockType CRIMSON = OreFeatureConfig.FillerBlockType.create("CRIMSON", null, CRIMSON_PREDICATE);
    public static final OreFeatureConfig.FillerBlockType HALLOWED = OreFeatureConfig.FillerBlockType.create("HALLOWED", null, HALLOWED_PREDICATE);
}