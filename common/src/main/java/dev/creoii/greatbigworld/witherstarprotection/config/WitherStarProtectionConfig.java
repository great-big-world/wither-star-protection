package dev.creoii.greatbigworld.witherstarprotection.config;

import dev.creoii.greatbigworld.witherstarprotection.WitherStarProtection;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;

@Config(name = "wither_star_protection")
public class WitherStarProtectionConfig implements ConfigData {
    public boolean noGravity = true;
    public boolean invulnerable = true;
    public boolean neverDespawn = true;

    public static void init() {
        AutoConfig.register(WitherStarProtectionConfig.class, (conf, clazz) -> new Toml4jConfigSerializer<>(conf, clazz) {
            public WitherStarProtectionConfig deserialize() {
                try {
                    return super.deserialize();
                } catch (Exception e) {
                    return createDefault();
                }
            }
        });

        WitherStarProtection.CONFIG = AutoConfig.getConfigHolder(WitherStarProtectionConfig.class).getConfig();
    }
}
