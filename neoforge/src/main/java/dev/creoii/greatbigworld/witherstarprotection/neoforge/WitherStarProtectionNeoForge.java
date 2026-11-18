package dev.creoii.greatbigworld.witherstarprotection.neoforge;

import dev.creoii.greatbigworld.witherstarprotection.config.ModMenuConfig;
import dev.creoii.greatbigworld.witherstarprotection.config.WitherStarProtectionConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod("wither_star_protection")
public final class WitherStarProtectionNeoForge {
    public WitherStarProtectionNeoForge(ModContainer container, IEventBus bus) {
        if (ModList.get().isLoaded("cloth_config")) {
            WitherStarProtectionConfig.init();
            container.registerExtensionPoint(IConfigScreenFactory.class, (_, screen) ->  ModMenuConfig.createConfigScreen(screen));
            bus.addListener(this::onClientSetup);
        }
    }

    public void onClientSetup(FMLClientSetupEvent event) {
        ModMenuConfig.createConfigScreenBuilder(null);
    }

}
