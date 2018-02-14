import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

class Pollution {
    public static void main(String[] args) throws FileNotFoundException {
        
        PollutionDataset p = new PollutionDataset();
        //String f = "D:\\Java\\comp1721\\cwk1\\data\\corn-exchange.csv";
        Scanner in = new Scanner(System.in);
        String f = in.nextLine();
        try{
            p.readCSV(f);
         }
         catch (FileNotFoundException e){

         }
       /* for(int i = 0; i < p.size(); i++){
            System.out.println(p.get(i));
*/
       
       System.out.println(p.size() + " records processed");
       System.out.println("Max: " + p.maxLevel());
        }
    }

