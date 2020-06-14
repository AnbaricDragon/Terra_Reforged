package com.anbaric.terra_reforged.biomes;

import com.anbaric.terra_reforged.features.TerraBiomeFeatures;
import com.anbaric.terra_reforged.features.carvers.TerraWorldCarver;
import com.anbaric.terra_reforged.util.init.TerraSurfaceBuilderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class TerraBiomeSnowCrimson extends Biome
{
    private static final BlockState WATER = Blocks.WATER.getDefaultState();

    public TerraBiomeSnowCrimson(Builder biomeBuilder)
    {
        super(biomeBuilder
                .precipitation(RainType.SNOW).category(Category.ICY).depth(0.125F).scale(0.02F).temperature(0.0F).downfall(0.5F).waterColor(6821670).waterFogColor(7804710).parent("crimson")
                .surfaceBuilder(TerraSurfaceBuilderRegistry.SNOW_CRIMSON, TerraSurfaceBuilderRegistry.SNOW_CRIMSON_CONFIG)
        );
        this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(TerraWorldCarver.TERRA_SNOW_CAVES, new ProbabilityConfig(0.7F)));
        TerraBiomeFeatures.addIceVariants(this, TerraBiomeFeatures.CRIMSON, TerraBiomeFeatures.CRIMSON_SNOW, TerraBiomeFeatures.CRIMSON_ICE, TerraBiomeFeatures.CRIMSON_PACKED_ICE);
        TerraBiomeFeatures.addCrimsonOres(this);
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, Feature.MINESHAFT.withConfiguration(new MineshaftConfig((double)0.004F, MineshaftStructure.Type.NORMAL)).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(WATER)).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
    }
}