package PersonalPasswordGenerator;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class InputBasedHashCodeGenerator {

    // Define character pools
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:',.<>?/`~";
    private static final String BANK_SPECIAL_CHARACTERS = "$#^@&%_~!*-";

    /**
     * Generates a deterministic hashcode based on the input string.
     * The hashcode contains at least 3 uppercase letters, 3 lowercase letters,
     * 3 digits, and 3 special characters.
     *
     * @param input The input string based on which the hashcode is generated.
     * @return A deterministic hashcode string.
     * @throws NoSuchAlgorithmException If SHA-256 algorithm is not available.
     */
    public static String generateHashCode(String input) throws NoSuchAlgorithmException {
        // Compute SHA-256 hash of the input
        byte[] hashBytes = sha256(input);

        // Initialize character lists
        List<Character> hashCodeChars = new ArrayList<>();

        // Create separate indices for each character pool
        int upperIndex = 0;
        int lowerIndex = 0;
        int digitIndex = 0;
        int specialIndex = 0;

        // Ensure at least 3 characters from each category
        for (int i = 0; i < 3; i++) {
            // Uppercase
            hashCodeChars.add(UPPERCASE.charAt(Byte.toUnsignedInt(hashBytes[upperIndex % hashBytes.length]) % UPPERCASE.length()));
            upperIndex += 1;

            // Lowercase
            hashCodeChars.add(LOWERCASE.charAt(Byte.toUnsignedInt(hashBytes[lowerIndex % hashBytes.length]) % LOWERCASE.length()));
            lowerIndex += 1;

            // Digits
            hashCodeChars.add(DIGITS.charAt(Byte.toUnsignedInt(hashBytes[digitIndex % hashBytes.length]) % DIGITS.length()));
            digitIndex += 1;

            // Special Characters
            if (input.startsWith("bankicici")) {
                hashCodeChars.add(BANK_SPECIAL_CHARACTERS.charAt(Byte.toUnsignedInt(hashBytes[specialIndex % hashBytes.length]) % BANK_SPECIAL_CHARACTERS.length()));
                specialIndex += 1;
            } else {
                hashCodeChars.add(SPECIAL_CHARACTERS.charAt(Byte.toUnsignedInt(hashBytes[specialIndex % hashBytes.length]) % SPECIAL_CHARACTERS.length()));
                specialIndex += 1;
            }


        }

        // Optionally, add more characters to reach a desired length
        // For example, to make the hashcode 16 characters long:
        int desiredLength = 16;
        int byteIndex = 12; // Starting index after the initial 12 characters
        while (hashCodeChars.size() < desiredLength) {
            byte currentByte = hashBytes[byteIndex % hashBytes.length];
            char nextChar;
            int poolSelector = Byte.toUnsignedInt(currentByte) % 4;
            switch (poolSelector) {
                case 0:
                    nextChar = UPPERCASE.charAt(Byte.toUnsignedInt(hashBytes[byteIndex % hashBytes.length]) % UPPERCASE.length());
                    break;
                case 1:
                    nextChar = LOWERCASE.charAt(Byte.toUnsignedInt(hashBytes[byteIndex % hashBytes.length]) % LOWERCASE.length());
                    break;
                case 2:
                    nextChar = DIGITS.charAt(Byte.toUnsignedInt(hashBytes[byteIndex % hashBytes.length]) % DIGITS.length());
                    break;
                case 3:
                default:
                    if (input.startsWith("bankicici")) {
                        nextChar = BANK_SPECIAL_CHARACTERS.charAt(Byte.toUnsignedInt(hashBytes[byteIndex % hashBytes.length]) % BANK_SPECIAL_CHARACTERS.length());
                    } else {
                        nextChar = SPECIAL_CHARACTERS.charAt(Byte.toUnsignedInt(hashBytes[byteIndex % hashBytes.length]) % SPECIAL_CHARACTERS.length());
                    }
                    break;
            }
            hashCodeChars.add(nextChar);
            byteIndex += 1;
        }

        // Initialize Random with seed derived from the hash to shuffle deterministically
        long seed = bytesToLong(hashBytes);
        Random random = new Random(seed);
        Collections.shuffle(hashCodeChars, random);

        // Convert to string
        StringBuilder hashCode = new StringBuilder();
        for (char c : hashCodeChars) {
            hashCode.append(c);
        }

        return hashCode.toString();
    }

    /**
     * Computes the SHA-256 hash of the given input string.
     *
     * @param input The input string to hash.
     * @return A byte array representing the SHA-256 hash.
     * @throws NoSuchAlgorithmException If SHA-256 algorithm is not available.
     */
    private static byte[] sha256(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(input.getBytes());
    }

    /**
     * Converts a byte array to a long value.
     * Uses the first 8 bytes of the array.
     *
     * @param bytes The byte array to convert.
     * @return A long value derived from the byte array.
     */
    private static long bytesToLong(byte[] bytes) {
        long value = 0L;
        for (int i = 0; i < Math.min(8, bytes.length); i++) {
            value = (value << 8) | (Byte.toUnsignedInt(bytes[i]));
        }
        return value;
    }

    // Example usage with test cases
    public static void main(String[] args) {
        String[] testInputs = {
                "facebook",
                "instagram",
                "twitter",
                "gmail",
                "linkedin",
                "bankicici",
                "bankkotak",
                "bankhdfc",
                "irctc"
        };

        for (String input : testInputs) {
            try {
                String hashCode = generateHashCode(input + args[0] + args[1]);
                System.out.println("Input: " + input + " -> HashCode: " + hashCode);
            } catch (NoSuchAlgorithmException e) {
                System.err.println("SHA-256 algorithm not found.");
            }
        }
    }
}
