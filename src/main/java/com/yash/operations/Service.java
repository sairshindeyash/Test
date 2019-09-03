package com.yash.operations;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.yash.beveragesEntities.BlackCoffee;
import com.yash.beveragesEntities.BlackTea;
import com.yash.beveragesEntities.Coffee;
import com.yash.beveragesEntities.Tea;
import com.yash.containerEntities.CoffeeContainer;
import com.yash.containerEntities.Container;
import com.yash.containerEntities.MilkContainer;
import com.yash.containerEntities.SugarContainer;
import com.yash.containerEntities.TeaContainer;
import com.yash.containerEntities.WaterContainer;
import com.yash.exceptions.UnderflowException;

public class Service {
	Map<String, Integer> cupCounter=new HashMap<String, Integer>();
	private Integer teaCupCounter = 0;
	private Integer blackTeaCupCounter = 0;
	private Integer coffeeCupCounter = 0;
	private Integer blackCoffeeCupCounter = 0;

	private Container milkContainer;
	private Container waterContainer;
	private Container sugarContainer;
	private Container teaContainer;
	private Container coffeeContainer;

	public Service() {
		
		milkContainer = new MilkContainer();
		waterContainer =new WaterContainer(); 
		sugarContainer = new SugarContainer();
		teaContainer = new TeaContainer();
		coffeeContainer = new CoffeeContainer();
		cupCounter.put("tea", 0);
		cupCounter.put("coffee", 0);
		cupCounter.put("blackTea", 0);
		cupCounter.put("blackCoffee", 0);

	}

	public String makeDrink(String drinkType, Integer numberOfCups, Integer waterQuantity, Integer suagrQuantity,
			Integer milkQuantity, Integer teaPowderQuantity, Integer coffeePowderQuantity)throws UnderflowException {
		System.out.println("No of cups====="+numberOfCups);
		if (sugarContainer.getStatus() < suagrQuantity * numberOfCups) {
			throw new UnderflowException("Insufficient amount of sugar");
		} else if (this.teaContainer.getStatus() < teaPowderQuantity * numberOfCups) {
			throw new UnderflowException("Insufficient amount of teapowder");
		} else if (this.waterContainer.getStatus() < waterQuantity * numberOfCups) {
			throw new UnderflowException("Insufficient amount of water");
		} else if (this.milkContainer.getStatus() < milkQuantity * numberOfCups) {
			throw new UnderflowException("Insufficient amount of milk");
		} else if (this.coffeeContainer.getStatus() < coffeePowderQuantity * numberOfCups) {
			throw new UnderflowException("Insufficient amount of coffee");
		} else {
			if (drinkType.equals("Tea")) {
				Tea tea = new Tea(teaPowderQuantity, waterQuantity, suagrQuantity, milkQuantity);
				//teaCupCounter = teaCupCounter + (1 * numberOfCups);
				Integer res = cupCounter.entrySet().stream().filter(drink->drink.getKey().equals("tea")).findFirst().get().getValue();
				cupCounter.put("tea", (1*numberOfCups)+res);
				 
			} else if (drinkType.equals("Black Tea")) {
				BlackTea blackTea = new BlackTea(teaPowderQuantity, waterQuantity, suagrQuantity);
				//blackTeaCupCounter = blackTeaCupCounter + (1 * numberOfCups);
				Integer res = cupCounter.entrySet().stream().filter(drink->drink.getKey().equals("blackTea")).findFirst().get().getValue();
				cupCounter.put("blackTea", (1*numberOfCups)+res);
			} else if (drinkType.equals("Coffee")) {
				Coffee coffee = new Coffee(coffeePowderQuantity, waterQuantity, suagrQuantity, milkQuantity);
				//coffeeCupCounter = coffeeCupCounter + (1 * numberOfCups);
				Integer res = cupCounter.entrySet().stream().filter(drink->drink.getKey().equals("coffee")).findFirst().get().getValue();
				cupCounter.put("coffee", (1*numberOfCups)+res);
			}

			else {
				BlackCoffee blackCoffee = new BlackCoffee(coffeePowderQuantity, waterQuantity, suagrQuantity);
				//blackCoffeeCupCounter = blackCoffeeCupCounter + (1 * numberOfCups);
				Integer res = cupCounter.entrySet().stream().filter(drink->drink.getKey().equals("blackCoffee")).findFirst().get().getValue();
				cupCounter.put("blackCoffee", (1*numberOfCups)+res);
				
			}
		}
		teaContainer.updateCurrentCapacity(teaPowderQuantity * numberOfCups);
		waterContainer.updateCurrentCapacity(waterQuantity * numberOfCups);
		coffeeContainer.updateCurrentCapacity(coffeePowderQuantity * numberOfCups);
		milkContainer.updateCurrentCapacity(milkQuantity * numberOfCups);
		sugarContainer.updateCurrentCapacity(suagrQuantity * numberOfCups);
		return numberOfCups + " cups made";
	}

