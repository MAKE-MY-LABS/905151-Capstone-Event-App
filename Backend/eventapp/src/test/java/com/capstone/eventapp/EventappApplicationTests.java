package com.capstone.eventapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * This class contains unit tests for the EventappApplication class.
 */
@SpringBootTest
class EventappApplicationTests {

	// create a test method to test the main method using junit5
	/**
	 * Tests the main method of the EventappApplication class.
	 */
	/**
	 * Test case for the main method of the EventappApplication class.
	 * This test ensures that the main method can be executed without any errors.
	 */
	@Test
	void testMain() {
		EventappApplication.main(new String[] {});
	}
}
