package com.crypto;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Scanner;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

public class MacSample {
	public static void main(String[] args) throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");

		SecureRandom secRandom = new SecureRandom();

		keyGen.init(secRandom);

		Key key = keyGen.generateKey();
		System.out.println(key);

		Mac mac = Mac.getInstance("HmacSHA256");

		mac.init(key);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter anything :");
		String msg = sc.nextLine();
		byte[] bytes = msg.getBytes();
		byte[] macResult = mac.doFinal(bytes);

		System.out.println("Mac result:");
		System.out.println(new String(macResult));

	}
}
