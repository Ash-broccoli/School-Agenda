package login;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Encode the password to SHA256. So there is not the password in the db.
 *
 * @author Alyssa Heimlicher
 * @since 2021
 */
public class SHA256 {
    public static String getInstantSHA(String password) {
        return getHexString(getSHA(password));
    }

    /**
     * Make a bytearray form a password
     *
     * @param password to endcode
     * @return a bytearray from the password
     */
    public static byte[] getSHA(String password) {
        MessageDigest messageDigest = null;
        try {
            // Static getInstance method is called with hashing SHA
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //Returns an array of bytes
        return messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Make a hexstring from a bytearray
     *
     * @param hash a bytearray for the hexstring
     * @return the bytearray as hexstring
     */
    public static String getHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);
        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
        // Pad with leading zeros
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
}
