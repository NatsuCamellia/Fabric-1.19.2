package net.natsucamellia.tanzanite;

import net.fabricmc.api.ModInitializer;
import net.natsucamellia.tanzanite.block.ModBlocks;
import net.natsucamellia.tanzanite.item.ModItems;
import net.natsucamellia.tanzanite.painting.ModPaintings;
import net.natsucamellia.tanzanite.villager.ModVillagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tanzanite implements ModInitializer {
	public static final String MOD_ID = "tanzanite";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		ModPaintings.registerPaintings();
	}
}
