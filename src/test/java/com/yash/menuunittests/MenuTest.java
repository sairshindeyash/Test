package com.yash.menuunittests;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.customexit.SystemExit;
import com.yash.customscanner.CustomInputScanner;
import com.yash.exceptions.OverflowException;
import com.yash.exceptions.UnderflowException;
import com.yash.operations.Menu;
import com.yash.operations.Service;

@RunWith(value = MockitoJUnitRunner.class)
public class MenuTest {

	@InjectMocks
	Menu menu;

	@Mock
	CustomInputScanner customInputScanner;

	@Mock
	Service mockService;

	@Mock
	SystemExit mockSystemExit;

	@Test
	public void shouldCheckForChoiceZero() {
		when(customInputScanner.acceptInteger("Input choice")).thenReturn(0);
		mockSystemExit.exit(0);

		verify(mockSystemExit).exit(0);

		menu.teaCoffeeVendingMachine();
	}

	@Test
	public void shouldCheckMakeDrinkIsCalledForCase1() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(1,  11);
		when(customInputScanner.acceptInteger("Input quantity")).thenReturn(1);
		mockService.makeDrink("Tea", 1, 65, 17, 44, 6, 0);

		verify(mockService).makeDrink("Tea", 1, 65, 17, 44, 6, 0);

