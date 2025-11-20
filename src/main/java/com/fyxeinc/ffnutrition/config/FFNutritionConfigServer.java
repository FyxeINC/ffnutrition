package com.fyxeinc.ffnutrition.config;

import net.neoforged.neoforge.common.ModConfigSpec;


public class FFNutritionConfigServer
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC = BUILDER.build();


    public static final ModConfigSpec.BooleanValue TEST_2 = BUILDER
            .comment("ServerTest")
            .define("test2", true);
}
