package benji.vegetables.item;

import benji.vegetables.Vegetables;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class VegetableItemGroups {
    public static final RegistryKey<ItemGroup> VEGETABLE_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Vegetables.MOD_ID, "vegetables_item_group"));
    public static final ItemGroup VEGETABLE_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(VegetableItems.ZUCHINI))
            .displayName(Text.translatable("vegetablesItemGroup.vegetables"))
            .build();
}
