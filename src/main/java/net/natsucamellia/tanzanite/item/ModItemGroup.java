package net.natsucamellia.tanzanite.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.natsucamellia.tanzanite.Tanzanite;

public class ModItemGroup {
    public static final ItemGroup TANZANITE = FabricItemGroupBuilder.build(
            new Identifier(Tanzanite.MOD_ID, "tanzanite"), () -> new ItemStack(ModItems.TANZANITE));
}
