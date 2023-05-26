/*
 * CSCE 146 S2023 ExamFinal Question03
 * Provided code. Do not alter the code that says "Do not alter"
 */
//Do not alter-----------------------------------------------------------------------
public class ShippingContainer 
{
	private String label;
	private double length, width, height;
	public ShippingContainer(String aN, double aL, double aW, double aH)
	{
		if(aN != null)
			this.label = aN;
		if(aL > 0.0)
			this.length = aL;
		if(aW > 0.0)
			this.width = aW;
		if(aH > 0.0)
			this.height = aH;
		
	}
	public String getLabel() {
		return label;
	}
	public double getLength() {
		return length;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public String toString()
	{
		return "[Container] Label: "+this.label+" Length: "+this.length+" Width: "+this.width+" Height: "+this.height;
	}
}
//-----------------------------------------------------------------------------------