package com.starfish_studios.infinite_pie;

import com.starfish_studios.infinite_pie.registry.IPBlocks;
import com.starfish_studios.infinite_pie.registry.IPItems;
import dev.architectury.registry.CreativeTabOutput;
import dev.architectury.registry.CreativeTabRegistry;
import eu.midnightdust.lib.config.MidnightConfig;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class InfinitePie {
    public static final String MOD_ID = "infinite_pie";

    public static void init() {
        MidnightConfig.init(InfinitePie.MOD_ID, IPConfig.class);

        IPItems.ITEMS.register();
        IPBlocks.BLOCKS.register();

        CreativeTabRegistry.modifyBuiltin(BuiltInRegistries.CREATIVE_MODE_TAB.get(CreativeModeTabs.FOOD_AND_DRINKS), (FeatureFlagSet flags, CreativeTabOutput output, boolean canUseGameMasterBlocks) -> {
            output.acceptAfter(Items.PUMPKIN_PIE, IPItems.INFINITE_PIE.get());
        });
    }
}
