package de.angx.komp.packets;

import net.labymod.utils.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.network.play.server.S05PacketSpawnPosition;

import java.util.ArrayList;

public class TPSPacket implements Consumer<Object> {
    private static double tpsOverLast30Seconds = 0;

        @Override
        public void accept(Object o) {
            if (o instanceof S03PacketTimeUpdate) {
                S03PacketTimeUpdate S03PacketTimeUpdate = (S03PacketTimeUpdate) o;
                calctps(S03PacketTimeUpdate);
            }
            if (o instanceof S05PacketSpawnPosition) {
                reset();
            }
        }

        private Long lastWorldTime;
        private Long lastMillis;
        private int lasttriptime;
        private final ArrayList<Double> totalTPS = new ArrayList<>();



        private void calctps(S03PacketTimeUpdate packet) {
            if (Minecraft.getMinecraft().thePlayer == null || Minecraft.getMinecraft().getNetHandler() == null) {
                return;
            }
            try {
                int triptime = Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime() / 2;
                long currentWorldTime = packet.getTotalWorldTime();
                long currentMillis = System.currentTimeMillis();
                if (lastWorldTime == null) {
                    lastWorldTime = currentWorldTime;
                    lastMillis = currentMillis;
                    lasttriptime = triptime;
                    return;
                }

                int triptimeDiff = triptime - lasttriptime;
                long ageDiff = currentWorldTime - lastWorldTime;
                long timeDiff = currentMillis - (lastMillis + triptimeDiff);
                double timeDiffInSeconds = timeDiff / 1000.0;
                double tpt = ageDiff / timeDiffInSeconds;
                if (tpt > 1) {
                    totalTPS.add(Math.min(tpt, 20));
                    tpsOverLast30Seconds = Math.round(getAverage(totalTPS) * 100) / 100.0;

                    if (totalTPS.size() >= 30) {
                        totalTPS.remove(0);
                    }
                }
                lastWorldTime = currentWorldTime;
                lasttriptime = triptime;
                lastMillis = currentMillis;
            } catch (Exception ignored) {
            }

        }
        private void reset() {
            tpsOverLast30Seconds = 0;
            lastWorldTime = null;
            totalTPS.clear();
        }


        private double getAverage(ArrayList<Double> doubles) {
            double total = 0;
            for (double d : doubles) {
                total += d;
            }
            return total / doubles.size();
        }

        public static double getTpsOverLast30Seconds() {
            return tpsOverLast30Seconds;
        }
    }