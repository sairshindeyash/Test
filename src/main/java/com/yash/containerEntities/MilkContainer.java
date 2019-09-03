package com.yash.containerEntities;

import com.yash.exceptions.OverflowException;

public class MilkContainer implements Container {

	private Integer currentCapacity = 10000;

	public MilkContainer() {
		super();
	}

	public Integer updateCurrentCapacity(Integer consumedQuantity) {
		currentCapacity = this.currentCapacity - consumedQuantity;
		return currentCapacity;
	}

	public Integer getStatus() {

		return currentCapacity;
	}

	public Integer refill(Integer quantity) throws OverflowException {
		System.out.println("inside refill");
		Integer updateCapacity = currentCapacity + quantity;
		System.out.println("current capacity===" + updateCapacity);
		if (updateCapacity > 10000)
			throw new OverflowException();
		else
			currentCapacity = updateCapacity;
		return currentCapacity;
	}

	public Integer reset() {
		return this.currentCapacity = 10000;
	}

}
