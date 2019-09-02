package tn.esprit.CRM.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import tn.esprit.CRM.persistence.Staff;
import tn.esprit.CRM.persistence.User;
import tn.esprit.CRM.services.StaffServiceRemote;


public class AccController implements Initializable {


	@FXML
	private VBox pnItems;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			loadUserGrid();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	void close(MouseEvent event) {
	}

	@FXML
	void close_app(MouseEvent event) {
		System.exit(0);
	}
	
	private void loadUserGrid() throws NamingException {
		InitialContext ctx;
		ctx = new InitialContext();
		StaffServiceRemote proxy;
		proxy = (StaffServiceRemote) ctx.lookup("CRM-ear/CRM-ejb/StaffService!tn.esprit.CRM.services.StaffServiceRemote");
		
		List<Staff> users = proxy.FindAllStaff();
		Node[] nodes = new Node[users.size()];
		
		AtomicInteger i = new AtomicInteger(0);
		users.forEach(Staff -> {
			int j = i.getAndIncrement();
			Node node = nodes[j] = loadNewItemNode();

			displaUserDetails(node, Staff);
			
			setupActions(node, Staff, j);
			
			setHoverStyleForNode(nodes, j);

			pnItems.getChildren().add(node);
		});

		if (nodes.length > 0) {
			pnItems.setStyle("-fx-background-color : #53639F");
			pnItems.toFront();
		}
	}
	
	private List<Staff> fetchUsers() {
		try {
			return getStaffServiceRemove().FindAllStaff();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
	}
	
	private Node loadNewItemNode() {
		try {
			return FXMLLoader.load(getClass().getResource("/tn/esprit/CRM/gui/Item.fxml"));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	private void displaUserDetails(Node node, Staff staff) {
		Label firstName = (Label) node.lookup(".item_firstName");
		firstName.setText(staff.getFirst_Name());
	
		// other properties
		// ...
	}
	
	private void setupActions(Node node, User user, int index) {
	//	Button deleteButton = (Button) node.lookup(".item_action_delete");
	//	deleteButton.setOnMouseClicked(deleteEventHandler(user.getId_user(), index));
	}
	
	private void setHoverStyleForNode(Node[] nodes, int i) {
		final int j = i;
		nodes[i].setOnMouseEntered(even -> {
			nodes[j].setStyle("-fx-background-color : #0A0E3F");
		});
		nodes[i].setOnMouseExited(even -> {
			nodes[j].setStyle("-fx-background-color : #02030A");
		});
	}

	private EventHandler<MouseEvent> deleteEventHandler(Integer id_user, int index) {
		return event -> {
	//		getStaffServiceRemove().FindStaffByCin(121212);
			
		//	pnItems.getChildren().remove(index);
		};	
	}
	
	private StaffServiceRemote getStaffServiceRemove() {
	/*	Context context;
		try {
			context = new InitialContext();
			return (StaffServiceRemote) context.lookup(JNDI_NAME);
		} catch (NamingException e) {
			throw new RuntimeException(e);
		} */
		return null;
	}

}
