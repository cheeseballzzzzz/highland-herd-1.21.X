package net.chizutosuto.highlandherd.entity.custom;

import net.chizutosuto.highlandherd.block.ModBlocks;
import net.chizutosuto.highlandherd.entity.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class HighlandCowEntity extends AnimalEntity {



    public HighlandCowEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(1, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(2, new TemptGoal(this,1.15, Ingredient.ofItems(ModBlocks.HIGHLAND_THISTLE_PLANT.asItem()), false));

        this.goalSelector.add(3, new FollowParentGoal(this, 1.1D));

        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));

    }

    public static DefaultAttributeContainer.Builder createAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 5)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.FOLLOW_RANGE, 20);
    }




    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(ModBlocks.HIGHLAND_THISTLE_PLANT.asItem());
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return new HighlandCowEntity(ModEntities.HIGHLAND_COW, world);

    }
}
