package com.inolia_zaicek.potion_pill.Register;

import com.inolia_zaicek.potion_pill.Item.PotionPillItem; // 新增导入
import com.inolia_zaicek.potion_pill.Item.SpecialPillItem.LevelUP.AnimalPowerPillItem;
import com.inolia_zaicek.potion_pill.Item.SpecialPillItem.LevelUP.DragonPowerPillItem;
import com.inolia_zaicek.potion_pill.Item.SpecialPillItem.LevelUP.IronhidePillItem;
import com.inolia_zaicek.potion_pill.Item.SpecialPillItem.LevelUP.WardPillItem;
import com.inolia_zaicek.potion_pill.Item.SpecialPillItem.Special.*;
import com.inolia_zaicek.potion_pill.Item.SpecialPillItem.TargetedPotionPillItem;
import com.inolia_zaicek.potion_pill.Item.SpecialPillItem.TimeUP.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem; // 新增导入
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;
import java.util.function.Supplier;

import static com.inolia_zaicek.potion_pill.PotionPill.MODID;


public class PotionPillItemRegister {
    public static final DeferredRegister<Item> ZeroingITEM=DeferredRegister.create(Registries.ITEM,MODID);
    public static final DeferredRegister<Item> PatchouliITEM=DeferredRegister.create(Registries.ITEM,MODID);
    public static List<RegistryObject<Item>> CommonItem=new ArrayList<>(List.of());

    public static RegistryObject<Item> registerCommonMaterials(DeferredRegister<Item> register,String name, Supplier<? extends Item> sup){
        RegistryObject<Item> object = register.register(name,sup);
        CommonItem.add(object);
        return object;
    }
    // tag
    public static final TagKey<Item> leavesTag = TagKey.create(Registries.ITEM,new ResourceLocation("minecraft","leaves"));
    public static final TagKey<Item> flowersTag = TagKey.create(Registries.ITEM,new ResourceLocation("minecraft","flowers"));
    //原版
    // 修改 PotionPill 注册，使用新的 PotionPillItem 类
    public static final RegistryObject<Item> PotionPill = registerCommonMaterials(ZeroingITEM,"potion_pill", () -> new PotionPillItem(new Item.Properties().stacksTo(64)));

