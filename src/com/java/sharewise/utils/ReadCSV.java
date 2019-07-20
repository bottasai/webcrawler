package com.java.sharewise.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.opencsv.CSVReader;

public class ReadCSV {
    FileReader filereader;
    CSVReader csvReader;
	
	public ReadCSV(String file) throws FileNotFoundException
	{
		filereader = new FileReader(file); 
        csvReader = new CSVReader(filereader); 
	}
	
	public String get(String file) 
	{ 
	  
	    try { 
	  
	        // Create an object of filereader 
	        // class with CSV file as a parameter. 
	        FileReader filereader = new FileReader(file); 
	  
	        // create csvReader object passing 
	        // file reader as a parameter 
	        CSVReader csvReader = new CSVReader(filereader); 
	        String[] nextRecord; 
	  
	        // we are going to read data line by line 
	        while ((nextRecord = csvReader.readNext()) != null) { 
	            for (String cell : nextRecord) { 
	                System.out.print(cell + "\t"); 
	            } 
	            System.out.println(); 
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	} 

}
