package de.angx.komp.discord;

import de.angx.komp.Main;
import de.angx.komp.helper.WebhookHelper;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import org.apache.commons.lang3.StringEscapeUtils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WebhookMSGs {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void sendDC(String inhalt) {

        String payload = "{\n" +
                "  \"embeds\": [\n" +
                "    {\n" +
                "      \"title\": \"" + StringEscapeUtils.escapeJson("Du hast eine MSG erhalten!") + "\",\n" +
                "      \"description\": \" \",\n" +
                "      \"color\": \"" + 3447003 + "\",\n" +
                "      \"footer\": {\n" +
                "        \"text\": \"\"\n" +
                "      },\n" +
                "      \"author\": {\n" +
                "        \"name\": \"\"\n" +
                "      },\n" +
                "      \"fields\": [ {\n" +
                "      \"name\": \"Account, der die Nachricht erhalten hat:\",\n" +
                "      \"value\": \""+ Minecraft.getMinecraft().thePlayer.getName()+"\"\n" +
                "    },  {\n" +
                "      \"name\": \"Uhrzeit:\",\n" +
                "      \"value\": \""+ LocalDateTime.now().format(formatter)+"\"\n" +
                "    }, {\n" +
                "      \"name\": \"Nachricht:\",\n" +
                "      \"value\": \""+inhalt+"\"\n" +
                "    } ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"content\": \"\"\n" +
                "}";

        WebhookHelper.sendPayLoad(payload, Main.msgWebhook);
    }
}

