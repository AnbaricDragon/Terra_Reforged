package com.anbaric.terra_reforged.entities.goals;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.BeeEntity;

public class BeeItemGoal extends NearestAttackableTargetGoal<LivingEntity>
{
    public BeeItemGoal(MobEntity goalOwnerIn, Class<LivingEntity> targetClassIn, boolean checkSight)
    {
        super(goalOwnerIn, targetClassIn, checkSight);
    }

    public static boolean isThingAttackable(LivingEntity ent)
    {
        return (ent.getType() != EntityType.BEE && ent.getType() != EntityType.PLAYER);
    }

    public BeeItemGoal(BeeEntity beeIn)
    {
        super(beeIn, LivingEntity.class, 10, true, false, BeeItemGoal::isThingAttackable);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute()
    {
        return this.canSting() && super.shouldExecute();
    }

    @Override
    protected void findNearestTarget()
    {
        this.nearestTarget = this.goalOwner.world.getClosestEntityWithinAABB(this.targetClass, this.targetEntitySelector, this.goalOwner, this.goalOwner.getPosX(), this.goalOwner.getPosY(), this.goalOwner.getPosZ(), this.getTargetableArea(this.getTargetDistance()));
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    @Override
    public boolean shouldContinueExecuting()
    {
        boolean canSting = this.canSting();
        if (canSting && this.goalOwner.getAttackTarget() != null)
        {
            return super.shouldContinueExecuting();
        }
        else
        {
            this.target = null;
            return false;
        }
    }

    private boolean canSting()
    {
        BeeEntity beeentity = (BeeEntity) this.goalOwner;
        return beeentity.isAggressive() && !beeentity.hasStung();
    }
}