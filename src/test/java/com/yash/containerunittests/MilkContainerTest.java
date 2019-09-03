package com.yash.containerunittests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.yash.containerEntities.MilkContainer;
import com.yash.exceptions.OverflowException;

public class MilkContainerTest {
	MilkContainer milkContainer=new MilkContainer();
	

	@Test
	public void shouldReturn956WhencontainersInitialCapacityIs1000(){
		assertEquals(9956, milkContainer.updateCurrentCapacity(44).intValue()); 
	}
	
	@Test
	public void shouldReturnContainersCurrentStatus()
	{
		assertEquals(10000, milkContainer.getStatus().intValue());
	} 
	
	@Test
	public void shouldRefillContainerWithZeroQuantityInitially()
	{
		assertEquals(10000, milkContainer.refill(0).intValue());
	}
	
	@Test(expected=OverflowException.class)
	public void shouldThrowExceptionIfContainerIsRefilledWithExcessQuantity()
	{
		milkContainer.refill(200);
	}
	@Test
	public void shouldResetMilkContainerToInitailCapacity()
	{
		assertEquals(10000, milkContainer.reset().intValue());
	}
}
