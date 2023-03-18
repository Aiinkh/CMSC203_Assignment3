/*
 * Testing class made to test every single method by using JUnit
 * Author: Aiin Khalilzadeh
 * 
 * */



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CryptoManagerTestStudent {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("THIS TEST SHOULD SUCCEED"));
		
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("WKLV#LV#DQRWKHU#WHVW",CryptoManager.caesarEncryption("THIS IS ANOTHER TEST", 3));
		
	}
	
	@Test
	public void testDecryptCaesar() {
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.caesarDecryption("WKLV#LV#DQRWKHU#WHVW", 3));
		
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("WU\\VR9F#N!RF88U-'HED", CryptoManager.bellasoEncryption("THIS IS ANOTHER TEST", "CMSC203"));
		
		                                                                                      
	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.bellasoDecryption("WU\\VR9F#N!RF88U-'HED", "CMSC203"));
		
	}

}