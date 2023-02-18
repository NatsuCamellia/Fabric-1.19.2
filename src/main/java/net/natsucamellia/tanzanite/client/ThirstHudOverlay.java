package net.natsucamellia.tanzanite.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.natsucamellia.tanzanite.Tanzanite;
import net.natsucamellia.tanzanite.util.IEntityDataSaver;

public class ThirstHudOverlay implements HudRenderCallback {
    public static final Identifier FILLED_THIRST = new Identifier(Tanzanite.MOD_ID,
            "textures/thirst/filled_thirst.png");
    public static final Identifier EMPTY_THIRST = new Identifier(Tanzanite.MOD_ID,
            "textures/thirst/empty_thirst.png");

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        int x = 0;
        int y = 0;

        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width / 2;
            y = height;
        }

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, EMPTY_THIRST);

        for (int i = 0; i < 10; i++) {
            DrawableHelper.drawTexture(matrixStack, x - 94 + (i * 9), y - 54, 0, 0,
                    12, 12, 12, 12);
        }

        RenderSystem.setShaderTexture(0, FILLED_THIRST);
        for (int i = 0; i < 10; i++) {
            if (((IEntityDataSaver) client.player).getPersistentData().getInt("thirst") > i) {
                DrawableHelper.drawTexture(matrixStack, x - 94 + (i * 9), y - 54, 0, 0,
                        12, 12, 12, 12);
            } else {
                break;
            }
        }
    }
}
