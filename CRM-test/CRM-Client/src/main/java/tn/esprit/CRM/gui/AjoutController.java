package tn.esprit.CRM.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import tn.esprit.CRM.persistence.Staff;
import tn.esprit.CRM.services.StaffServiceRemote;

import java.net.URL;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;

public class AjoutController implements Initializable{
	@FXML
	private TextField disponibilite;
	@FXML
	private TextField nbrjrc;
	@FXML
	private TextField yearswork;
	@FXML
	private TextField salaire;
	@FXML
	private TextField increase;
	@FXML
	private TextField CIN;
	@FXML
	private Button ajouter;
	@FXML
	private TextField firstname;
	@FXML
	private TextField lastname;
	@FXML
	private TextField mail;
	@FXML
	private TextField number;

	// Event Listener on Button[#ajouter].onAction
	@FXML
	public void ajouter(ActionEvent event) throws NamingException, ParseException {
		InitialContext ctx;
		ctx = new InitialContext();
		StaffServiceRemote proxy;
		proxy = (StaffServiceRemote) ctx.lookup("CRM-ear/CRM-ejb/StaffService!tn.esprit.CRM.services.StaffServiceRemote");
		//Date date = new Date(0);
		
		
		Date date=new Date();
		
		//Staff e = new Staff(Integer.parseInt(disponibilite.getText()),Integer.parseInt(nbrjrc.getText()),Integer.parseInt(yearswork.getText()),Float.parseFloat(salaire.getText()),Integer.parseInt(increase.getText()));
	Staff s=new Staff();
	s.setDisponibilite(Integer.parseInt(disponibilite.getText()));
	s.setCIN(Integer.parseInt(CIN.getText()));
	s.setYearswork(Integer.parseInt(yearswork.getText()));
	s.setPhone_number(Integer.parseInt(number.getText()));
	s.setSalary_staff(Float.parseFloat(salaire.getText()));
	s.setIncrease(Integer.parseInt(increase.getText()));
	s.setFirst_Name(firstname.getText());
	s.setLast_Name(lastname.getText());
	s.setEmail(mail.getText());
	s.setAccount_Date(date);
	proxy.AjouterEmployee(s);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
