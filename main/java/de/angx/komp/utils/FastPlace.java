package de.angx.komp.utils;

import de.angx.komp.Main;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.lang.reflect.Field;

public class FastPlace {

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

    public static void place() {
        new Thread(() -> {
            while (isKeyDown(Main.fastplace)) {
                try {
                    Field delay = Minecraft.class.getDeclaredField("rightClickDelayTimer");
                    delay.setAccessible(true);
                    delay.set(Minecraft.getMinecraft(), 0);
                } catch (NoSuchFieldException e) {
                    try {
                        Field delay = Minecraft.class.getDeclaredField("field_71467_ac");
                        delay.setAccessible(true);
                        delay.set(Minecraft.getMinecraft(), 0);
                    } catch (NoSuchFieldException | IllegalAccessException e2) {
                        e.printStackTrace();
                    }

                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            Thread.currentThread().interrupt();
        }).start();
    }
}
