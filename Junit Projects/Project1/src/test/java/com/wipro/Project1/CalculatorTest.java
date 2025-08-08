package com.wipro.Project1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class CalculatorTest {

	Calculator c = new Calculator();
	
	@Test
	public void addTest() {
		assertEquals(10,c.add(5, 5));
	}
	


	@Test
	public void mulTest() {
		assertEquals(10,c.mul(5, 5));
	}
}
