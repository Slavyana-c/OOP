import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * A sequence of air pollution measurements.
 *
 * <p>Created for COMP1721 Coursework 1.</p>
 *
 * @author Slavyana Dianova Chervenkondeva
 */
public class PollutionDataset {
   private ArrayList<Measurement> dataset;

  public PollutionDataset() {
    dataset = new ArrayList<>();
  }

  public void readCSV(String filename) throws FileNotFoundException {
    dataset.clear();
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
    dataset.add(m);
  }

  public int size() {
    return dataset.size();
  }

  public Measurement get(int index) {
    if(dataset.size() == 0 || dataset.size() < index + 1){
      throw new DataException("Error!");
    }

    else return dataset.get(index);
  }

  public Measurement maxLevel() {
    if(dataset.size() == 0) {
      throw new DataException("Error!");
    }
    int max = 0;
    Measurement maxM = get(0);
      for (int i = 0; i < dataset.size(); i++) {
          Measurement m = get(i);
          if(m.getLevel() > max){
            max = m.getLevel();
            maxM = m;
          }
      }
    return maxM;
  }
  
   public Measurement minLevel()  throws DataException{
    if(dataset.size() == 0) {
      throw new DataException("Error!");
    }
    int min = Integer.MAX_VALUE;
    Measurement minM = get(0);
      for (int i = 0; i < dataset.size(); i++) {
          Measurement m = get(i);
          if(m.getLevel() < min && m.getLevel() != -1){
            min = m.getLevel();
            minM = m;
          }
      }
    return minM;
  }
   
    public double meanLevel()  throws DataException{
    if(dataset.size() == 0) {
      throw new DataException("Error!");
    }
    double mean = 0;
    int days = 0;
    for (int i = 0; i < dataset.size(); i++) {
          Measurement m = get(i);
          if(m.getLevel() != -1){
            mean += m.getLevel();
            days++;
          }
      }

    return mean / days;
  }

  public LocalDate dayRulesBreached(){

    Measurement m = get(0);
    LocalDate startDate = dataset.get(0).getTime().toLocalDate();
    int startHour = m.getTime().getHour();
    int hourlyLvl = 0;
    int timesBreached = 0;

    for (int i = 0; i < dataset.size(); i++) {

          m = get(i);
          LocalDate currentDate = m.getTime().toLocalDate();
          int currentHour = m.getTime().getHour();
          if(currentHour != startHour) {
            startHour = currentHour;
            hourlyLvl = 0;
          }
          if(currentDate != startDate) {
            startDate = currentDate;
          }
          if(m.getLevel() != -1){
            hourlyLvl += m.getLevel();
          }
          if(hourlyLvl > 200){
            timesBreached++;
          }
          if (timesBreached > 18){
            return currentDate;
          }
  }
      return null;
  }
}
