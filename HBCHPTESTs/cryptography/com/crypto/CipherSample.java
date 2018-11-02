package com.crypto;

import java.io.ByteArrayInputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Scanner;

import javax.crypto.Cipher;

public class CipherSample {
	private static Scanner sc;

	public static void main(String[] args) throws Exception {
		sc = new	Scanner(System.in);
		
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(2048);
		KeyPair pair = keyPairGen.generateKeyPair();
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
		System.out.println("Enter your text here : ");
		String	msg	=	sc.nextLine();
		byte[]	msgAsByte	=	msg.getBytes();
		cipher.update(msgAsByte);
		byte[]	cipherText	=	cipher.doFinal();
		System.out.println("Encrypted data : ");
		System.out.println(new	String(cipherText,"UTF-8"));
		cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
		System.out.println();
		System.out.println("DeCrypted data : ");
		byte[]	decipherText	=	cipher.doFinal(cipherText);
		System.out.println(new	String(decipherText,"UTF-8"));
	}
}
