package net.natsucamellia.tanzanite.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.natsucamellia.tanzanite.networking.ModMessages;

public class ThirstData {
    public static int addThirst(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int thirst = nbt.getInt("thirst");

        thirst = Math.min(10, thirst + amount);
        nbt.putInt("thirst", thirst);

        syncThirst(thirst, ((ServerPlayerEntity) player));
        return thirst;
    }

    public static int removeThirst(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int thirst = nbt.getInt("thirst");

        thirst = Math.max(0, thirst - amount);
        nbt.putInt("thirst", thirst);

        syncThirst(thirst, ((ServerPlayerEntity) player));
        return thirst;
    }

    public static void syncThirst(int thirst, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(thirst);
        ServerPlayNetworking.send(player, ModMessages.THIRST_SYNC_ID, buffer);
    }
}
