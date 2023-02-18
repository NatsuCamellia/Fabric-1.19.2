package net.natsucamellia.tanzanite;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.render.RenderLayer;
import net.natsucamellia.tanzanite.block.ModBlocks;
import net.natsucamellia.tanzanite.client.ThirstHudOverlay;
import net.natsucamellia.tanzanite.event.KeyInputHandler;

public class TanzaniteClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EGGPLANT_CROP, RenderLayer.getCutout());

        KeyInputHandler.register();

        HudRenderCallback.EVENT.register(new ThirstHudOverlay());
    }
}
