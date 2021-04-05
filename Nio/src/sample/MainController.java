package sample;



import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import javax.swing.event.ChangeListener;



import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.AmbientLight;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;


public class MainController extends MenuController {

    @FXML
    private PieChart pieChart;
    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private AreaChart<String, Number> areaChart;
    @FXML
    private ImageView myImage;

    @FXML
    private ImageView myMainImage;

    @FXML
    private BarChart<String , Number> barChart;

    @FXML
    private Button charts;
    @FXML
    private AnchorPane MarchAnchorpane;
    @FXML
    private AnchorPane AprilAnchorpane;
    @FXML
    private AnchorPane anchorPaneChart;
    @FXML
    private AnchorPane anchorPaneHours;
    
    @FXML
    private BorderPane calendar;
  
    
    @FXML
    private TextField test;
    @FXML
    private GridPane gridPaneMonth;
    @FXML
    private ColumnConstraints Monday;
    
    @FXML
    private ImageView arrowRight;

    @FXML
    private AnchorPane anchorpaneMD1;
    @FXML
    private AnchorPane anchorpaneMD2;
    @FXML
    private AnchorPane anchorpaneMD3;
    
    @FXML
    private ImageView arrowLeft;
    
    @FXML
    private Label monthName;

    Object a; 
    public Label label = new Label("New Entry");
    
    boolean checkStage = false;
    
    private Stage stage;
    Label listNumbers;
    int i;
    int multiple = 1;
    double number = 10;
    boolean z;
    int labelNumber;
    int t = 0;
    Label[] primeList = new Label[100];
 
    private List<AnchorPane> panes;
    private List<Label> labels;
    private List<AnchorPane> calendarPanesMarch;
    private List<Label> EntryLabels;
    @FXML
    public void initialize(){

        setpieChart();
        setLineChart();
        setAreaChart();
        setBarChart();
        panes = new ArrayList<AnchorPane>();
    	panes.add(0,MarchAnchorpane);
    	panes.add(1,AprilAnchorpane);
    	
    	labels = new ArrayList<Label>();
    	labels.add(0, monthName);
    	
    	calendarPanesMarch = new ArrayList<AnchorPane>();
    	calendarPanesMarch.add(anchorpaneMD1);
    	calendarPanesMarch.add(anchorpaneMD2);
    	calendarPanesMarch.add(anchorpaneMD3);
    	
    	
        /* translate
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(myImage);
        transition.setDuration(Duration.millis(1000));
        transition.setCycleCount(2);
        transition.setByX(250);
        transition.setAutoReverse(true);
        transition.play();
        //rotate */

        RotateTransition rotate = new RotateTransition();
        rotate.setNode(arrowRight);
        rotate.setDuration(Duration.millis(1000));
        rotate.setCycleCount(4);
        rotate.setByAngle(360);
        rotate.play();
        

        FadeTransition fade = new FadeTransition();
        fade.setNode(myMainImage);
        fade.setDuration(Duration.millis(1000));
        fade.setCycleCount(3);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();


        //scale
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(myImage);
        scale.setDuration(Duration.millis(1000));
        scale.setCycleCount(4);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setByX(2.0);
        scale.setByY(2.0);
        scale.setAutoReverse(true);
        scale.play();
        scale.isAutoReverse();


    }
    
