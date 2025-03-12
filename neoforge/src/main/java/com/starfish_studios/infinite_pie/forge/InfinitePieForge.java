package com.starfish_studios.infinite_pie.forge;

import com.starfish_studios.infinite_pie.InfinitePie;
import com.starfish_studios.infinite_pie.registry.IPBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(InfinitePie.MOD_ID)
public class InfinitePieForge {
    public InfinitePieForge() {
        InfinitePie.init();
    }

    @SubscribeEvent
    public static void registerBlockRenderType(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(IPBlocks.INFINITE_PIE.get(), RenderType.cutout());
        });
    }
}
