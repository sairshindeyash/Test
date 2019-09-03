package com.yash.containerunittests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.yash.containerEntities.TeaContainer;
import com.yash.exceptions.OverflowException;

public class TeaContainerTest {
	TeaContainer teaContainer=new TeaContainer();
	
	@Before
	public void initializeAllContainersWithTherMaxCapacity() {
		
		teaContainer.setCurrentCapacity(2000);
		
	}
	@Test
	public void shouldReturn956WhencontainersInitialCapacityIs1000(){
		assertEquals(1956, teaContainer.updateCurrentCapacity(44).intValue());
	}
	
	@Test
	public void shouldReturnContainersCurrentStatus()
	{
		assertEquals(2000, teaContainer.getStatus().intValue());
	}
	
	@Test
	public void shouldRefillContainerWithZeroQuantityInitially()
	{
		assertEquals(2000, teaContainer.refill(0).intValue());
	}
	
	@Test(expected=OverflowException.class)
	public void shouldThrowExceptionIfContainerIsRefilledWithExcessQuantity()
	{
		teaContainer.refill(100);
	}
	
	@Test
	public void shouldResetTeaContainerToInitailCapacity()
	{
		assertEquals(2000, teaContainer.reset().intValue());
	}
}
