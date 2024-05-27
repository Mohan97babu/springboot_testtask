package com.school.test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {

  @Id	
  @GeneratedValue(strategy=GenerationType.AUTO,generator="sequenceGenerator")
  private long id;
  
  @Column(name="question")
  private String question;
  
  @ManyToOne
  @JoinColumn(name="test_id")
  private Test test;
            
  public Test getTest() 
  {
		return test;
  }
  public void setTest(Test test) 
  {
		this.test = test;
  }
  public long getId() 
  {
		return id;
  }
  public void setId(long id) 
  {
		this.id = id;
  }
  public String getQuestion() 
  {
		return question;
  }
  public void setQuestion(String question) 
  {
		this.question = question;
  }
}
