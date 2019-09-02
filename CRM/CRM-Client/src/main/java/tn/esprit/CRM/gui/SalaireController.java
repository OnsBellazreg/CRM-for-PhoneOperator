package tn.esprit.CRM.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import tn.esprit.CRM.persistence.Staff;
import tn.esprit.CRM.persistence.User;
import tn.esprit.CRM.services.StaffServiceRemote;
import javafx.scene.control.TableColumn;

public class SalaireController implements Initializable{
	@FXML
	private TableView<User> user;
	@FXML
	private TableColumn<User,String> firstname;
	@FXML
	private TableColumn<User,String> lastname;
	@FXML
	private TableView<Staff> staff;
	@FXML
	private TableColumn<Staff,Float> salaire;
	@FXML
	private TableColumn<Staff,Integer> years;
	@FXML
	private TableColumn<Staff,Integer> increase;
	@FXML
	private Button traiter;

	// Event Listener on Button[#traiter].onAction
	@FXML
	public void traiter(ActionEvent event) throws NamingException {
		InitialContext ctx;
		ctx = new InitialContext();
		StaffServiceRemote proxy;
		proxy = (StaffServiceRemote) ctx.lookup("CRM-ear/CRM-ejb/StaffService!tn.esprit.CRM.services.StaffServiceRemote");
		ObservableList<Staff> data3 = FXCollections.observableArrayList(proxy.FindAllStaff());
		for (Staff str : data3) {
			if (str.getIncrease() < str.getYearswork()) {
				Staff ss = proxy.FindStaffByCin(str.getCIN());
				ss.setSalary_staff((((str.getYearswork()) - (str.getIncrease())) * 2 * (str.getSalary_staff() / 100))
						+ str.getSalary_staff());
				ss.setIncrease(str.getIncrease() + ((str.getYearswork()) - (str.getIncrease())));
				proxy.UpdateStaff(ss);
				ObservableList<Staff> data = FXCollections.observableArrayList(proxy.FindAllStaff());
				staff.setItems(data);
			} 
			//yourButton.setEnabled(false);
			
	/*		if((str.getYearswork()>=2) && (str.getYearswork()<4)){
				str.setIncrease(10);
			}
			if((str.getYearswork()>=4) && (str.getYearswork()<7)){
				str.setIncrease(20);
			}
			if((str.getYearswork()>=7) && (str.getYearswork()<10)){
				str.setIncrease(30);
			}
			if((str.getYearswork()>=10)){
				str.setIncrease(50);
			}	
			
			str.setSalary_staff(str.getSalary_staff()+(str.getSalary_staff()*str.getIncrease())/100);
			proxy.UpdateStaff(str);	*/
			//label: already updated for the year
		}
		}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			StaffServiceRemote proxy;

			proxy = (StaffServiceRemote) ctx.lookup("CRM-ear/CRM-ejb/StaffService!tn.esprit.CRM.services.StaffServiceRemote");
			ObservableList<Staff> data = FXCollections.observableArrayList(proxy.FindAllStaff());
	     	ObservableList<User> data2 = FXCollections.observableArrayList(proxy.FindAllUsers());
		
			staff.setItems(data);
			user.setItems(data2);
			salaire.setCellValueFactory(new PropertyValueFactory<Staff,Float>("salary_staff"));
			firstname.setCellValueFactory(new PropertyValueFactory<User,String>("first_Name"));
			years.setCellValueFactory(new PropertyValueFactory<Staff,Integer>("yearswork"));
			lastname.setCellValueFactory(new PropertyValueFactory<User,String>("last_Name"));
			increase.setCellValueFactory(new PropertyValueFactory<Staff,Integer>("increase"));

			
			
		} catch (NamingException e1) {
			// TODO Auto-generated catch blocks
			//e1.printStackTrace();
		} 
		
	}
}
