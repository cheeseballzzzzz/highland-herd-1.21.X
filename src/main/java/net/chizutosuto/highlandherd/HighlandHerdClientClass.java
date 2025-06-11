package net.chizutosuto.highlandherd;

import net.chizutosuto.highlandherd.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class HighlandHerdClientClass implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HIGHLAND_THISTLE_PLANT, RenderLayer.getCutout());

    }
}
