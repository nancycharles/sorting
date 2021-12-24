package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sorting {
	public static void main(String[] args)throws IOException
    {
		getFile(args);
    }

	//scans for the input text file from the console
	private static void getFile(String[] args) throws IOException {
		try {
			if (args.length > 0) {
		  		System.out.println("The File name provided is: " +args[0]);
		  	    String fn = args[0];
		  	    File locateFile = new File(fn);
		  	    Scanner sc = new Scanner(locateFile);
		  	    readFile(sc);
		  	}
			else {
		        System.out.println("File name is not provided by the user..!!");
		    }
  	    }
    	catch(FileNotFoundException e) {
    	    e.printStackTrace();
    	}
	}

	//reads the content of input text file and creates an arraylist
	private static void readFile(Scanner sc) throws IOException {
		ArrayList<PersonName> nameList = new ArrayList<PersonName>();
		while (sc.hasNextLine()) {
			String currentLine = sc.nextLine();
            String[] name = currentLine.split("[,\\s]", 2);
            String lname = name[0];
            String fname = name[1];
            nameList.add(new PersonName(lname, fname));
		}
		sc.close();
		sortNames(nameList);
	}

	//sorts and writes the output in a text file
	private static void sortNames(ArrayList<main.PersonName> nameList) throws IOException {
		Collections.sort(nameList, new NameComparator());
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Nancy\\EclipseNewWS\\SortNames\\Names_sorted.txt"));
        for (PersonName person : nameList)
        {
            writer.write(person.lastName);
            writer.write(", "+person.firstName);
            writer.newLine();
        }
        System.out.println("File named Names_sorted.txt is created by the user in the project root folder..!!");
        writer.close();
	}
}
