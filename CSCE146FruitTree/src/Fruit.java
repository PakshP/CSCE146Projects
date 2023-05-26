public class Fruit implements Comparable<Fruit>{
	private double weight;
	private String type;
	public Fruit()
	{
		this.weight = 1.0;
		this.type = "apple";
	}
	public Fruit(double aW, String aT)
	{
		this.setWeight(aW);
		this.setType(aT);
	}
	public double getWeight()
	{
		return this.weight;
	}
	public String getType()
	{
		return this.type;
	}
	public void setWeight(double aW)
	{
		if(aW > 0.0)
			this.weight = aW;
		else
			this.weight = 1.0;
	}
	public void setType(String aT)
	{
		if(aT != null && (aT.equalsIgnoreCase("kiwi") || aT.equalsIgnoreCase("tomato") || aT.equalsIgnoreCase("banana") || aT.equalsIgnoreCase("apple") || aT.equalsIgnoreCase("orange")))
		{
			this.type = aT;
		}
		else
			this.type = "apple";
	}
	public String toString()
	{
		return this.type+ " " + this.weight;
	}
	public int compareTo(Fruit aFruit)
	{
		if(aFruit == null)
			return -1;
		if(this.weight < aFruit.getWeight())
			return -1;
		else if(this.weight > aFruit.getWeight())
			return 1;
		else
			return this.type.compareTo(aFruit.getType());
	}
}