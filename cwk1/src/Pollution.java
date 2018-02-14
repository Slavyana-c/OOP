import java.io.FileNotFoundException;
import java.time.LocalDateTime;

class Pollution {
    public static void main(String[] args) throws FileNotFoundException {
        
        PollutionDataset m = new PollutionDataset();
        m.readCSV("D:\\Java\\comp1721\\cwk1\\data\\kirkstall.csv");
    }
}
