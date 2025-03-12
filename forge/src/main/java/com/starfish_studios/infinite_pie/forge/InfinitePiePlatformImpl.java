package com.starfish_studios.infinite_pie.forge;

import com.starfish_studios.infinite_pie.InfinitePiePlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class InfinitePiePlatformImpl {
    /**
     * This is our actual method to {@link InfinitePiePlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
