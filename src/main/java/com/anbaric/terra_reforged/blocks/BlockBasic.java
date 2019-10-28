package com.anbaric.terra_reforged.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockBasic extends Block
{
    public BlockBasic()
    {
        super(Properties.create(Material.IRON).sound(SoundType.METAL).harvestLevel(3).harvestTool(ToolType.PICKAXE));

        setRegistryName("soil_mud");
    }
}
