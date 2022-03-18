import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of $sqft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dollarsqft {
    public void testSqft () {
        FileResource fr = new FileResource();
        averageSqft(fr);        
    }
    public void averageSqft(FileResource fr) {
        double price = 0;
        int count = 0;
        int count1 = 0;
        int sqft = 0;
        int highcount = 0;
        int lowcount = 0;
        double sum = 0;
        double average = 0;
        double squarefeet = 0;
        double lowestSqft = 0;
        double highestSqft = 0;
        String highestAddress = null;
        String lowestAddress = null;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (count1 >= 1) {
            //if ((rec.get(5).equals("2")) && (rec.get(6).equals("3"))) {    
            price = Double.parseDouble(rec.get(2));
            sqft = Integer.parseInt(rec.get(7));
            squarefeet = (price / sqft);
                if ((squarefeet < lowestSqft) || lowestSqft == 0) {
                    lowestSqft = squarefeet;
                    lowestAddress = rec.get(10);
                    lowcount = count1 + 1;
                    System.out.println("Another Low Home is " + lowestAddress + " At: $" + lowestSqft + " At: " + lowcount);  
                }
                if (squarefeet > highestSqft) {
                    highestSqft = squarefeet;
                    highestAddress = rec.get(10);
                    highcount = count1 + 1;
                }
            sum += squarefeet;
            price = 0;
            sqft = 0;
            squarefeet = 0;
            count += 1;
            //}
        }
            count1 += 1;
        }
        average = (sum / count);
        System.out.println("Average price per square feet is: $" + average);
        System.out.println("Home with the lowest Price per square feet is: " + lowestAddress + " At: $"
                            + lowestSqft + " Per Square Foot, At number " + lowcount);
        System.out.println("Home with the highest Price per square feet is: " + highestAddress + " At: $"
                            + highestSqft + " Per Square Foot, At number: " + highcount);
        }
}
