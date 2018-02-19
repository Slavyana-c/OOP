import java.io.FileNotFoundException;
import java.time.Month;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
public class PollutionPlot extends Application {
    
    @Override public void start(Stage stage) {
        stage.setTitle("Bar Chart");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Air Pollution Levels");
        xAxis.setLabel("Month");       
        yAxis.setLabel("NO2");
 
        
        XYChart.Series series1 = new XYChart.Series();
        String f = "D:\\Java\\comp1721\\cwk1\\data\\kirkstall.csv";
        PollutionDataset p = new PollutionDataset();      
        try{
            p.readCSV(f);
         }
         catch (FileNotFoundException e){
            System.out.println("File not found.");
         }
        
        Measurement y = p.get(0);
        int yy = y.getTime().getYear();
        series1.setName(Integer.toString(yy));     
        Month mth1 = y.getTime().getMonth();
        int num = 0;
        double total = 0;
        for (int i = 0; i < p.size(); i++) {
             Month mth2 = p.get(i).getTime().getMonth();
             if(mth1 != mth2 || i == p.size() - 1){
                 series1.getData().add(new XYChart.Data(mth1.name(), (total/num)));
                 mth1 = mth2;
                 total = 0;
                 num = 0;
             }
             total += p.get(i).getLevel();
             num++;
                    
        }
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}

