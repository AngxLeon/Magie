package de.angx.komp.utils;

import de.angx.komp.Main;
import de.angx.komp.helper.HelperClass;
import de.angx.komp.helper.TPSHelper;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.util.Random;

public class Komprimerung {

    public static void pickupItem(int slotIndex) {
        Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().thePlayer.openContainer.windowId, slotIndex, 0, 1, Minecraft.getMinecraft().thePlayer);
    }

    public static void Komp1() {
        new Thread(() -> {
            try {

                int ausgewaehlterSlot = Minecraft.getMinecraft().thePlayer.inventory.currentItem;
                ausgewaehlterSlot = ausgewaehlterSlot + 81;

                Thread.sleep(TPSHelper.Komprimierung());
                Minecraft.getMinecraft().thePlayer.sendChatMessage("/rezepte");
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(11);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(ausgewaehlterSlot);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                Minecraft.getMinecraft().thePlayer.closeScreen();
                Main.cooldown = false;


                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void Komp2() {
        new Thread(() -> {
            try {

                int ausgewaehlterSlot = Minecraft.getMinecraft().thePlayer.inventory.currentItem;
                ausgewaehlterSlot = ausgewaehlterSlot + 81;


                Thread.sleep(TPSHelper.Komprimierung());
                Minecraft.getMinecraft().thePlayer.sendChatMessage("/rezepte");
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(11);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(ausgewaehlterSlot);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                Minecraft.getMinecraft().thePlayer.closeScreen();
                Main.cooldown = false;


                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void Komp3() {
        new Thread(() -> {
            try {

                int ausgewaehlterSlot = Minecraft.getMinecraft().thePlayer.inventory.currentItem;
                ausgewaehlterSlot = ausgewaehlterSlot + 81;


                Thread.sleep(TPSHelper.Komprimierung());
                Minecraft.getMinecraft().thePlayer.sendChatMessage("/rezepte");
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(11);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(ausgewaehlterSlot);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                Minecraft.getMinecraft().thePlayer.closeScreen();
                Main.cooldown = false;


                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void Komp4() {
            new Thread(() -> {
                try {

                    int ausgewaehlterSlot = Minecraft.getMinecraft().thePlayer.inventory.currentItem;
                    ausgewaehlterSlot = ausgewaehlterSlot + 81;


                    Thread.sleep(TPSHelper.Komprimierung());
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/rezepte");
                    Thread.sleep(TPSHelper.Komprimierung());
                    pickupItem(11);
                    Thread.sleep(TPSHelper.Komprimierung());
                    pickupItem(ausgewaehlterSlot);
                    Thread.sleep(TPSHelper.Komprimierung());
                    pickupItem(52);
                    Thread.sleep(TPSHelper.Komprimierung());
                    pickupItem(50);
                    Thread.sleep(TPSHelper.Komprimierung());
                    pickupItem(52);
                    Thread.sleep(TPSHelper.Komprimierung());
                    pickupItem(50);
                    Thread.sleep(TPSHelper.Komprimierung());
                    pickupItem(52);
                    Thread.sleep(TPSHelper.Komprimierung());
                    pickupItem(50);
                    Thread.sleep(TPSHelper.Komprimierung());
                    pickupItem(52);
                    Thread.sleep(TPSHelper.Komprimierung());
                    Minecraft.getMinecraft().thePlayer.closeScreen();
                    Main.cooldown = false;


                    Thread.currentThread().interrupt();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    public static void Komp5() {
        new Thread(() -> {
            try {

                int ausgewaehlterSlot = Minecraft.getMinecraft().thePlayer.inventory.currentItem;
                ausgewaehlterSlot = ausgewaehlterSlot + 81;


                Thread.sleep(TPSHelper.Komprimierung());
                Minecraft.getMinecraft().thePlayer.sendChatMessage("/rezepte");
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(11);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(ausgewaehlterSlot);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                Minecraft.getMinecraft().thePlayer.closeScreen();
                Main.cooldown = false;


                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void Komp6() {
        new Thread(() -> {
            try {

                int ausgewaehlterSlot = Minecraft.getMinecraft().thePlayer.inventory.currentItem;
                ausgewaehlterSlot = ausgewaehlterSlot + 81;


                Thread.sleep(TPSHelper.Komprimierung());
                Minecraft.getMinecraft().thePlayer.sendChatMessage("/rezepte");
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(11);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(ausgewaehlterSlot);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                Minecraft.getMinecraft().thePlayer.closeScreen();
                Main.cooldown = false;


                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void Komp7() {
        new Thread(() -> {
            try {

                int ausgewaehlterSlot = Minecraft.getMinecraft().thePlayer.inventory.currentItem;
                ausgewaehlterSlot = ausgewaehlterSlot + 81;


                Thread.sleep(TPSHelper.Komprimierung());
                Minecraft.getMinecraft().thePlayer.sendChatMessage("/rezepte");
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(11);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(ausgewaehlterSlot);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(50);
                Thread.sleep(TPSHelper.Komprimierung());
                pickupItem(52);
                Thread.sleep(TPSHelper.Komprimierung());
                Minecraft.getMinecraft().thePlayer.closeScreen();
                Main.cooldown = false;


                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static Long zufaelligeVeraenderung(double zahl) {
        Random rand = new Random();
        double zufallsFaktor = (rand.nextDouble() * 0.2) - 0.1;
        int veraenderteZahl = (int) Math.round(zahl + (zahl * zufallsFaktor));
        String sZeit = String.valueOf(veraenderteZahl);
        Long Zeit = Long.parseLong(sZeit);

        return Zeit;
    }


    public static void DauerKomp() {
        new Thread(() -> {
            try {

                int ausgewaehlterSlot = Minecraft.getMinecraft().thePlayer.inventory.currentItem;
                ausgewaehlterSlot = ausgewaehlterSlot + 81;

                double dZeit = Double.parseDouble(Main.msGeschwindigkeit);

                Thread.sleep(zufaelligeVeraenderung(dZeit));
                Minecraft.getMinecraft().thePlayer.sendChatMessage("/rezepte");
                Thread.sleep(zufaelligeVeraenderung(dZeit));
                pickupItem(11);
                Thread.sleep(zufaelligeVeraenderung(dZeit));
                pickupItem(ausgewaehlterSlot);
                Thread.sleep(zufaelligeVeraenderung(dZeit));

                for (int o = 0;o<10;o++) {
                    for (int n = 0; n < 10; n++) {
                        for (int m = 0; m < 10; m++) {
                            for (int l = 0; l < 10; l++) {
                                for (int k = 0; k < 10; k++) {
                                    for (int j = 0; j < 10; j++) {
                                        for (int i = 0; i < 10; i++) {
                                            pickupItem(52);
                                            Thread.sleep(zufaelligeVeraenderung(dZeit));
                                        }
                                        pickupItem(50);
                                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                                        pickupItem(52);
                                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                                        pickupItem(48);
                                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                                        System.out.println(Minecraft.getMinecraft().thePlayer.openContainer.getSlot(49).getStack().getDisplayName());
                                        System.out.println("§6Komprimierungsstufe 1");
                                        while (!Minecraft.getMinecraft().thePlayer.openContainer.getSlot(49).getStack().getDisplayName().equals("§6Komprimierungsstufe 1")) {
                                            pickupItem(48);
                                            Thread.sleep(zufaelligeVeraenderung(dZeit));
                                        }
                                    }
                                    pickupItem(50);
                                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                                    pickupItem(50);
                                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                                    pickupItem(52);
                                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                                    pickupItem(48);
                                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                                    pickupItem(48);
                                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                                    while (!Minecraft.getMinecraft().thePlayer.openContainer.getSlot(49).getStack().getDisplayName().equals("§6Komprimierungsstufe 1")) {
                                        pickupItem(48);
                                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                                    }
                                }
                                pickupItem(50);
                                Thread.sleep(zufaelligeVeraenderung(dZeit));
                                pickupItem(50);
                                Thread.sleep(zufaelligeVeraenderung(dZeit));
                                pickupItem(50);
                                Thread.sleep(zufaelligeVeraenderung(dZeit));
                                pickupItem(52);
                                Thread.sleep(zufaelligeVeraenderung(dZeit));
                                pickupItem(48);
                                Thread.sleep(zufaelligeVeraenderung(dZeit));
                                pickupItem(48);
                                Thread.sleep(zufaelligeVeraenderung(dZeit));
                                pickupItem(48);
                                Thread.sleep(zufaelligeVeraenderung(dZeit));
                                while (!Minecraft.getMinecraft().thePlayer.openContainer.getSlot(49).getStack().getDisplayName().equals("§6Komprimierungsstufe 1")) {
                                    pickupItem(48);
                                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                                }
                            }
                            pickupItem(50);
                            Thread.sleep(zufaelligeVeraenderung(dZeit));
                            pickupItem(50);
                            Thread.sleep(zufaelligeVeraenderung(dZeit));
                            pickupItem(50);
                            Thread.sleep(zufaelligeVeraenderung(dZeit));
                            pickupItem(50);
                            Thread.sleep(zufaelligeVeraenderung(dZeit));
                            pickupItem(52);
                            Thread.sleep(zufaelligeVeraenderung(dZeit));
                            pickupItem(48);
                            Thread.sleep(zufaelligeVeraenderung(dZeit));
                            pickupItem(48);
                            Thread.sleep(zufaelligeVeraenderung(dZeit));
                            pickupItem(48);
                            Thread.sleep(zufaelligeVeraenderung(dZeit));
                            pickupItem(48);
                            Thread.sleep(zufaelligeVeraenderung(dZeit));
                            while (!Minecraft.getMinecraft().thePlayer.openContainer.getSlot(49).getStack().getDisplayName().equals("§6Komprimierungsstufe 1")) {
                                pickupItem(48);
                                Thread.sleep(zufaelligeVeraenderung(dZeit));
                            }
                        }
                        pickupItem(50);
                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                        pickupItem(50);
                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                        pickupItem(50);
                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                        pickupItem(50);
                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                        pickupItem(50);
                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                        pickupItem(52);
                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                        pickupItem(48);
                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                        pickupItem(48);
                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                        pickupItem(48);
                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                        pickupItem(48);
                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                        pickupItem(48);
                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                        while (!Minecraft.getMinecraft().thePlayer.openContainer.getSlot(49).getStack().getDisplayName().equals("§6Komprimierungsstufe 1")) {
                            pickupItem(48);
                            Thread.sleep(zufaelligeVeraenderung(dZeit));
                        }
                    }
                    pickupItem(50);
                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                    pickupItem(50);
                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                    pickupItem(50);
                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                    pickupItem(50);
                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                    pickupItem(50);
                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                    pickupItem(50);
                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                    pickupItem(52);
                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                    pickupItem(48);
                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                    pickupItem(48);
                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                    pickupItem(48);
                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                    pickupItem(48);
                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                    pickupItem(48);
                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                    pickupItem(48);
                    Thread.sleep(zufaelligeVeraenderung(dZeit));
                    while (!Minecraft.getMinecraft().thePlayer.openContainer.getSlot(49).getStack().getDisplayName().equals("§6Komprimierungsstufe 1")) {
                        pickupItem(48);
                        Thread.sleep(zufaelligeVeraenderung(dZeit));
                    }
                }

                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void entkomprimierer() throws InterruptedException {
        while (Main.dauerEntKompri) {
            for (int i = 0; i < 54; ) {
                HelperClass.kisteoeffnen();
                Thread.sleep(TPSHelper.Komprimierung());
                if (Minecraft.getMinecraft().thePlayer.openContainer.getSlot(i).getStack() != null) {
                    for (int k = 0; k < 4; k++) {
                        if (i == 52) {
                            k = 2;
                        }
                        Thread.sleep(TPSHelper.Komprimierung());
                        Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().thePlayer.openContainer.windowId, i, 0, 2, Minecraft.getMinecraft().thePlayer);
                        i++;

                    }
                    Minecraft.getMinecraft().thePlayer.closeScreen();
                    Thread.sleep(TPSHelper.Komprimierung());
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/craft");
                    Thread.sleep(TPSHelper.Komprimierung());
                        if (i == 54) {
                            for (int j = 0; j < 2; j++) {
                                Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().thePlayer.openContainer.windowId, 1, j, 2, Minecraft.getMinecraft().thePlayer);
                                Thread.sleep(TPSHelper.Komprimierung());
                                HelperClass.slotLinksKlick(0);
                                Thread.sleep(TPSHelper.Komprimierung());
                            }
                        } else { for (int j = 0; j < 4; j++) {
                            Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().thePlayer.openContainer.windowId, 1, j, 2, Minecraft.getMinecraft().thePlayer);
                            Thread.sleep(TPSHelper.Komprimierung());
                            HelperClass.slotLinksKlick(0);
                            Thread.sleep(TPSHelper.Komprimierung());
                        }
                    }
                    Minecraft.getMinecraft().thePlayer.closeScreen();
                    Thread.sleep(TPSHelper.Komprimierung());
                    HelperClass.invDroppen();
                    Thread.sleep(TPSHelper.Komprimierung());
                } else {
                    Main.dauerEntKompri = false;
                    Minecraft.getMinecraft().thePlayer.closeScreen();
                    Minecraft.getMinecraft().ingameGUI.displayTitle("§4Entkomprimierung beendet!", (String)null, -1, -1, -1);

                    break;
                }
            }
        }
    }

    public static void einzelEntkomprimierer() throws InterruptedException {
        int ausgewaehlterSlot = Minecraft.getMinecraft().thePlayer.inventory.currentItem;
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/craft");
        Thread.sleep(TPSHelper.Komprimierung());
        Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().thePlayer.openContainer.windowId, 1, ausgewaehlterSlot, 2, Minecraft.getMinecraft().thePlayer);
        Thread.sleep(TPSHelper.Komprimierung());
        HelperClass.slotLinksKlick(0);
        Thread.sleep(TPSHelper.Komprimierung());
        Minecraft.getMinecraft().thePlayer.closeScreen();
    }
}