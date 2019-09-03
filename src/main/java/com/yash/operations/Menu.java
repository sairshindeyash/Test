package com.yash.operations;

import com.yash.customexit.SystemExit;
import com.yash.customscanner.CustomInputScanner;
import com.yash.exceptions.OverflowException;
import com.yash.exceptions.UnderflowException;

public class Menu {
	private CustomInputScanner customInputScanner = new CustomInputScanner();
	private SystemExit systemExit = new SystemExit();
	private Service service = new Service();

	private Integer teaContainerRefillCounter = 0;
	private Integer coffeeContainerRefillCounter = 0;
	private Integer waterContainerRefillCounter = 0;
	private Integer sugarContainerRefillCounter = 0;
	private Integer milkContainerRefillCounter = 0;

	public Integer menu() {
		System.out.println("-----------------TeaCoffee Vending Machine-------------------");
		System.out.println("0.Exit");
		System.out.println("1.Make Tea");
		System.out.println("2.Make Black Tea");
		System.out.println("3.Make Coffee");
		System.out.println("4.Make Black Coffee");
		System.out.println("5.Get Container status");
		System.out.println("6.Refill containers");
		System.out.println("7. Reset all containers");
		System.out.println("8.Get count of cups");
		System.out.println("9.Get number of times of container refilling");
		System.out.println("10.Get wastage of different materials");
		System.out.println("Enter your choice:-");
		return customInputScanner.acceptInteger("Input choice");
	}

	public Integer menuForRefillingContainers() {
		System.out.println("0.Exit");
		System.out.println("1.Refill Tea container");
		System.out.println("2.Refill water container");
		System.out.println("3.Refill Coffee container");
		System.out.println("4.Refill milk");
		System.out.println("5.Refill sugar Container");
		System.out.println("Enter your choice:-");

		return customInputScanner.acceptInteger("Input choice");
	}

