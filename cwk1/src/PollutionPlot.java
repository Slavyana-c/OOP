import java.io.FileNotFoundException;
import java.time.Month;
import java.util.List;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PollutionPlot extends Application {

    // Creates a bar chart from a CSV
    @Override public void start(Stage stage)  throws FileNotFoundException {
        stage.setTitle("Bar Chart");

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> chart =
            new BarChart<String,Number>(xAxis,yAxis);
        final Parameters params = getParameters();
        final List<String> mainArgs = params.getRaw();

        chart.setTitle("Air Pollution Levels");
        xAxis.setLabel("Month");
        yAxis.setLabel("NO\u2082 (\u00b5g/m\u00b3)");


        XYChart.Series<String,Number> series = new XYChart.Series<String, Number>();
        // "D:\\Java\\comp1721\\cwk1\\data\\corn-exchange.csv";

        // Reads CSV, if file is found
        Scanner in;
        if(mainArgs.size() > 0) {
          in = new Scanner(mainArgs.get(0));
        }
        else {
          System.out.print("Input file path: ");
          in = new Scanner(System.in);
        }
          String fileName = in.nextLine();

        // Sets the name of the series
        PollutionDataset set = new PollutionDataset();
        set.readCSV(fileName);
        Measurement m = set.get(0);
        int year = m.getTime().getYear();
        series.setName(fileName + ", " + Integer.toString(year));


        // Adds the levels of the measurementsz
        Month startMonth = m.getTime().getMonth();
        int numOfElements = 0;
        double totalLevel = 0;

        for (int i = 0; i < set.size(); i++) {
             double avg;
             m = set.get(i);
             Month currentMonth = m.getTime().getMonth();

             // Adds the data to the chart at the end of every month
             if(startMonth != currentMonth || i == set.size() - 1){
                if(numOfElements == 0) avg = 0;
                else avg = totalLevel/numOfElements;
                 series.getData().add(new XYChart.Data<String,Number>
                            (startMonth.name(), avg));
                 startMonth = currentMonth;
                 totalLevel = 0;
                 numOfElements = 0;
             }
             if(m.getLevel() > -1) {
               totalLevel += m.getLevel();
               numOfElements++;
             }
        }

        // Shows the chart
        Scene scene  = new Scene(chart,800,600);
        chart.getData().add(series);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
      try {
        launch(args);
      }
      catch(Exception e){
          System.out.println("There was an error reading data from the file.");
      }
    }
}
