package com.inventoryapp;


import org.junit.*;
import org.springframework.boot.system.JavaVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InventoryAppApplicationTests {

//	@Test
//	void contextLoads() {
//	}


	@Test
	public void checkSpringVersion() {
		assertEquals("6.1.2", SpringVersion.getVersion());
	}

	@Test public void getJDKVersion() {
		assertEquals("1.8.0_191", System.getProperty("java.version"));
	}

	@Test public void  getJavaLanguageVersion() {
		assertEquals("1.8", JavaVersion.getJavaVersion().toString());
	}


}
