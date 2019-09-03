package com.yash.containerEntities;

public interface Container {
	public Integer updateCurrentCapacity(Integer consumedQuantity);

	public Integer refill(Integer quantity);

	public Integer reset();

	public Integer getStatus();
}
