package com.inolia_zaicek.potion_pill.Register;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.inolia_zaicek.potion_pill.PotionPill.MODID;

public class PotionPillEffectsRegister {
    public static final DeferredRegister<MobEffect> INOEFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,MODID);
    //决斗
    public static final RegistryObject<MobEffect> NitenIchiryuKatana = INOEFFECT.register("niten_ichiryu_katana", com.inolia_zaicek.potion_pill.Register.Effect.NitenIchiryuKatana::new);

}
