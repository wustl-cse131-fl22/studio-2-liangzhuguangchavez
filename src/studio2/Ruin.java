package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		int startAmount,winLimit,totalSimulations, totalLoss = 0;
		double winChance;
		Scanner in = new Scanner(System.in);
		System.out.println("What is your start amount?");	
		startAmount = in.nextInt();
		System.out.println("What is your win chance?");
		winChance = in.nextDouble();
		System.out.println("What is your win limit?");
		winLimit = in.nextInt();
		System.out.println("What is the number of total simulation?");
		totalSimulations = in.nextInt();
		
		for(int i=1; i<totalSimulations+1; i++) {	
			int money = startAmount, daySimulations = 0;
			while (money != 0 && money < winLimit) {
				daySimulations ++;
				if (Math.random() <= winChance) {
					money ++;										
					}
				else {
					money --;					
					}
				
				}
			if (money >= winLimit) {
				System.out.println("Simulation "+i+": "+daySimulations+" WIN");			
				}
			else {
				totalLoss ++;
				System.out.println("Simulation "+i+": "+daySimulations+" LOSE");	
			}
		}
		System.out.println("Losses: "+totalLoss+" Simulations: "+totalSimulations);
		double ruinRate = (double)totalLoss/ (double)totalSimulations;
		double alpha = (1-winChance)/winChance;
		double expectedRuin;
		if (winChance == 0.5) {
			expectedRuin = 1 - startAmount/winLimit;
		}
		else {
			expectedRuin = (Math.pow(alpha,startAmount) - Math.pow(alpha, winLimit))/(1-Math.pow(alpha,winLimit));
		}		
		System.out.println("Ruin Rate from Simulation: "+ruinRate+" Expected Ruin Rate: "+expectedRuin);
	}
}

