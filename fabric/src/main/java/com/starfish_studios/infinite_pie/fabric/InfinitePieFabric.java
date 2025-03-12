package com.starfish_studios.infinite_pie.fabric;

import com.starfish_studios.infinite_pie.InfinitePie;
import com.starfish_studios.infinite_pie.registry.IPBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class InfinitePieFabric implements ModInitializer, ClientModInitializer {
    @Override
    public void onInitialize() {
        InfinitePie.init();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                IPBlocks.INFINITE_PIE.get()
        );
    }
}
