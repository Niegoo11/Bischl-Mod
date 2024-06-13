package us.diewaldmert.bischlmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import us.diewaldmert.bischlmod.BischlMod;
import us.diewaldmert.bischlmod.sound.ModSounds;

public class BischlEntity extends ZombieEntity {


    public BischlEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new ZombieAttackGoal(this, 1.0, false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));
        //this.targetSelector.add(2, new ActiveTargetGoal<PlayerEntity>((MobEntity)this, PlayerEntity.class, false));
        this.targetSelector.add(1, new ActiveTargetGoal<PlayerEntity>((MobEntity) this, PlayerEntity.class, false));
        setAttacking(false);
    }

    @Override
    protected void initAttributes() {
        EntityAttributeInstance instance = this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (instance == null) {
            BischlMod.LOGGER.error("Attribute instance for max health is null");
        } else {
            instance.setBaseValue(20.0);
        }
        setAttacking((PlayerEntity) this.getAttacker());
        setAttacking(false);
    }

    @Override
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
        ItemStack diamondHelmet = new ItemStack(Items.DIAMOND_HELMET);
        this.equipStack(EquipmentSlot.HEAD, diamondHelmet);
    }

    public static DefaultAttributeContainer createBischlAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0)
                .build();
    }

    /*@Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.PAPER);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.BISCHL.create(world);
    }*/

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.pickRandomBischlSound();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.BISCHL_OIDA;
    }

    /*@Override
    protected void playHurtSound(DamageSource source) {
        SoundEvent soundEvent = getHurtSound(source);
        if (soundEvent != null) {
            this.playSound(soundEvent, 4.0F, 1F);
        } else {
            BischlMod.LOGGER.error("SoundEvent in \"BischlEntity.java\" is null.");
            throw new NullPointerException("SoundEvent in \"BischlEntity.java\" is null.");
        }
    }*/

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.BISCHL_SOUNDS[ModSounds.random(0, 1)];
    }

    /*@Override
    public void playSound(SoundEvent sound, float volume, float pitch) {
        if (this.isSilent()) {
            return;
        }
        this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), sound, this.getSoundCategory(), volume, pitch);
    }*/

    @Override
    protected SoundEvent getSwimSound() {
        return ModSounds.BISCHL_SAUGEIL;
    }
}
