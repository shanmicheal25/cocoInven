package com.inven.coco.common.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class SecurityHash {


    public static String passwordHash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100,
                                           16).substring(1));
            }

            //convert the byte to hex format method 2
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }

            String hexSha1 = hexString.toString();
            byte[] bytearray = hexStringToByteArray(hexSha1);
            String base64encoded = new BASE64Encoder().encodeBuffer(bytearray);

            return "{SHA-256}" + base64encoded;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return password;
    }


    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] =
                    (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i +
                                                                                              1),
                                                                                     16));
        }
        return data;

    }
}
