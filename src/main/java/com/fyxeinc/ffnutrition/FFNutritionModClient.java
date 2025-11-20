package com.fyxeinc.ffnutrition;

import com.fyxeinc.ffnutrition.config.FFNutritionConfigCommon;
import com.fyxeinc.ffnutrition.data.FFNutritionItemDataLoader;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
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
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = FFNutritionMod.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = FFNutritionMod.MODID, value = Dist.CLIENT)
public class FFNutritionModClient
{
    public FFNutritionModClient(ModContainer container)
    {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        //container.registerConfig(ModConfig.Type.COMMON, FFNutritionConfigCommon.SPEC);

        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event)
    {
        // Some client setup code
        //FFNutritionMod.LOGGER.info("HELLO FROM CLIENT SETUP");
        //FFNutritionMod.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    private static void onItemTooltip(ItemTooltipEvent event)
    {
        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();

        Item item = stack.getItem();
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        String idString = id.toString();

//        FoodProperties foodProperties = item.getDefaultInstance().get(DataComponents.FOOD);
//        if (foodProperties == null)
//        {
//            return;
//        }

        if (!FFNutritionItemDataLoader.getHasNutritionValues(item))
        {
            return;
        }

        if (!Screen.hasShiftDown())
        {
            tooltip.add(Component.literal("Hold SHIFT for nutrition info")
                    .setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY).withItalic(true))
            );
            return;
        }

        double[] nutrition = FFNutritionItemDataLoader.getNutritionValues(item);

        if (nutrition != null)
        {
            for (int i = 0; i < nutrition.length; i++)
            {
                String categoryName = FFNutritionItemDataLoader.getNutritionCategoryAtIndex(i);
                // We don't give exact values because these are just the compositions of the items
                // Exact values are determined by the composition * multipliers that are set on the server only

                String line = ""; //String.format("%-12s %s", i + "):", String.format("%6.2f", nutrition[i]));
                if (nutrition[i] >= 1.1)
                {
                    line = "Overwhelmingly " + categoryName;
                }
                else if (nutrition[i] >= 1.0)
                {
                    line = "Entirely " + categoryName;
                }
                else if (nutrition[i] >= 0.8)
                {
                    line = "Mostly " + categoryName;
                }
                else if (nutrition[i] >= 0.7)
                {
                    line = "Largely " + categoryName;
                }
                else if (nutrition[i] >= 0.6)
                {
                    line = "Mainly " + categoryName;
                }
                else if (nutrition[i] >= 0.5)
                {
                    line = "Partly " + categoryName;
                }
                else if (nutrition[i] >= 0.4)
                {
                    line = "Some " + categoryName;
                }
                else if (nutrition[i] >= 0.3)
                {
                    line = "A bit of " + categoryName;
                }
                else if (nutrition[i] >= 0.2)
                {
                    line = "Barely any " + categoryName;
                }
                else if (nutrition[i] >= 0.1)
                {
                    line = "Trace " + categoryName;
                }
                else if (nutrition[i] >= 0.01)
                {
                    line = "A pinch of " + categoryName;
                }
                else if (nutrition[i] >= 0.001)
                {
                    line = "A molecule of " + categoryName;
                }

                if (!line.isEmpty())
                {
                    tooltip.add(Component.literal(line).setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
                }
            }
        }
    }


}