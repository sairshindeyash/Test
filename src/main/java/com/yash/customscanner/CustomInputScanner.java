package com.yash.customscanner;

import java.util.Scanner;

public class CustomInputScanner {
	final Scanner scanner = new Scanner(System.in);

	public Integer acceptInteger(String message) {
		return scanner.nextInt();
	}
}
