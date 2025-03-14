package com.starfish_studios.infinite_pie.mixin;


import com.starfish_studios.infinite_pie.InfinitePie;
import com.starfish_studios.infinite_pie.registry.IPItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin {

    @Inject(method = "drop(Lnet/minecraft/world/item/ItemStack;ZZ)Lnet/minecraft/world/entity/item/ItemEntity;", at = @At("RETURN"))
    private void onDrop(ItemStack stack, boolean throwRandomly, boolean retainOwnership, CallbackInfoReturnable<ItemEntity> cir) {
        if (stack.getItem() == IPItems.INFINITE_PIE.get()) {
            Player self = (Player)(Object)this;
            System.out.println("Infinite Pie dropped by " + self.getName().getString());
            stack.set(InfinitePie.INFINITE_PIE_OWNER_COMPONENT.get(), self.getUUID().toString());
        }
    }
}