package com.inolia_zaicek.potion_pill;

// import com.inolia_zaicek.daily_delight.Curios.BentoBox.WoodenBentoBoxCurios; // This class might be removed or adapted if you fully replace it

import com.inolia_zaicek.potion_pill.Register.PotionPillEffectsRegister;
import com.inolia_zaicek.potion_pill.Register.PotionPillItemRegister;
import com.inolia_zaicek.potion_pill.Register.PotionPillTab;
import com.mojang.logging.LogUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.*;

@SuppressWarnings({"all", "removal"})
@Mod.EventBusSubscriber(modid = PotionPill.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
@Mod(PotionPill.MODID)
public class PotionPill {

    public static final String MODID = "potion_pill";
    public static final Logger LOGGER = LogUtils.getLogger();
    public PotionPill() {
        init();
    }
    public void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        //注册卷轴
        PotionPillTab.register(bus);
        PotionPillItemRegister.register(bus);
        PotionPillEffectsRegister.INOEFFECT.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
        // 注册 FML 生命周期事件
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        //监听事件
        //MinecraftForge.EVENT_BUS.register(new Duel());
        //MinecraftForge.EVENT_BUS.register(Duel.class);
    }

    @SubscribeEvent
    public void commonSetup(FMLCommonSetupEvent event){
    }

    // 客户端设置事件，用于注册渲染器和GUI屏幕
    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
        });
    }

    //注册掉落物
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();
        if (event.includeServer()) {
        }
    }

    public static ResourceLocation prefix(String name){
        return new ResourceLocation(MODID,name.toLowerCase(Locale.ROOT));
    }

}
