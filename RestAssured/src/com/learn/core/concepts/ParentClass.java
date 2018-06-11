package com.learn.core.concepts;

public class ParentClass 
{

	public ParentClass() 
	{
		try
		{
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println(" Parent class No Arguments Constructor");
	}

}