	public void teaCoffeeVendingMachine() {

		Integer choice1, choice2;
		do {
			choice1 = menu();
			switch (choice1) {
			case 0:
				System.out.println("  ***Thank you.Visit again***");
				systemExit.exit(0);

			case 1:
				try {
					System.out.println("Enter no of cups of tea to make:-");
					Integer numberOfCups = customInputScanner.acceptInteger("Input quantity");
					System.out.println(service.makeDrink("Tea", numberOfCups, 65, 17, 44, 6, 0));

				} catch (UnderflowException e) {
					System.out.println(e.getMessage());

				}
				break;
			case 2:
				try {
					System.out.println("Enter no of cups of black tea to make:-");
					Integer numberOfCups = customInputScanner.acceptInteger("Input quantity");
					System.out.println("@@@@@@@@@"+numberOfCups);
					System.out.println(service.makeDrink("Black Tea", numberOfCups, 112, 17, 0, 3, 0));

				} catch (UnderflowException e) {
					System.out.println(e.getMessage());

				}
				break;
			case 3:
				try {
					System.out.println("Enter no of cups of coffee to make:-");
					Integer numberOfCups = customInputScanner.acceptInteger("Input quantity");
					System.out.println(service.makeDrink("Coffee", numberOfCups, 23, 17, 88, 0, 3));

				} catch (UnderflowException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					System.out.println("Enter no of cups of black coffee to make:-");
					Integer numberOfCups = customInputScanner.acceptInteger("Input quantity");
					System.out.println(service.makeDrink("Black Coffee", numberOfCups, 112, 17, 0, 0, 3));
				} catch (UnderflowException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println("***Container's curreent status***");

				System.out.println("| Coffee | Milk | Water | Sugar | Tea |");
				System.out.println("---------------------------------------");
				System.out.println("|  " + service.getCoffeeContainerstatus() + "  | "
						+ service.getMilkContainerstatus() + " | " + service.getWaterContainerstatus() + " | "
						+ service.getSugarContainerstatus() + " |  " + service.getTeaContainerstatus() + " |");
				System.out.println("---------------------------------------");

				break;
			case 6:
				do {
					choice2 = menuForRefillingContainers();

					switch (choice2) {
					case 0:

						break;

					case 1:
						System.out.println("Enter the quantity to refill");
						try {
							service.refillTeaContainer(customInputScanner.acceptInteger("Input quantity"));
							teaContainerRefillCounter += 1;
						} catch (OverflowException overflowException) {
							System.out.println(overflowException.getMessage());
						}
						break;
					case 2:
						System.out.println("Enter the quantity to refill");
						try {
							service.refillWaterContainer(customInputScanner.acceptInteger("Input quantity"));
							waterContainerRefillCounter += 1;
						} catch (OverflowException overflowException) {
							System.out.println(overflowException.getMessage());
						}
						break;
					case 3:
						System.out.println("Enter the quantity to refill");
						try {
							service.refillCoffeeContainer(customInputScanner.acceptInteger("Input quantity"));
							coffeeContainerRefillCounter += 1;
						} catch (OverflowException overflowException) {
							System.out.println(overflowException.getMessage());
						}
						break;
					case 4:
						System.out.println("Enter the quantity to refill");
						try {
							service.refillMilkContainer(customInputScanner.acceptInteger("Input quantity"));
							milkContainerRefillCounter += 1;
						} catch (OverflowException overflowException) {
							System.out.println(overflowException.getMessage());
						}
						break;
					case 5:
						System.out.println("Enter the quantity to refill");
						try {
							service.refillSugarContainer(customInputScanner.acceptInteger("Input quantity"));
							sugarContainerRefillCounter += 1;
						} catch (OverflowException overflowException) {
							System.out.println(overflowException.getMessage());
						}
						break;
					case 6:
						choice2 = 0;
						break;

					}
				} while (choice2 != 0);
				break;
			case 7:
				service.resetCoffeeContainer();
				service.resetMilkContainer();
				service.resetSugarContainer();
				service.resetTeaContainer();
				service.resetWaterContainer();
				break;

			case 8:// check total sale
				System.out.println("***** No Of Times drinks made *****");

				System.out.println("------------------------------------------");
				System.out.println("| Coffee | BlackCoffee | BlackTea | Tea |");
				System.out.println("------------------------------------------");
				System.out.println("|   " + service.noOfCupsOfCoffeeMade() + "    |     "
						+ service.noOfCupsOfBlackCoffeeMade() + "       |     " + service.noOfCupsOfBlackTeaMade()
						+ "    |  " + service.noOfCupsOfTeaMade() + " |");
				System.out.println("------------------------------------------");
				break;

			case 9:
				System.out.println("***** No Of Times containers refilled *****");
				System.out.println(
						"| CoffeeContainer | MilkContainer | WaterContainer | SugarContainer | TeaContainer |");
				System.out
						.println("-----------------------------------------------------------------------------------");
				System.out.println("|        " + coffeeContainerRefillCounter + "        |       "
						+ milkContainerRefillCounter + "       |         " + waterContainerRefillCounter
						+ "      |        " + sugarContainerRefillCounter + "       |       "
						+ teaContainerRefillCounter + "      |");
				System.out
						.println("-----------------------------------------------------------------------------------");

				break;

			case 10:
				System.out.println("*****Wastage of different materials*****");
				System.out.println("| Coffee | Milk | Water | Sugar | Tea |");
				System.out.println("---------------------------------------");
				System.out.println("|  " + service.calculateCoffeeWastage() + "  | " + service.calculateMilkWastage()
						+ " | " + service.calculateWaterWastage() + " | " + service.calculateSugarWastage() + " |  "
						+ service.calculateTeaWastage() + " |");
				System.out.println("---------------------------------------");
				break;

			case 11:
				choice1 = 0;
				break;
			default:
				break;
			}

		} while (choice1 != 0);

	}

}
