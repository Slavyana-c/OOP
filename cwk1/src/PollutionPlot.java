import java.io.FileNotFoundException;
import java.time.Month;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.util.Scanner;

public class PollutionPlot extends Application {

    //
    @Override public void start(Stage stage) throws FileNotFoundException{
        stage.setTitle("Bar Chart");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> chart =
            new BarChart<String,Number>(xAxis,yAxis);
        chart.setTitle("Air Pollution Levels");
        xAxis.setLabel("Month");
        yAxis.setLabel("NO\u2082 (\u00b5g/m\u00b3)");


        XYChart.Series<String,Number> series1 = new XYChart.Series<String, Number>();

        Scanner in;
        if(args.length > 0) {
          in = new Scanner(args[0]);
        }
        else {
          System.out.print("Input file path: ");
          in = new Scanner(System.in);
        }
          String fileName = in.nextLine();

        PollutionDataset p = new PollutionDataset();

        // Read data from CSV

           p.readCSV(fileName);

        Measurement y = p.get(0);
        int yy = y.getTime().getYear();
        series1.setName(Integer.toString(yy));
        Month mth1 = y.getTime().getMonth();
        int num = 0;
        double total = 0;
        for (int i = 0; i < p.size(); i++) {
             Month mth2 = p.get(i).getTime().getMonth();
             if(mth1 != mth2 || i == p.size() - 1){
                 series1.getData().add(new XYChart.Data<String,Number> (mth1.name(), (total/num)));
                 mth1 = mth2;
                 total = 0;
                 num = 0;
             }
             total += p.get(i).getLevel();
             num++;

        }
        Scene scene  = new Scene(chart,800,600);
        chart.getData().add(series1);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
      try {
        launch(args);
      }
      catch(Exception e){
          System.out.println("Please select a different file.");
      }

    }
}
