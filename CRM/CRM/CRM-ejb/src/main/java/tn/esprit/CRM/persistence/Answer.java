package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Answer
 *
 */
@Entity

public class Answer implements Serializable {

	   
	@Id
	private Integer id_answer;
	private String answer_recl;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private User user4;
	
	
	public User getUser4() {
		return user4;
	}
	public void setUser4(User user4) {
		this.user4 = user4;
	}
	public Answer() {
		super();
	}   
	public Integer getId_answer() {
		return this.id_answer;
	}

	public void setId_answer(Integer id_answer) {
		this.id_answer = id_answer;
	}   
	public String getAnswer_recl() {
		return this.answer_recl;
	}

	public void setAnswer_recl(String answer_recl) {
		this.answer_recl = answer_recl;
	}
   
}
