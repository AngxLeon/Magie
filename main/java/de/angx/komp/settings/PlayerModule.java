package de.angx.komp.settings;

import de.angx.komp.Main;
import net.labymod.core.LabyModCore;
import net.labymod.ingamegui.Module;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.main.lang.LanguageManager;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;
import net.minecraft.client.gui.Gui;

import java.awt.*;
import static de.angx.komp.packets.JoinPacket.cachePlayerJoins;

public class PlayerModule extends Module {

    public static boolean enableJoinModule = true;

    @Override
    public void draw(int x, int y, int rightX) {
        if(enableJoinModule) {
            Gui gui = new Gui();
            int linePlus = 0;

            for (int i = 0; i < cachePlayerJoins.size(); i++) {
                LabyModCore.getMinecraft().getFontRenderer().drawStringWithShadow(cachePlayerJoins.get(i), x, y + linePlus, new Color(255, 255, 255, 255).getRGB());
                linePlus = linePlus + 10;
            }
        }
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.FIREBALL);
    }

    @Override
    public double getHeight() {
        return 50;
    }

    @Override
    public double getWidth() {
        return 100;
    }

    @Override
    public void loadSettings() {

    }

    @Override
    public String getSettingName() {
        return LanguageManager.translateOrReturnKey("Magie_Joins");
    }

    @Override
    public String getDescription() {
        return "Letzte Spieler Joins";
    }

    @Override
    public int getSortingId() {
        return 0;
    }

    @Override
    public ModuleCategory getCategory() {
        return Main.getInstance().getCategory();
    }
}
