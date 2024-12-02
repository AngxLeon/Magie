package de.angx.komp.Events;

import de.angx.komp.discord.WebhookMSGs;
import de.angx.komp.utils.Komprimerung;
import net.labymod.api.events.MessageReceiveEvent;
import net.minecraft.client.Minecraft;

public class LabyChatListener implements MessageReceiveEvent {

    @Override
    public boolean onReceive(String chatColor, String chatClean) {
        new Thread(() -> {
            try {

                if (chatClean.contains("-> mir]")) {
                    WebhookMSGs.sendDC(chatClean);
                    Thread.sleep(100L);

                    String spieler = chatClean.split(" ")[2];
                    String content = chatClean.substring(chatClean.indexOf("]") + 1).trim();

                    if(content.contains("start komp") && spieler.contains("AngxberLeoooon")) {
                        Komprimerung.DauerKomp();
                    }
                }

                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        return false;
    }
}
