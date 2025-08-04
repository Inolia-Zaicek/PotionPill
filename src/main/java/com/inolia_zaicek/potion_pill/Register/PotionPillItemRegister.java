package com.inolia_zaicek.potion_pill.Register;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;
import java.util.function.Supplier;

import static com.inolia_zaicek.potion_pill.PotionPill.MODID;


public class PotionPillItemRegister {
    public static final DeferredRegister<Item> ZeroingITEM=DeferredRegister.create(Registries.ITEM,MODID);
    public static List<RegistryObject<Item>> CommonItem=new ArrayList<>(List.of());

    public static RegistryObject<Item> registerCommonMaterials(DeferredRegister<Item> register,String name, Supplier<? extends Item> sup){
        RegistryObject<Item> object = register.register(name,sup);
        CommonItem.add(object);
        return object;
    }
    // tag
    public static final TagKey<Item> stoneTag = TagKey.create(Registries.ITEM,new ResourceLocation("minecraft","stone_tool_materials"));
    public static final TagKey<Item> stoneTag2 = TagKey.create(Registries.ITEM,new ResourceLocation("forge","stone"));
    //原版
    public static final RegistryObject<Item> PotionPill = registerCommonMaterials(ZeroingITEM,"potion_pill", () -> new Item(new Item.Properties().stacksTo(64)));

    public PotionPillItemRegister(){
    }

    public static void register(IEventBus bus){
        ZeroingITEM.register(bus);
    }
}
