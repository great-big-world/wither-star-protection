package dev.creoii.greatbigworld.witherstarprotection.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.creoii.greatbigworld.witherstarprotection.WitherStarProtection;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WitherBoss.class)
public class WitherBossMixin {
    @Inject(method = "dropCustomDeathLoot", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/item/ItemEntity;setExtendedLifetime()V"))
    private void gbw$adjustDroppedStar(ServerLevel level, DamageSource source, boolean killedByPlayer, CallbackInfo ci, @Local(name = "netherStar") ItemEntity netherStar) {
        if (WitherStarProtection.isNoGravity()) netherStar.setNoGravity(true);
        if (WitherStarProtection.isInvulnerable()) netherStar.setPermanentlyInvulnerable(true);
        if (WitherStarProtection.shouldNeverDespawn()) netherStar.setUnlimitedLifetime();
    }
}
