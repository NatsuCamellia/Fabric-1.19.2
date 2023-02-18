package net.natsucamellia.tanzanite.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.block.Blocks;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.natsucamellia.tanzanite.util.IEntityDataSaver;
import net.natsucamellia.tanzanite.util.ThirstData;

public class DrinkingC2SPacket {
    private static final String MESSAGE_DRINKING_WATER = "message.tanzanite.drank_water";
    private static final String MESSAGE_NO_WATER_NEARBY = "message.tanzanite.no_water";

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        // Everything here happens ONLY on the server
        ServerWorld world = player.getWorld();
        if (isAroundWater(player, world, 2)) {
            // Notify Player
            player.sendMessage(Text.translatable(MESSAGE_DRINKING_WATER)
                    .fillStyle(Style.EMPTY.withColor(Formatting.DARK_AQUA)), false);

            // Play the drinking sound
            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.PLAYERS,
                    0.5f, world.random.nextFloat() * 0.1f + 0.9f);

            // Actually add the water level to the player
            ThirstData.addThirst(((IEntityDataSaver) player), 1);

            // Outputting the current thirst level of player
            player.sendMessage(Text.literal("Thirst: " + ((IEntityDataSaver) player).getPersistentData().getInt("thirst"))
                    .fillStyle(Style.EMPTY.withColor(Formatting.AQUA)), true);
        } else {
            // Notify Player
            player.sendMessage(Text.translatable(MESSAGE_NO_WATER_NEARBY)
                    .fillStyle(Style.EMPTY.withColor(Formatting.RED)), false);

            int thirst = ((IEntityDataSaver) player).getPersistentData().getInt("thirst");

            // Outputting the current thirst level of player
            player.sendMessage(Text.literal("Thirst: " + thirst)
                    .fillStyle(Style.EMPTY.withColor(Formatting.AQUA)), true);

            // Sync thirst
            ThirstData.syncThirst(thirst, player);
        }

    }

    private static boolean isAroundWater(ServerPlayerEntity player, ServerWorld world, int size) {
        return BlockPos.stream(player.getBoundingBox().expand(size))
                .map(world::getBlockState).filter(state -> state.isOf(Blocks.WATER)).toArray().length > 0;
    }
}
