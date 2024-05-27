package com.school.test.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Choice {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="sequenceGenerator")
	private long id;
	
	@Column(name="choice")
	private String choice;

	@Column(name="is_correct",nullable=false)
	private long isCorrect;
	
	@ManyToOne
	@JoinColumn(name="question_id")
	private Question question;
	
	public long getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(long isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}
	
}
