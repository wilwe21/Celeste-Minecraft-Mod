package com.github.wilwe21.gsad.block.custom.blockEntity.dustbunny;

import com.github.wilwe21.gsad.block.types.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class DustBunnyEntity extends BlockEntity {
    public DustBunnyEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.DUST_BUNNY, pos, state);
    }
}
