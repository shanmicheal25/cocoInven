package com.inven.coco.common.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class SecurityUtil {

	public static String keyAes = "k.condoCommunity";

	public static String getEncryptionAES(String fileName) {

		String encryptedString = null;
		try {

			encryptedString = DatatypeConverter.printBase64Binary(fileName.getBytes("UTF-16"));

			// encryptedString = encoder.encodeToString(encrypted);
			System.out.println(encryptedString);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception occur in encrypted filename ");
		}
		return encryptedString;
	}

	public static String getDeEncryptionAES(String fileName) {

		String decrypted = null;
		try {

			byte[] decoded = DatatypeConverter.parseBase64Binary(fileName);

			decrypted = new String(decoded, "UTF-16");
			System.out.println(decrypted);

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception occur in deencrypted filename ");
		}
		return decrypted;
	}

	
	public static void main(String arg[]){
		System.out.println(SecurityUtil.getEncryptionAES("shankar"));
		System.out.println(SecurityUtil.getEncryptionAES("azhar"));
		System.out.println(SecurityUtil.getEncryptionAES("nadia"));
	}
}