    @SuppressWarnings("static-access")
	@FXML
    void addNewEntry(MouseEvent event) {
    	
    	
    	
    	if(event.MOUSE_CLICKED != null) {
    	//for(int i = 0; i < 1; i++) {
    		
    		//((AnchorPane) event.getTarget()).getOnMouseExited() {
    			
    			
    		
    		
 
    	/*
    		 new Timer().schedule(
    		            new TimerTask() {
    						
    						 @Override
    						public void run() {
    							// TODO Auto-generated method stub
    							 ((AnchorPane) event.getTarget()).addEventHandler(MouseEvent.MOUSE_MOVED,
    					    		        new EventHandler<MouseEvent>() {
    					    		          @Override
    					    		          public void handle(MouseEvent e) {
    					    		              i = ((AnchorPane) event.getTarget()).getChildren().indexOf(primeList[labelNumber]);
    					    		          }
    					    		        }); 
    							
    						}
    					}, 0, 1000);*/ 
    		  
            ((AnchorPane) event.getTarget()).addEventHandler(MouseEvent.MOUSE_MOVED,
    		        new EventHandler<MouseEvent>() {
    		          @Override
    		          public void handle(MouseEvent e) {
    		              a = event.getTarget();

    		          }}); 
			//  System.out.println(event.getSource().equals(a));
			
	//	if (((AnchorPane) event.getTarget()).getChildren().indexOf(primeList[labelNumber])) {
         if(event.getTarget().equals(a) == false) {
        	 
        	 i = 0;
        	 number = 0;
        	 
        
         } else if (((AnchorPane) event.getTarget()).getChildren().lastIndexOf(primeList[labelNumber]) == -1) {
        	 i = ((AnchorPane) event.getTarget()).getChildren().size() -1;
        	 System.out.println(i);
        	 number = primeList[i - 1].getLayoutY() - 10;
        	 
        	 System.out.println(number);
        	 
         }
         
         
         //ObservableList<Node> c = ((AnchorPane) event.getTarget()).getChildren();

           // System.out.println(((AnchorPane) event.getTarget()).getChildren().lastIndexOf(primeList[labelNumber]));
    		primeList[i] = new Label();
        	primeList[i].setText("Entry " + i);
        	((AnchorPane) event.getTarget()).getChildren().addAll(primeList[i]);
        	((AnchorPane) event.getTarget()).setTopAnchor(primeList[i], 20d + number);
        	((AnchorPane) event.getTarget()).setLeftAnchor(primeList[i], 50d);
        	
            
        	number += 10;	
            labelNumber = i;
            i++;
            
            if(i > 0) {
          /*  MenuController menuController = new MenuController();
            
            String labelNameString = menuController.getLabel();
            i = ((AnchorPane) event.getTarget()).getChildren().size() -2;
            System.out.println(i);
            primeList[i].setText(labelNameString);
            */
            }
           
    	
           /* new Timer().schedule(
            new TimerTask() {
				
				 @Override
				public void run() {
					// TODO Auto-generated method stub
					((AnchorPane) event.getTarget()).hoverProperty().addListener((observable) -> {
            		
            		   z = ((AnchorPane) event.getTarget()).getChildren().contains(primeList[labelNumber]);
            	
            	});
					
					
				}
			}, 0, 1000); */
			
			
			
            	
           
            	
          //  System.out.println(calendarPanesMarch.get(i).getChildren().contains(primeList[i]));
            
            if(((AnchorPane) event.getTarget()).getChildren().contains(primeList[i]) == false) {
        		if(checkStage == false) {
        		window();

        		 }    		
        		checkStageIsShowing();

        	}
       // }
           // for(int n = 0; n < primeList.length; n++) {
            //if(anchorpaneMD1.getChildren().contains(primeList[i])) {
               
           // }}
            
         /*   if(anchorpaneMD1.getChildren().contains(primeList[1])) {
            	
            	AnchorPane.setBottomAnchor(primeList[1], 10d);
            	AnchorPane.setLeftAnchor(primeList[1], 40d);
            	
            } */
    		
    	
    	}
        
    	/*anchorpaneMD1.getChildren().addAll(hBox);
    	AnchorPane.setBottomAnchor(hBox, 20d);
    	AnchorPane.setLeftAnchor(hBox, 40d); */

    	if(((AnchorPane) event.getTarget()).getChildren().contains(primeList[i])) {

    		if(checkStage == false) {
    		window();
    		 }
    		
    		checkStageIsShowing();

    		 
    	}
    	
    }
    
    
   
    @FXML
    void addNote(MouseEvent event) {

    	label.setAlignment(Pos.CENTER);;
    	label.minWidth(100);
    	label.maxWidth(100);
 
    	label.setStyle("-fx-border-color:blue; -fx-alignment: bottom-right; -fx-background-color: #20D747; -fx-font-weight: white;");
    	HBox hBox = new HBox(10, label);
    	
    	if(event.MOUSE_CLICKED != null) {
    	//for(int i = 0; i < 1; i++) {
    		primeList[i] = new Label();
        	primeList[i].setText("Entry " + i);
        	anchorpaneMD1.getChildren().addAll(primeList[i]);
            AnchorPane.setTopAnchor(primeList[i], 20d + number);
            AnchorPane.setLeftAnchor(primeList[i], 40d);
            number += 10;	
            i++;
            
          
            
            System.out.println(anchorpaneMD1.getChildren().contains(primeList[i]));
            
            if(anchorpaneMD1.getChildren().contains(primeList[i]) == false) {
        		if(checkStage == false) {
        		window();

        		 }    		
        		checkStageIsShowing();

        	}
       // }
           // for(int n = 0; n < primeList.length; n++) {
            //if(anchorpaneMD1.getChildren().contains(primeList[i])) {
               
           // }}
            
         /*   if(anchorpaneMD1.getChildren().contains(primeList[1])) {
            	
            	AnchorPane.setBottomAnchor(primeList[1], 10d);
            	AnchorPane.setLeftAnchor(primeList[1], 40d);
            	
            } */
    		
    	
    	}
        
    	/*anchorpaneMD1.getChildren().addAll(hBox);
    	AnchorPane.setBottomAnchor(hBox, 20d);
    	AnchorPane.setLeftAnchor(hBox, 40d); */

    	if(anchorpaneMD1.getChildren().contains(hBox)) {

    		if(checkStage == false) {
    		window();
    		 }
    		
    		checkStageIsShowing();

    		 
    	}
    	
      
    } 
    
