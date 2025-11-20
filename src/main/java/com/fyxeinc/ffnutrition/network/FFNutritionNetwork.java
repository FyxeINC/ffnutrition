package com.fyxeinc.ffnutrition.network;

import com.fyxeinc.ffnutrition.FFNutritionMod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

/**
 * Registers the custom payload. This runs on the mod event bus automatically because of @EventBusSubscriber.
 */
//@EventBusSubscriber(modid = FFNutritionMod.MODID)
//public class FFNutritionNetwork
//{
//
//    @SubscribeEvent
//    public static void registerPayloads(final RegisterPayloadHandlersEvent event)
//    {
//        // Use a protocol version string (arbitrary). Keep on MAIN thread for client handler (default).
//        PayloadRegistrar registrar = event.registrar("1");
//
//        // Register a clientbound payload. We only need client handling (server sends).
//        registrar.playToClient(
//                FFNutritionPayload.TYPE,
//                FFNutritionPayload.STREAM_CODEC,
//                (payload, context) -> FFNutritionClientHandler.handle(payload, context)
//        );
//
//        // If you later need to handle this payload on the server, use playToServer or playBidirectional.
//    }
//}
