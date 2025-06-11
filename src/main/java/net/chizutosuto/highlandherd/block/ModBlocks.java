package net.chizutosuto.highlandherd.block;

import net.chizutosuto.highlandherd.HighlandHerd;
import net.chizutosuto.highlandherd.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.block.MapColor;


import java.util.function.Function;

public class ModBlocks {

    public static final Block HIGHLAND_THISTLE_PLANT = register(
            "highland_thistle_plant",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.GREEN)
                    .noCollision()
                    .breakInstantly()
                    .nonOpaque()
                    .sounds(BlockSoundGroup.GRASS),
            true
    );

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);

        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Register item if requested
        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(HighlandHerd.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HighlandHerd.MOD_ID, name));
    }

    public static void initialize() {

        ItemGroupEvents.modifyEntriesEvent(ModItems.CUSTOM_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(ModBlocks.HIGHLAND_THISTLE_PLANT.asItem());
        });
    }
}
