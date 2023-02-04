package net.natsucamellia.tanzanite;

import net.fabricmc.api.ModInitializer;
import net.natsucamellia.tanzanite.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tanzanite implements ModInitializer {
	public static final String MOD_ID = "tanzanite";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}
