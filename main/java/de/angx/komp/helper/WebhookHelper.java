package de.angx.komp.helper;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebhookHelper {

    public static void sendPayLoad(String payload, String webhookUrl) {
        try {

            URL url = new URL(webhookUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("user-agent", "Mozilla/5.0 ");

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(payload.getBytes());
                outputStream.flush();
            }

            int responseCode = connection.getResponseCode();
            System.out.println( connection.getErrorStream());
            System.out.println( connection.getResponseMessage());
            System.out.println("Response Code: " + responseCode);
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}