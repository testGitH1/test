package com.learn.ser.deser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.learn.pojo.Rectangle;

public class Desrilazation {

	
	public static Object DeSerializeFromFileToObject(String fileName)
	{
		try {

			// Step 1: Create a file input stream to read the serialized content
			// of rectangle class from the file
			java.io.FileInputStream fileStream = new FileInputStream(new File(fileName));

			// Step 2: Create an object stream from the file stream. So that the content
			// of the file is converted to the Rectangle Object instance
			java.io.ObjectInputStream objectStream = new ObjectInputStream(fileStream);

			// Step 3: Read the content of the stream and convert it into object
			Object deserializeObject = objectStream.readObject();

			// Step 4: Close all the resources
			objectStream.close();
			fileStream.close();

			// return the deserialized object
			return deserializeObject;

		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args)
	{
		Rectangle rect = new Rectangle(18, 78);
		Serialization.SerializeToFile(rect, "rectSerialized");

		Rectangle deSerializedRect = (Rectangle) DeSerializeFromFileToObject("rectSerialized");
		System.out.println("Rect area is " + deSerializedRect.Area());
	}
}
