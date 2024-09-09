package model;

public class Circle {
	public static final Double PI = 3.14;
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public static Double getPi() {
		return PI;
	}
	
	public void draw() {
		System.out.println("반지름" + radius +"cm인 원을 그립니다.");
	}
}
