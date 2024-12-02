package de.angx.komp.utils;

import de.angx.komp.Main;
import de.angx.komp.helper.HelperClass;
import de.angx.komp.helper.TPSHelper;
import net.minecraft.client.Minecraft;

public class Trichter {

    public static boolean hallo = true;

    public static void trichterEinstellung() throws InterruptedException {
        if (Main.trichterBoolean) {
            HelperClass.kisteoeffnen();
            Thread.sleep(TPSHelper.Trichter());

            if (Main.trichterFilter) {
                HelperClass.slotLinksKlick(80);
            }

            Thread.sleep(TPSHelper.Trichter());
            if (Integer.parseInt(Main.sammelradius) >= 1 && Integer.parseInt(Main.sammelradius) < 16) {
                for (int i = 1; i < Integer.parseInt(Main.sammelradius); i++) {
                    HelperClass.slotLinksKlick(32);
                    Thread.sleep(TPSHelper.Trichter());
                }
                Minecraft.getMinecraft().thePlayer.closeScreen();
            } else if (Integer.parseInt(Main.sammelradius) == 0) {
                HelperClass.slotLinksKlick(30);
            }
        }
    }
}
