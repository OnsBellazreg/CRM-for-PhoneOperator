package tn.esprit.CRM.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import tn.esprit.CRM.persistence.Conge;
import tn.esprit.CRM.persistence.User;
import tn.esprit.CRM.services.StaffServiceRemote;

import java.net.URL;
import java.util.Date;

import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.control.TableView;

import javafx.scene.control.DatePicker;

import javafx.scene.control.TableColumn;

public class MesCongeController implements Initializable {
	@FXML
	private TableView<Conge> table;
	@FXML
	private TableColumn<Conge,Date> date;
	@FXML
	private TableColumn<Conge,String> type;
	@FXML
	private TableColumn<Conge,Integer> days;
	@FXML
	private TableColumn<Conge,String> certif;
	@FXML
	private TableColumn<Conge,String> status;
	@FXML
	private TextField nbrj;
	@FXML
	private DatePicker datec;
	@FXML
	private ComboBox<String> typec;
	@FXML
	private ComboBox<String> certificat;
	@FXML
	private Button submit;
	@FXML
	private Button delete;
	@FXML
	private Button update;
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		 ObservableList<String> items = FXCollections.observableArrayList("Medical",
			        "Normal");
	       
		 typec.setItems(items);	
		 ObservableList<String> itemss = FXCollections.observableArrayList("Available",
			        "Unavailable");
		 certificat.setItems(itemss);
		 InitialContext ctx;
			try {
				ctx = new InitialContext();
				StaffServiceRemote proxy;

				proxy = (StaffServiceRemote) ctx.lookup("CRM-ear/CRM-ejb/StaffService!tn.esprit.CRM.services.StaffServiceRemote");
				ObservableList<Conge> data = FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(121212));
					List<Conge> li= proxy.FindDemandeCongeByCin(121212);
				for(Conge c:li){
					System.out.println(c);
				}

