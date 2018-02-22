import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;
import javafx.application.Application;
/**
 * Program that uses the Measurement and PollutionDataset classes.
 *
 * <p>Created for COMP1721 Coursework 1.</p>
 *
 * @author Slavyana Dianova Chervenkondeva
 */

class Pollution {

    public static void main(String[] args) throws FileNotFoundException {

        PollutionDataset set = new PollutionDataset();
        
        // Read the file path from command line
        Scanner in;
        if(args.length > 0) {
          in = new Scanner(args[0]);
        }
        // Input file path, if no args were found 
        else {
          System.out.print("Input file path: ");
          in = new Scanner(System.in);
        }
          String fileName = in.nextLine();

        // Read CSV file and print data, unless exceptions occur  
        try{
            set.readCSV(fileName);

            System.out.println(set.size() + " records processed");
            System.out.println("Max: " + set.maxLevel());
            System.out.println("Min: " + set.minLevel());
            System.out.printf("Mean: %.3f \u00b5g/m\u00b3%n", set.meanLevel());
            if(set.dayRulesBreached() == null){
                 System.out.println("No rules were breached.");
            }
            else System.out.printf("The EU rules were breached on %s.%n",
                    set.dayRulesBreached());
            
            
            // Print a bar chart with the average monthly levels
            System.out.print("Would you like to see a bar chart of the data? (y/n): ");
            String choice = "";
           
            while (!(choice.equals("y") || choice.equals("n"))) {
                choice = in.nextLine();
                choice = choice.toLowerCase();
                
                switch (choice) {
                    case "y":
                        Application.launch(PollutionPlot.class, fileName);
                        break;
                    case "n":
                        System.out.println("Ending program.");
                        break;
                    default:
                        System.out.print("Invalid command! Please select (y/n): ");
                        break;
                }
            }
        }
        
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        
        catch(Exception e){
            System.out.println("There was an error reading data from the file.");
            System.out.println("Please choose a different file.");
        }
        
    }
}
