package benji.vegetables.item;

import benji.vegetables.Vegetables;
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

    public static Item ZUCHINI = register(
            "zuchini",
            Item::new,
            new Item.Settings().food()
    )


    public static void registerModItems() {
        Vegetables.LOGGER.info("Registering Mod Items for " + Vegetables.MOD_ID);
        Registry.register(Registries.ITEM_GROUP, VegetableItemGroups.VEGETABLE_GROUP_KEY, VegetableItemGroups.VEGETABLE_GROUP);

        ItemGroupEvents.modifyEntriesEvent(VegetableItemGroups.VEGETABLE_GROUP_KEY).register(itemGroup -> {

        });
    }

    public static void initialize() {
        registerModItems();
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Vegetables.MOD_ID, name));

        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
}
