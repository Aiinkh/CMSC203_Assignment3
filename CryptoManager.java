/*
 * Class: CMSC203 
 * Instructor: Vahabzadeh-Monshi
 * Description: The CryptoManager class implements multiple static methods that
 * are used to encrypt and decrypt information using two cyphers: Caesar's cypher and the
 * Bellaso Cypher.
 * Due: 03/17/2023
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Aiin Khalilzadeh
*/





/**
 * This class manages methods that use both the Caesar encryption/decryption and the Bellaso encryption/decryption
 * @author Aiin Khalilzadeh
 *
 */



public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		int size = plainText.length();
		for (int i = 0; i < size; i++) {
			if (plainText.charAt(i) < LOWER_RANGE || plainText.charAt(i) > UPPER_RANGE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {

		String encryptedText = "";
		key %= RANGE;
		int size = plainText.length();
		for (int i = 0; i < size; i++) {
			int ch = (int)plainText.charAt(i) + key;
			while(ch > UPPER_RANGE) {
				ch -= RANGE;
			}
			encryptedText += (char)ch;
		}
		return encryptedText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption(String encryptedText, int key) {
		String decryptedText = "";
		key%=RANGE;
		int size = encryptedText.length();
		for (int i = 0; i < size; i++) {
			int ch = (char)(encryptedText.charAt(i) - key);
			while (ch < LOWER_RANGE) {
				ch += RANGE;
			}
			decryptedText += (char)ch;
		}
		return decryptedText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption(String plainText, String bellasoStr) {
		
		String encryptedText = "";
		int size = plainText.length();
		
		for (int i = 0; i < size; i++) {
			int j = i % bellasoStr.length();
			int ch = plainText.charAt(i) + bellasoStr.charAt(j);
			
			while (ch > UPPER_RANGE) {
				ch -= RANGE;
			}
			encryptedText += (char)ch;
		}
		return encryptedText;
	}
	
	
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String decryptedText = "";
		int size = encryptedText.length();
		
		for (int i = 0; i < size; i++) {
			int j = i % bellasoStr.length();
			int ch = encryptedText.charAt(i) - bellasoStr.charAt(j);
			
			while (ch < LOWER_RANGE) {
				ch += RANGE;
			}
			decryptedText += (char)ch;
		}
		return decryptedText;
	}
}