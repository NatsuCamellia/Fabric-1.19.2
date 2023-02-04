package net.natsucamellia.tanzanite.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.natsucamellia.tanzanite.Tanzanite;

public class ModItems {

    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));

    public static final Item TANZANITE = registerItem("tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Tanzanite.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Tanzanite.LOGGER.debug("Registering Mod Items for " + Tanzanite.MOD_ID);
    }
}