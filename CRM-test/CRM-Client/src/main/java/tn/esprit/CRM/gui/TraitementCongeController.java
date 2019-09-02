package tn.esprit.CRM.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import tn.esprit.CRM.persistence.Conge;
import tn.esprit.CRM.persistence.Staff;
import tn.esprit.CRM.services.StaffServiceRemote;

import javafx.scene.control.TableColumn;

public class TraitementCongeController implements Initializable{
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
	private Button traiter;
	@FXML
	private Button re;

	// Event Listener on Button[#traiter].onAction
	@FXML
	public void traiter(ActionEvent event) throws NamingException {
		InitialContext ctx;
		ctx = new InitialContext();
		StaffServiceRemote proxy;
		proxy = (StaffServiceRemote) ctx.lookup("CRM-ear/CRM-ejb/StaffService!tn.esprit.CRM.services.StaffServiceRemote");
		ObservableList<Conge> data = FXCollections.observableArrayList(proxy.FindAllDemandeConge());
	
		for(Conge c:data){
		int k;
		k=c.getCin();
	//	System.out.println(k);
	//	System.out.println(proxy.FindStaffByCin(k).getNbjrscp());
		//if not examined
		if(c.getStatus_co().equals("not examined yet")){
			Staff flen=proxy.FindStaffByCin(k);
			
			/*
			if(((proxy.FindStaffByCin(k).getNbjrscp())+c.getNbjrs_co())<30){
			//	System.out.println("debut");
				int old=proxy.FindStaffByCin(k).getNbjrscp();
			//	System.out.println(old);
			/*	List<Conge> LC = proxy.FindDemandeCongeByCin(k);
				int nouv=0;
				for(Conge con:LC)
				{			System.out.println("for");	
					nouv=con.getNbjrs_co()+nouv;
					proxy.FindStaffByCin(k).setNbjrscp(old+nouv);
					System.out.println("setnbr");
					proxy.UpdateDemandeConge(c);
				} */
		//		int nouv= old+ c.getNbjrs_co();
				//System.out.println(nouv+ "="+old+"+"+c.getNbjrs_co());
				// int nouv=proxy.FindDemandeCongeByCin(k)
				// proxy.FindStaffByCin(k).setNbjrscp();
				/*
				c.setStatus_co("Approved");
				Staff s=proxy.FindStaffByCin(k);
				s.setNbjrscp(nouv);
				//proxy.FindStaffByCin(k).setNbjrscp(c.getNbjrs_co()+old);
				proxy.UpdateStaff(s);
				//System.out.println("fin");
				proxy.UpdateDemandeConge(c);
				//System.out.println("so?");
				table.setItems(data);
				
			} */
			//else 
				if((c.getCertificat().equals("Available"))&&(c.getType_co().equals("Medical"))&&(((flen.getNbjrscp()+c.getNbjrs_co())<30))){
				c.setStatus_co("Approved");
				proxy.UpdateDemandeConge(c);
				flen.setNbjrscp(flen.getNbjrscp()+c.getNbjrs_co());
				proxy.UpdateStaff(flen);
				table.setItems(data);
			}
			else if((c.getCertificat().equals("Unavailable"))&&(c.getType_co().equals("Normal"))&&((flen.getNbjrscp()+c.getNbjrs_co())>30)){
				c.setStatus_co("Rejected");
				proxy.UpdateDemandeConge(c);
				
				table.setItems(data);
			}
			else if((c.getCertificat().equals("Unavailable"))&&(c.getType_co().equals("Medical"))&&(((flen.getNbjrscp()+c.getNbjrs_co())<30))){
				c.setStatus_co("Rejected");
				proxy.UpdateDemandeConge(c);
				
				table.setItems(data);
			}
			else if((c.getCertificat().equals("Available"))&&(c.getType_co().equals("Normal"))&&((flen.getNbjrscp()+c.getNbjrs_co())>30)){
				c.setStatus_co("Contact HR for further Information");
				proxy.UpdateDemandeConge(c);
				table.setItems(data);
			}
			else if((c.getCertificat().equals("Available"))&&(c.getType_co().equals("Medical"))&&(((flen.getNbjrscp()+c.getNbjrs_co())>30))){
				c.setStatus_co("Approved with salary decrease");
				proxy.UpdateDemandeConge(c);
				flen.setNbjrscp(flen.getNbjrscp()+c.getNbjrs_co());
				flen.setSalary_staff(flen.getSalary_staff()- (c.getNbjrs_co()-30)*20);
				proxy.UpdateStaff(flen);
				table.setItems(data);
			}
			
			}
		}
		
	}
	// Event Listener on Button[#re].onAction
	@FXML
	public void re(ActionEvent event) throws IOException {
		FXMLLoader loaders= new FXMLLoader(getClass().getResource("./test.fxml"));
	       Parent root;
	  	 	root=loaders.load();
	  	 	re.getScene().setRoot(root);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			StaffServiceRemote proxy;

			proxy = (StaffServiceRemote) ctx.lookup("CRM-ear/CRM-ejb/StaffService!tn.esprit.CRM.services.StaffServiceRemote");
			System.out.println("aaaaaa");
			ObservableList<Conge> data = FXCollections.observableArrayList(proxy.FindAllDemandeConge());	
				List<Conge> li= proxy.FindAllDemandeConge();
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
}
