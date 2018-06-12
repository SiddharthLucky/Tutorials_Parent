package Associations;

public class Triangle implements Shape
{
	private double base;
	private double height;
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public double getArea() {
		double Area;
		Area = 0.5*getBase()*getHeight();
		return Area;
	}
	
	@Override
	public String toString() {
		return "Triangle [getArea()=" + getArea() + "]";
	}
	
}
