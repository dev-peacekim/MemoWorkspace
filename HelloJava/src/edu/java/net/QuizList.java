package edu.java.net;

import java.util.List;

public class QuizList {

	private List<Quiz> quizList;

	public QuizList(List<Quiz> quizList) {
		super();
		this.quizList = quizList;
	}

	public List<Quiz> getQuizList() {
		return quizList;
	}

	public void setQuizList(List<Quiz> quizList) {
		this.quizList = quizList;
	}
	
}
