package com.fyxeinc.ffnutrition.data;

import com.fyxeinc.ffnutrition.FFNutritionEvents;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.util.GsonHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FFNutritionItemDataLoader extends SimpleJsonResourceReloadListener
{

    private static final Gson GSON = new Gson();
    private static final Map<Item, double[]> ITEM_NUTRITION_MAP = new HashMap<>();
    private static final List<String> NUTRITION_CATEGORIES = new ArrayList<>();
    public static final FFNutritionItemDataLoader INSTANCE = new FFNutritionItemDataLoader();

    private FFNutritionItemDataLoader()
    {
        super(GSON, "item_nutrition"); // folder under data/<modid>/
    }

    @Override
    protected void apply(@NotNull Map<ResourceLocation, JsonElement> elements,
                         @NotNull ResourceManager resourceManager,
                         @NotNull ProfilerFiller profiler)
    {
        // Load nutrition category definitions
        NUTRITION_CATEGORIES.clear();
        try
        {
            ResourceLocation categoriesLoc = ResourceLocation.fromNamespaceAndPath("ffnutrition", "nutrition_categories.json");
            resourceManager.getResource(categoriesLoc).ifPresent(resource ->
            {
                try (BufferedReader reader = resource.openAsReader())
                {
                    JsonObject root = GsonHelper.parse(reader);
                    JsonArray categoriesArray = GsonHelper.getAsJsonArray(root, "categories");
                    for (JsonElement e : categoriesArray)
                    {
                        NUTRITION_CATEGORIES.add(e.getAsString());
                    }
                }
                catch (Exception e)
                {
                    System.err.println("[FFNutrition] Failed to load nutrition_categories.json: " + e);
                }
            });
        }
        catch (Exception ignored)
        {
            // Not required — fallback if file is missing
        }


        // Load item nutrition data
        ITEM_NUTRITION_MAP.clear();

        for (Map.Entry<ResourceLocation, JsonElement> entry : elements.entrySet())
        {
            JsonObject obj = GsonHelper.convertToJsonObject(entry.getValue(), "item_nutrition");
            String itemId = GsonHelper.getAsString(obj, "item");
            JsonArray valuesArray = GsonHelper.getAsJsonArray(obj, "values");

            double[] values = new double[valuesArray.size()];
            for (int i = 0; i < valuesArray.size(); i++)
            {
                values[i] = valuesArray.get(i).getAsDouble();
            }

            Item item = BuiltInRegistries.ITEM.get(ResourceLocation.parse(itemId));
            if (item != null)
            {
                ITEM_NUTRITION_MAP.put(item, values);
            }
        }

        System.out.println("Loaded " + ITEM_NUTRITION_MAP.size() + " item nutrition entries");

        FFNutritionEvents.cacheItemNutritionInfo(true);
    }

    public static double[] getNutritionValues(Item item)
    {
        return ITEM_NUTRITION_MAP.getOrDefault(item, new double[]{0, 0, 0, 0, 0});
    }

    public static boolean getHasNutritionValues(Item item)
    {
        return ITEM_NUTRITION_MAP.containsKey(item);
    }

    public static Map<Item, double[]> getItemNutritionMap()
    {
        return ITEM_NUTRITION_MAP;
    }

    public static List<String> getNutritionCategories()
    {
        return NUTRITION_CATEGORIES;
    }

    public static String getNutritionCategoryAtIndex(int index)
    {
        if (index < 0 || index >= NUTRITION_CATEGORIES.size())
        {
            return "UNKNOWN";
        }
        return NUTRITION_CATEGORIES.get(index);
    }

}