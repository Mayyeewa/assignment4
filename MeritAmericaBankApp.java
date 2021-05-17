package com.meritamerica.assignment4;

import java.io.IOException;
import java.text.ParseException;

public class MeritAmericaBankApp {
	public static void main(String[] args) throws IOException, ParseException {
		MeritBank.readFromFile("src/test/testMeritBank_good.txt");
		//MeritBank.writeToFile("C:/Users/dell/Desktop");
	}
}