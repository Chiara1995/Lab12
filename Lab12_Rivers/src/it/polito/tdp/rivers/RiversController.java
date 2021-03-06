/**
 * Sample Skeleton for 'Rivers.fxml' Controller Class
 */

package it.polito.tdp.rivers;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.rivers.model.Model;
import it.polito.tdp.rivers.model.River;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class RiversController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxRiver"
    private ComboBox<River> boxRiver; // Value injected by FXMLLoader

    @FXML // fx:id="txtStartDate"
    private TextField txtStartDate; // Value injected by FXMLLoader

    @FXML // fx:id="txtEndDate"
    private TextField txtEndDate; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumMeasurements"
    private TextField txtNumMeasurements; // Value injected by FXMLLoader

    @FXML // fx:id="txtFMed"
    private TextField txtFMed; // Value injected by FXMLLoader

    @FXML // fx:id="txtK"
    private TextField txtK; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    public void setModel(Model model){
    	this.model=model;
    	this.boxRiver.getItems().addAll(model.getRivers());
//    	if(this.boxRiver.getItems().size()!=0){
//    		this.boxRiver.setValue(model.getRivers().get(0));
//    	}
    }
    
    @FXML
    void doDati(ActionEvent event) {
    	this.txtEndDate.clear();
    	this.txtFMed.clear();
    	this.txtNumMeasurements.clear();
    	this.txtResult.clear();
    	this.txtStartDate.clear();
    	if(this.boxRiver.getValue()==null){
    		this.txtResult.setText("Selezionare un fiume nella comboBox.");
    		return;
    	}
    	else{
    		River r=this.boxRiver.getValue();
    		this.txtStartDate.setText(model.getDateFirstMeasure(r.getId()).toString());
    		this.txtEndDate.setText(model.getDateLastMeasure(r.getId()).toString());
    		this.txtNumMeasurements.setText(String.valueOf(model.getNumberMesures(r.getId())));
    		this.txtFMed.setText(String.valueOf(model.getAverageFlow(r.getId())));
    		
    	}
    }
    
    @FXML
    void doSimula(ActionEvent event) {
    	if(this.boxRiver.getValue()==null){
    		this.txtResult.setText("Selezionare un fiume nella comboBox.");
    		return;
    	}
    	River r=this.boxRiver.getValue();
    	if(this.txtFMed.getText().isEmpty()){
    		this.txtResult.setText("Errore: nessun flusso medio impostato.");
    		return;
    	}
    	float fmed=Float.parseFloat(this.txtFMed.getText());
    	if(this.txtK.getText().isEmpty()){
    		this.txtResult.setText("Errore: nessun fattore k impostato.");
    		return;
    	}
    	float k=Float.parseFloat(this.txtK.getText());
    	if(k<=0){
    		this.txtResult.setText("Errore: inserire un fattore k maggiore di zero.");
    		return;
    	}
    	this.txtResult.setText(model.simulazione(r,fmed,k));    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxRiver != null : "fx:id=\"boxRiver\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtStartDate != null : "fx:id=\"txtStartDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtEndDate != null : "fx:id=\"txtEndDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtNumMeasurements != null : "fx:id=\"txtNumMeasurements\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Rivers.fxml'.";

    }
}

