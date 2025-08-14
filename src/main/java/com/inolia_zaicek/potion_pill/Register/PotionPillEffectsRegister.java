package com.inolia_zaicek.potion_pill.Register;

import com.inolia_zaicek.potion_pill.Register.Effect.*;
import com.inolia_zaicek.potion_pill.Register.Effect.NonPlayer.Attribute.*;
import com.inolia_zaicek.potion_pill.Register.Effect.NonPlayer.Damage.AttackUpPillEffect;
import com.inolia_zaicek.potion_pill.Register.Effect.NonPlayer.Damage.PowerUpPillEffect;
import com.inolia_zaicek.potion_pill.Register.Effect.NonPlayer.Damage.StrongPillEffect;
import com.inolia_zaicek.potion_pill.Register.Effect.NonPlayer.NirvanaPillEffect;
import com.inolia_zaicek.potion_pill.Register.Effect.NonPlayer.NirvanaPowerPillEffect;
import com.inolia_zaicek.potion_pill.Register.Effect.NonPlayer.NonplayerRevivePillEffect;
import com.inolia_zaicek.potion_pill.Register.Effect.NonPlayer.Resistance.*;
import com.inolia_zaicek.potion_pill.Register.Effect.NonPlayer.Resistance.Down.AstutePillEffect;
import com.inolia_zaicek.potion_pill.Register.Effect.NonPlayer.Resistance.Down.HoldBreathPillEffect;
import com.inolia_zaicek.potion_pill.Register.Effect.NonPlayer.Resistance.Down.LightBodyPillEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.inolia_zaicek.potion_pill.PotionPill.MODID;

public class PotionPillEffectsRegister {
    public static final DeferredRegister<MobEffect> INOEFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,MODID);
    public static final RegistryObject<MobEffect> AnimalPowerPill = INOEFFECT.register("animal_power_pill", AnimalPowerPillEffect::new);
    public static final RegistryObject<MobEffect> DragonPowerPill = INOEFFECT.register("dragon_power_pill", DragonPowerPillEffect::new);
    public static final RegistryObject<MobEffect> WardPill = INOEFFECT.register("ward_pill", WardPillEffect::new);
    public static final RegistryObject<MobEffect> IronhidePill = INOEFFECT.register("ironhide_pill", IronhidePillEffect::new);
    public static final RegistryObject<MobEffect> CopperArmorPill = INOEFFECT.register("copper_armor_pill", CopperArmorPillEffect::new);
    public static final RegistryObject<MobEffect> IronArmorPill = INOEFFECT.register("iron_armor_pill", IronArmorPillEffect::new);
    public static final RegistryObject<MobEffect> DiamondArmorPill = INOEFFECT.register("diamond_armor_pill", DiamondArmorPillEffect::new);
    public static final RegistryObject<MobEffect> NetheriteArmorPill = INOEFFECT.register("netherite_armor_pill", NetheriteArmorPillEffect::new);
    public static final RegistryObject<MobEffect> ChillheartPill = INOEFFECT.register("chillheart_pill", ChillheartPillEffect::new);
    public static final RegistryObject<MobEffect> FrostspiritPill  = INOEFFECT.register("frostspirit_pill", FrostspiritPillEffect::new);
    public static final RegistryObject<MobEffect> ZephyrPill = INOEFFECT.register("zephyr_pill", ZephyrPillEffect::new);
    public static final RegistryObject<MobEffect> ZenithZephyr = INOEFFECT.register("zenith_zephyr_pill", ZenithZephyrPillEffect::new);
    public static final RegistryObject<MobEffect> RevivePill = INOEFFECT.register("revive_pill", NoSpecialPillEffect::new);
    public static final RegistryObject<MobEffect> UndyingPill = INOEFFECT.register("undying_pill", NoSpecialPillEffect::new);
    //NonPlayer
    public static final RegistryObject<MobEffect> HealthUpPill = INOEFFECT.register("health_up_pill", HealthUpPillEffect::new);
    public static final RegistryObject<MobEffect> BoneUpPill = INOEFFECT.register("bone_up_pill", BoneUpPillEffect::new);
    public static final RegistryObject<MobEffect> BodyUpPill = INOEFFECT.register("body_up_pill", BodyUpPillEffect::new);

    public static final RegistryObject<MobEffect> StrongPill = INOEFFECT.register("strong_pill", StrongPillEffect::new);
    public static final RegistryObject<MobEffect> AttackUpPill = INOEFFECT.register("attack_up_pill", AttackUpPillEffect::new);
    public static final RegistryObject<MobEffect> PowerUpPill = INOEFFECT.register("power_up_pill", PowerUpPillEffect::new);

    public static final RegistryObject<MobEffect> CrystalSkinPill = INOEFFECT.register("crystal_skin_pill", CrystalSkinPillEffect::new);
    public static final RegistryObject<MobEffect> ShiningBloodPill = INOEFFECT.register("shining_blood_pill", ShiningBloodPillEffect::new);
    public static final RegistryObject<MobEffect> BlackArmorPill = INOEFFECT.register("black_armor_pill", BlackArmorPillEffect::new);

    public static final RegistryObject<MobEffect> NirvanaPill = INOEFFECT.register("nirvana_pill", NirvanaPillEffect::new);
    public static final RegistryObject<MobEffect> NirvanaPowerPill = INOEFFECT.register("nirvana_pill_power", NirvanaPowerPillEffect::new);
    public static final RegistryObject<MobEffect> NonplayerRevivePill = INOEFFECT.register("nonplayer_revive_pill", NonplayerRevivePillEffect::new);

    public static final RegistryObject<MobEffect> AstutePill = INOEFFECT.register("astute_pill", AstutePillEffect::new);
    public static final RegistryObject<MobEffect> HoldBreathPill = INOEFFECT.register("hold_breath_pill", HoldBreathPillEffect::new);
    public static final RegistryObject<MobEffect> LightBodyPill = INOEFFECT.register("light_body_pill", LightBodyPillEffect::new);

    public static final RegistryObject<MobEffect> ArrowResistancePill = INOEFFECT.register("arrow_resistance_pill", ArrowResistancePillEffect::new);
    public static final RegistryObject<MobEffect> ExplosionResistancePill = INOEFFECT.register("explosion_resistance_pill", ExplosionResistancePillEffect::new);
    public static final RegistryObject<MobEffect> FreezeResistancePill = INOEFFECT.register("freeze_resistance_pill", FreezeResistancePillEffect::new);
    public static final RegistryObject<MobEffect> LavaResistancePill = INOEFFECT.register("lava_resistance_pill", LavaResistancePillEffect::new);
    public static final RegistryObject<MobEffect> ThunderResistancePill = INOEFFECT.register("thunder_resistance_pill", ThunderResistancePillEffect::new);
    public static final RegistryObject<MobEffect> VoidResistancePill = INOEFFECT.register("void_resistance_pill", VoidResistancePillEffect::new);

    public static final RegistryObject<MobEffect> HealPill = INOEFFECT.register("heal_pill", NoSpecialPillEffect::new);
    public static final RegistryObject<MobEffect> VampirePill = INOEFFECT.register("vampire_pill", NoSpecialPillEffect::new);
    public static final RegistryObject<MobEffect> DamageAbsorptionPill = INOEFFECT.register("damage_absorption_pill", NoSpecialPillEffect::new);
}
