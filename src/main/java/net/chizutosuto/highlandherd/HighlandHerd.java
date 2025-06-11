package net.chizutosuto.highlandherd;

import net.chizutosuto.highlandherd.block.ModBlocks;
import net.chizutosuto.highlandherd.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HighlandHerd implements ModInitializer {
	public static final String MOD_ID = "highlandherd";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.initialize();

	}
}