package com.github.Robert_IX.codingassignment_lucksmith;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTest
{

	@Test
	public void contextLoads()
	{
		// This test checks whether the application context is loaded successfully
	}

	@Test
	public void testMain()
	{
		// Calls the main method directly to ensure that it is covered by the coverage
		Application.main(new String[] {});
	}
}
