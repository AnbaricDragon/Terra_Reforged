package com.anbaric.terra_reforged.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.*;

import javax.annotation.Nullable;
import java.util.Random;

public class TerraBlockSnowLayer extends Block
{
    public static final IntegerProperty LAYERS = BlockStateProperties.LAYERS_1_8;
    protected static final VoxelShape[]
            SHAPES =
            new VoxelShape[]{VoxelShapes.empty(), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public TerraBlockSnowLayer(Block.Properties properties)
    {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(LAYERS, Integer.valueOf(1)));
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type)
    {
        switch (type)
        {
            case LAND:
                return state.get(LAYERS) < 5;
            case WATER:
                return false;
            case AIR:
                return false;
            default:
                return false;
        }
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return SHAPES[state.get(LAYERS)];
    }

    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return SHAPES[state.get(LAYERS) - 1];
    }

    public boolean func_220074_n(BlockState state)
    {
        return true;
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos)
    {
        BlockState blockstate = worldIn.getBlockState(pos.down());
        if (!blockstate.matchesBlock(Blocks.ICE) && !blockstate.matchesBlock(Blocks.PACKED_ICE) && !blockstate.matchesBlock(Blocks.BARRIER))
        {
            if (!blockstate.matchesBlock(Blocks.HONEY_BLOCK) && !blockstate.matchesBlock(Blocks.SOUL_SAND))
            {
                return Block.doesSideFillSquare(blockstate.getCollisionShapeUncached(worldIn, pos.down()), Direction.UP) || blockstate.getBlock() == this && blockstate.get(LAYERS) == 8;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        return !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public void tick(BlockState state, World worldIn, BlockPos pos, Random random)
    {
        int i = state.get(LAYERS);
        if (worldIn.getLightFor(LightType.BLOCK, pos) > 11)
        {
            if (i == 1)
            {
                spawnDrops(state, worldIn, pos);
                worldIn.removeBlock(pos, false);
            }
            else
            {
                worldIn.setBlockState(pos, this.getDefaultState().with(LAYERS, i - 1));
            }
        }

    }

    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext)
    {
        int i = state.get(LAYERS);
        if (useContext.getItem().getItem() == this.asItem() && i < 8)
        {
            if (useContext.replacingClickedOnBlock())
            {
                return useContext.getFace() == Direction.UP;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return i == 1;
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        BlockState blockstate = context.getWorld().getBlockState(context.getPos());
        if (blockstate.getBlock() == this)
        {
            int i = blockstate.get(LAYERS);
            return blockstate.with(LAYERS, Integer.valueOf(Math.min(8, i + 1)));
        }
        else
        {
            return super.getStateForPlacement(context);
        }
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(LAYERS);
    }
}