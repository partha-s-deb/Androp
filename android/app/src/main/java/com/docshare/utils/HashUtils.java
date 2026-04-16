package com.docshare.utils;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/**
 * HashUtils.java
 * Generates SHA-256 hashes for document verification.
 */
public class HashUtils {

    /**
     * Hash a byte array — use for small files already in memory
     */
    public static byte[] hashBytes(byte[] data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(data);
    }

    /**
     * Hash a file from disk — use for larger documents
     */
    public static byte[] hashFile(File file) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                digest.update(buffer, 0, bytesRead);
            }
        }
        return digest.digest();
    }

    /**
     * Convert hash bytes to hex string for display/logging
     */
    public static String toHexString(byte[] hash) {
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    /**
     * Compare two hashes — constant time to avoid timing attacks
     */
    public static boolean hashesMatch(byte[] a, byte[] b) {
        if (a.length != b.length) return false;
        int diff = 0;
        for (int i = 0; i < a.length; i++) {
            diff |= a[i] ^ b[i];
        }
        return diff == 0;
    }
}
