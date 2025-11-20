package com.fyxeinc.ffnutrition;

import com.fyxeinc.ffnutrition.config.FFNutritionConfigCommon;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// This will ONLY load for dedicated servers, not for singleplayer instances
@Mod(value = FFNutritionMod.MODID, dist = Dist.DEDICATED_SERVER)
//@EventBusSubscriber(modid = FFNutritionMod.MODID, value = Dist.DEDICATED_SERVER)
public class FFNutritionModDedicatedServer
{

    public FFNutritionModDedicatedServer(ModContainer container)
    {
        //container.registerConfig(ModConfig.Type.COMMON, FFNutritionConfigCommon.SPEC);
    }


}
