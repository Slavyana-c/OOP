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

  // TODO: define fields

  public Measurement(String record) {
    // TODO: implement constructor
  }

  public LocalDateTime getTime() {
    return null;  // TODO: return field
  }

  public int getLevel() {
    return 0;  // TODO: return field
  }

  public String toString() {
    return null;  // TODO: return string representation of measurement
  }
}
