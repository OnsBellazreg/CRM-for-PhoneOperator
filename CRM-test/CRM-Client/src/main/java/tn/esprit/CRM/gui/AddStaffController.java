package tn.esprit.CRM.gui;



import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import tn.esprit.CRM.persistence.Staff;
import tn.esprit.CRM.services.StaffServiceRemote;

public class AddStaffController implements Initializable{

    @FXML
    private JFXTextField fname;

    @FXML
    private JFXTextField lname;

    @FXML
    private JFXTextField cin;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField salary;

    @FXML
    private JFXTextField number;

    @FXML
    private JFXButton add;
    @FXML
    private JFXButton cancel;
    @FXML
    private Label fname_al;

    @FXML
    private Label lname_al;

    @FXML
    private Label cin_al;

    @FXML
    private Label email_al;

    @FXML
    private Label number_al;

    @FXML
    private Label salary_al;


    @FXML
    void add(ActionEvent event) throws NamingException {
    	InitialContext ctx;
		ctx = new InitialContext();
		StaffServiceRemote proxy;
		proxy = (StaffServiceRemote) ctx.lookup("CRM-ear/CRM-ejb/StaffService!tn.esprit.CRM.services.StaffServiceRemote");
		//Date date = new Date(0);
		
		
		Date date=new Date();
		//CIN
		boolean exist=true;
		List<Staff> ls=proxy.FindAllStaff();
		for(Staff s:ls){
			if(s.getCIN().equals(cin.getText())){
				exist=false;
				cin_al.setText("Employee Already exist !");
			}
		}
		
		//Staff e = new Staff(Integer.parseInt(disponibilite.getText()),Integer.parseInt(nbrjrc.getText()),Integer.parseInt(yearswork.getText()),Float.parseFloat(salaire.getText()),Integer.parseInt(increase.getText()));
	Staff s=new Staff();
    if(((Verifier())&&(validateprix())&&(validateNumTel())&&(exist)&&(VerifCIN()))){
    	
    	s.setDisponibilite(1);
    	s.setCIN(Integer.parseInt(cin.getText()));
    	s.setYearswork(0);
    	s.setPhone_number(Integer.parseInt(number.getText()));
    	s.setSalary_staff(Float.parseFloat(salary.getText()));
    	s.setIncrease(0);
    	s.setFirst_Name(fname.getText());
    	s.setLast_Name(lname.getText());
    	s.setEmail(email.getText());
    	s.setAccount_Date(date);
    	
    	proxy.AjouterEmployee(s);
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("you added a new Employee");
		alert.setContentText("A New Employee Joined Our Company!");

		alert.showAndWait();
    }
    else System.out.println("notif");
	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	@FXML
    void cancel(ActionEvent event) throws IOException {
		FXMLLoader loaders= new FXMLLoader(getClass().getResource("./test.fxml"));
	       Parent root;
	  	 	root=loaders.load();
	  	 	cancel.getScene().setRoot(root);
    }
private boolean validateNumTel(){
        number_al.setText("");
        Pattern pattern=Pattern.compile("[0-9]+");
        Matcher matcher=pattern.matcher(number.getText());
        if (number.getText().isEmpty()){
            number_al.setText("(*)Required");
            return false;
        }
        else if (matcher.find() && matcher.group().equals(number.getText())){
            return true;
        }else {
            number_al.setText("(*)Only numbers Allowed");
            return false;
    }}
    
    
    private boolean validateprix(){
    
        Pattern pattern=Pattern.compile("[0-9]+");
        Matcher matcher=pattern.matcher(salary.getText());
        if (salary.getText().isEmpty()){
            salary_al.setText("(*)Required");
            return false;
        }
        else if (matcher.find() && matcher.group().equals(salary.getText())){
            return true;
        }else {
            salary_al.setText("(*)Enter a valid Salary!");
            return false;
    }
    
    }
    
    private boolean Verifier(){
            if(fname.getText().equals("")||salary.getText().equals("")||lname.getText().equals("")||cin.getText().equals("")||number.getText().equals("")|email.getText().equals(""))
            {
       Alert alert = new Alert(Alert.AlertType.ERROR);
                                            alert.setTitle("Unsuccessful ");
                                            alert.setHeaderText("Please Provide all required informations");
                                            Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();  
                                            
                                            return false;
     } 
             
                return true;
    }
    
  private boolean VerifCIN() throws NamingException{
    	 InitialContext ctx;
    	 ctx = new InitialContext();
			StaffServiceRemote proxy;

			proxy = (StaffServiceRemote) ctx.lookup("CRM-ear/CRM-ejb/StaffService!tn.esprit.CRM.services.StaffServiceRemote");
    	
    	// boolean valid = true ;
         List<Staff> listeParcourt= proxy.FindAllStaff() ;
    	       
    	       for (int i=0;i<listeParcourt.size();i++){
    	    	   if (listeParcourt.get(i).getCIN().equals(cin.getText())){
    	    		   cin_al.setText("This employee already exist!");
    	    		   return false;
    	    	   }
    	    	  
    	    	   
    	       }
    	       return true;	  
    	       
    	   
  }

}
