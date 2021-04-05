package sample;


import java.time.LocalDate;
import java.time.LocalTime;



import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class MenuController  {
	
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private TextField textField;
    

    @FXML
    private Label labelDate;
    @FXML
    private Label entryName;
    
    @FXML
    private TextField entryBTNName;
	 
    
	  @FXML
		public void initialize(){
		
		 
		  
			 
		 }
	  
	   @FXML
	    void entryNameChanged(MouseEvent event) {
		   
		  entryName.setText(entryBTNName.getText()); 
		   
	    }
	   
	   
	   public String getLabel() {
		  // return entryName.getText();
		   
		   return "not working";
		   
	   }
}
