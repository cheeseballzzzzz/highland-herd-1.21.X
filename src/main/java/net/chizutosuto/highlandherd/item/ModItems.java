package net.chizutosuto.highlandherd.item;

import net.chizutosuto.highlandherd.HighlandHerd;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final  Item HIGHLAND_THISTLE = registerItem("highland_thistle", new Item(new Item.Settings() .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HighlandHerd.MOD_ID,"highland_thistle")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(HighlandHerd.MOD_ID, name), item);
    }

    public static void registerModItems() {

        HighlandHerd.LOGGER.info("Registering Mod Items for " + HighlandHerd.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register( entries -> {
            entries.add(HIGHLAND_THISTLE);
        } );
    }
}
