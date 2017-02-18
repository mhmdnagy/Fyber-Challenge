package com.fyber.challenege.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by mNagy on 2/11/17.
 */

public class HashKeyGenerator {

    public static String generate(String appId, String ip, String locale, String offer_type,
                                  String timestamp, String uId, String token) {
        String concatenatedRequest = "appid=" + appId + "&"
                + "ip=" + ip + "&"
                + "locale=" + locale + "&"
                + "offer_types=" + offer_type + "&"
                + "timestamp=" + timestamp + "&"
                + "uid=" + uId + "&"
                + token;

        return getHash(concatenatedRequest);
    }

    public static String generate(String response, String token) {
        String concatenatedRequest = response
                + token;

        return getHash(concatenatedRequest);
    }

    public static String getHash(String str) {
        MessageDigest digest = null;
        byte[] input = null;

        try {
            digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            input = digest.digest(str.getBytes("UTF-8"));

        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return convertToHex(input);
    }

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9))
                    buf.append((char) ('0' + halfbyte));
                else
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }
}
