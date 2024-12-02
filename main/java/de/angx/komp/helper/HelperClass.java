package de.angx.komp.helper;

import io.netty.buffer.Unpooled;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class HelperClass {

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

    public static void kisteoeffnen() {
        if (Minecraft.getMinecraft().objectMouseOver != null && Minecraft.getMinecraft().objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            BlockPos pos = Minecraft.getMinecraft().objectMouseOver.getBlockPos();
            Block block = Minecraft.getMinecraft().theWorld.getBlockState(pos).getBlock();
            if (block == Blocks.chest || block == Blocks.trapped_chest || block == Blocks.hopper || block == Blocks.mob_spawner) {
                Minecraft mc = Minecraft.getMinecraft();
                MovingObjectPosition omo = mc.objectMouseOver;
                if (mc.playerController.onPlayerRightClick(mc.thePlayer, mc.theWorld, mc.thePlayer.getHeldItem(), omo.getBlockPos(), omo.sideHit, omo.hitVec)) {
                    mc.thePlayer.swingItem();
                }
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

    public static void pickupItem(int slotIndex) {
        PacketBuffer packet = new PacketBuffer(Unpooled.buffer());
        packet.writeByte(0);
        packet.writeShort(slotIndex);
        Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().thePlayer.openContainer.windowId, slotIndex, 0, 0, Minecraft.getMinecraft().thePlayer);
    }

    public static void slotLinksKlick(int slotIndex) {
        Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().thePlayer.openContainer.windowId, slotIndex, 0, 1, Minecraft.getMinecraft().thePlayer);
    }

    public static void slotDroppen(int slotIndex) {
        Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().thePlayer.inventoryContainer.windowId, slotIndex, 1, 4, Minecraft.getMinecraft().thePlayer);
    }

    public static void invDroppen() throws InterruptedException {
        for (int i = 9; i < 45; i++) {
            Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().thePlayer.inventoryContainer.windowId, i, 1, 4, Minecraft.getMinecraft().thePlayer);
            Thread.sleep(TPSHelper.invLeerung());
        }
    }

    public static boolean inventoryCheck() {
        boolean isFull = true;
        for (int j = 0; j < 36; j++) {
            ItemStack stack = Minecraft.getMinecraft().thePlayer.openContainer.getSlot(j).getStack();
            if (stack == null) {
                isFull = false;
                return isFull;
            }
        }
        return isFull;
    }








}
