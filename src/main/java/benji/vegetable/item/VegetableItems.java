package benji.vegetable.item;

import benji.vegetable.Vegetable;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class VegetableItems {
    public static final int TICKS_PER_SECOND = 20;
    public static final int SECONDS_PER_MINUTE = 60;

    public static Item ZUCCHINI = register(
            "zucchini",
            Item::new,
            new Item.Settings().food(VegetableFoodComponents.ZUCCHINI_FOOD_COMPONENT, VegetableFoodComponents.ZUCCHINI_CONSUMABLE_COMPONENT)
    );

    public static void registerModItems() {
        Vegetable.LOGGER.info("Registering Mod Items for " + Vegetable.MOD_ID);
        Registry.register(Registries.ITEM_GROUP, VegetableItemGroups.VEGETABLE_GROUP_KEY, VegetableItemGroups.VEGETABLE_GROUP);

        ItemGroupEvents.modifyEntriesEvent(VegetableItemGroups.VEGETABLE_GROUP_KEY).register(itemGroup -> {
            // Zucchini
            itemGroup.add(ZUCCHINI);
        });
    }

    public static void initialize() {
        registerModItems();
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Vegetable.MOD_ID, name));

        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
}
