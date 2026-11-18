package dev.creoii.greatbigworld.witherstarprotection;

import dev.creoii.greatbigworld.witherstarprotection.config.WitherStarProtectionConfig;
import org.jspecify.annotations.Nullable;

public final class WitherStarProtection {
    public static final String NAMESPACE = "wither_star_protection";
    public static final String GBW = "great_big_world";

    @Nullable
    public static WitherStarProtectionConfig CONFIG;

    public static boolean isNoGravity() {
        return CONFIG == null || CONFIG.noGravity;
    }

    public static boolean isInvulnerable() {
        return CONFIG == null || CONFIG.invulnerable;
    }

    public static boolean shouldNeverDespawn() {
        return CONFIG == null || CONFIG.neverDespawn;
    }

    public static void setNoGravity(boolean noGravity) {
        if (CONFIG != null) CONFIG.noGravity = noGravity;
    }

    public static void setInvulnerable(boolean invulnerable) {
        if (CONFIG != null) CONFIG.invulnerable = invulnerable;
    }

    public static void setNeverDespawn(boolean neverDespawn) {
        if (CONFIG != null) CONFIG.neverDespawn = neverDespawn;
    }
}