				table.setItems(data);
				date.setCellValueFactory(new PropertyValueFactory<Conge,Date>("date_co"));
				type.setCellValueFactory(new PropertyValueFactory<Conge,String>("type_co"));
				certif.setCellValueFactory(new PropertyValueFactory<Conge,String>("certificat"));
				days.setCellValueFactory(new PropertyValueFactory<Conge,Integer>("nbjrs_co"));
				status.setCellValueFactory(new PropertyValueFactory<Conge,String>("status_co"));
			
			
				
				
			} catch (NamingException e1) {
				// TODO Auto-generated catch blocks
				//e1.printStackTrace();
			}
	}
	// Event Listener on Button[#submit].onAction
	@SuppressWarnings("deprecation")
	@FXML
	public void submit(ActionEvent event) throws NamingException {
	 	InitialContext ctx;
		ctx = new InitialContext();
		StaffServiceRemote proxy;
		proxy = (StaffServiceRemote) ctx.lookup("CRM-ear/CRM-ejb/StaffService!tn.esprit.CRM.services.StaffServiceRemote");

		//Staff s=new Staff();
	//	s.setCIN(1);
		if (!nbrj.getText().equals("")  && !typec.getSelectionModel().getSelectedItem().equals("")&& !certificat.getSelectionModel().getSelectedItem().equals("")) {
		Conge c1 = new Conge( );
		//Conge c1 = new Conge(typec.getSelectionModel().getSelectedItem(),certificat.getSelectionModel().getSelectedItem(),Integer.parseInt(nbrj.getText()),"not examined yet",12121212);
			Date d;
			if (datec.getValue() == null) {
				d = new Date();
			} else {
				d = new Date(datec.getValue().getYear() - 1900, datec.getValue().getMonthValue() - 1,
						datec.getValue().getDayOfMonth());
			} 
			User user=new User(6, "mohamed","ali");
			c1.setCertificat(certificat.getSelectionModel().getSelectedItem());
			c1.setType_co(typec.getSelectionModel().getSelectedItem());
			c1.setNbjrs_co(Integer.parseInt(nbrj.getText()));
			c1.setStatus_co("not examined yet");
			c1.setCin(121212);
			c1.setUser(user);
			//c.setUser(cin.getText());
			c1.setDate_co(d);
			proxy.AddDemandeConge(c1);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("you added a new request");
			alert.setContentText("your Holiday request has been sent!");

			alert.showAndWait();
			 System.out.println("done");	
			 nbrj.clear();
				
				typec.setPromptText("type");
				certificat.setPromptText("certificate");
				datec.setPromptText("");
			
			ObservableList<Conge> data = FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(121212));
			 table.setItems(data);
			
		} else {
			//erreur.setText("champs vide!!");
			
			 System.out.println("not done");
		} 
	}
	// Event Listener on Button[#delete].onAction
	@FXML
	public void delete(ActionEvent event) throws NamingException {
		
		 Context context;
    	context = new InitialContext();

    	String jndiName ="CRM-ear/CRM-ejb/StaffService!tn.esprit.CRM.services.StaffServiceRemote";
    	StaffServiceRemote proxy2= (StaffServiceRemote) context
				.lookup(jndiName) ;
    	
    	Integer selected = table.getSelectionModel().getSelectedIndex();
    	Conge cc =(Conge) table.getSelectionModel().getSelectedItem();
    	//c.getStatus_co()
    	   if (table.getSelectionModel().isSelected(selected)) 
    		 
    	if (((table.getSelectionModel().isSelected(selected))) && (cc.getStatus_co().equals("not examined yet")) ) {   		
    		proxy2.DeleteDemandeConge(table.getItems().get(selected));
			table.getItems().remove(table.getItems().get(selected));
				
			
		} else {
			System.out.println("selectionner un élement non traité" + selected);
		}
    	
        List<Conge> Conges= proxy2.FindDemandeCongeByCin(121212);

        		date.setCellValueFactory(new PropertyValueFactory<Conge,Date>("date_co"));
				type.setCellValueFactory(new PropertyValueFactory<Conge,String>("type_co"));
				certif.setCellValueFactory(new PropertyValueFactory<Conge,String>("certificat"));
				days.setCellValueFactory(new PropertyValueFactory<Conge,Integer>("nbjrs_co"));
				status.setCellValueFactory(new PropertyValueFactory<Conge,String>("status_co"));       
        
        	ObservableList<Conge> data = FXCollections.observableArrayList(Conges);
        	table.setItems(data);
        	ObservableList<Conge> data1 = FXCollections.observableArrayList(Conges);
        	table.setItems(data1);
        	ObservableList<Conge> data3 = FXCollections.observableArrayList(Conges);
        	table.setItems(data3);
        	ObservableList<Conge> data4 = FXCollections.observableArrayList(Conges);
        	table.setItems(data4);

		
	}
	// Event Listener on Button[#update].onAction
	@SuppressWarnings("deprecation")
	@FXML
	public void update(ActionEvent event) throws NamingException {
		
		Integer selected = table.getSelectionModel().getSelectedIndex();
		InitialContext ctx;
		ctx = new InitialContext();
		StaffServiceRemote proxy;
		proxy = (StaffServiceRemote) ctx.lookup("CRM-ear/CRM-ejb/StaffService!tn.esprit.CRM.services.StaffServiceRemote");
      if (table.getSelectionModel().isSelected(selected)) {

			Conge cc = table.getItems().get(selected);
			cc.setNbjrs_co(Integer.parseInt(nbrj.getText()));
			
			cc.setType_co(typec.getSelectionModel().getSelectedItem());
			cc.setCertificat(certificat.getSelectionModel().getSelectedItem());
			Date d;
			if (datec.getValue() == null) {
				d = new Date(0);
			} else {
				d = new Date(datec.getValue().getYear() - 1900, datec.getValue().getMonthValue() - 1,
				datec.getValue().getDayOfMonth());
			}
			

			cc.setStatus_co(" not examined yet ");
			cc.setDate_co(d);
			proxy.UpdateDemandeConge(cc);
			//System.out.println("eee");
			nbrj.clear();
			
			typec.setPromptText("Type");
			certificat.setPromptText("certificate");
			datec.setPromptText("");

		}
      ObservableList<Conge> data = FXCollections.observableArrayList(proxy.FindDemandeCongeByCin(121212));
		 table.setItems(data);
	/*	 Notifications notification11 = Notifications.create().title("Done !")
					.text("Holiday request succesfully updated").graphic(null).hideAfter(Duration.seconds(5))
					.position(Pos.BOTTOM_RIGHT);

			notification11.darkStyle();
			notification11.showWarning(); */
    }
		/*
		 Context context;
    	context = new InitialContext();

    	String jndiName ="CRM-ear/CRM-ejb/StaffService!tn.esprit.CRM.services.StaffServiceRemote";
    	StaffServiceRemote proxy3= (StaffServiceRemote) context
				.lookup(jndiName) ;
    	Integer selected = table.getSelectionModel().getSelectedIndex();
    	if (table.getSelectionModel().isSelected(selected)) {
    		Conge ab = table.getSelectionModel().getSelectedItem();
    		 ab.setCertificat(certificat.getSelectionModel().getSelectedItem());
		    ab.setNbjrs_co(Integer.parseInt(nbrj.getText()));
		      
		        ab.setType_co(typec.getSelectionModel().getSelectedItem());
		        
		        DateFormat sysDate = new SimpleDateFormat("yyyy/MM/dd");
		        ab.setDate_co(Date.from(datec.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		       proxy3.UpdateDemandeConge(ab);

    		
    		
		      
    		
    	} else {
			System.out.println("selectionner un élement" + selected);
		}
    	
        List<Conge> Conges= proxy3.FindDemandeCongeByCin(121212);

        		date.setCellValueFactory(new PropertyValueFactory<Conge,Date>("date_co"));
				type.setCellValueFactory(new PropertyValueFactory<Conge,String>("type_co"));
				certif.setCellValueFactory(new PropertyValueFactory<Conge,String>("certificat"));
				days.setCellValueFactory(new PropertyValueFactory<Conge,Integer>("nbjrs_co"));
				status.setCellValueFactory(new PropertyValueFactory<Conge,String>("status_co"));       
        
        	ObservableList<Conge> data = FXCollections.observableArrayList(Conges);
        	table.setItems(data);
        	ObservableList<Conge> data1 = FXCollections.observableArrayList(Conges);
        	table.setItems(data1);
        	ObservableList<Conge> data3 = FXCollections.observableArrayList(Conges);
        	table.setItems(data3);
        	ObservableList<Conge> data4 = FXCollections.observableArrayList(Conges);
        	table.setItems(data4);
        	*/

		
		
	
}
