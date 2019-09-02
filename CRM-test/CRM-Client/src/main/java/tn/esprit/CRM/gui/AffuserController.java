package tn.esprit.CRM.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.CRM.persistence.Staff;
import tn.esprit.CRM.persistence.User;
import tn.esprit.CRM.services.StaffServiceRemote;
import javafx.scene.control.TableColumn;

public class AffuserController implements Initializable {
	@FXML
	private TableView<User> user;
	@FXML
	private TableColumn<User,String> firstname;
	@FXML
	private TableColumn<User,String> lastname;
	@FXML
	private TableView<Staff> staff;
	@FXML
	private TableColumn<Staff,Integer> dispo;
	@FXML
	private TableColumn<Staff,Integer> years;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	InitialContext ctx;
		try {
			ctx = new InitialContext();
			StaffServiceRemote proxy;

			proxy = (StaffServiceRemote) ctx.lookup("CRM-ear/CRM-ejb/StaffService!tn.esprit.CRM.services.StaffServiceRemote");
			ObservableList<Staff> data = FXCollections.observableArrayList(proxy.FindAllStaff());
	     	ObservableList<User> data2 = FXCollections.observableArrayList(proxy.FindAllUsers());
			//System.out.println("one");
				List<Staff> li= proxy.FindAllStaff();
			//	List<User> li1= proxy.FindAllUsers();
		//	for(Staff c:li){
		//		System.out.println("two");
		//		proxy.FindUserById(c.getId_user());
		//		System.out.println(c);
		//	}
		
			staff.setItems(data);
			user.setItems(data2);
			dispo.setCellValueFactory(new PropertyValueFactory<Staff,Integer>("disponibilite"));
			firstname.setCellValueFactory(new PropertyValueFactory<User,String>("first_Name"));
			years.setCellValueFactory(new PropertyValueFactory<Staff,Integer>("yearswork"));
			lastname.setCellValueFactory(new PropertyValueFactory<User,String>("last_Name"));
			
		//	nbrj.setCellValueFactory(new PropertyValueFactory<User,String>("first_Name"));
		
			
			
		} catch (NamingException e1) {
			// TODO Auto-generated catch blocks
			//e1.printStackTrace();
		} 
	
}
	
	}