    // 新增 PillMaker 方块对应的物品
    // 注意：PillMaker 方块物品不添加到 CommonItem 列表中，因为它是一个方块物品，通常直接添加到创造模式物品栏
    public static final RegistryObject<Item> PillMakerBlockItem = ZeroingITEM.register("pill_maker",
            () -> new BlockItem(PotionPillBlockRegister.PillMakerBlock.get(), new Item.Properties().stacksTo(64)));
    //书
    //public static final RegistryObject<Item> PharmaceuticalNotes = registerCommonMaterials(PatchouliITEM,"pharmaceutical_notes", () -> new TooltipItem(new Item.Properties().stacksTo(1)));
    //容器
    public static final RegistryObject<Item> AStackOfPotionPillPapers = registerCommonMaterials(ZeroingITEM,"a_stack_of_potion_pill_papers", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> RefinePotionPillCloth = registerCommonMaterials(ZeroingITEM,"refine_potion_pill_cloth", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> MedicinalMaterialsBottle = registerCommonMaterials(ZeroingITEM,"medicinal_materials_bottle", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> BoneDust = registerCommonMaterials(ZeroingITEM,"bone_dust", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    //末影珍珠
    public static final RegistryObject<Item> StaticStateEnderPearl = registerCommonMaterials(ZeroingITEM,"static_state_ender_pearl", () -> new Item(new Item.Properties().stacksTo(64)));
    //草药
    public static final RegistryObject<Item> ExtremelyPotentHoltMedicinalHerbs = registerCommonMaterials(ZeroingITEM,"extremely_potent_holt_medicinal_herbs", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ModeratelyPotentHoltMedicinalHerbs = registerCommonMaterials(ZeroingITEM,"moderately_potent_holt_medicinal_herbs", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> MildlyPotentHoltMedicinalHerbs = registerCommonMaterials(ZeroingITEM,"mildly_potent_holt_medicinal_herbs", () -> new TooltipItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> ExtremelyPotentColdMedicinalHerbs = registerCommonMaterials(ZeroingITEM,"extremely_potent_cold_medicinal_herbs", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ModeratelyPotentColdMedicinalHerbs = registerCommonMaterials(ZeroingITEM,"moderately_potent_cold_medicinal_herbs", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> MildlyPotentColdMedicinalHerbs = registerCommonMaterials(ZeroingITEM,"mildly_potent_cold_medicinal_herbs", () -> new TooltipItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> ExtremelyPotentWarmMedicinalHerbs = registerCommonMaterials(ZeroingITEM,"extremely_potent_warm_medicinal_herbs", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ModeratelyPotentWarmMedicinalHerbs = registerCommonMaterials(ZeroingITEM,"moderately_potent_warm_medicinal_herbs", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> MildlyPotentWarmMedicinalHerbs = registerCommonMaterials(ZeroingITEM,"mildly_potent_warm_medicinal_herbs", () -> new TooltipItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> ExtremelyPotentCoolMedicinalHerbs = registerCommonMaterials(ZeroingITEM,"extremely_potent_cool_medicinal_herbs", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ModeratelyPotentCoolMedicinalHerbs = registerCommonMaterials(ZeroingITEM,"moderately_potent_cool_medicinal_herbs", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> MildlyPotentCoolMedicinalHerbs = registerCommonMaterials(ZeroingITEM,"mildly_potent_cool_medicinal_herbs", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    //药材
    //热性
    public static final RegistryObject<Item> ConcentratedDragonBreath = registerCommonMaterials(ZeroingITEM,"concentrated_dragon_breath", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> EssenceOfBeast = registerCommonMaterials(ZeroingITEM,"essence_of_beast", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> EssenceOfDeath = registerCommonMaterials(ZeroingITEM,"essence_of_death", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> EssenceOfLava = registerCommonMaterials(ZeroingITEM,"essence_of_lava", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> MoltenNetherite = registerCommonMaterials(ZeroingITEM,"molten_netherite", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> EssenceOfBlaze = registerCommonMaterials(ZeroingITEM,"essence_of_blaze", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    //寒性
    public static final RegistryObject<Item> FrostSpiritWater = registerCommonMaterials(ZeroingITEM,"frostspirit_water", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> EssenceOfSnow = registerCommonMaterials(ZeroingITEM,"essence_of_snow", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> EssenceOfPoison = registerCommonMaterials(ZeroingITEM,"essence_of_poison", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    //凉性
    public static final RegistryObject<Item> LeafJuice = registerCommonMaterials(ZeroingITEM,"leaf_juice", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> MoltenIron = registerCommonMaterials(ZeroingITEM,"molten_iron", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> MoltenCopper = registerCommonMaterials(ZeroingITEM,"molten_copper", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> MoltenGold = registerCommonMaterials(ZeroingITEM,"molten_gold", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> EssenceOfDiamond = registerCommonMaterials(ZeroingITEM,"essence_of_diamond", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> EssenceOfAmethyst = registerCommonMaterials(ZeroingITEM,"essence_of_amethyst", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    //温性
    public static final RegistryObject<Item> EssenceOfLife = registerCommonMaterials(ZeroingITEM,"essence_of_life", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> MedicinalEssenceBeads = registerCommonMaterials(ZeroingITEM,"medicinal_essence_beads", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> EssenceOfNature = registerCommonMaterials(ZeroingITEM,"essence_of_nature", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> BottledEnderDust = registerCommonMaterials(ZeroingITEM,"bottled_ender_dust", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> EssenceOfRevive = registerCommonMaterials(ZeroingITEM,"essence_of_revive", () -> new TooltipItem(new Item.Properties().stacksTo(64)));
    //丹药
    public static final RegistryObject<Item> DragonPowerPill = registerCommonMaterials(ZeroingITEM, "dragon_power_pill",
            () -> new DragonPowerPillItem(new Item.Properties().stacksTo(64))); // 可以添加 fireResistant 属性，使其更像龙的物品
    public static final RegistryObject<Item> AnimalPowerPill = registerCommonMaterials(ZeroingITEM, "animal_power_pill",
            () -> new AnimalPowerPillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> WardPowerPill = registerCommonMaterials(ZeroingITEM, "ward_pill",
            () -> new WardPillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> IronhidePill = registerCommonMaterials(ZeroingITEM, "ironhide_pill",
            () -> new IronhidePillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> CopperArmorPill = registerCommonMaterials(ZeroingITEM, "copper_armor_pill",
            () -> new CopperArmorPillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> IronArmorPill = registerCommonMaterials(ZeroingITEM, "iron_armor_pill",
            () -> new IronArmorPillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> DiamondArmorPill = registerCommonMaterials(ZeroingITEM, "diamond_armor_pill",
            () -> new DiamondArmorPillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> NetheriteArmorPill = registerCommonMaterials(ZeroingITEM, "netherite_armor_pill",
            () -> new NetheriteArmorPillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> RevivalPill = registerCommonMaterials(ZeroingITEM, "revival_pill",
            () -> new RevivalPillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> RejuvenationPill = registerCommonMaterials(ZeroingITEM, "rejuvenation_pill",
            () -> new RejuvenationPillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> BoneforgePill = registerCommonMaterials(ZeroingITEM, "boneforge_pill",
            () -> new BoneforgePillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> MendingPill = registerCommonMaterials(ZeroingITEM, "mending_pill",
            () -> new MendingPillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ChillheartPill = registerCommonMaterials(ZeroingITEM, "chillheart_pill",
            () -> new ChillHeartPillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> FrostspiritPill = registerCommonMaterials(ZeroingITEM, "frostspirit_pill",
            () -> new FrostSpiritPillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ZephyrPill = registerCommonMaterials(ZeroingITEM, "zephyr_pill",
            () -> new ZephyrPillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ZenithZephyrPill = registerCommonMaterials(ZeroingITEM, "zenith_zephyr_pill",
            () -> new ZenithZephyrPillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> NightVisionPill = registerCommonMaterials(ZeroingITEM, "night_vision_pill",
            () -> new NightVisionPillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> RevivePill = registerCommonMaterials(ZeroingITEM, "revive_pill",
            () -> new RevivePillItem(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> UndyingPill = registerCommonMaterials(ZeroingITEM, "undying_pill",
            () -> new UndyingPillItem(new Item.Properties().stacksTo(64)));
    //非玩家丹药
    public static final RegistryObject<Item> HealthUpPill = registerCommonMaterials(ZeroingITEM, "health_up_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
                    // 药水效果，最大等级-1
                    () -> new MobEffectInstance(PotionPillEffectsRegister.HealthUpPill.get(), -1, 0),9));
    public static final RegistryObject<Item> BoneUpPill = registerCommonMaterials(ZeroingITEM, "bone_up_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.BoneUpPill.get(), -1, 0),9));
    public static final RegistryObject<Item> BodyUpPill = registerCommonMaterials(ZeroingITEM, "body_up_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.BodyUpPill.get(), -1, 0),9));


    public static final RegistryObject<Item> StrongPill = registerCommonMaterials(ZeroingITEM, "strong_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.StrongPill.get(), -1, 0),9));
    public static final RegistryObject<Item> AttackUpPill = registerCommonMaterials(ZeroingITEM, "attack_up_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.AttackUpPill.get(), -1, 0),9));
    public static final RegistryObject<Item> PowerUpPill = registerCommonMaterials(ZeroingITEM, "power_up_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.PowerUpPill.get(), -1, 0),9));


    public static final RegistryObject<Item> CrystalSkinPill = registerCommonMaterials(ZeroingITEM, "crystal_skin_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.CrystalSkinPill.get(), -1, 0),4));
    public static final RegistryObject<Item> ShiningBloodPill = registerCommonMaterials(ZeroingITEM, "shining_blood_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.ShiningBloodPill.get(), -1, 0),4));
    public static final RegistryObject<Item> BlackArmorPill = registerCommonMaterials(ZeroingITEM, "black_armor_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.BlackArmorPill.get(), -1, 0),9));


    public static final RegistryObject<Item> NirvanaPill = registerCommonMaterials(ZeroingITEM, "nirvana_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.NirvanaPill.get(), -1, 0),8));
    public static final RegistryObject<Item> NonplayerRevivePill = registerCommonMaterials(ZeroingITEM, "nonplayer_revive_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.NonplayerRevivePill.get(), -1, 0),0));


    public static final RegistryObject<Item> AstutePill = registerCommonMaterials(ZeroingITEM, "astute_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.AstutePill.get(), -1, 0),4));
    public static final RegistryObject<Item> HoldBreathPill = registerCommonMaterials(ZeroingITEM, "hold_breath_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.HoldBreathPill.get(), -1, 0),4));
    public static final RegistryObject<Item> LightBodyPill = registerCommonMaterials(ZeroingITEM, "light_body_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.LightBodyPill.get(), -1, 0),4));


    public static final RegistryObject<Item> ArrowResistancePill = registerCommonMaterials(ZeroingITEM, "arrow_resistance_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.ArrowResistancePill.get(), -1, 0),4));
    public static final RegistryObject<Item> ExplosionResistancePill = registerCommonMaterials(ZeroingITEM, "explosion_resistance_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.ExplosionResistancePill.get(), -1, 0),4));
    public static final RegistryObject<Item> FreezeResistancePill = registerCommonMaterials(ZeroingITEM, "freeze_resistance_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.FreezeResistancePill.get(), -1, 0),4));
    public static final RegistryObject<Item> LavaResistancePill = registerCommonMaterials(ZeroingITEM, "lava_resistance_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.LavaResistancePill.get(), -1, 0),4));
    public static final RegistryObject<Item> ThunderResistancePill = registerCommonMaterials(ZeroingITEM, "thunder_resistance_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.ThunderResistancePill.get(), -1, 0),4));
    public static final RegistryObject<Item> VoidResistancePill = registerCommonMaterials(ZeroingITEM, "void_resistance_pill", () -> new TargetedPotionPillItem(new Item.Properties().stacksTo(64),
            // 药水效果，最大等级-1
            () -> new MobEffectInstance(PotionPillEffectsRegister.VoidResistancePill.get(), -1, 0),4));



    public PotionPillItemRegister(){
    }

    public static void register(IEventBus bus){
        ZeroingITEM.register(bus);
        if(ModList.get().isLoaded("patchouli")){
            PatchouliITEM.register(bus);
        }
    }
}
