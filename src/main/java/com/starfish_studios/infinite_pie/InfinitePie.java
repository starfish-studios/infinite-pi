package com.starfish_studios.infinite_pie;

import com.google.common.reflect.Reflection;
import com.starfish_studios.infinite_pie.registry.*;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;


public class InfinitePie implements ModInitializer {
	public static final String MOD_ID = "infinite_pie";

	@Override
	public void onInitialize() {
		MidnightConfig.init(MOD_ID, IPConfig.class);

		Reflection.initialize(
				IPItems.class,
				IPBlocks.class
		);

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> {
			entries.addAfter(Items.PUMPKIN_PIE, IPItems.INFINITE_PIE);
		});
	}
}