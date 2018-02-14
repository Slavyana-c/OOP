import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * A sequence of air pollution measurements.
 *
 * <p>Created for COMP1721 Coursework 1.</p>
 *
 * @author YOUR NAME HERE
 */
public class PollutionDataset {
  private List<Measurement> data;
// TODO: add field

  public PollutionDataset() {
    data = new ArrayList<>();
    
    String f = "D:\\Java\\comp1721\\cwk1\\data\\kirkstall.csv";
    try{
        readCSV(f);
    }
    catch (FileNotFoundException e){
    }
  }

  public void readCSV(String filename) throws FileNotFoundException {
      try {
          Scanner input = new Scanner(new File(filename));
          input.nextLine();
          while(input.hasNextLine()){
              String data = input.nextLine();
              String[] values = data.split(",");
              try {
                  System.out.println(values[0] +"  " + values[1] + " " + values[2]);
              }
              catch(Exception e){
                  System.out.print("moo\n");
              }
          }
          input.close();
      }
      catch(FileNotFoundException e) {
          System.out.println("moo");
      }
          
    
  }

  public void add(Measurement m) {
    // TODO: add a new measurement to the dataset
  }

  public int size() {
    return 0;  // TODO: return number of measurements in dataset
  }

  public Measurement get(int index) {
    return null;  // TODO: return measurement at given index
  }

  public Measurement maxLevel() {
    return null;  // TODO: return measurement with max NO2 level
  }
}
