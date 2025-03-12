package com.starfish_studios.infinite_pie;

import eu.midnightdust.lib.config.MidnightConfig;

public class IPConfig extends MidnightConfig {
    @Entry(category = "main") public static int piHunger = 6;
    @Entry(category = "main") public static float piSaturation = 0.0F;
    @Entry(category = "main") public static int piMaxStackSize = 1;
    @Entry(category = "main") public static int piEatingSpeed = 32;
    @Entry(category = "main") public static boolean piCooldown = true;
}
