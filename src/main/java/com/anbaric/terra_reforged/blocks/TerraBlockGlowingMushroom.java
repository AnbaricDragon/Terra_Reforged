package com.anbaric.terra_reforged.blocks;

import com.anbaric.terra_reforged.features.vegetation.TerraGlowingMushroom;
import com.anbaric.terra_reforged.features.vegetation.TerraTreeShade;
import com.anbaric.terra_reforged.util.init.TerraBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class TerraBlockGlowingMushroom extends BushBlock implements IGrowable
{
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
    protected static final VoxelShape MUSHROOM_SHAPE = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);


    public TerraBlockGlowingMushroom(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(STAGE, Integer.valueOf(0)));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return MUSHROOM_SHAPE;
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        Block target = state.getBlock();
        return target == TerraBlockRegistry.GRASS_MUSHROOM.get();
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return worldIn.getBlockState(blockpos).canSustainPlant(worldIn, blockpos, Direction.UP, this);
        return isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand)
    {
        super.tick(state, worldIn, pos, rand);
        if (!worldIn.isAreaLoaded(pos, 1))
        {
            return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        }
        if (rand.nextInt(7) == 0)
        {
            this.grow(worldIn, pos, state, rand);
        }

    }

    public void grow(ServerWorld worldIn, BlockPos pos, BlockState state, Random rand)
    {
        if (state.get(STAGE) == 0)
        {
            worldIn.setBlockState(pos, state.cycle(STAGE), 4);
        }
        else
        {
            if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(worldIn, rand, pos))
            {
                return;
            }
            TerraGlowingMushroom.generateTree(worldIn, pos, rand);
        }

    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient)
    {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state)
    {
        return (double) worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state)
    {
        this.grow(worldIn, pos, state, rand);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(STAGE);
    }
}