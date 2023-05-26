/*
 * CSCE 146 S2023 ExamFinal Question02
 * Provided code. Do not alter the code that says "Do not alter"
 */
//Do not alter-----------------------------------------------------------------------
public class Bucket
{
	private int weight;
	public Bucket()
	{
		this.weight = 1;
	}
	public Bucket(int aC)
	{
		this.setWeight(aC);
	}
	public int getWeight()
	{
		return this.weight;
	}
	public void setWeight(int aC)
	{
		if(aC > 0)
			this.weight = aC;
		else
			this.weight = 1;
	}
	public String toString()
	{
		return "Bucket that weights "+this.weight+" kg";
	}
}
//-----------------------------------------------------------------------------------