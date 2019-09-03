package com.yash.beveragesEntities;

public class Coffee extends BlackCoffee {
	public Integer milkQuantity;

	
	public Coffee(Integer coffeePowderQuantity, Integer waterQuantity, Integer sugarQuantity, Integer milkQuantity) {
		super(coffeePowderQuantity, waterQuantity, sugarQuantity);
		this.milkQuantity = milkQuantity;
	}

	

}
