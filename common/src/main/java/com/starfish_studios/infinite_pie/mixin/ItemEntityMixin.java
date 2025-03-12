package com.starfish_studios.infinite_pie.mixin;


import com.starfish_studios.infinite_pie.registry.IPItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin {
    @Shadow private int age;

    @Shadow public abstract ItemStack getItem();

    @Inject(method = "<init>(Lnet/minecraft/world/level/Level;DDD Lnet/minecraft/world/item/ItemStack;)V", at = @At("TAIL"))
    private void onConstruct(Level world, double x, double y, double z, ItemStack stack, CallbackInfo ci) {
        if (stack.getItem() == IPItems.INFINITE_PIE) {
            this.age = -32768;
            ((ItemEntity)(Object)this).setInvulnerable(true);
        }
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        if (getItem().getItem() != IPItems.INFINITE_PIE) {
            return;
        }

        double y = ((ItemEntity)(Object)this).getY();
        if (y < -65) {
            ItemStack stack = getItem();
            CompoundTag tag = stack.getTag();
            if (tag != null && tag.contains("InfinitePiOwner")) {
                UUID ownerUUID = tag.getUUID("InfinitePiOwner");
                Level level = ((ItemEntity)(Object)this).level();
                Player owner = level.getPlayerByUUID(ownerUUID);
                if (owner != null) {
                    ItemStack copy = stack.copy();
                    boolean added = owner.getInventory().add(copy);
                    if (added) {
                        owner.playSound(SoundEvents.ITEM_PICKUP, 1.0F, 1.0F);
                        ((ItemEntity)(Object)this).remove(RemovalReason.DISCARDED);
                    } else {
                        ((ItemEntity)(Object)this).setPos(owner.getX(), owner.getY(), owner.getZ());
                    }
                }
            }
        }
    }
}