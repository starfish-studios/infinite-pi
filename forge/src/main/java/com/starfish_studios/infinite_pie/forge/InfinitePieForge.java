package com.starfish_studios.infinite_pie.forge;

import com.starfish_studios.infinite_pie.InfinitePie;
import com.starfish_studios.infinite_pie.registry.IPBlocks;
import dev.architectury.platform.forge.EventBuses;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(InfinitePie.MOD_ID)
public class InfinitePieForge {
    public InfinitePieForge() {

        EventBuses.registerModEventBus(InfinitePie.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        InfinitePie.init();
    }

    @SubscribeEvent
    public static void registerBlockRenderType(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(IPBlocks.INFINITE_PIE.get(), RenderType.cutout());
        });
    }
}
