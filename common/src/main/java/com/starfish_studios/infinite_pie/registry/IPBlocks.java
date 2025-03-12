package com.starfish_studios.infinite_pie.registry;


import com.starfish_studios.infinite_pie.InfinitePie;
import com.starfish_studios.infinite_pie.block.InfinitePiBlock;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class IPBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(InfinitePie.MOD_ID, Registries.BLOCK);

    public static final Supplier<Block> INFINITE_PIE = BLOCKS.register("infinite_pie", () -> new InfinitePiBlock(
            BlockBehaviour.Properties.copy((Blocks.CAKE))
                    .noOcclusion()
    ));

}