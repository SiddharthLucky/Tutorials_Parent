package Associations;

public class RectangleAbs extends ShapeAbs
{
	private double length;
	private double width;
	
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
	@Override
	public double getArea(double side1, double side2) {
		double area;
		area = side1 * side2;
		return area;
	}
}