    private void checkStageIsShowing() {
    
    if(stage.isShowing() == false) {
   	 
        checkStage = false;
        window();

    } 
    
	}
    
    
    @FXML
    void addEntry2(MouseEvent event) {
    	
    	label.setAlignment(Pos.CENTER);
    	label.minWidth(100);
    	label.maxWidth(100);
 
    	label.setStyle("-fx-border-color:blue; -fx-alignment: bottom-right; -fx-background-color: #20D747;");
    	HBox hBox2 = new HBox(10, label);
    	
    	anchorpaneMD2.getChildren().addAll(hBox2);
    	AnchorPane.setBottomAnchor(hBox2, 20d);
    	AnchorPane.setLeftAnchor(hBox2, 40d);

    	if(anchorpaneMD2.getChildren().contains(hBox2)) {
    		if(checkStage == false) {
    		window();

    		 }    		
    		checkStageIsShowing();

    	}
    	
    	

    }
    @FXML
    void previousMonth(MouseEvent event) {

    	panes.get(0).setVisible(true);
    	panes.get(1).setVisible(false);
    	
    }
    @FXML
    void NextMonth(MouseEvent event) {
    	
    	panes.get(0).setVisible(false);
    	panes.get(1).setVisible(true);
    	System.out.println(labels);
    	labels.get(0).setText("April");
    }
    @FXML
    void addEntry3(MouseEvent event) {
    	label.setAlignment(Pos.CENTER);
    	label.minWidth(100);
    	label.maxWidth(100);
 
    	label.setStyle("-fx-border-color:blue; -fx-alignment: bottom-right; -fx-background-color: #20D747; -fx-font-weight: white;");
    	HBox hBox2 = new HBox(10, label);
    	
    	anchorpaneMD3.getChildren().addAll(hBox2);
    	AnchorPane.setBottomAnchor(hBox2, 20d);
    	AnchorPane.setLeftAnchor(hBox2, 40d);

    	if(anchorpaneMD3.getChildren().contains(hBox2)) {
    		if(checkStage == false) {
    		window();

    		 }    		
    		checkStageIsShowing();

    	}
    	
    	
    }
	@FXML
    void showHoursPane(ActionEvent event) {
       // anchorPaneHours.setVisible(true);
       // anchorPaneHours.toFront();
       anchorPaneChart.setVisible(false);
       anchorPaneHours.setVisible(true);
       
    }

    @FXML
    void showChartPane(ActionEvent event) {
        anchorPaneChart.setVisible(true);
        anchorPaneChart.toFront();
        anchorPaneHours.setVisible(false);
    }
    
    private void window() {
    	 try {
             FXMLLoader fxmlLoader = new FXMLLoader();
             fxmlLoader.setLocation(getClass().getResource("MenuCalendar.fxml"));
             /*
              * if "fx:controller" is not set in fxml
              * fxmlLoader.setController(NewWindowController);
              */
             Parent root = FXMLLoader.load(getClass().getResource("MenuCalendar.fxml"));
             
             
             Scene mainscene = new Scene(root, 427, 274);
             stage = new Stage();
             stage.setX(label.getLayoutX() + 375);
             stage.setY(label.getLayoutY() + 215);
             stage.setTitle("New Window");
             stage.setScene(mainscene);
             stage.initModality(Modality.APPLICATION_MODAL);
             stage.show();
             checkStage = true;
             stage.toFront();
             
            
             
             

         } catch (IOException e) {
             Logger logger = Logger.getLogger(getClass().getName());
             logger.log(Level.SEVERE, "Failed to create new Window.", e);
         }
    }

    private void setpieChart(){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
        pieChart.setData(pieChartData);


    }
    private void setLineChart(){
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Series 1");
        series1.getData().add(new XYChart.Data<>("k", 20));
        series1.getData().add(new XYChart.Data<>("d", 100));
        series1.getData().add(new XYChart.Data<>("s", 80));
        series1.getData().add(new XYChart.Data<>("a", 180));
        series1.getData().add(new XYChart.Data<>("q", 20));
        series1.getData().add(new XYChart.Data<>("e", -10));
        lineChart.getData().add(series1);
        lineChart.setOpacity(1);


    }

    private void setAreaChart(){
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Series 1");
        series.getData().add(new XYChart.Data<>("k", 20));
        series.getData().add(new XYChart.Data<>("d", 100));
        series.getData().add(new XYChart.Data<>("s", 80));
        series.getData().add(new XYChart.Data<>("a", 180));
        series.getData().add(new XYChart.Data<>("q", 20));
        series.getData().add(new XYChart.Data<>("e", -10));

        areaChart.getData().add(series);
        areaChart.setOpacity(1);

    }

    private void setBarChart(){

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Series 1");
        series.getData().add(new XYChart.Data<>("k", 20));
        series.getData().add(new XYChart.Data<>("d", 100));
        series.getData().add(new XYChart.Data<>("s", 80));
        series.getData().add(new XYChart.Data<>("a", 180));
        series.getData().add(new XYChart.Data<>("q", 20));
        series.getData().add(new XYChart.Data<>("e", -10));

        barChart.getData().add(series);
        barChart.setOpacity(1);

    }

}
