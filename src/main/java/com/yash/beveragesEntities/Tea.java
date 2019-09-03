package com.yash.beveragesEntities;

public class Tea extends BlackTea {
	public Integer milkQuantity;



	public Tea(Integer teaPowderQuantity, Integer waterQuantity, Integer sugarQuantity, Integer milkQuantity) {
		super(teaPowderQuantity, waterQuantity, sugarQuantity);
		this.milkQuantity = milkQuantity;
	}

	
}
