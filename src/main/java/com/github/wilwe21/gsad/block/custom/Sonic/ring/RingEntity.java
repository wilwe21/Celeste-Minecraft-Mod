package com.github.wilwe21.gsad.block.custom.Sonic.ring;

import com.github.wilwe21.gsad.block.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class RingEntity extends BlockEntity {
    public RingEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.RING, pos, state);
    }
}
