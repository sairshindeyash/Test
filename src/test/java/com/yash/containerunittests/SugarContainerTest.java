package com.yash.containerunittests;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.yash.containerEntities.SugarContainer;
import com.yash.exceptions.OverflowException;

public class SugarContainerTest {
	SugarContainer sugarContainer =new SugarContainer();

	@Before
	public void initializeAllContainersWithTherMaxCapacity() {
		
		sugarContainer.setCurrentCapacity(8000);
		
	}
	@Test
	public void shouldReturn956WhencontainersInitialCapacityIs1000(){
		assertEquals(7956, sugarContainer.updateCurrentCapacity(44).intValue());
	}
	
	@Test
	public void shouldReturnContainersCurrentStatus()
	{
		assertEquals(8000, sugarContainer.getStatus().intValue());
	}
	
	@Test
	public void shouldRefillContainerWithZeroQuantityInitially()
	{
		assertEquals(8000, sugarContainer.refill(0).intValue());
	}
	
	@Test(expected=OverflowException.class)
	public void shouldThrowExceptionIfContainerIsRefilledWithExcessQuantity()
	{
		sugarContainer.refill(100);
	}
	
	
	@Test
	public void shouldResetSugarContainerToInitailCapacity()
	{
		assertEquals(8000, sugarContainer.reset().intValue());
	}
}
