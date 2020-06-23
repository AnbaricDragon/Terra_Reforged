package com.anbaric.terra_reforged.biomes.crimson;

import com.anbaric.terra_reforged.features.TerraBiomeFeatures;
import com.anbaric.terra_reforged.util.init.TerraSurfaceBuilderRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.VillageConfig;

public class TerraBiomePlainsCrimson extends Biome
{
    public TerraBiomePlainsCrimson(Builder biomeBuilder)
    {
        super(new Builder()
                .surfaceBuilder(TerraSurfaceBuilderRegistry.BASE_CRIMSON, TerraSurfaceBuilderRegistry.GRASS_CRIMSON_CONFIG).precipitation(RainType.RAIN).category(Category.PLAINS)
                .depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).waterColor(6821670).waterFogColor(7804710).parent("crimson"));
        this.addStructure(Feature.VILLAGE.withConfiguration(new VillageConfig("village/plains/town_centers", 6)));
        this.addStructure(Feature.PILLAGER_OUTPOST.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
        this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        TerraBiomeFeatures.addCarvers(this);
        DefaultBiomeFeatures.addStructures(this);
        DefaultBiomeFeatures.addLakes(this);
        DefaultBiomeFeatures.addMonsterRooms(this);
        TerraBiomeFeatures.addDoubleGrass(this, TerraBiomeFeatures.CRIMSON_DOUBLE_TALL_GRASS_CONFIG);
        TerraBiomeFeatures.addDyeFlowers(this);
        TerraBiomeFeatures.addStoneVariants(this, TerraBiomeFeatures.CRIMSON);
        TerraBiomeFeatures.addCrimsonOres(this);
        TerraBiomeFeatures.addSedimentDisks(this, TerraBiomeFeatures.GRAVEL, TerraBiomeFeatures.CRIMSON_SAND);
        TerraBiomeFeatures.addShadeTreesGrass(this);
        DefaultBiomeFeatures.addMushrooms(this);
        TerraBiomeFeatures.addReedsAndPumpkins(this, TerraBiomeFeatures.CRIMSON_SUGAR_CANE_CONFIG);
        DefaultBiomeFeatures.addSprings(this);
        //TerraBiomeFeatures.addCrimsonSnowLayer(this);
    }
}