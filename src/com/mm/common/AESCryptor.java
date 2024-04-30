package com.mm.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class AESCryptor {
	private static SecretKey key;
	private String path;
	
	public AESCryptor() {
		this.path = AESCryptor.class.getResource("/").getPath();
		this.path = this.path.substring(0,this.path.indexOf("classes"));
		File f = new File(this.path+"/hair.oj");
		if(f.exists()) {
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
				this.key = (SecretKey)ois.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			if(key == null) {
				getGenerator();
			}
		}
	}

	private void getGenerator() {
		SecureRandom ser = new SecureRandom();
		KeyGenerator keygen = null;
		
		try {
			keygen = KeyGenerator.getInstance("AES");
			keygen.init(128, ser);
			this.key = keygen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		File f = new File(this.path+"/hair.oj");
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))){
			oos.writeObject(this.key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String encrypt(String str) {
		String resultValue ="";
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, AESCryptor.key);
			byte[] encrpt = str.getBytes(Charset.forName("UTF-8"));
			byte[] result = cipher.doFinal(encrpt);
			resultValue = Base64.getEncoder().encodeToString(result);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return resultValue;
	}
	public static String decrypt(String encryptedStr) {
		String decryptedValue = "";
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, AESCryptor.key);
			
			byte[] decodeStr = Base64.getDecoder().decode(encryptedStr.getBytes(Charset.forName("UTF-8")));
			byte[] orignStr = cipher.doFinal(decodeStr);
			decryptedValue = new String(orignStr);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return decryptedValue;
	}
}
