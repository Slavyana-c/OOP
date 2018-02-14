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

  public Measurement(String record) {
    String[] values = record.split(",");
    String dateAndTime = values[0] + " " + values[1];
    time = LocalDateTime.parse(values[0], FORMAT);
  }

  public LocalDateTime getTime() {
    return time; 
  }

  public int getLevel() {
    return level; 
  }

  @Override
  public String toString() {
    return null;  // TODO: return string representation of measurement
  }
}
