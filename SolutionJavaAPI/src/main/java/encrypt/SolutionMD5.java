package encrypt;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class SolutionMD5 {

	private static byte[] sharedvector = { 0x01, 0x02, 0x03, 0x05, 0x07, 0x0B, 0x0D, 0x11 };

	public static void main(String[] args) {
//		String query = "abcdefghijklmn";
//		String key = "ckmates";
//		System.out.println(query);
//		 
//		try {
//			String encrptText = encryptText(query, key);
//			System.out.println(encrptText);
//			String decrptText = decrypt(encrptText, key);
//			System.out.println(decrptText);
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		String text1 = "HelloWorld1";
		long time = System.currentTimeMillis();
		System.out.println(getMD5V2(text1));
		System.out.println("time : " + (System.currentTimeMillis() - time));             
//		time = System.currentTimeMillis();
//		String text2 = "HelloWorld2";
//		System.out.println(getMD5V2(text2));
//		System.out.println("time : " + (System.currentTimeMillis() - time));

	}
	
	public static String getMD5V1(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	
	public static String getMD5V2(String input) {
        byte[] source;
        try {
            //Get byte according by specified coding.
            source = input.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            source = input.getBytes();
        }
        String result = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            //The result should be one 128 integer
            byte temp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = temp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            result = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

	public static String encryptText(String rawText, String key) throws Exception{

		String encText = "";
		byte[] keyArray = new byte[24];
		byte[] temporaryKey;
		byte[] toEncryptArray = null;

		toEncryptArray = rawText.getBytes("UTF-8");
		MessageDigest m = MessageDigest.getInstance("MD5");
		temporaryKey = m.digest(key.getBytes("UTF-8"));

		if (temporaryKey.length < 24) { // DESede require 24 byte length key
			int index = 0;
			for (int i = temporaryKey.length; i < 24; i++) {
				keyArray[i] = temporaryKey[index];
			}
		}

		Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyArray, "DESede"), new IvParameterSpec(sharedvector));
		byte[] encrypted = c.doFinal(toEncryptArray);
		encText = Base64.getEncoder().encodeToString(encrypted);

		return encText;
	}

	public static String decrypt(String encText, String key) throws Exception {
		String rawText = "";
		byte[] keyArray = new byte[24];
		byte[] temporaryKey;
		byte[] toEncryptArray = null;

		MessageDigest m = MessageDigest.getInstance("MD5");
		temporaryKey = m.digest(key.getBytes("UTF-8"));

		if (temporaryKey.length < 24) { // DESede require 24 byte length key
			int index = 0;
			for (int i = temporaryKey.length; i < 24; i++) {
				keyArray[i] = temporaryKey[index];
			}
		}

		Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyArray, "DESede"), new IvParameterSpec(sharedvector));
		byte[] decrypted = c.doFinal(Base64.getDecoder().decode(encText));

		rawText = new String(decrypted, "UTF-8");

		return rawText;

	}

}
