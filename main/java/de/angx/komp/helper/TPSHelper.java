package de.angx.komp.helper;

import de.angx.komp.packets.TPSPacket;

public class TPSHelper {

    public static long craft() {
        return 0;
    }

    public static long invLeerung() {
        if (TPSPacket.getTpsOverLast30Seconds() > 15 ) {
            return 80L;
        } else {
            return 100L;
        }
    }

    public static long Komprimierung() {
        if (TPSPacket.getTpsOverLast30Seconds() > 15 ) {
            return 150L;
        } else {
            return 250L;
        }
    }

    public static long SpawnerTool() {
        if (TPSPacket.getTpsOverLast30Seconds() > 15 ) {
            return 150L;
        } else {
            return 250L;
        }
    }

    public static long Trichter() {
        if (TPSPacket.getTpsOverLast30Seconds() > 15 ) {
            return 100L;
        } else {
            return 150L;
        }
    }
}
