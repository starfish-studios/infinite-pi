package com.starfish_studios.infinite_pie;

import com.mojang.serialization.Codec;
import com.starfish_studios.infinite_pie.registry.IPBlocks;
import com.starfish_studios.infinite_pie.registry.IPItems;
import dev.architectury.registry.CreativeTabOutput;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import eu.midnightdust.lib.config.MidnightConfig;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class InfinitePie {
    public static final String MOD_ID = "infinite_pie";

    public static DeferredRegister<DataComponentType<?>> DATA = DeferredRegister.create(MOD_ID, Registries.DATA_COMPONENT_TYPE);

    public static final RegistrySupplier<DataComponentType<String>> INFINITE_PIE_OWNER_COMPONENT = DATA.register("infinite_pie_owner",
            () -> DataComponentType.<String>builder().persistent(Codec.STRING).build());

    public static final RegistrySupplier<DataComponentType<Integer>> EAT_COUNT_COMPONENT = DATA.register("eat_count",
            () -> DataComponentType.<Integer>builder().persistent(Codec.INT).build());

    public static final RegistrySupplier<DataComponentType<String>> PI_LORE_COMPONENT = DATA.register("pi_lore",
            () -> DataComponentType.<String>builder().persistent(Codec.STRING).build());

    public static void init() {
        MidnightConfig.init(InfinitePie.MOD_ID, IPConfig.class);

        IPItems.ITEMS.register();
        IPBlocks.BLOCKS.register();

        DATA.register();

        CreativeTabRegistry.modifyBuiltin(BuiltInRegistries.CREATIVE_MODE_TAB.get(CreativeModeTabs.FOOD_AND_DRINKS), (FeatureFlagSet flags, CreativeTabOutput output, boolean canUseGameMasterBlocks) -> {
            output.acceptAfter(Items.PUMPKIN_PIE, IPItems.INFINITE_PIE.get());
        });
    }
}
