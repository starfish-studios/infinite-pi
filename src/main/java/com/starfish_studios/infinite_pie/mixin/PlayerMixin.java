package com.starfish_studios.infinite_pie.mixin;

import com.starfish_studios.infinite_pie.IPConfig;
import com.starfish_studios.infinite_pie.registry.IPItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin {
    @Inject(method = "drop*", at = @At("RETURN"))
    private void onDrop(ItemStack stack, boolean throwRandomly, boolean retainOwnership, CallbackInfoReturnable<ItemEntity> cir) {
        if (stack.getItem() == IPItems.INFINITE_PIE) {
            Player self = (Player)(Object)this;
            System.out.println("Infinite Pie dropped by " + self.getName().getString());
            CompoundTag tag = stack.getOrCreateTag();
            tag.putUUID("InfinitePiOwner", self.getUUID());
        }
    }
}
