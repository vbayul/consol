package org.luxoft.consol;


import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BeginProgram {
	private static Scanner in;

	public static void main(String[] args) 
	{
		in = new Scanner(System.in);
		System.out.print("Enter base directory:");

		String directory = in.nextLine();
		if (directory.equals("")) 
			directory = in.nextLine();
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		FolderReader counter = new FolderReader(new File(directory), pool); 
		pool.submit(counter);
	}
}
