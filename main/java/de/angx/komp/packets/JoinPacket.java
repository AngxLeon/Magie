package de.angx.komp.packets;

import com.mojang.authlib.yggdrasil.response.MinecraftTexturesPayload;
import de.angx.komp.Main;
import ibxm.Player;
import net.labymod.utils.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.network.play.server.S05PacketSpawnPosition;
import net.minecraft.network.play.server.S38PacketPlayerListItem;
import net.minecraft.network.play.server.S39PacketPlayerAbilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JoinPacket implements Consumer<Object> {

    public static List<String> cachePlayerJoins = new ArrayList();
    Map<String, String> playerCache = new HashMap<>();
    boolean cooldown = true;


    @Override
    public void accept(Object o) {
        if (o instanceof S38PacketPlayerListItem) {
            S38PacketPlayerListItem S38PacketPlayerListItem = (S38PacketPlayerListItem) o;
            String Player = String.valueOf(S38PacketPlayerListItem.getEntries());
            String[] nameparts = Player.split("name=");
            String[] uuidparts = Player.split("id=");
            if (nameparts.length > 1) {
                String name = nameparts[1].split(",")[0];
                String uuid = uuidparts[1].split(",")[0];
                String aktion = String.valueOf(S38PacketPlayerListItem.getAction());


                if (aktion.equals("ADD_PLAYER")) {
                    if (!name.contains(Minecraft.getMinecraft().getSession().getUsername())) {
                        if (!name.contains("<null>")) {
                            if (!name.contains(" ")) {
                                if (!name.contains("§")) {
                                    playerCache.put(uuid, name);
                                    if (cachePlayerJoins.size() > 5) {
                                        cachePlayerJoins.set(0, cachePlayerJoins.get(1));
                                        cachePlayerJoins.set(1, cachePlayerJoins.get(2));
                                        cachePlayerJoins.set(2, cachePlayerJoins.get(3));
                                        cachePlayerJoins.set(3, cachePlayerJoins.get(4));
                                        cachePlayerJoins.set(4, cachePlayerJoins.get(5));
                                        cachePlayerJoins.set(5, "§8[§a+§8] §7" + name);
                                    } else {
                                        cachePlayerJoins.add("§8[§a+§8] §7" + name);
                                    }
                                }
                            }
                        }
                    }
                } else if (aktion.equals("REMOVE_PLAYER")) {
                    if (playerCache.get(uuid) != null) {
                        if (!playerCache.get(uuid).contains(Minecraft.getMinecraft().getSession().getUsername())) {
                            if (!playerCache.get(uuid).contains("<null>")) {
                                if (!playerCache.get(uuid).contains(" ")) {
                                    if (!playerCache.get(uuid).contains("§")) {
                                        if (cachePlayerJoins.size() > 5) {
                                            cachePlayerJoins.set(0, cachePlayerJoins.get(1));
                                            cachePlayerJoins.set(1, cachePlayerJoins.get(2));
                                            cachePlayerJoins.set(2, cachePlayerJoins.get(3));
                                            cachePlayerJoins.set(3, cachePlayerJoins.get(4));
                                            cachePlayerJoins.set(4, cachePlayerJoins.get(5));
                                            cachePlayerJoins.set(5, "§8[§4-§8] §7" + playerCache.get(uuid));
                                        } else {
                                            cachePlayerJoins.add("§8[§4-§8] §7" + playerCache.get(uuid));
                                        } if (Main.evilHelfer && cooldown) {
                                            Minecraft.getMinecraft().thePlayer.sendChatMessage("/tpaccept");
                                            cooldown = false;
                                            try {
                                                Thread.sleep(3000L);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                            cooldown = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

