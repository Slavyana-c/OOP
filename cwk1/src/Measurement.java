import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A single measurement of NO<sub>2</sub> level.
 *
 * <p>Created for COMP1721 Coursework 1.</p>
 *
 * @author YOUR NAME HERE
 */
public class Measurement {
  // Use this when parsing measurement time
  private static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
  private LocalDateTime time;
  private int level;

  // TODO: define fields

  public Measurement(String record) throws DataException {
    String[] values = record.split(",");
    String dateAndTime = values[0] + " " + values[1];
    time = LocalDateTime.parse(dateAndTime, FORMAT);
    try{
        level = Integer.parseInt(values[2]);
    }
    catch(Exception e){
        level = -1;
    }
  }

  public LocalDateTime getTime() {
    return time; 
  }

  public int getLevel() {
    return level; 
  }

  @Override
  public String toString() {
      
    if(getLevel() != -1){
         return String.format("%s, %d%sg/m%s", getTime(), getLevel(), "\u00b5", "\u00b3");
    }  
    else {
        return String.format("%s, no data", getTime());
    }
   
    // TODO: return string representation of measurement
  }
}
