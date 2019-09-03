package com.yash.containerunittests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.yash.containerEntities.WaterContainer;
import com.yash.exceptions.OverflowException;
import com.yash.exceptions.UnderflowException;

public class WaterContainerTest {
	WaterContainer waterContainer=new WaterContainer();
	@Before
	public void initializeAllContainersWithTherMaxCapacity() {
		
		waterContainer.setCurrentCapacity(15000);
		
	}
	@Test
	public void shouldReturn10000WhencontainersInitialCapacityIs15000(){
		
		assertEquals(10000, waterContainer.updateCurrentCapacity(5000).intValue());
	}
	
	@Test
	public void shouldReturnContainersCurrentStatus()
	{
		assertEquals(15000, waterContainer.getStatus().intValue());
	}
	
	@Test
	public void shouldRefillContainerWithZeroQuantityInitially()
	{
		assertEquals(15000, waterContainer.refill(0).intValue());
	}
	
	@Test(expected=OverflowException.class)
	public void shouldThrowExceptionIfContainerIsRefilledWithExcessQuantity()
	{
		waterContainer.refill(100);
	}
	
	@Test
	public void shouldResetWaterContainerToInitailCapacity()
	{
		assertEquals(15000, waterContainer.reset().intValue());
	}
	
	
}