		menu.teaCoffeeVendingMachine();
	}

	@Test//(expected=UnderflowException.class)
	public void shouldCheckUnderflowExceptionIsCaughtWhenMakeDrinkForQuantity14000IsCalledForCase1() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(1, 11);
		when(customInputScanner.acceptInteger("Input quantity")).thenReturn(14000);
		when(mockService.makeDrink("Tea", 14000, 65, 17, 44, 6, 0)).thenThrow(new UnderflowException("insufficient quantity"));
		
		menu.teaCoffeeVendingMachine();
	}

	@Test
	public void shouldCheckMakeDrinkIsCalledForCase2() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(2, 11);
		when(customInputScanner.acceptInteger("Input quantity")).thenReturn(2);
		mockService.makeDrink("Black Tea", 1, 112, 17, 0, 3, 0);

		verify(mockService).makeDrink("Black Tea", 1, 112, 17, 0, 3, 0);

		menu.teaCoffeeVendingMachine();
	}

	@Test
	public void shouldCheckUnderflowExceptionIsCaughtWhenMakeDrinkForQuantity14000IsCalledForCase2() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(2, 11);
		when(customInputScanner.acceptInteger("Input quantity")).thenReturn(14000);
		when(mockService.makeDrink(anyString(), anyInt(), anyInt(), anyInt(), anyInt(), anyInt(), anyInt())).thenThrow(new UnderflowException("insufficient quantity"));
		
		menu.teaCoffeeVendingMachine();
	}

	@Test
	public void shouldCheckMakeDrinkIsCalledForCase3() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(3, 1, 11);
		mockService.makeDrink("Coffee", 5, 23, 17, 88, 0, 3);

		verify(mockService).makeDrink("Coffee", 5, 23, 17, 88, 0, 3);

		menu.teaCoffeeVendingMachine();
	}

	@Test
	public void shouldCheckUnderflowExceptionIsCaughtWhenMakeDrinkForQuantity14000IsCalledForCase3() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(3, 11);
		when(customInputScanner.acceptInteger("Input quantity")).thenReturn(14000);
		when(mockService.makeDrink(anyString(), anyInt(), anyInt(), anyInt(), anyInt(), anyInt(), anyInt())).thenThrow(new UnderflowException("insufficient quantity"));
		

		menu.teaCoffeeVendingMachine();
	}

	@Test
	public void shouldCheckMakeDrinkIsCalledForCase4() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(4, 1, 11);
		mockService.makeDrink("Black Coffee", 1, 112, 17, 0, 0, 3);

		verify(mockService).makeDrink("Black Coffee", 1, 112, 17, 0, 0, 3);

		menu.teaCoffeeVendingMachine();
	}
 
	@Test
	public void shouldCheckUnderflowExceptionIsCaughtWhenMakeDrinkForQuantity14000IsCalledForCase4() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(4, 11);
		when(customInputScanner.acceptInteger("Input quantity")).thenReturn(14000);
		when(mockService.makeDrink(anyString(), anyInt(), anyInt(), anyInt(), anyInt(), anyInt(), anyInt())).thenThrow(new UnderflowException("insufficient quantity"));
		
		menu.teaCoffeeVendingMachine();
	}
	
	@Test
	public void shouldCheckgetStatusForDifferentContainersIsCalledForCase5() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(5, 11);
		mockService.getCoffeeContainerstatus();
		mockService.getMilkContainerstatus();
		mockService.getSugarContainerstatus();
		mockService.getTeaContainerstatus();
		mockService.getWaterContainerstatus();

		verify(mockService).getCoffeeContainerstatus();
		verify(mockService).getMilkContainerstatus();
		verify(mockService).getSugarContainerstatus();
		verify(mockService).getTeaContainerstatus();
		verify(mockService).getWaterContainerstatus();

		menu.teaCoffeeVendingMachine();
	}

	@Test
	public void shouldCheckResetForDifferentContainersIsCalledForCase6() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(7, 11);

		mockService.resetCoffeeContainer();
		mockService.resetMilkContainer();
		mockService.resetSugarContainer();
		// mockService.refillTeaContainer();
		mockService.resetWaterContainer();

		verify(mockService).resetCoffeeContainer();
		verify(mockService).resetMilkContainer();
		verify(mockService).resetSugarContainer();
		// verify(mockService).refillTeaContainer();
		verify(mockService).resetWaterContainer();

		menu.teaCoffeeVendingMachine();
	}

	@Test
	public void shouldCheckForChoiceIsEight() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(8, 11);

		menu.teaCoffeeVendingMachine();
	}

	@Test
	public void shouldCheckForChoiceIsNine() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(9, 11);

		menu.teaCoffeeVendingMachine();
	}

	@Test
	public void shouldCheckForChoiceIsTen() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(10, 11);

		menu.teaCoffeeVendingMachine();
	}

	@Test
	public void shouldCheckRefillContainerForTeaIsCalled() {
		when(mockService.getTeaContainerstatus()).thenReturn(1994);
		when(customInputScanner.acceptInteger("Input choice")).thenReturn(6, 1, 6, 11);

		menu.teaCoffeeVendingMachine();
	}

	@Test
	public void shouldCheckOverflowExceptionForTeaContainerIsCaughtWhenContainerIsRefilledWithExcessQuantity()
	{
		when(mockService.getTeaContainerstatus()).thenReturn(2000);
		when(customInputScanner.acceptInteger("Input choice")).thenReturn(6, 1, 6, 11);
		when(mockService.refillTeaContainer(anyInt())).thenThrow(new OverflowException());
		
		menu.teaCoffeeVendingMachine();
	}
	@Test  
	public void shouldCheckRefillContainerForWaterIsCalled() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(6, 2, 6, 11);

		menu.teaCoffeeVendingMachine();
	}
	@Test
	public void shouldCheckOverflowExceptionForWaterContainerIsCaughtWhenContainerIsRefilledWithExcessQuantity()
	{
		when(mockService.getWaterContainerstatus()).thenReturn(15000);
		when(customInputScanner.acceptInteger("Input choice")).thenReturn(6, 2, 6, 11);
		when(mockService.refillWaterContainer(anyInt())).thenThrow(new OverflowException());
		
		menu.teaCoffeeVendingMachine();
	}
	@Test
	public void shouldCheckRefillContainerForCoffeeIsCalled() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(6, 3, 6, 11);

		menu.teaCoffeeVendingMachine();
	}
	@Test
	public void shouldCheckOverflowExceptionForCoffeeContainerIsCaughtWhenContainerIsRefilledWithExcessQuantity()
	{
		when(mockService.getCoffeeContainerstatus()).thenReturn(2000);
		when(customInputScanner.acceptInteger("Input choice")).thenReturn(6, 3, 6, 11);
		when(mockService.refillCoffeeContainer(anyInt())).thenThrow(new OverflowException());
		
		menu.teaCoffeeVendingMachine();
	}
	@Test
	public void shouldCheckRefillContainerForMilkIsCalled() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(6, 4, 6, 11);

		menu.teaCoffeeVendingMachine();
	}

	@Test
	public void shouldCheckOverflowExceptionForMilkContainerIsCaughtWhenContainerIsRefilledWithExcessQuantity()
	{
		when(mockService.getMilkContainerstatus()).thenReturn(10000);
		when(customInputScanner.acceptInteger("Input choice")).thenReturn(6, 4, 6, 11);
		when(mockService.refillMilkContainer(anyInt())).thenThrow(new OverflowException());
		
		menu.teaCoffeeVendingMachine();
	}
	@Test
	public void shouldCheckRefillContainerForSugarIsCalled() {

		when(customInputScanner.acceptInteger("Input choice")).thenReturn(6, 5, 6, 11);

		menu.teaCoffeeVendingMachine();
	}

	@Test
	public void shouldCheckOverflowExceptionForSugarContainerIsCaughtWhenContainerIsRefilledWithExcessQuantity()
	{
		when(mockService.getSugarContainerstatus()).thenReturn(8000);
		when(customInputScanner.acceptInteger("Input choice")).thenReturn(6, 5, 6, 11);
		when(mockService.refillSugarContainer(anyInt())).thenThrow(new OverflowException());
		
		menu.teaCoffeeVendingMachine();
	}
}
