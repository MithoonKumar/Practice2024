package org.ipAddress;

import java.util.Arrays;

public class Main {

    // Define static zones
    static long ZONE_1_START = ipToLong("0.0.0.0");
    static long ZONE_1_END = ipToLong("127.255.255.255");

    static long ZONE_2_START = ipToLong("128.0.0.0");
    static long ZONE_2_END = ipToLong("191.255.255.255");

    static long ZONE_3_START = ipToLong("192.0.0.0");
    static long ZONE_3_END = ipToLong("223.255.255.255");

    static long ZONE_4_START = ipToLong("224.0.0.0");
    static long ZONE_4_END = ipToLong("255.255.255.255");

    public static void main(String[] args) {
        String[] ipAddresses = {"0.0.0.123", "129.234.233.24", "256.256.2.1"};
        int[] results = findZones(ipAddresses);
        System.out.println(Arrays.toString(results));  // Expected output: [1, 2, -1]
    }

    // Function to find zones for each IP address
    public static int[] findZones(String[] ipAddresses) {
        int[] zones = new int[ipAddresses.length];

        for (int i = 0; i < ipAddresses.length; i++) {
            String ip = ipAddresses[i];
            long ipValue = ipToLong(ip);

            if (ipValue == -1) {
                zones[i] = -1;  // Invalid IP address
            } else if (ipValue >= ZONE_1_START && ipValue <= ZONE_1_END) {
                zones[i] = 1;
            } else if (ipValue >= ZONE_2_START && ipValue <= ZONE_2_END) {
                zones[i] = 2;
            } else if (ipValue >= ZONE_3_START && ipValue <= ZONE_3_END) {
                zones[i] = 3;
            } else if (ipValue >= ZONE_4_START && ipValue <= ZONE_4_END) {
                zones[i] = 4;
            } else {
                zones[i] = -1;  // IP does not fall in any valid zone
            }
        }
        return zones;
    }

    // Function to convert IP address from string format to long
    public static long ipToLong(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return -1;  // Invalid IP address format

        try {
            long result = 0;
            for (int i = 0; i < 4; i++) {
                int part = Integer.parseInt(parts[i]);
                if (part < 0 || part > 255) return -1;  // Each part of the IP should be between 0 and 255
                result = (result << 8) + part;
            }
            return result;
        } catch (NumberFormatException e) {
            return -1;  // If IP address contains non-numeric values
        }
    }
}