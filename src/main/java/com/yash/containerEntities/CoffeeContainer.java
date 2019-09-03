package com.yash.containerEntities;

import com.yash.exceptions.OverflowException;

public class CoffeeContainer implements Container {

	private Integer currentCapacity = 2000;

	public CoffeeContainer() {
		super();

	}

	public Integer updateCurrentCapacity(Integer consumedQuantity) {
		currentCapacity = this.currentCapacity - consumedQuantity;
		return currentCapacity;
	}

	public void setCurrentCapacity(Integer currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public Integer getStatus() {

		return currentCapacity;
	}

	public Integer refill(Integer quantity) throws OverflowException {

		Integer updateCapacity = currentCapacity + quantity;

		if (updateCapacity > 2000)
			throw new OverflowException();
		else
			currentCapacity = updateCapacity;

		return currentCapacity;
	}

	public Integer reset() {

		return this.currentCapacity = 2000;
	}

}
