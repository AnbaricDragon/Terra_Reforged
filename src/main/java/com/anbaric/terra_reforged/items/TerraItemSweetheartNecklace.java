package com.anbaric.terra_reforged.items;

import com.anbaric.terra_reforged.util.handlers.BeeHandler;
import com.anbaric.terra_reforged.util.init.TerraEffectRegistry;
import com.anbaric.terra_reforged.util.init.TerraTagRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;

public class TerraItemSweetheartNecklace extends TerraItemAccessory
{
    public TerraItemSweetheartNecklace(Properties properties)
    {
        super(properties);
        MinecraftForge.EVENT_BUS.addListener(this::beeInPanic);
    }

    public void beeInPanic(LivingDamageEvent event)
    {
        PlayerEntity player = event.getEntityLiving() instanceof PlayerEntity ? (PlayerEntity) event.getEntityLiving() : null;
        if (player == null) { return; }
        ServerWorld world = (ServerWorld) event.getEntity().getEntityWorld();

        float aggroDist = 10F;

        CuriosApi.getCuriosHelper().findEquippedCurio(stack -> stack.getItem() == this && !player.getCooldownTracker().hasCooldown(stack.getItem()), player).ifPresent(found ->
        {
            player.addPotionEffect(new EffectInstance(Effects.SPEED, 60));
            player.addPotionEffect(new EffectInstance(TerraEffectRegistry.HONEY.get(), 100));
            BeeHandler.spawnAngryBees(world, player.getPosition(), aggroDist);
            CuriosApi.getCuriosHelper().getCuriosHandler(player).map(ICuriosItemHandler::getCurios).map(map -> map.get("curio")).map(ICurioStacksHandler::getStacks).map(dynamicStackHandler ->
            {
                for (int i = 0; i < dynamicStackHandler.getSlots(); i++)
                {
                    ItemStack stack = dynamicStackHandler.getStackInSlot(i);
                    if (stack.getItem().isIn(TerraTagRegistry.PANIC_GIVERS) || stack.getItem().isIn(TerraTagRegistry.BEE_SPAWNERS))
                    {
                        player.getCooldownTracker().setCooldown(stack.getItem(), 100);
                    }
                }
                return null;
            });
        });
    }
}
