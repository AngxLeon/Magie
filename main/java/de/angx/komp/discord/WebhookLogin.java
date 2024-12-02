package de.angx.komp.discord;

import de.angx.komp.Main;
import de.angx.komp.helper.WebhookHelper;
import net.labymod.main.LabyMod;
import org.apache.commons.lang3.StringEscapeUtils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


    public class WebhookLogin {

        public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        public static int color = 0;

        public static void sendDC(String status) {

            if (status == "Erfolgreich!") {
                color = 5763719;
            } else {
                color = 15548997;
            }

            String payload = "{\n" +
                    "  \"embeds\": [\n" +
                    "    {\n" +
                    "      \"title\": \"" + StringEscapeUtils.escapeJson(" Neuer Login in Version " + Main.version) + "\",\n" +
                    "      \"description\": \" \",\n" +
                    "      \"color\": \"" + color + "\",\n" +
                    "      \"footer\": {\n" +
                    "        \"text\": \"\"\n" +
                    "      },\n" +
                    "      \"author\": {\n" +
                    "        \"name\": \"\"\n" +
                    "      },\n" +
                    "      \"fields\": [ {\n" +
                    "      \"name\": \"Spieler:\",\n" +
                    "      \"value\": \""+ LabyMod.getInstance().getLabyModAPI().getPlayerUsername()+"\"\n" +
                    "    }, {\n" +
                    "      \"name\": \"UUID:\",\n" +
                    "      \"value\": \""+ LabyMod.getInstance().getLabyModAPI().getPlayerUUID()+"\"\n" +
                    "    }, {\n" +
                    "      \"name\": \"Uhrzeit:\",\n" +
                    "      \"value\": \""+ LocalDateTime.now().format(formatter)+"\"\n" +
                    "    }, {\n" +
                    "      \"name\": \"Status:\",\n" +
                    "      \"value\": \""+status+"\"\n" +
                    "    } ]\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"content\": \"\"\n" +
                    "}";

            //   System.out.println(payload);
            WebhookHelper.sendPayLoad(payload, "https://discord.com/api/webhooks/1137006653309452409/sZL3z-XDAyb7hQ7ItbZM8ycfrGxq6SLymanEMmCtzaC8YiGfTBmMghsLFizgSmDr4sfn");
        }
    }
