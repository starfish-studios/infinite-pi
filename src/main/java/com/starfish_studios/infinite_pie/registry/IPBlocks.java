package com.starfish_studios.infinite_pie.registry;

import com.starfish_studios.infinite_pie.InfinitePie;
import com.starfish_studios.infinite_pie.block.InfinitePiBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;

public class IPBlocks {

    public static final Block INFINITE_PIE = register("infinite_pie", new InfinitePiBlock(FabricBlockSettings.copy((Blocks.CAKE)).noOcclusion()));

    private static Block register(String id, Block block) {

        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(InfinitePie.MOD_ID, id), block);
    }
}
