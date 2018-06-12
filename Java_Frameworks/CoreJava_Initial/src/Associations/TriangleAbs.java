package Associations;

public class TriangleAbs extends ShapeAbs
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
	public double getArea(double side1, double side2) {
		double area;
		area = side1 * side2*0.5;
		return area;
	}
	
	
	
}
