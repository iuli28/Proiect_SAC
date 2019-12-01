package com.demo.restaurants.demo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.restaurants.demo.model.Restaurant;
import com.demo.restaurants.demo.repository.RestaurantRepository;

@Component
public class RestaurantParser {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	private static final char DEFAULT_SEPARATOR = ',';
	private static final char DEFAULT_QUOTE = '"';
	
	@PostConstruct
	public void parseCsv() throws FileNotFoundException {
		String csvFile = "C:\\Users\\Iulian\\eclipse-workspace\\SAC\\Proiect_SAC\\demo\\src\\main\\resources\\static\\bot_maps_data.csv";

		Scanner scanner = new Scanner(new File(csvFile));
		scanner.nextLine();
		while (scanner.hasNext()) {
			List<String> line = parseLine(scanner.nextLine());
			
			if(!line.get(0).isEmpty() && !line.get(1).isEmpty() && !line.get(2).isEmpty()
					&& !line.get(5).isEmpty() && !line.get(6).isEmpty()) {
				if(line.get(6).length() != 1) {
					line.add(6, line.get(6).replaceAll(",","").substring(1));
				}
				
				
				Restaurant restaurant = new Restaurant(Long.valueOf(line.get(0)), line.get(1), line.get(2),
						Double.valueOf(line.get(5)), line.get(3), Integer.valueOf(line.get(6)));
				
				
				if(restaurantRepository == null)
					System.out.println(true);
				

			}
		}

		scanner.close();

		
	}

	public static List<String> parseLine(String cvsLine) {
        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String cvsLine, char separators) {
        return parseLine(cvsLine, separators, DEFAULT_QUOTE);
    }

    public static List<String> parseLine(String cvsLine, char separators, char customQuote) {

        List<String> result = new ArrayList<>();

        //if empty, return!
        if (cvsLine == null && cvsLine.isEmpty()) {
            return result;
        }

        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        char[] chars = cvsLine.toCharArray();

        for (char ch : chars) {

            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {

                    //Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }

                }
            } else {
                if (ch == customQuote) {

                    inQuotes = true;

                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }

                    //double quotes in column will hit this!
                    if (startCollectChar) {
                        curVal.append('"');
                    }

                } else if (ch == separators) {

                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    startCollectChar = false;

                } else if (ch == '\r') {
                    //ignore LF characters
                    continue;
                } else if (ch == '\n') {
                    //the end, break!
                    break;
                } else {
                    curVal.append(ch);
                }
            }

        }

        result.add(curVal.toString());

        return result;
    }
    
    
}