package com.fyxeinc.ffnutrition.config;

import net.neoforged.neoforge.common.ModConfigSpec;


public class FFNutritionConfigClient
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC = BUILDER.build();


    public static final ModConfigSpec.BooleanValue TEST_1 = BUILDER
            .comment("ClientTest")
            .define("test1", true);
}
