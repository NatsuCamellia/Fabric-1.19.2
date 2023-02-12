package net.natsucamellia.tanzanite.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.natsucamellia.tanzanite.Tanzanite;
import net.natsucamellia.tanzanite.networking.packet.DrinkingC2SPacket;
import net.natsucamellia.tanzanite.networking.packet.ExampleC2SPacket;

public class ModMessages {
    public static final Identifier DRINKING_ID = new Identifier(Tanzanite.MOD_ID, "drinking");
    public static final Identifier THIRST_SYNC_ID = new Identifier(Tanzanite.MOD_ID, "thirst_sync");
    public static final Identifier EXAMPLE_ID = new Identifier(Tanzanite.MOD_ID, "example");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(DRINKING_ID, DrinkingC2SPacket::receive);
    }

    public static void registerS2CPackets() {

    }
}
