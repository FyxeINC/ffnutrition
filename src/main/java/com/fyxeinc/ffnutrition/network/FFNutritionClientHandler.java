package com.fyxeinc.ffnutrition.network;

import com.fyxeinc.ffnutrition.FFNutritionDataAttachment;
import com.fyxeinc.ffnutrition.NutritionData;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/**
 * Client-side handling for nutrition updates.
 */
//public class FFNutritionClientHandler
//{
//    public static void handle(final FFNutritionPayload payload, final IPayloadContext context)
//    {
//        /*
//         * Default behavior: handler is invoked on the main thread per docs.
//         * Use context.enqueueWork if you need explicit scheduling; here we still enqueue to be safe.
//         */
//        context.enqueueWork(() ->
//        {
//            Minecraft minecraft = Minecraft.getInstance();
//            if (minecraft.level == null)
//            {
//                return;
//            }
//
//            int entityId = payload.entityId();
//            if (minecraft.level.getEntity(entityId) == null)
//            {
//                return;
//            }
//
//            if (!(minecraft.level.getEntity(entityId) instanceof LivingEntity living))
//            {
//                return;
//            }
//
//            NutritionData data = living.getData(FFNutritionDataAttachment.NUTRITION_DATA);
//            if (data == null)
//            {
//                return;
//            }
//
//            CompoundTag tag = payload.data();
//
//            data.loadFromNBT(tag);
//
//            // Apply simple primitive
////            double score = tag.getDouble("score");
////            data.setNutritionScore(score);
////
////            // Apply map from compound "map" (keys -> double)
////            CompoundTag mapTag = tag.getCompound("map");
////            Map<String, Double> map = new HashMap<>();
////            for (String key : mapTag.getAllKeys())
////            {
////                double value = mapTag.getDouble(key);
////                map.put(key, value);
////            }
////            data.setNutritionValueCollection(map);
//        });
//    }
//}
