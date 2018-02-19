import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A single measurement of NO<sub>2</sub> level.
 *
 * <p>Created for COMP1721 Coursework 1.</p>
 *
 * @author Slavyana Dianova Chervenkondeva
 */

public class Measurement {
  // Use this when parsing measurement time
    private static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private LocalDateTime time;
    private int level;

    // Measurement constructor
    public Measurement(String record) throws DataException{
        String[] data = record.split(",");
        switch (data.length) {
            case 3:
                level = Integer.parseInt(data[2]);
                break;
            case 2:
                level = -1;
                break;
            default:
              throw new DataException("Invalid number of elements in record!");
    }

    String dateAndTime = data[0] + " " + data[1];
    time = LocalDateTime.parse(dateAndTime, FORMAT);
    }

    // Returns the time of the Measurement
    public LocalDateTime getTime() {
        return time;
    }

    // Returns the level of NO2
    public int getLevel() {
        return level;
    }

    //Converts the Measurement to String
    @Override
    public String toString() {
        if(level == -1) return String.format("%s, no data", time);
        else return String.format("%s, %d \u00b5g/m\u00b3", time, level);
    }
}
