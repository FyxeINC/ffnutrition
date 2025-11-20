package com.fyxeinc.ffnutrition.network;

import com.fyxeinc.ffnutrition.FFNutritionMod;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

//public record FFNutritionPayload(int entityId, CompoundTag data) implements CustomPacketPayload
//{
//    public static final CustomPacketPayload.Type<FFNutritionPayload> TYPE =
//            new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(FFNutritionMod.MODID, "nutrition_update"));
//
//    /**
//     * We encode as: [entityId : VAR_INT] [data : TRUSTED_COMPOUND_TAG]
//     * Using a compound tag keeps the StreamCodec simple and allows flexible structure.
//     */
//    public static final StreamCodec<FriendlyByteBuf, FFNutritionPayload> STREAM_CODEC =
//            StreamCodec.composite(
//                    ByteBufCodecs.VAR_INT,
//                    FFNutritionPayload::entityId,
//                    ByteBufCodecs.TRUSTED_COMPOUND_TAG,
//                    FFNutritionPayload::data,
//                    FFNutritionPayload::new
//            );
//
//    @Override
//    public CustomPacketPayload.Type<? extends CustomPacketPayload> type()
//    {
//        return TYPE;
//    }
//
//}
