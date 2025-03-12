package com.starfish_studios.infinite_pie.registry;

import com.starfish_studios.infinite_pie.IPConfig;
import com.starfish_studios.infinite_pie.InfinitePie;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

public class IPItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(InfinitePie.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> INFINITE_PIE = ITEMS.register("infinite_pie", () ->
            new Item(new Item.Properties()
                    .stacksTo(IPConfig.piMaxStackSize)
                    .food(new FoodProperties.Builder().nutrition(20).saturationMod(1.0F).alwaysEat().build())
                    .rarity(Rarity.EPIC)
                    .fireResistant()));

}