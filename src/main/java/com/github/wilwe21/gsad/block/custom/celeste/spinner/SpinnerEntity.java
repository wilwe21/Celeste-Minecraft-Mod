package com.github.wilwe21.gsad.block.custom.celeste.spinner;

import com.github.wilwe21.gsad.block.BlockTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class SpinnerEntity extends BlockEntity {
    public int color = 0x3495eb;

    public SpinnerEntity(BlockPos pos, BlockState state) {
        super(BlockTypes.SPINNER, pos, state);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        color = nbt.getInt("color");

        if (world != null) {
            world.updateListeners(pos, getCachedState(), getCachedState(), 0);
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putInt("color", color);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    @Override
    public @Nullable Object getRenderData() {
        // this is the method from `RenderDataBlockEntity` class.
        return color;
    }
}
