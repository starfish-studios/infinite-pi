package com.starfish_studios.infinite_pie.registry;

import com.starfish_studios.infinite_pie.IPConfig;
import com.starfish_studios.infinite_pie.InfinitePie;
import com.starfish_studios.infinite_pie.item.InfinitePiItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

public class IPItems {

    public static final Item INFINITE_PIE = register("infinite_pie", new InfinitePiItem(new FabricItemSettings()
            .maxCount(IPConfig.piMaxStackSize)
            .food(new FoodProperties.Builder().nutrition(20).saturationMod(1.0F).alwaysEat().build())
            .rarity(Rarity.EPIC)
            .fireproof()
    ));

    private static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(InfinitePie.MOD_ID, id), item);
    }
}
