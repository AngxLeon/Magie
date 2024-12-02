package de.angx.komp.Events;

import de.angx.komp.Main;
import de.angx.komp.settings.Settings;
import de.angx.komp.utils.*;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;



public class Listener {

    public boolean isKeyDown(int pWert) {
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

    @SubscribeEvent
    public void onTick(InputEvent.KeyInputEvent event) {
        new Thread(() -> {
            try {
                if (!Main.cooldown) {
                    if (isKeyDown(Main.komp)) {
                        if (Settings.kompFilter.getSelected() == Settings.KompEnum.StufeI) {
                            Komprimerung.Komp1();
                        } else if (Settings.kompFilter.getSelected() == Settings.KompEnum.StufeII) {
                            Komprimerung.Komp2();
                        } else if (Settings.kompFilter.getSelected() == Settings.KompEnum.StufeIII) {
                            Komprimerung.Komp3();
                        } else if (Settings.kompFilter.getSelected() == Settings.KompEnum.StufeIV) {
                            Komprimerung.Komp4();
                        } else if (Settings.kompFilter.getSelected() == Settings.KompEnum.StufeV) {
                            Komprimerung.Komp5();
                        } else if (Settings.kompFilter.getSelected() == Settings.KompEnum.StufeVI) {
                            Komprimerung.Komp6();
                        } else if (Settings.kompFilter.getSelected() == Settings.KompEnum.StufeVII) {
                            Komprimerung.Komp7();
                        }
                    } else if (isKeyDown(Main.dauerKomp)) {
                        Komprimerung.DauerKomp();
                    } else if (isKeyDown(Main.signkey)) {
                        Chests.nutzeKisten("sign");
                        //Signierung.signieren();
                    } else if (isKeyDown(Main.spawnerTool)) {
                        //Chests.nutzeKisten("spawner");
                        SpawnerTool.spawner();
                    } else if (isKeyDown(Main.fastplace)) {
                        FastPlace.place();
                    } else if (isKeyDown(Main.craftEinspeichern)) {
                        //Craft.einspeichern();
                    } else if (isKeyDown(Main.entkomprimiererEinzeln)) {
                        Komprimerung.einzelEntkomprimierer();
                    } else if (isKeyDown(Main.entkomprimiererUnendlich)) {
                        if (!Main.dauerEntKompri) {
                            Main.dauerEntKompri = true;
                            Minecraft.getMinecraft().ingameGUI.displayTitle("§aEntkomprimierung Aktiviert!", (String) null, -1, -1, -1);
                            Komprimerung.entkomprimierer();
                        } else {
                            Main.dauerEntKompri = false;
                            Minecraft.getMinecraft().ingameGUI.displayTitle("§4Entkomprimierung Deaktiviert!", (String) null, -1, -1, -1);
                        }
                    } else if (isKeyDown(Keyboard.KEY_LSHIFT)) {
                        Trichter.trichterEinstellung();
                    } else if (isKeyDown(Main.KistenEinlernen)) {
                        if (!Chests.anaus) {
                            Chests.anaus = true;
                            Minecraft.getMinecraft().ingameGUI.displayTitle("§cDrücke C um eine Kiste einzulernen.", (String) null, -1, -1, -1);
                            Chests.speichern();
                        } else {
                            Chests.anaus = false;
                            Minecraft.getMinecraft().ingameGUI.displayTitle("§4Entkomprimiert Deaktiviert!", (String) null, -1, -1, -1);
                        }
                        Chests.speichern();
                    }
                }

                Thread.sleep(1000L);

                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @SubscribeEvent
    public void onTick2(InputEvent.MouseInputEvent event) {
        new Thread(() -> {
            try {
                    if (isKeyDown(Main.komp)) {
                        if (!Main.cooldown) {
                            Main.cooldown = true;
                            if (Settings.kompFilter.getSelected() == Settings.KompEnum.StufeI) {
                                Komprimerung.Komp1();
                            } else if (Settings.kompFilter.getSelected() == Settings.KompEnum.StufeII) {
                                Komprimerung.Komp2();
                            } else if (Settings.kompFilter.getSelected() == Settings.KompEnum.StufeIII) {
                                Komprimerung.Komp3();
                            } else if (Settings.kompFilter.getSelected() == Settings.KompEnum.StufeIV) {
                                Komprimerung.Komp4();
                            } else if (Settings.kompFilter.getSelected() == Settings.KompEnum.StufeV) {
                                Komprimerung.Komp5();
                            } else if (Settings.kompFilter.getSelected() == Settings.KompEnum.StufeVI) {
                                Komprimerung.Komp6();
                            } else if (Settings.kompFilter.getSelected() == Settings.KompEnum.StufeVII) {
                                Komprimerung.Komp7();
                            }
                        }
                    } else if (isKeyDown(Main.dauerKomp)) {
                        Komprimerung.DauerKomp();
                    } else if (isKeyDown(Main.signkey)) {
                        Signierung.signieren();
                    } else if (isKeyDown(Main.spawnerTool)) {
                        SpawnerTool.spawner();
                    } else if (isKeyDown(Main.fastplace)) {
                        FastPlace.place();
                    } else if (isKeyDown(Main.craftEinspeichern)) {
                        //Craft.einspeichern();
                    } else if (isKeyDown(Main.entkomprimiererEinzeln)) {
                        Komprimerung.einzelEntkomprimierer();
                    } else if (isKeyDown(Main.entkomprimiererUnendlich)) {
                        if (!Main.dauerEntKompri) {
                            Main.dauerEntKompri = true;
                            Minecraft.getMinecraft().ingameGUI.displayTitle("§aEntkomprimiert Aktiviert!", (String)null, -1, -1, -1);
                            Komprimerung.entkomprimierer();
                        } else {
                            Main.dauerEntKompri = false;
                            Minecraft.getMinecraft().ingameGUI.displayTitle("§4Entkomprimiert Deaktiviert!", (String)null, -1, -1, -1);
                        }
                    } else if (isKeyDown(Main.KistenEinlernen)) {
                        if (!Chests.anaus) {
                            Chests.anaus = true;
                            Minecraft.getMinecraft().ingameGUI.displayTitle("§cDrücke C um eine Kiste einzulernen.", (String) null, -1, -1, -1);
                            Chests.speichern();
                        } else {
                            Chests.anaus = false;
                            Minecraft.getMinecraft().ingameGUI.displayTitle("§4Entkomprimiert Deaktiviert!", (String)null, -1, -1, -1);
                        }
                        Chests.speichern();
                    }

                Thread.sleep(1000L);

                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @SubscribeEvent
    public void onArrowLoose(net.minecraftforge.event.entity.player.ArrowLooseEvent event) {
        new Thread(() -> {
            if (Main.bonze)
            Minecraft.getMinecraft().thePlayer.inventory.currentItem = 8;

            Thread.currentThread().interrupt();
        }).start();
    }
}


