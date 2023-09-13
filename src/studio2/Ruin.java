package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("The amount of money that you start with: ");
		int startAmount = in.nextInt();
		
		System.out.println("The win probability, or the probability that you win a single play: ");
		double winChance = in.nextDouble();
		
		System.out.println("If you reach this amount of money you had a successful day and leave: ");
		int winLimit = in.nextInt();
		
		System.out.println("The number of day’s you’ll simulate: ");
		int totalSimulations = in.nextInt();
		
		int num2 =0;
		int num3 =0;
		
		double chance = Math.random();
		int num = 0;
		for (int i = totalSimulations;  i > 0; i --) {
			while ((startAmount > 0) && (startAmount != winLimit)) { 
			
				if (chance <= winChance) { 
					startAmount ++;
					num ++;
					System.out.println(startAmount);
				}
				else {
					startAmount --;
					num ++;
					System.out.println(startAmount);
				
				}
				
			}
			
			num2++;
			
			if (startAmount == 0) {
				System.out.println("Simulation" + num2 + ": "+ num + "LOSE" );
				num3 ++;
			}
			
			if (startAmount == winLimit) {
				System.out.println("Simulation" + num2 + ": "+ num + "WIN" );
			}
			
		}
		
		System.out.println("Losses: " + num3 + " Simulation: " + totalSimulations);
		
		double a = ((1-winChance) / winChance);
		double expectedRuinRate = 0;
		
		if (winChance == 0.5) {
			expectedRuinRate = 1 - (startAmount / winLimit);
		}
		else {
			expectedRuinRate = (Math.pow(a, startAmount) - Math.pow(a, winLimit)) / (1 - Math.pow(a, winLimit));
		}
		
		System.out.println("Ruin Rate from Simulations: " + num3/totalSimulations + "Expected Ruin Rate: " + expectedRuinRate);
		
	}

}
