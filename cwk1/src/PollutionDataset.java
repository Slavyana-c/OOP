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

  // PollutionDataset constructor
  public PollutionDataset() {
    dataset = new ArrayList<>();
  }

  // Reads the CSV file, if it exists
  public void readCSV(String filename) throws FileNotFoundException {
    dataset.clear();
    Scanner input = new Scanner(new File(filename));
    input.nextLine(); // Skips first line

    while(input.hasNextLine()){
      String record = input.nextLine();
      Measurement m = new Measurement(record);
      add(m);
    }
    input.close();
  }

  // Adds a Measurement to the dataset.
  public void add(Measurement m) {
    dataset.add(m);
  }

  // Returns the size of the dataset.
  public int size() {
    return dataset.size();
  }

  // Returns the Measurement at a given index, if it exists
  public Measurement get(int index) {
    if(dataset.isEmpty() || dataset.size() < index + 1){
      throw new DataException("No such index!");
    }

    else return dataset.get(index);
  }

  // Returns the Measurement with the largest level of NO2
  public Measurement maxLevel() {
    if(dataset.isEmpty()) {
      throw new DataException("The dataset is empty!");
    }

    int maxLevel = 0;
    Measurement maxM = get(0);

      for (int i = 0; i < dataset.size(); i++) {
          Measurement m = get(i);

          if(m.getLevel() > maxLevel){
            maxLevel = m.getLevel();
            maxM = m;
          }
      }
    return maxM;
  }

  // Returns the Measurement with the lowest level of NO2
  public Measurement minLevel()  throws DataException{
    if(dataset.isEmpty()) {
      throw new DataException("The dataset is empty!");
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

  // Returns the arithmetic mean of all levels of NO2 in the dataset
  public double meanLevel()  throws DataException{
    if(dataset.isEmpty()) {
      throw new DataException("Error!");
    }

    double totalLevel = 0;
    int count = 0;
    double avg;
    for (int i = 0; i < dataset.size(); i++) {
          Measurement m = get(i);

          if(m.getLevel() != -1){
            totalLevel += m.getLevel();
            count++;
          }
      }
    // Prevents division by 0
    if(count == 0) avg = 0;
    else avg = totalLevel / count;
    
    return avg;
  }

  // Returns the date when the EU rules were breached
  public LocalDate dayRulesBreached(){

    Measurement m = get(0);
    int startHour = m.getTime().getHour();
    int hourlyLvl = 0;
    int timesBreached = 0;

    // Calculates the hourly levels of NO2 and checks if rules were breached
    for (int i = 0; i < dataset.size(); i++) {

          m = get(i);
          int currentHour = m.getTime().getHour();

          if(currentHour != startHour) {
            startHour = currentHour;
            hourlyLvl = 0;
          }
          
          if(m.getLevel() != -1){
            hourlyLvl += m.getLevel();
          }

          if(hourlyLvl > 200){
            timesBreached++;
          }

          if (timesBreached > 18){
            LocalDate currentDate = m.getTime().toLocalDate();
            return currentDate;
          }
    }
      return null;
   }
}
