package com.starfish_studios.infinite_pie;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class IPClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		IPVanillaIntegration.Client.clientInit();
	}

}