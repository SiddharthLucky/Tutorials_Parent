package Associations;

public abstract class ShapeAbs 
{
	private double side1;
	private double side2;
	private double area;
	
	public double getSide1() {
		return side1;
	}
	public void setSide1(double side1) {
		this.side1 = side1;
	}
	public double getSide2() {
		return side2;
	}
	public void setSide2(double side2) {
		this.side2 = side2;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public abstract double getArea(double side1, double side2);
}
