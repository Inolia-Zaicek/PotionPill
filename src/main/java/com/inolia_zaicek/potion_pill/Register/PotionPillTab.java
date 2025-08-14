package com.inolia_zaicek.potion_pill.Register;

import com.inolia_zaicek.potion_pill.Item.PotionPillItem; // 确保导入 PotionPillItem
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.inolia_zaicek.potion_pill.PotionPill.MODID;


public class PotionPillTab {
    public static final DeferredRegister<CreativeModeTab> creative_mode_tab= DeferredRegister.create(Registries.CREATIVE_MODE_TAB,MODID);
    public static final String MoreModTetraTab="item_group.potion_pill.tab";
    public static final Supplier<CreativeModeTab> materials=creative_mode_tab.register("item",()-> CreativeModeTab.builder()
            //槽位位置
            .withTabsBefore(CreativeModeTabs.COMBAT)
            //物品栏名称
            .title(Component.translatable(MoreModTetraTab))
            //图标
            .icon(PotionPillItemRegister.PotionPill.get()::getDefaultInstance)
            .displayItems((itemDisplayParameters, output) -> {
                // 遍历 CommonItem 列表中的物品 (保留，如果你有其他普通物品)
                for(RegistryObject<Item> curios: PotionPillItemRegister.CommonItem){
                    if(curios.isPresent() && curios.get() != PotionPillItemRegister.PotionPill.get()){ // 避免重复添加PotionPill的基础版本
                        output.accept(curios.get());
                    }
                }

                // 添加所有药水药丸
                // 遍历所有注册的药水（包括原版的和mod添加的）
                for (Potion potion : ForgeRegistries.POTIONS) {
                    if (potion.getEffects().isEmpty() && !potion.hasInstantEffects()) {
                        // 跳过空药水或纯粹的瞬时效果药水，除非你希望它们也显示
                        // Potions.EMPTY 药水不会有效果，通常不显示其药丸
                        // 如果 potion.hasInstantEffects() 且 effects.isEmpty()，说明是水瓶、不可见的药水等
                        // 根据你的需求，你可能需要更精确的过滤
                        continue;
                    }

                    ItemStack pillStack = PotionUtils.setPotion(new ItemStack(PotionPillItemRegister.PotionPill.get()), potion);
                    output.accept(pillStack);
                }
                // 新增：将 PillMaker 方块物品添加到创造物品栏
                output.accept(PotionPillItemRegister.PillMakerBlockItem.get());
            })
            .build()
    );
    public static void register(IEventBus bus){
        creative_mode_tab.register(bus);
    }
}
