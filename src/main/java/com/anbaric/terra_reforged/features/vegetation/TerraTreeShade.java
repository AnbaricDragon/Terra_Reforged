package com.anbaric.terra_reforged.features.vegetation;

import com.anbaric.terra_reforged.util.init.TerraBlockRegistry;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class TerraTreeShade extends Feature<NoFeatureConfig>
{
    public static final BlockState LOG_SHADE = TerraBlockRegistry.LOG_SHADE.get().getDefaultState();
    public static final BlockState LEAF_SHADE = TerraBlockRegistry.LEAF_SHADE.get().getDefaultState();

    public static final char[][][] SHADE_ARRAY =
    {{{'O', 'O', 'O', 'O', 'O', 'O', 'O'},
    {'O', 'O', 'O', '3', 'O', 'O', 'O'},
    {'O', 'O', '3', 'L', '3', 'O', 'O'},
    {'O', '3', 'L', 'W', 'L', '3', 'O'},
    {'O', 'O', '3', 'L', '3', 'O', 'O'},
    {'O', 'O', 'O', '3', 'O', 'O', 'O'},
    {'O', 'O', 'O', 'O', 'O', 'O', 'O'}},

    {{'O', 'O', 'O', 'O', 'O', 'O', 'O'},
    {'O', '2', 'L', 'L', 'L', '2', 'O'},
    {'O', 'L', 'L', 'a', 'L', 'L', 'O'},
    {'O', 'L', 'd', 'W', 'b', 'L', 'O'},
    {'O', 'L', 'L', 'c', 'L', 'L', 'O'},
    {'O', '2', 'L', 'L', 'L', '2', 'O'},
    {'O', 'O', 'O', 'O', 'O', 'O', 'O'}},

    {{'O', 'O', '3', 'a', '3', 'O', 'O'},
    {'O', 'L', 'L', 'a', 'L', 'L', 'O'},
    {'3', 'L', 'L', 'e', 'L', 'L', '3'},
    {'d', 'd', 'h', 'W', 'f', 'b', 'b'},
    {'3', 'L', 'L', 'g', 'L', 'L', '3'},
    {'O', 'L', 'L', 'c', 'L', 'L', 'O'},
    {'O', 'O', '3', 'c', '3', 'O', 'O'}},

    {{'O', 'O', '3', 'e', '3', 'O', 'O'},
    {'O', '1', 'L', 'e', 'L', '1', 'O'},
    {'3', 'L', 'L', 'L', 'L', 'L', '3'},
    {'h', 'h', 'L', 'W', 'L', 'f', 'f'},
    {'3', 'L', 'L', 'L', 'L', 'L', '3'},
    {'O', '1', 'L', 'g', 'L', '1', 'O'},
    {'O', 'O', '3', 'g', '3', 'O', 'O'}},

    {{'O', 'O', 'O', 'O', 'O', 'O', 'O'},
    {'O', 'O', '1', '3', '1', 'O', 'O'},
    {'O', '1', 'L', 'c', 'L', '1', 'O'},
    {'O', '3', 'b', 'W', 'd', '3', 'O'},
    {'O', '1', 'L', 'a', 'L', '1', 'O'},
    {'O', 'O', '1', '3', '1', 'O', 'O'},
    {'O', 'O', 'O', 'O', 'O', 'O', 'O'}},

    {{'O', 'O', 'O', 'O', 'O', 'O', 'O'},
    {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
    {'O', 'O', '2', 'L', '2', 'O', 'O'},
    {'O', 'O', 'L', 'L', 'L', 'O', 'O'},
    {'O', 'O', '2', 'L', '2', 'O', 'O'},
    {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
    {'O', 'O', 'O', 'O', 'O', 'O', 'O'}}};

    public TerraTreeShade(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactory)
    {
        super(configFactory);
    }

    private boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        Block target = state.getBlock();
        return target == TerraBlockRegistry.GRASS_CRIMSON.get() || target == Blocks.DIRT || target == Blocks.GRASS_BLOCK;
    }

    private static char[][][] mutateArray(char[][][] inputArray, Random rand)
    {
        char[][][] outputArray = new char[inputArray.length][inputArray[0].length][inputArray[0][0].length];
        float lowChance = rand.nextFloat();
        float highChance = rand.nextFloat();

        for (int y = 0; y < inputArray.length; y++)
        {
            for (int x = 0; x < inputArray[0].length; x++)
            {
                for (int z = 0; z < inputArray[0][0].length; z++)
                {
                    float   chance = Character.getNumericValue(inputArray[y][x][z]) * 0.25F;
                    boolean won    = rand.nextFloat() < chance;
                    switch (inputArray[y][x][z])
                    {
                        case '1': case '2': case '3':
                            outputArray[y][x][z] = won ? 'L' : 'O';
                            break;

                        case 'a':
                            outputArray[y][x][z] = lowChance < 0.2F ? 'v' : 'L';
                            break;

                        case 'b':
                            outputArray[y][x][z] = lowChance > 0.2F && lowChance < 0.4F ? 'h' : 'L';
                            break;

                        case 'c':
                            outputArray[y][x][z] = lowChance > 0.4F && lowChance < 0.6F ? 'v' : 'L';
                            break;

                        case 'd':
                            outputArray[y][x][z] = lowChance > 0.6F && lowChance < 0.8F ? 'h' : 'L';
                            break;

                        case 'e':
                            outputArray[y][x][z] = highChance < 0.2F ? 'v' : 'L';
                            break;

                        case 'f':
                            outputArray[y][x][z] = highChance > 0.2F && highChance < 0.4F ? 'h' : 'L';
                            break;

                        case 'g':
                            outputArray[y][x][z] = highChance > 0.4F && highChance < 0.6F ? 'v' : 'L';
                            break;

                        case 'h':
                            outputArray[y][x][z] = highChance > 0.6F && highChance < 0.8F ? 'h' : 'L';
                            break;

                        default:
                            outputArray[y][x][z] = inputArray[y][x][z];
                    }
                }
            }
        }
        return outputArray;
    }

    public static boolean checkSpace(IWorld world, BlockPos pos, int trunkHeight, char[][][] template)
    {
        System.out.println("Successfully checking space");

        int     arrayX     = 0, arrayY = 0, arrayZ = 0;
        int     radius     = 3;
        int     treeHeight = template.length;
        boolean canGrow = true;

        BlockPos.Mutable target = new BlockPos.Mutable();

        for (int i = 0; i <= trunkHeight; i++)
        {
            if (!world.getBlockState(pos.up(i)).canBeReplacedByLogs(world, pos))
            {
                canGrow = false;
            }
        }
        for (int y = pos.getY() + trunkHeight; y < pos.getY() + treeHeight + trunkHeight; y++)
        {
            for (int x = pos.getX() - radius; x <= pos.getX() + radius; x++)
            {
                for (int z = pos.getZ() - radius; z <= pos.getZ() + radius; z++)
                {
                    target.setPos(x, y, z);
                    char targetChar = template[arrayY][arrayX][arrayZ];
                    if (targetChar == 'W' || targetChar == 'h' || targetChar == 'v')
                    {
                        if (!world.getBlockState(target).canBeReplacedByLogs(world, pos))
                        {
                            canGrow = false;
                        }
                    }
                    if (targetChar == 'L')
                    {
                        if (!world.getBlockState(target).canBeReplacedByLeaves(world, target))
                        {
                            canGrow = false;
                        }
                    }
                    arrayZ++;
                }
                arrayX++;
                arrayZ = 0;
            }
            arrayY++;
            arrayX = 0;
        }
        return canGrow;
    }

    public static void generateTree(IWorld world, BlockPos pos, Random rand)
    {
        int        arrayX      = 0, arrayY = 0, arrayZ = 0;
        int        trunkHeight = rand.nextInt(3) + 1;
        int        treeHeight  = SHADE_ARRAY.length;
        int        radius      = 3;
        char[][][] template    = mutateArray(SHADE_ARRAY, rand);
        boolean    hasSpace    = checkSpace(world, pos, trunkHeight, template);

        if (hasSpace)
        {
            BlockPos.Mutable target = new BlockPos.Mutable();
            for (int y = pos.getY() + trunkHeight; y < pos.getY() + treeHeight + trunkHeight; y++)
            {
                for (int x = pos.getX() - radius; x <= pos.getX() + radius; x++)
                {
                    for (int z = pos.getZ() - radius; z <= pos.getZ() + radius; z++)
                    {
                        target.setPos(x, y, z);
                        char inputChar = template[arrayY][arrayX][arrayZ];
                        switch (inputChar)
                        {
                            case 'L':
                                world.setBlockState(target, LEAF_SHADE, 3);
                                break;
                            case 'W':
                                world.setBlockState(target, LOG_SHADE, 3);
                                break;
                            case 'v':
                                world.setBlockState(target, LOG_SHADE.with(LogBlock.AXIS, Direction.Axis.X), 3);
                                break;
                            case 'h':
                                world.setBlockState(target, LOG_SHADE.with(LogBlock.AXIS, Direction.Axis.Z), 3);
                                break;
                        }
                        arrayZ++;
                    }
                    arrayX++;
                    arrayZ = 0;
                }
                arrayY++;
                arrayX = 0;
            }
            for (int i = 0; i < trunkHeight; i++)
            {
                world.setBlockState(pos.up(i), LOG_SHADE, 3);
            }
        }
    }

    @Override
    public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random random, BlockPos pos, NoFeatureConfig config)
    {
        if (isValidGround(world.getBlockState(pos.down()), world, pos) && world.getBlockState(pos).getMaterial().isReplaceable())
        {
            generateTree(world, pos, random);
            return true;
        }
        return false;
    }
}