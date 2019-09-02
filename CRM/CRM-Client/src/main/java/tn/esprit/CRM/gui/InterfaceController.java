package tn.esprit.CRM.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;

public class InterfaceController {
	@FXML
	private Button directeur;
	@FXML
	private Button salarie;

	// Event Listener on Button[#directeur].onAction
	@FXML
	public void directeur(ActionEvent event) throws IOException {
		FXMLLoader loaders= new FXMLLoader(getClass().getResource("./Directeur.fxml"));
	       Parent root;
	  	 	root=loaders.load();
	  	 	directeur.getScene().setRoot(root);
	}
	// Event Listener on Button[#salarie].onAction
	@FXML
	public void salarie(ActionEvent event) throws IOException {
		FXMLLoader loaders= new FXMLLoader(getClass().getResource("./MesConge.fxml"));
	       Parent root;
	  	 	root=loaders.load();
	  	 	salarie.getScene().setRoot(root);
	}
}
