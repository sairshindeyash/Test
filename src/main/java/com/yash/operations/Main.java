package com.yash.operations;

import com.yash.exceptions.OverflowException;
import com.yash.exceptions.UnderflowException;

public class Main {

	public static void main(String[] args) {
		Menu menu=new Menu();
		try {
		menu.teaCoffeeVendingMachine();
		}catch ( OverflowException overflowException) {
			System.out.println(overflowException.getMessage());
		}
		catch (UnderflowException underflowException) {
			System.out.println(underflowException.getMessage());
		}
	}

}
