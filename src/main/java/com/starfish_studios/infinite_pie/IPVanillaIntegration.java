package com.starfish_studios.infinite_pie;

import com.starfish_studios.infinite_pie.registry.IPBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class IPVanillaIntegration {

    @Environment(EnvType.CLIENT)
    public static class Client {

        public static void clientInit() {
            registerBlockRenderLayers();
        }

        private static void registerBlockRenderLayers() {
            BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                    IPBlocks.INFINITE_PIE
            );
        }
    }

}
