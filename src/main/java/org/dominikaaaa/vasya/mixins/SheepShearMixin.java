package org.dominikaaaa.vasya.mixins;

import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.dominikaaaa.vasya.events.SheepShearCallback;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SheepEntity.class)
public class SheepShearMixin {

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/SheepEntity;dropItems()V"), method = "interactMob", cancellable = true)
    private void onShear(final PlayerEntity player, final Hand hand, final CallbackInfoReturnable<Boolean> info) {
        ActionResult result = SheepShearCallback.EVENT.invoker().interact(player, (SheepEntity) (Object) this);
        if (result == ActionResult.FAIL) {
            info.cancel();
        }
    }
}