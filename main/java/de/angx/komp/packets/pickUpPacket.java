package de.angx.komp.packets;

import de.angx.komp.Main;
import de.angx.komp.helper.TPSHelper;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.network.play.server.S05PacketSpawnPosition;
import net.minecraft.network.play.server.S0DPacketCollectItem;

import java.util.Objects;

public class pickUpPacket implements Consumer<Object> {

    @Override
    public void accept(Object o) {
        if (o instanceof S0DPacketCollectItem) {
            S0DPacketCollectItem S0DPacketCollectItem = (S0DPacketCollectItem) o;
            Entity entity = Minecraft.getMinecraft().theWorld.getEntityByID(S0DPacketCollectItem.getCollectedItemEntityID());
            if (entity instanceof EntityItem) {
                new Thread(() -> {
                    try {
                        if (Main.invSort) {
                            for (int i = 9; i < 36; ) {
                                int id = Integer.parseInt(Main.invText);
                                if (Minecraft.getMinecraft().thePlayer.inventory.getStackInSlot(i) != null && Minecraft.getMinecraft().thePlayer.inventory.getStackInSlot(i).getItem() != Item.getItemById(id)) {
                                    Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().thePlayer.openContainer.windowId, i, 1, 4, Minecraft.getMinecraft().thePlayer);
                                    Thread.sleep(TPSHelper.invLeerung());
                                }
                                i++;
                            }
                        }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            }
        }
    }
}
