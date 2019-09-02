import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.CRM.persistence.Conge;
import tn.esprit.CRM.persistence.Reclamation;
import tn.esprit.CRM.persistence.Staff;
import tn.esprit.CRM.persistence.User;
import tn.esprit.CRM.services.ReclamationServiceRemote;
import tn.esprit.CRM.services.StaffServiceRemote;


public class Main_Project {

	public static void main(String[] args) throws NamingException {
		
		String jndiName = "CRM-ear/CRM-ejb/ReclamationService!tn.esprit.CRM.services.ReclamationServiceRemote";
		Context context = new InitialContext();
		Context context2 = new InitialContext();
		//StaffServiceRemote proxy = (StaffServiceRemote) context2.lookup(jndiName);
		ReclamationServiceRemote proxy = (ReclamationServiceRemote) context2.lookup(jndiName);
		ReclamationServiceRemote proxy2 = (ReclamationServiceRemote) context.lookup(jndiName);
	/*	Reclamation e= new Reclamation();
		e.setStatus_recl("Non lu");
		e.setDescription_recl("hello");
		e.setId_client(2);
		proxy.AjouterReclamation(e); */
		
	/*	List<Reclamation> ABL = proxy.AfficherReclamation();
		//System.out.println("aa");
		for(Reclamation c:ABL){
			System.out.println(c.toString());	
		} */
		
 	List<Reclamation> ABL = proxy.AfficherReclamation();
		//System.out.println("aa");
	/*	for(Reclamation c:ABL){
			if(c.getId_recl()==4){
				c.setDescription_recl("luuuu");
				proxy.ModifierReclamation(c);
			}
		} */
	/*	for(Reclamation c:ABL){
			if(c.getId_recl()==6){
				proxy2.AjouterArchive(c);
				proxy.SupprimerReclamation(c);
			}
		} */
	/*	List<Conge> ABL = proxy2.FindAllDemandeConge();
		//System.out.println("aa");
		for(Conge c:ABL){
			int k=c.getCin();
			System.out.println(k);
			System.out.println(proxy2.FindStaffByCin(k).getNbjrscp());
		}
*/
	/*	List<Staff> ABL = proxy2.FindAllStaff();
		//System.out.println("aa");
		for(Staff c:ABL){
			System.out.println(c.toString() + c.getCIN());
		
	}
		*/
	//	System.out.println(proxy2.FindStaffByCin(121212).toString()); 
/*		List<Staff> li= proxy2.FindAllStaff();
		//	List<User> li1= proxy.FindAllUser();
		for(Staff c:li){
			System.out.println("two");
		//	proxy.FindUserById(c.getId_user());
			System.out.println(c.toString());
		} */
	/*	List<User> ABL = proxy2.FindAllUsers();
		//System.out.println("aa");
		for(User c:ABL){
			System.out.println(c.getCIN());
	} */
/*	User u=	proxy2.FindUserById(6);
		System.out.println(u.getCIN());
	/*	List<Conge> li= proxy2.FindDemandeCongeByStatus("Approved with salary decrease");
		for(Conge c:li){
			System.out.println(c.getCin());
		} */
/*		List<Conge> li=proxy2.FindAllDemandeConge();
		for(Conge c:li){
			if (c.getStatus_co().equals("Approved with salary decrease")){
				System.out.println(c);
			}
		} */
/*		List <Staff> st=proxy2.FindAllStaff();
		for(Staff s:st){
			if(s.getDisponibilite()==1){
				System.out.println(s);
			}
		}  */
	/*	Staff p=(Staff) proxy2.FindStaffById(6);
		Date d=p.getAccount_Date();
		System.out.println(d.getYear()+1900);
		
		
		Date date = p.getAccount_Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+" "+month+" "+" "+day);
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
		   System.out.println(now.getYear());
		   */
	
	/*	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date2 = new Date();
		System.out.println(dateFormat.format(date));
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  */
/*		List<Staff> li= proxy2.FindAllStaff();
		
		for(Staff c:li){
			Date d1=new Date();
			Date d2=c.getAccount_Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		//	String s1 = dateFormat.format(d1);
		//	String s2 = dateFormat.format(d2);
		int x=((d1.getYear()-d2.getYear())*12)+(d1.getMonth()-d2.getMonth())+1;
		int nbr=x/12;
		System.out.println(nbr);
		} */
   /*  Conge test=proxy2.FindDemandeCongeById(2);
	Date d=	test.getDate_co();
	System.out.println(d);
	long lol=d.getTime()+1*24*60*60*1000;
	System.out.println("bitch what"+lol);
	Date today8=new Date(lol);
	System.out.println(today8); */
	/*	List<Conge> li= proxy.FindAllDemandeConge();
		for(Conge c:li){
			if (c.getStatus_co().equals("not examined yet"))
			{System.out.println(c);}
		} */
	} 
}