	public Integer getWaterContainerstatus() {
		return waterContainer.getStatus();
	}

	public Integer getSugarContainerstatus() {
		return sugarContainer.getStatus();
	}

	public Integer getTeaContainerstatus() {
		return teaContainer.getStatus();
	}

	public Integer getCoffeeContainerstatus() {
		return coffeeContainer.getStatus();
	}

	public Integer getMilkContainerstatus() {
		return milkContainer.getStatus();
	}

	public Integer refillCoffeeContainer(Integer quantity) {
		return coffeeContainer.refill(quantity);

	}

	public Integer refillTeaContainer(Integer quantity) {

		return teaContainer.refill(quantity);
	}

	public Integer refillWaterContainer(Integer quantity) {

		return waterContainer.refill(quantity);
	}

	public Integer refillMilkContainer(Integer quantity) {

		return milkContainer.refill(quantity);
	}

	public Integer refillSugarContainer(Integer quantity) {

		return sugarContainer.refill(quantity);
	}

	public Integer resetCoffeeContainer() {
		return coffeeContainer.reset();
	}

	public Integer resetMilkContainer() {
		return milkContainer.reset();
	}

	public Integer resetSugarContainer() {
		return sugarContainer.reset();
	}

	public Integer resetTeaContainer() {
		return teaContainer.reset();
	}

	public Integer resetWaterContainer() {
		return waterContainer.reset();
	}

	public Integer noOfCupsOfTeaMade() {
		return cupCounter.get("tea");
	}

	public Integer noOfCupsOfCoffeeMade() {
		return cupCounter.get("coffee");
	}

	public Integer noOfCupsOfBlackTeaMade() {

		return cupCounter.get("blackTea");
	}

	public Integer noOfCupsOfBlackCoffeeMade() {
		return cupCounter.get("blackCoffee");
	}

	public Integer checkTotalSale() {

		return (noOfCupsOfTeaMade() * 10) + (noOfCupsOfCoffeeMade() * 15) + (noOfCupsOfBlackTeaMade() * 5) + (noOfCupsOfBlackCoffeeMade() * 10);
	}

	public Integer calculateTeaWastage() {
		return (noOfCupsOfTeaMade() * 1);
	}

	public Integer calculateWaterWastage() {
		return ((noOfCupsOfBlackCoffeeMade() * 12) + (noOfCupsOfBlackTeaMade() * 12) + (noOfCupsOfCoffeeMade() * 3)
				+ (noOfCupsOfTeaMade() * 5));
	}

	public Integer calculateMilkWastage() {
		return ((noOfCupsOfCoffeeMade() * 3) + (noOfCupsOfTeaMade() * 4));
	}

	public Integer calculateSugarWastage() {
		return ((noOfCupsOfBlackCoffeeMade() * 2) + (noOfCupsOfBlackTeaMade() * 2) + (noOfCupsOfCoffeeMade() * 2)
				+ (noOfCupsOfTeaMade() * 2));
	}

	public Integer calculateCoffeeWastage() {
		return ((noOfCupsOfBlackCoffeeMade() * 0) + noOfCupsOfCoffeeMade() * 1);
	}

}
