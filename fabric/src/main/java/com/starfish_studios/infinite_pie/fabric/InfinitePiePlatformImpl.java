package com.starfish_studios.infinite_pie.fabric;

import com.starfish_studios.infinite_pie.InfinitePiePlatform;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class InfinitePiePlatformImpl {
    /**
     * This is our actual method to {@link InfinitePiePlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
