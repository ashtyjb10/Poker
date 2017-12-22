package cards;

public class Main 
{
	static final int ITERATIONS = 1000;
	
	public static void main(String[] args) 
	{
		//Timing for exhaustive
		System.out.println("~Exhaustive~");
		System.out.println("-------------------------------");
		
		long startTimeExhaustive = System.nanoTime();
		double[] testExhaustive = Odds.percentage_per_hand_category_exhaustive(5);
		long endTimeExhaustive = System.nanoTime();
		
		long totalTime = endTimeExhaustive - startTimeExhaustive;
		
		System.out.println("Total time exhaustive: " + totalTime / 1_000_000_000);
		
		for(int index = 0; index < testExhaustive.length; index++)
		{
			System.out.println(testExhaustive[index]);
		}
		
		System.out.println();
		
		//Timing for stochastic 
		System.out.println("~Stochastic~");
		System.out.println("-------------------------------");
		
		long startTimeStochastic = System.nanoTime();
		double[] testStochastic = Odds.percentage_per_hand_category_stochastic(5, ITERATIONS);
		long endTimeStochastic = System.nanoTime();
		
		long totalTimeStochastic = endTimeStochastic - startTimeStochastic;
		
		System.out.println("Total time stochastic: " + totalTimeStochastic / 1_000_000_000);
		
		
		for(int index = 0; index < testStochastic.length; index++)
		{
			System.out.println(testStochastic[index]);
		}
		
	
		//Timing for Java Random Generator vs. Our Best Random Generator
		
		
		//Timing for Texas Hold'em 
		long startTimeTexasHoldem = 0;
		double texasHoldem = 0;
		long endTimeTexasHoldem = 0;
		
		for(int index = 0; index < 13; index++)
		{
			startTimeTexasHoldem = System.nanoTime();
			texasHoldem = Odds.odds_to_win((int) (Math.random() * 52), (int) (Math.random() * 52), (int) (Math.random() * 52), (int) (Math.random() * 52), 10);
			//double texasHoldem = Odds.odds_to_win(2, 32, 6, 29, 10);
			endTimeTexasHoldem = System.nanoTime();
		}
	
		long totalTimeTexasHoldem = endTimeTexasHoldem - startTimeTexasHoldem;
		
		System.out.println("Total time Texas Hold'em : " + totalTimeTexasHoldem / 1_000_000 + " seconds \nPlayer 1 wins : " + texasHoldem + "% of the time...");
	}
}
