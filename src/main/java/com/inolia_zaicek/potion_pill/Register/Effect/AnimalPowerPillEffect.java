package com.inolia_zaicek.potion_pill.Register.Effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class AnimalPowerPillEffect extends MobEffect {
    private static final String ATTACK_DAMAGE_UUID = "82C635F7-EAEB-EF16-9A4D-3F1AC2592389";
    private static final String UUID1 = "43855599-2D6B-EB37-1677-E91859621DD9";
    private static final String UUID2 = "EAAE2A2E-9E88-DAF1-237A-54938273837E";
    private static final String UUID3 = "E69C63F5-C138-B2C3-C279-E3B1BA481C6A";
    private static final double NUMBER = 0.1;

    public AnimalPowerPillEffect() {
        super(MobEffectCategory.BENEFICIAL, 0);
        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ATTACK_DAMAGE_UUID, NUMBER, AttributeModifier.Operation.MULTIPLY_TOTAL);
        this.addAttributeModifier(Attributes.MAX_HEALTH, UUID1, NUMBER, AttributeModifier.Operation.MULTIPLY_TOTAL);
        this.addAttributeModifier(Attributes.ATTACK_KNOCKBACK, UUID2, NUMBER, AttributeModifier.Operation.MULTIPLY_TOTAL);
        this.addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, UUID3, NUMBER, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }
}
