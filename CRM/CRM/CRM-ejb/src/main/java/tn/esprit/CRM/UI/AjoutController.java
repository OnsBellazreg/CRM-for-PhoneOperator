package tn.esprit.CRM.UI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import tn.esprit.CRM.persistence.Staff;

import tn.esprit.CRM.services.StaffServiceRemote;

import java.net.URL;
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

	// Event Listener on Button[#ajouter].onAction
	@FXML
	public void ajouter(ActionEvent event) throws NamingException {
		InitialContext ctx;
		ctx = new InitialContext();
		StaffServiceRemote proxy;
		proxy = (StaffServiceRemote) ctx.lookup("CRM-ear/CRM-ejb/StaffService!tn.esprit.CRM.services.StaffServiceRemote");

		Staff e = new Staff(Integer.parseInt(disponibilite.getText()),Integer.parseInt(nbrjrc.getText()),Integer.parseInt(yearswork.getText()),Float.parseFloat(salaire.getText()),Integer.parseInt(increase.getText()));
	proxy.AjouterEmployee(e);}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
