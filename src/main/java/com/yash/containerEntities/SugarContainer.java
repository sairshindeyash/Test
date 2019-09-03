package com.yash.containerEntities;

import com.yash.exceptions.OverflowException;

public class SugarContainer implements Container {

	private Integer currentCapacity = 8000;

	public SugarContainer() {
		super();
	}

	public Integer updateCurrentCapacity(Integer consumedQuantity) {
		currentCapacity = this.currentCapacity - consumedQuantity;
		return currentCapacity;
	}

	public Integer refill(Integer quantity) throws OverflowException {
		System.out.println("inside refill");
		Integer updateCapacity = currentCapacity + quantity;
		System.out.println("current capacity===" + updateCapacity);
		if (updateCapacity > 8000)
			throw new OverflowException();
		else
			currentCapacity = updateCapacity;

		return currentCapacity;
	}

	public void setCurrentCapacity(Integer currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public Integer reset() {

		return this.currentCapacity = 8000;

	}

	public Integer getStatus() {

		return currentCapacity;
	}

}
