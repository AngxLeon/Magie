package de.angx.komp.Events;

import de.angx.komp.utils.Komprimerung;
import ibxm.Player;
import net.labymod.api.events.PluginMessageEvent;
import net.labymod.utils.ServerData;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.S38PacketPlayerListItem;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OnJoinEvent {

    public static String player;
    public static List<String> cachePlayerJoins = new ArrayList();

    @SubscribeEvent
    public void onJoin(EntityJoinWorldEvent event) {
        if (event.entity instanceof EntityPlayer) {
            if (!Objects.equals(event.entity.getName(), player)) {
                if (!event.entity.getName().contains(" ")) {
                    if (!event.entity.getName().contains("§")) {
                        player = event.entity.getName();
                        if (cachePlayerJoins.size() > 5) {
                            cachePlayerJoins.set(0, cachePlayerJoins.get(1));
                            cachePlayerJoins.set(1, cachePlayerJoins.get(2));
                            cachePlayerJoins.set(2, cachePlayerJoins.get(3));
                            cachePlayerJoins.set(3, cachePlayerJoins.get(4));
                            cachePlayerJoins.set(4, cachePlayerJoins.get(5));
                            cachePlayerJoins.set(5, "§8[§a+§8] §f" + event.entity.getName());
                        } else {
                            cachePlayerJoins.add("§8[§a+§8] §f" + event.entity.getName());
                        }
                    }
                }
            }
        }
    }
}
