package com.yash.containerunittests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.yash.containerEntities.CoffeeContainer;
import com.yash.exceptions.OverflowException;

public class CoffeeContainerTest {
	CoffeeContainer coffeeContainer = new CoffeeContainer();

	
	@Before
	public void initializeAllContainersWithTherMaxCapacity() {
		
		coffeeContainer.setCurrentCapacity(2000);
	}
	@Test
	public void shouldReturn1956WhencontainersInitialCapacityIs2000() {
		assertEquals(1956, coffeeContainer.updateCurrentCapacity(44).intValue());
	}
 
	@Test
	public void shouldReturnContainersCurrentStatus() {
		assertEquals(2000, coffeeContainer.getStatus().intValue());
	}
    
	@Test
	public void shouldRefillContainerWithZeroQuantityInitially()
	{
		assertEquals(2000, coffeeContainer.refill(0).intValue());
	}
	
	@Test(expected=OverflowException.class)
	public void shouldThrowExceptionIfContainerIsRefilledWithExcessQuantity()
	{
		coffeeContainer.refill(200);
	}
	@Test
	public void shouldResetCoffeeContainerToInitailCapacity()
	{
		assertEquals(2000, coffeeContainer.reset().intValue());
	}
} 
