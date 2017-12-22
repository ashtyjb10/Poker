package cards;

public class My_Best_Random_Generator implements Random_Generator
{
	
	private long prev;
	private long mult;
	private long increment;
	private static long mask = ( 1L << 48)-1;

	
	@Override
	public int next_int(int max) 
	{
		prev = (mult * prev + increment) & mask;
		return(int) (prev % max);
	}

	@Override
	public void set_seed(long seed) 
	{
		prev  = seed;
	}

	@Override
	public void set_constants(long mult, long increment) 
	{
		this.mult = mult;
		this.increment = increment;
	}

}
