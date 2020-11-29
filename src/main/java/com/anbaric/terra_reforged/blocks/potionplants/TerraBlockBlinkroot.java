package com.anbaric.terra_reforged.blocks.potionplants;

import com.anbaric.terra_reforged.util.init.TerraBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.PlantType;

import java.util.Random;

public class TerraBlockBlinkroot extends TerraBlockPotionPlant
{
    public TerraBlockBlinkroot(Properties builder)
    {
        super(builder, 0);
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        Block target = state.getBlock();
        return target == Blocks.DIRT || target == Blocks.GRASS_BLOCK || target == TerraBlockRegistry.GRASS_CORRUPT.get() || target == TerraBlockRegistry.GRASS_CRIMSON.get() || target == TerraBlockRegistry.GRASS_HALLOWED.get() || target == Blocks.STONE || target == TerraBlockRegistry.STONE_EBON.get() || target == TerraBlockRegistry.STONE_CRIM.get() || target == TerraBlockRegistry.STONE_PEARL.get();
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos)
    {
        return PlantType.CAVE;
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random)
    {
        if (!worldIn.isRemote)
        {
            if (!worldIn.isAreaLoaded(pos, 3))
            {
                return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            }
            if (state.get(AGE) == 0 && random.nextFloat() < 0.01F)
            {
                worldIn.setBlockState(pos, state.with(AGE, 1));
            }
            else
            {
                if (MathHelper.floor(worldIn.getGameTime() / 2000) % 2 == 0 && state.get(AGE) == 1) {worldIn.setBlockState(pos, this.getDefaultState().with(AGE, 2));}
                if (MathHelper.floor(worldIn.getGameTime() / 2000) % 2 != 0 && state.get(AGE) == 2) {worldIn.setBlockState(pos, this.getDefaultState().with(AGE, 1));}
            }
        }
    }
}
