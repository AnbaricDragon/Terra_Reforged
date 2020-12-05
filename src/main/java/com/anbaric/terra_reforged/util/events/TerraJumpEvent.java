package com.anbaric.terra_reforged.util.events;

import com.anbaric.terra_reforged.capabilities.multijump.TerraCapabilityMultiJump;
import com.anbaric.terra_reforged.util.handlers.NetworkHandler;
import com.anbaric.terra_reforged.util.packets.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TerraJumpEvent
{
    @OnlyIn(Dist.CLIENT)
    private boolean jumpState;

    @OnlyIn(Dist.CLIENT)
    private boolean lastJumpState;

    @OnlyIn(Dist.CLIENT)
    private boolean hasfirstJump;

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    void onClientTick(TickEvent.ClientTickEvent event)
    {
        if (event.phase == TickEvent.Phase.END)
        {
            ClientPlayerEntity player = Minecraft.getInstance().player;

            if (player != null)
            {
                if (player.isOnGround())
                {
                    hasfirstJump = true;
                }
                jumpState = player.movementInput.jump;
                if (jumpState != lastJumpState)
                {
                    if (jumpState && !player.isOnGround() && !player.isInWater())
                    {
                        if (!hasfirstJump)
                        {
                            pickJump(player);
                        }
                        else
                        {
                            hasfirstJump = false;
                        }
                    }
                }
                lastJumpState = jumpState;
            }
        }
    }

    public static void pickJump(PlayerEntity player)
    {
        player.getCapability(TerraCapabilityMultiJump.MULTI_JUMP_CAPABILITY).ifPresent(cap -> {
            if (cap.getCanCloudJump())
            {
                cap.setCanCloudJump(false);
                NetworkHandler.INSTANCE.sendToServer(new CloudJumpPacket());
                jump(player);
                player.playSound(SoundEvents.BLOCK_WOOL_FALL, 1, 0.9F + player.getRNG().nextFloat() * 0.2F);
                return;
            }
            else if (cap.getCanBlizzardJump())
            {
                cap.setCanBlizzardJump(false);
                NetworkHandler.INSTANCE.sendToServer(new BlizzardJumpPacket());
                jump(player);
                player.playSound(SoundEvents.BLOCK_SNOW_FALL, 1, 0.9F + player.getRNG().nextFloat() * 0.2F);
                return;
            }
            else if (cap.getCanSandstormJump())
            {
                cap.setCanSandstormJump(false);
                NetworkHandler.INSTANCE.sendToServer(new SandstormJumpPacket());
                jump(player);
                player.playSound(SoundEvents.BLOCK_SAND_FALL, 1, 0.9F + player.getRNG().nextFloat() * 0.2F);
                return;
            }
            else if (cap.getCanTsunamiJump())
            {
                cap.setCanTsunamiJump(false);
                NetworkHandler.INSTANCE.sendToServer(new TsunamiJumpPacket());
                jump(player);
                player.playSound(SoundEvents.AMBIENT_UNDERWATER_EXIT, 1, 0.9F + player.getRNG().nextFloat() * 0.2F);
                return;
            }
            else if (cap.getCanFartJump())
            {
                cap.setCanFartJump(false);
                NetworkHandler.INSTANCE.sendToServer(new FartJumpPacket());
                jump(player);
                player.playSound(SoundEvents.ENTITY_DROWNED_DEATH_WATER, 1, 0.9F + player.getRNG().nextFloat() * 0.2F);
                return;
            }

        });
    }

    public static void jump(PlayerEntity player)
    {
        double upwardsMotion = 0.5;
        if (player.isPotionActive(Effects.JUMP_BOOST))
        {
            upwardsMotion += 0.1 * (player.getActivePotionEffect(Effects.JUMP_BOOST).getAmplifier() + 1);
        }
        Vector3d motion = player.getMotion();

        player.setMotion(player.getMotion().add(0, upwardsMotion - motion.y, 0));

        player.isAirBorne = true;
        net.minecraftforge.common.ForgeHooks.onLivingJump(player);

        player.addStat(Stats.JUMP);
        player.addExhaustion(player.isSprinting() ? 0.2F : 0.05F);
    }
}