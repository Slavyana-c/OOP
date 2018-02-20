import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

class Pollution {

    public static void main(String[] args) throws FileNotFoundException {

        PollutionDataset set = new PollutionDataset();
        //String f = "D:\\Java\\comp1721\\cwk1\\data\\corn-exchange.csv";
        // /home/cserv1_a/soc_ug/sc17sdc/comp1721/cwk1/data/kirkstall.csv

        Scanner in;
        if(args.length > 0) {
          in = new Scanner(args[0]);
        }
        else {
          System.out.print("Input file path: ");
          in = new Scanner(System.in);
        }
          String fileName = in.nextLine();

        try{
            set.readCSV(fileName);

            System.out.println(set.size() + " records processed");
            System.out.println("Max: " + set.maxLevel());
            System.out.println("Min: " + set.minLevel());
            System.out.printf("Mean: %.3f%n", set.meanLevel());
            if(set.dayRulesBreached() == null){
                 System.out.println("No rules were breached.");
            }
            else System.out.printf("The EU rules were breached on %s.%n",
                    set.dayRulesBreached());
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        catch(Exception e){
            System.out.println("There was an error reading data from the file.");
        }
    }
}
