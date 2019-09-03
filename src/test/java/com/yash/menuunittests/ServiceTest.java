package com.yash.menuunittests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import com.yash.containerEntities.CoffeeContainer;
import com.yash.containerEntities.MilkContainer;
import com.yash.containerEntities.SugarContainer;
import com.yash.containerEntities.TeaContainer;
import com.yash.containerEntities.WaterContainer;
import com.yash.exceptions.UnderflowException;
import com.yash.operations.Service;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class ServiceTest {

	@InjectMocks
	Service menu;

	@Mock
	MilkContainer milkContainer;

	@Mock
	SugarContainer sugarContainer;

	@Mock
	TeaContainer teaContainer;

	@Mock
	WaterContainer waterContainer;

	@Mock
	CoffeeContainer coffeeContainer;

	@Test
	public void shouldMake1cupoftea() {
		when(sugarContainer.getStatus()).thenReturn(500);
		when(teaContainer.getStatus()).thenReturn(500);
		when(milkContainer.getStatus()).thenReturn(500);
		when(waterContainer.getStatus()).thenReturn(500);

		assertEquals("5 cups made", menu.makeDrink("Tea", 5, 65, 17, 44, 6, 0));
	}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void shouldThrowUnderflowExceptionIfMilkContainerIs() {
		expectedException.expect(UnderflowException.class);
		expectedException.expectMessage("Insufficient amount of milk");
		when(sugarContainer.getStatus()).thenReturn(200);
		when(waterContainer.getStatus()).thenReturn(900);
		when(teaContainer.getStatus()).thenReturn(800);
		when(milkContainer.getStatus()).thenReturn(-1);

		menu.makeDrink("Tea", 5, 65, 17, 44, 6, 0);

	}

	@Test
	public void shouldThrowUnderflowExceptionIfSugarContainerIsEmpty() {
		expectedException.expect(UnderflowException.class);
		expectedException.expectMessage("Insufficient amount of sugar");
		when(sugarContainer.getStatus()).thenReturn(-1);

		menu.makeDrink("Black Tea", 12, 112, 17, 0, 3, 0);

	}

	@Test
	public void shouldThrowUnderflowExceptionIfTeaContainerIsEmpty() {
		expectedException.expect(UnderflowException.class);
		expectedException.expectMessage("Insufficient amount of teapowder");
		when(sugarContainer.getStatus()).thenReturn(200);
		menu.makeDrink("Black Tea", 2, 112, 17, 0, 3, 0);
	}

	@Test
	public void shouldThrowUnderflowExceptionIfWaterContainerIsEmpty() {
		expectedException.expect(UnderflowException.class);
		expectedException.expectMessage("Insufficient amount of water");
		when(sugarContainer.getStatus()).thenReturn(200);
		when(teaContainer.getStatus()).thenReturn(800);
		when(waterContainer.getStatus()).thenReturn(-1);
		menu.makeDrink("Coffee", 1, 23, 17, 88, 0, 3);

	}

	@Test
	public void shouldMake2CupOfCoffee() {
		when(sugarContainer.getStatus()).thenReturn(200);
		when(waterContainer.getStatus()).thenReturn(900);
		when(coffeeContainer.getStatus()).thenReturn(800);
		when(milkContainer.getStatus()).thenReturn(200);
		assertEquals("2 cups made", menu.makeDrink("Coffee", 2, 23, 17, 88, 0, 3));
	}

	@Test
	public void shouldThrowUnderflowExceptionIfCoffeeContainerIsEmpty() {
		expectedException.expect(UnderflowException.class);
		expectedException.expectMessage("Insufficient amount of coffee");
		when(milkContainer.getStatus()).thenReturn(600);
		when(waterContainer.getStatus()).thenReturn(900);
		when(sugarContainer.getStatus()).thenReturn(300);
		when(coffeeContainer.getStatus()).thenReturn(-1);
		menu.makeDrink("Coffee", 5, 23, 17, 88, 0, 3);
	}

	@Test
	public void shouldMake5CupsOfBlackCoffee() {
		when(waterContainer.getStatus()).thenReturn(900);
		when(sugarContainer.getStatus()).thenReturn(300);
		when(coffeeContainer.getStatus()).thenReturn(400);
		assertEquals("5 cups made", menu.makeDrink("Black Coffee", 5, 112, 17, 0, 0, 3));
	}

	@Test
	public void shouldMake1cupofblackteamade() {
		when(sugarContainer.getStatus()).thenReturn(900);
		when(teaContainer.getStatus()).thenReturn(800);
		when(waterContainer.getStatus()).thenReturn(900);
		assertEquals("1 cups made", menu.makeDrink("Black Tea", 1, 112, 17, 0, 3, 0));
	}

	@Test
	public void sholdReturnWaterContainersCurrentStatus() {
		when(waterContainer.getStatus()).thenReturn(965);
		assertEquals(965, menu.getWaterContainerstatus().intValue());
	}

	@Test
	public void sholdReturnTeaContainersCurrentStatus() {
		when(teaContainer.getStatus()).thenReturn(1500);
		assertEquals(1500, menu.getTeaContainerstatus().intValue());
	}

	@Test
	public void sholdReturnSugarContainersCurrentStatus() {
		when(sugarContainer.getStatus()).thenReturn(1200);
		assertEquals(1200, menu.getSugarContainerstatus().intValue());
	}

	@Test
	public void sholdReturnCoffeeContainersCurrentStatus() {
		when(coffeeContainer.getStatus()).thenReturn(450);
		assertEquals(450, menu.getCoffeeContainerstatus().intValue());
	}

	@Test
	public void shouldReturnMilkContainersCurrentStatus() {
		when(milkContainer.getStatus()).thenReturn(9000);
		assertEquals(9000, menu.getMilkContainerstatus().intValue());
	}

	@Test
	public void shouldRefillCOffeeContainerWithRequiredQuantity() {
		coffeeContainer.updateCurrentCapacity(1500);
		when(coffeeContainer.refill(35)).thenReturn(1535);
		assertEquals(1535, menu.refillCoffeeContainer(35).intValue());
	}

	@Test
	public void shouldRefillMilkContainerWithRequiredQuantity() {
		milkContainer.updateCurrentCapacity(8000);
		when(milkContainer.refill(45)).thenReturn(8045);
		assertEquals(8045, menu.refillMilkContainer(45).intValue());
	}

	@Test
	public void shouldRefillSugarContainerWithRequiredQuantity() {
		sugarContainer.updateCurrentCapacity(5000);
		when(sugarContainer.refill(870)).thenReturn(5870);
		assertEquals(5870, menu.refillSugarContainer(870).intValue());
	}

	@Test
	public void shouldRefillTeaContainerWithRequiredQuantity() {
		teaContainer.updateCurrentCapacity(1500);
		when(teaContainer.refill(200)).thenReturn(1700);
		assertEquals(1700, menu.refillTeaContainer(200).intValue());
	}

	@Test
	public void shouldRefillWaterContainerWithRequiredQuantity() {
		waterContainer.updateCurrentCapacity(12000);
		when(waterContainer.refill(65)).thenReturn(12065);
		assertEquals(12065, menu.refillWaterContainer(65).intValue());
	}

	@Test
	public void sholdResetCoffeeContainersCapacityToOriginal() {
		when(coffeeContainer.reset()).thenReturn(2000);
		assertEquals(2000, menu.resetCoffeeContainer().intValue());
	}

	@Test
	public void sholdResetMilkContainersCapacityToOriginal() {
		when(milkContainer.reset()).thenReturn(10000);
		assertEquals(10000, menu.resetMilkContainer().intValue());
	}

	@Test
	public void sholdResetSugarContainersCapacityToOriginal() {
		when(sugarContainer.reset()).thenReturn(8000);
		assertEquals(8000, menu.resetSugarContainer().intValue());
	}

	@Test
	public void sholdResetTeaContainersCapacityToOriginal() {
		when(teaContainer.reset()).thenReturn(2000);
		assertEquals(2000, menu.resetTeaContainer().intValue());
	}

	@Test
	public void sholdResetWaterContainersCapacityToOriginal() {
		when(waterContainer.reset()).thenReturn(15000);
		assertEquals(15000, menu.resetWaterContainer().intValue());
	}

	@Test
	public void shouldReturnNoOfCupsOfTeaMade() {

		assertEquals(0, menu.noOfCupsOfTeaMade().intValue());
	}

	@Test
	public void shouldReturnNoOfCupsOfBlackTeaMade() {
		assertEquals(0, menu.noOfCupsOfBlackTeaMade().intValue());
	}

	@Test
	public void shouldReturnNoOfCupsOfBlackCoffeeMade() {
		assertEquals(0, menu.noOfCupsOfBlackCoffeeMade().intValue());
	}

	@Test
	public void shouldReturnNoOfCupsOfCoffeeMade() {
		assertEquals(0, menu.noOfCupsOfCoffeeMade().intValue());
	}

	@Test
	public void shouldReturnTotalSale() {

		assertEquals(0, menu.checkTotalSale().intValue());
	}

	@Test
	public void sholdReturnTotalTeaWasted() {
		assertEquals(0, menu.calculateTeaWastage().intValue());
	}

	@Test
	public void shouldReturnTotalWaterWasted() {
		assertEquals(0, menu.calculateWaterWastage().intValue());
	}

	@Test
	public void shouldReturnTotalMilkWasted() {
		assertEquals(0, menu.calculateMilkWastage().intValue());
	}

	@Test
	public void shouldReturnTotalSugarWasted() {
		assertEquals(0, menu.calculateSugarWastage().intValue());
	}

	@Test
	public void shouldReturnTotalCoffeeWasted() {
		assertEquals(0, menu.calculateCoffeeWastage().intValue());
	}
}
