package com.learn.pojo;

import java.io.Serializable;

public class Rectangle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8949216921719692074L;
	
	
	private double height;
	private double width;

	public Rectangle(double height, double width)
	{
		this.height = height;
		this.width = width;
	}

	public double Area()
	{
		return height * width;
	}

	public double Perimeter()
	{
		System.out.print("Returning perometer dfdsf");
		return 2 * (height + width);
	}
}
