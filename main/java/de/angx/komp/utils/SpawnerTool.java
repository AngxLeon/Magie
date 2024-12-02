package de.angx.komp.utils;

import de.angx.komp.Main;
import de.angx.komp.helper.HelperClass;
import de.angx.komp.helper.TPSHelper;
import de.angx.komp.settings.Settings;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;

public class SpawnerTool {

    public static boolean inventoryCheck() {
        boolean isFull = true;
        for (int j=54; j<90; j++) {
            ItemStack stack = Minecraft.getMinecraft().thePlayer.openContainer.getSlot(j).getStack();
            if (stack == null) {
                isFull = false;
                return isFull;
            }
        }
        return isFull;
    }

    public static void spawner() {
        new Thread(() -> {
            try {
                    if (Main.filter) {
                        if (Minecraft.getMinecraft().objectMouseOver != null && Minecraft.getMinecraft().objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                            BlockPos pos = Minecraft.getMinecraft().objectMouseOver.getBlockPos();
                            Block block = Minecraft.getMinecraft().theWorld.getBlockState(pos).getBlock();
                            if (block == Blocks.mob_spawner) {
                                Minecraft mc = Minecraft.getMinecraft();
                                MovingObjectPosition omo = mc.objectMouseOver;
                                if (mc.playerController.onPlayerRightClick(mc.thePlayer, mc.theWorld, mc.thePlayer.getHeldItem(), omo.getBlockPos(), omo.sideHit, omo.hitVec)) {
                                    mc.thePlayer.swingItem();
                                }
                                Thread.sleep(750L);
                                Settings.FilterEnum selectedOption = Settings.customFilter.getSelected();
                                String Auswahl = selectedOption.toString();
                                if (Auswahl.equals("RedstoneErz")) {
                                    Auswahl = "Redstone-Erz";
                                }
                                for (int i = 1; i <= 53;) {
                                    if (inventoryCheck() == true) {
                                        Minecraft.getMinecraft().thePlayer.closeScreen();
                                        Thread.sleep(TPSHelper.SpawnerTool());
                                        Minecraft.getMinecraft().ingameGUI.displayTitle("§4Inventar voll!", (String)null, -1, -1, -1);
                                        break;
                                        }
                                    else {
                                        if (Minecraft.getMinecraft().thePlayer.openContainer.getSlot(i).getStack() != null) {

                                            String itemName = Minecraft.getMinecraft().thePlayer.openContainer.getInventory().get(i).getDisplayName();
                                            if (itemName.equals(Auswahl)) {
                                                Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().thePlayer.openContainer.windowId, i, 0, 1, Minecraft.getMinecraft().thePlayer);
                                                Thread.sleep(TPSHelper.SpawnerTool());
                                                if (Minecraft.getMinecraft().thePlayer.openContainer.getSlot(i).getStack() == null) {
                                                    i++;
                                                } else {
                                                    continue;
                                                }
                                            } else {
                                                i++;
                                            }
                                        }
                                        else {
                                            i++;
                                        }
                                    }
                                }
                            }
                            Thread.sleep(TPSHelper.SpawnerTool());
                            Minecraft.getMinecraft().thePlayer.closeScreen();
                        }
                    }


                    if (!Main.filter) {
                        if (Minecraft.getMinecraft().objectMouseOver != null && Minecraft.getMinecraft().objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                            BlockPos pos = Minecraft.getMinecraft().objectMouseOver.getBlockPos();
                            Block block = Minecraft.getMinecraft().theWorld.getBlockState(pos).getBlock();
                            if (block == Blocks.mob_spawner) {
                                Minecraft mc = Minecraft.getMinecraft();
                                MovingObjectPosition omo = mc.objectMouseOver;
                                if (mc.playerController.onPlayerRightClick(mc.thePlayer, mc.theWorld, mc.thePlayer.getHeldItem(), omo.getBlockPos(), omo.sideHit, omo.hitVec)) {
                                    mc.thePlayer.swingItem();
                                }
                                Thread.sleep(750L);
                                for (int i = 1; i <= 53;) {
                                    if (inventoryCheck()) {
                                        Minecraft.getMinecraft().thePlayer.closeScreen();
                                        Thread.sleep(TPSHelper.SpawnerTool());
                                        Minecraft.getMinecraft().ingameGUI.displayTitle("§4Inventar voll!", (String)null, -1, -1, -1 );
                                        break;
                                    }
                                    else {
                                        if (Minecraft.getMinecraft().thePlayer.openContainer.getSlot(i).getStack() != null) {

                                            String itemName = Minecraft.getMinecraft().thePlayer.openContainer.getInventory().get(i).getDisplayName();
                                            if (itemName.equals("Bruchstein") || itemName.equals("Stein") || itemName.equals("Erde") || itemName.equals("Kohle") || itemName.equals("Redstone") || itemName.equals("Lapislazuli") || itemName.equals("Goldbarren") || itemName.equals("Eisenbarren") || itemName.equals("Smaragd") || itemName.equals("Diamant") || itemName.equals("Steinkohle") || itemName.equals("Redstone-Erz") || itemName.equals("Lapislazulierz") || itemName.equals("Golderz") || itemName.equals("Eisenerz") || itemName.equals("Smaragderz") || itemName.equals("Diamanterz") || itemName.equals("Prismarinkristalle") || itemName.equals("Prismarinscherbe") || itemName.equals("Roher Kabeljau") || itemName.equals("Tintenbeutel") || itemName.equals("Magmacreme") || itemName.equals("Ghastträne")) {
                                                Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().thePlayer.openContainer.windowId, i, 0, 1, Minecraft.getMinecraft().thePlayer);
                                                Thread.sleep(TPSHelper.SpawnerTool());
                                                if (Minecraft.getMinecraft().thePlayer.openContainer.getSlot(i).getStack() == null) {
                                                    i++;
                                                } else {
                                                    continue;
                                                }
                                            } else {
                                                i++;
                                            }
                                        }
                                        else {
                                            i++;
                                        }
                                    }
                                }
                            }
                            Thread.sleep(TPSHelper.SpawnerTool());
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
