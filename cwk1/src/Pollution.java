import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

class Pollution {
    public static void main(String[] args) throws FileNotFoundException {

        PollutionDataset p = new PollutionDataset();
        //String f = "D:\\Java\\comp1721\\cwk1\\data\\corn-exchange.csv";
        // /home/cserv1_a/soc_ug/sc17sdc/comp1721/cwk1/data/kirkstall.csv
        Scanner in = new Scanner(System.in);
        System.out.print("Input file path: ");
        String fileName = in.nextLine();
        try{
            p.readCSV(fileName);
                    
            System.out.println(p.size() + " records processed");
            System.out.println("Max: " + p.maxLevel()); 
            System.out.println("Min: " + p.minLevel());
            System.out.println("Mean: " + p.meanLevel());
            if(p.dayRulesBreached() == null){
                 System.out.println("No rules were breached.");
            }
            else System.out.println(p.dayRulesBreached());
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        catch(DataException e){
            System.out.println("There was an error with the file.");
        }  
    }
}
