package dev.creoii.greatbigworld.witherstarprotection.config;

import dev.creoii.greatbigworld.witherstarprotection.WitherStarProtection;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ModMenuConfig {
    public static Screen createConfigScreen(Screen parent) {
        return createConfigScreenBuilder(parent).build();
    }

    public static ConfigBuilder createConfigScreenBuilder(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create().setParentScreen(parent).setTitle(Component.translatable("title.wither_star_protection.config"));
        builder.setSavingRunnable(() -> AutoConfig.getConfigHolder(WitherStarProtectionConfig.class).save());

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        ConfigCategory generalCategory = builder.getOrCreateCategory(Component.translatable("wither_star_protection.config.category.general"));

        generalCategory.addEntry(entryBuilder.startBooleanToggle(Component.translatable("wither_star_protection.config.option.noGravity"), WitherStarProtection.isNoGravity())
                .setDefaultValue(true)
                .setTooltip(Component.translatable("wither_star_protection.config.option.noGravity.tooltip"))
                .setSaveConsumer(WitherStarProtection::setNoGravity)
                .build());

        generalCategory.addEntry(entryBuilder.startBooleanToggle(Component.translatable("wither_star_protection.config.option.invulnerable"), WitherStarProtection.isInvulnerable())
                .setDefaultValue(true)
                .setTooltip(Component.translatable("wither_star_protection.config.option.invulnerable.tooltip"))
                .setSaveConsumer(WitherStarProtection::setInvulnerable)
                .build());

        generalCategory.addEntry(entryBuilder.startBooleanToggle(Component.translatable("wither_star_protection.config.option.neverDespawn"), WitherStarProtection.shouldNeverDespawn())
                .setDefaultValue(true)
                .setTooltip(Component.translatable("wither_star_protection.config.option.neverDespawn.tooltip"))
                .setSaveConsumer(WitherStarProtection::setNeverDespawn)
                .build());

        return builder;
    }
}
