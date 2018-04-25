package net.dries007.tfc.objects.blocks.wood;

import net.dries007.tfc.objects.Wood;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.EnumMap;

public class BlockBookcaseTFC extends Block {
    private static final EnumMap<Wood, BlockBookcaseTFC> MAP = new EnumMap<>(Wood.class);

    public static BlockBookcaseTFC get(Wood wood) {
        return MAP.get(wood);
    }

    public final Wood wood;

    public BlockBookcaseTFC(Wood wood) {
        super(Material.WOOD);
        if (MAP.put(wood, this) != null) throw new IllegalStateException("There can only be one.");
        this.wood = wood;
        setSoundType(SoundType.WOOD);
        setHardness(2.0F).setResistance(5.0F);
        setHarvestLevel("axe", 0);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

}