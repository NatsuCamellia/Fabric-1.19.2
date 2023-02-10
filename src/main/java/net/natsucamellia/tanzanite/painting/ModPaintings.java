package net.natsucamellia.tanzanite.painting;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.natsucamellia.tanzanite.Tanzanite;

public class ModPaintings {

    public static final PaintingVariant SUNSET = registerPainting("sunset", new PaintingVariant(32, 16));
    public static final PaintingVariant PLANT = registerPainting("plant", new PaintingVariant(16, 16));
    public static final PaintingVariant WANDERER = registerPainting("wanderer", new PaintingVariant(16, 32));

    private static PaintingVariant registerPainting(String name, PaintingVariant variant) {
        return Registry.register(Registry.PAINTING_VARIANT, new Identifier(Tanzanite.MOD_ID, name), variant);
    }

    public static void registerPaintings() {
        Tanzanite.LOGGER.debug("Registering Paintings for " + Tanzanite.MOD_ID);
    }
}
