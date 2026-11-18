package dev.creoii.greatbigworld.witherstarprotection.fabric;

import dev.creoii.greatbigworld.witherstarprotection.config.WitherStarProtectionConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class WitherStarProtectionFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        if (FabricLoader.getInstance().isModLoaded("cloth-config")) {
            WitherStarProtectionConfig.init();
        }
    }
}
