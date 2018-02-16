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
  }

  public void readCSV(String filename) throws FileNotFoundException {
    data.clear();
        Scanner input = new Scanner(new File(filename));
        input.nextLine(); // skip first line
        while(input.hasNextLine()){
            String record = input.nextLine();
            Measurement m = new Measurement(record);
            add(m);
        }
          input.close();
  }

  public void add(Measurement m) {
      data.add(m);
    // TODO: add a new measurement to the dataset
  }

  public int size() {
    return data.size();  // TODO: return number of measurements in dataset
  }

  public Measurement get(int index) {
      if(data.size() == 0 || data.size() < index + 1) {
      throw new DataException("help");
    }
      return data.get(index);  // TODO: return measurement at given index
  }

  public Measurement maxLevel()  throws DataException{
    if(data.size() == 0) {
      throw new DataException("help");
    }
    int max = 0;
    Measurement maxM = get(0);
      for (int i = 0; i < data.size(); i++) {
          Measurement m = get(i);
          if(m.getLevel() > max){
            max = m.getLevel();
            maxM = m;
          }
      }
    return maxM;  // TODO: return measurement with max NO2 level
  }

  public Measurement minLevel()  throws DataException{
    if(data.size() == 0) {
      throw new DataException("help");
    }
    int min = Integer.MAX_VALUE;
    Measurement minM = get(0);
      for (int i = 0; i < data.size(); i++) {
          Measurement m = get(i);
          if(m.getLevel() < min && m.getLevel() != -1){
            min = m.getLevel();
            minM = m;
          }
      }
    return minM;
  }

  public double meanLevel()  throws DataException{
    if(data.size() == 0) {
      throw new DataException("help");
    }
    double mean = 0;
    int days = 0;
    for (int i = 0; i < data.size(); i++) {
          Measurement m = get(i);
          if(m.getLevel() != -1){
            mean += m.getLevel();
            days++;
          }
      }

    return mean / days;
  }

  public LocalDate dayRulesBreached(){
    return null;
  }

}
