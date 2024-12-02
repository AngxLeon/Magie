package de.angx.komp.utils;

import de.angx.komp.Main;
import io.netty.buffer.Unpooled;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Signierung {

    public static void pickupItem(int slotIndex) {
        PacketBuffer packet = new PacketBuffer(Unpooled.buffer());
        packet.writeByte(0);
        packet.writeShort(slotIndex);
        Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().thePlayer.openContainer.windowId, slotIndex, 0, 0, Minecraft.getMinecraft().thePlayer);
    }

    public static boolean isKeyDown(int pWert) {
        int wert = pWert;

        if (wert < 0) {
            wert = wert + 100;
            if (Mouse.isButtonDown(wert)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (Keyboard.isKeyDown(wert)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void signieren() {
        new Thread(() -> {
            try {
                //Signieren:
                    if (Minecraft.getMinecraft().objectMouseOver != null && Minecraft.getMinecraft().objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                        BlockPos pos = Minecraft.getMinecraft().objectMouseOver.getBlockPos();
                        Block block = Minecraft.getMinecraft().theWorld.getBlockState(pos).getBlock();
                        if (block == Blocks.chest || block == Blocks.trapped_chest) {
                            Minecraft mc = Minecraft.getMinecraft();
                            MovingObjectPosition omo = mc.objectMouseOver;
                            if (mc.playerController.onPlayerRightClick(mc.thePlayer, mc.theWorld, mc.thePlayer.getHeldItem(), omo.getBlockPos(), omo.sideHit, omo.hitVec)) {
                                mc.thePlayer.swingItem();
                            }
                            int M = -9;
                            int N = 0;

                            for (int i = 0; i < 6; i++) {
                                int o = -1;
                                M = M + 9;
                                N = N + 9;

                                for (int j = M; j < N; j++) {
                                    Thread.sleep(150L);
                                    Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().thePlayer.openContainer.windowId, j, 0, 2, Minecraft.getMinecraft().thePlayer);
                                }
                                Minecraft.getMinecraft().thePlayer.closeScreen();
                                Thread.sleep(500L);
                                Minecraft.getMinecraft().thePlayer.inventory.currentItem = 0;
                                Minecraft.getMinecraft().thePlayer.sendChatMessage("/sign " + Main.signText);

                                for (int k = 1; k < 9; k++) {
                                    Thread.sleep(1750L);
                                    Minecraft.getMinecraft().thePlayer.inventory.currentItem = k;
                                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/sign " + Main.signText);
                                }

                                if (mc.playerController.onPlayerRightClick(mc.thePlayer, mc.theWorld, mc.thePlayer.getHeldItem(), omo.getBlockPos(), omo.sideHit, omo.hitVec)) {
                                    mc.thePlayer.swingItem();
                                }

                                for (int l = M; l < N; l++) {
                                    o = o + 1;
                                    Thread.sleep(150L);
                                    Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().thePlayer.openContainer.windowId, l, o, 2, Minecraft.getMinecraft().thePlayer);
                                }
                                Thread.sleep(100L);
                            }
                            Thread.sleep(500L);
                            Minecraft.getMinecraft().thePlayer.closeScreen();
                        }
                    }
                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
