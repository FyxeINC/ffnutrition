package com.fyxeinc.ffnutrition;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

//@EventBusSubscriber(modid = FFNutritionMod.MODID)
public class FFNutritionAttributes
{
//    public static final DeferredRegister<Attribute> ATTRIBUTES =
//            DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, FFNutritionMod.MODID);
//
//    public static final DeferredHolder<Attribute, Attribute> ATTRIBUTE_NUTRITION_SCORE =
//            ATTRIBUTES.register("nutrition_score", () ->
//                    new RangedAttribute("attribute.name.ffnutrition.nutrition_score", 0.0D, 0.0D, 1024.0D)
//                            .setSyncable(true));
//
//    @SubscribeEvent
//    public static void modifyDefaultAttributes(EntityAttributeModificationEvent event)
//    {
//        if (!event.has(EntityType.PLAYER, ATTRIBUTE_NUTRITION_SCORE))
//        {
//            event.add(EntityType.PLAYER, ATTRIBUTE_NUTRITION_SCORE, 0.5D);
//        }
//    }
}