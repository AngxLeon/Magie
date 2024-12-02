package de.angx.komp.utils;

import de.angx.komp.Main;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.util.ArrayList;
import java.util.List;

public class Chests {

    public static boolean anaus = false;
    public static List<Vec3> list = new ArrayList<Vec3>();

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

    public static void position(Vec3 position) {
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        Vec3 playerPos = new Vec3(player.posX, player.getEyeHeight() + player.posY, player.posZ);
        Vec3 directionalVector = new Vec3(position.xCoord - playerPos.xCoord, position.yCoord - playerPos.yCoord, position.zCoord - playerPos.zCoord).normalize();

        float yaw = -(float) Math.toDegrees(Math.atan2(directionalVector.xCoord, directionalVector.zCoord));
        float pitch = (float) Math.toDegrees(Math.asin(-directionalVector.yCoord));
        Minecraft.getMinecraft().thePlayer.setPositionAndRotation(player.posX, player.posY, player.posZ, yaw, pitch);
    }

    public static void kisteoeffnen() {
        if (Minecraft.getMinecraft().objectMouseOver != null && Minecraft.getMinecraft().objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            BlockPos pos = Minecraft.getMinecraft().objectMouseOver.getBlockPos();
            Block block = Minecraft.getMinecraft().theWorld.getBlockState(pos).getBlock();
            if (block == Blocks.chest || block == Blocks.trapped_chest || block == Blocks.mob_spawner) {
                Minecraft mc = Minecraft.getMinecraft();
                MovingObjectPosition omo = mc.objectMouseOver;
                if (mc.playerController.onPlayerRightClick(mc.thePlayer, mc.theWorld, mc.thePlayer.getHeldItem(), omo.getBlockPos(), omo.sideHit, omo.hitVec)) {
                    mc.thePlayer.swingItem();
                }
            }
        }
    }

    public static void speichern() throws InterruptedException {
        int anzahl = 0;
        list.clear();
        while (anaus) {
            if (isKeyDown(Keyboard.KEY_C)) {
                Thread.sleep(500L);
                kisteoeffnen();
                Thread.sleep(500L);
                Minecraft.getMinecraft().thePlayer.closeScreen();
                Thread.sleep(500L);

                list.add(anzahl, new Vec3(Minecraft.getMinecraft().objectMouseOver.getBlockPos().getX(), Minecraft.getMinecraft().objectMouseOver.getBlockPos().getY() + 0.5, Minecraft.getMinecraft().objectMouseOver.getBlockPos().getZ() + 0.5));
                Minecraft.getMinecraft().ingameGUI.displayTitle("§aErfolgreich eingespeichert!", (String) null, -1, -1, -1);
                anzahl = anzahl + 1;
            }
        }
        Minecraft.getMinecraft().ingameGUI.displayTitle("§4Einlernen beendet", (String) null, -1, -1, -1);
    }
    public static void nutzeKisten(String Funktion) throws InterruptedException {
        for (int i=0;i<list.size();) {
            if (Funktion == "sign") {
                position(list.get(i));
                Thread.sleep(250L);
                Signierung.signieren();
                Thread.sleep(105000L);
                i++;
            }
        }
    }
}
