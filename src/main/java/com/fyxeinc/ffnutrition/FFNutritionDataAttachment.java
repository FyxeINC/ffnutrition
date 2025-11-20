package com.fyxeinc.ffnutrition;

import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

/**
 * FFNutritionData — stores a dynamic list of doubles per LivingEntity using NeoForge attachments.
 *
 * IMPORTANT: call FFNutritionData.ATTACHMENT_TYPES.register(modEventBus) in your mod constructor.
 */
//@EventBusSubscriber(modid = FFNutritionMod.MODID)
public class FFNutritionDataAttachment
{
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, FFNutritionMod.MODID);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<NutritionData>> NUTRITION_DATA =
            ATTACHMENT_TYPES.register("nutrition_data",
                    () -> AttachmentType.serializable(NutritionData::new).build());

//    public static final Supplier<AttachmentType<NutritionData>> NUTRITION_DATA_SYNCED
//            = ATTACHMENT_TYPES.register(
//                    "nutrition_data",
//                    () -> AttachmentType.builder(() -> new NutritionData())
//                    .sync(new NutritionDataSyncHandler())
//                    .build()
//    );
}

