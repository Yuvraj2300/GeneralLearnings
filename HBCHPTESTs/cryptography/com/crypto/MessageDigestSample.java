package com.crypto;

import java.security.MessageDigest;
import java.util.Scanner;

public class MessageDigestSample {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type in the text : ");
		String text = sc.nextLine();

		MessageDigest md = MessageDigest.getInstance("SHA-256");

		md.update(text.getBytes());

		byte[] digest = md.digest();

		System.out.println(digest);

		StringBuffer hexString = new StringBuffer();

		for (int i = 0; i < digest.length; i++) {
			hexString.append(Integer.toHexString(0xFF & digest[i]));
		}
		System.out.println("Hex format : " + hexString.toString());

	}
}
