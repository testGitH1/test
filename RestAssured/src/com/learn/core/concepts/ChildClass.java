package com.learn.core.concepts;

public class ChildClass extends ParentClass 
{

	@SuppressWarnings("deprecation")
	public ChildClass() throws InterruptedException 
	{
		System.out.println("ChildClass Constructor");
			System.out.println("This line changed in git hub");
		Thread localThread= Thread.currentThread();
		System.err.println(localThread.getId());
		System.out.println(localThread.getName());
		localThread.stop();
		Thread.sleep(5000L);
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		ChildClass parentClass = new ChildClass();
		parentClass.test();
		
	} 
	
	public void test() 
	{
		System.err.println("Test method ");
	}
}
