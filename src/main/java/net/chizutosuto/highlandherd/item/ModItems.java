package net.chizutosuto.highlandherd.item;

import net.chizutosuto.highlandherd.HighlandHerd;
import net.chizutosuto.highlandherd.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    // 1. Define a key for your item group
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(
            RegistryKeys.ITEM_GROUP,
            Identifier.of(HighlandHerd.MOD_ID, "custom_group")
    );

    // 2. Register the custom item group
    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, ItemGroup.create(
                        ItemGroup.Row.TOP, 0  // You can change placement and row
                )
                .displayName(Text.translatable("itemGroup." + HighlandHerd.MOD_ID + ".custom_group"))
                .icon(() -> new ItemStack(ModBlocks.HIGHLAND_THISTLE_PLANT.asItem()))
                .entries((displayContext, entries) -> {
                    entries.add(ModBlocks.HIGHLAND_THISTLE_PLANT);
                })
                .build());
    }
}
