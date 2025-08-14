package com.inolia_zaicek.potion_pill;

// import com.inolia_zaicek.daily_delight.Curios.BentoBox.WoodenBentoBoxCurios; // This class might be removed or adapted if you fully replace it

import com.inolia_zaicek.potion_pill.Event.NonPlayerPillEvent;
import com.inolia_zaicek.potion_pill.Event.Pill.*;
import com.inolia_zaicek.potion_pill.Event.Pill.NonPlayer.Damage.AttackUpPillEffectEvent;
import com.inolia_zaicek.potion_pill.Event.Pill.NonPlayer.Damage.PowerUpPillEffectEvent;
import com.inolia_zaicek.potion_pill.Event.Pill.NonPlayer.Damage.StrongPillEffectEvent;
import com.inolia_zaicek.potion_pill.Event.Pill.NonPlayer.Heal.VmpirePillEffectEvent;
import com.inolia_zaicek.potion_pill.Event.Pill.NonPlayer.Resistance.*;
import com.inolia_zaicek.potion_pill.Event.PillMakerInteractionEvent; // 新增导入
import com.inolia_zaicek.potion_pill.Register.PotionPillBlockRegister;
import com.inolia_zaicek.potion_pill.Register.PotionPillEffectsRegister;
import com.inolia_zaicek.potion_pill.Register.PotionPillItemRegister;
import com.inolia_zaicek.potion_pill.Register.PotionPillRecipe;
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
        PotionPillBlockRegister.register(bus);
        PotionPillEffectsRegister.INOEFFECT.register(bus);
        PotionPillRecipe.SERIALIZERS.register(bus); // 注册配方序列化器
        MinecraftForge.EVENT_BUS.register(this);
        // 新增：注册方块交互事件处理器
        MinecraftForge.EVENT_BUS.register(new PillMakerInteractionEvent()); // 修改为实例化对象
        MinecraftForge.EVENT_BUS.register(new NonPlayerPillEvent());
        // 注册 FML 生命周期事件
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        //监听事件
        MinecraftForge.EVENT_BUS.register(new DragonPowerPillEffectEvent());
        MinecraftForge.EVENT_BUS.register(new ChillheartPillEffectEvent());
        MinecraftForge.EVENT_BUS.register(new IronhidePillEffectEvent());
        MinecraftForge.EVENT_BUS.register(new WardPillEffectEvent());
        MinecraftForge.EVENT_BUS.register(new FrostspiritPillEffectEvent());
        MinecraftForge.EVENT_BUS.register(new ZephyrPillEffectEvent());
        //
        MinecraftForge.EVENT_BUS.register(new AttackUpPillEffectEvent());
        MinecraftForge.EVENT_BUS.register(new PowerUpPillEffectEvent());
        MinecraftForge.EVENT_BUS.register(new StrongPillEffectEvent());

        MinecraftForge.EVENT_BUS.register(new ArrowResistancePillEffectEvent());
        MinecraftForge.EVENT_BUS.register(new ExplosionResistancePillEffectEvent());
        MinecraftForge.EVENT_BUS.register(new FreezeResistancePillEffectEvent());
        MinecraftForge.EVENT_BUS.register(new HoldBreathPillEffectEvent());
        MinecraftForge.EVENT_BUS.register(new LavaResistancePillEffectEvent());
        MinecraftForge.EVENT_BUS.register(new LightBodyPillEffectEvent());
        MinecraftForge.EVENT_BUS.register(new ThunderResistancePillEffectEvent());
        MinecraftForge.EVENT_BUS.register(new VoidResistancePillEffectEvent());

        MinecraftForge.EVENT_BUS.register(new VmpirePillEffectEvent());
        MinecraftForge.EVENT_BUS.register(new VoidResistancePillEffectEvent());
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
