package com.practice.stack_overflow_system;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class User {
	private int id;
	private String userName;
	private String email;
	private int reputation;
	private List<Question> questions;
	private List<Answer> answers;
	private List<Comment> comments;

	public User(int id, String userName, String email) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		questions = new ArrayList<>();
		answers = new ArrayList<>();
		comments = new ArrayList<>();
	}

	public Question askQuestion(String title, String content, List<Tag> tags) {
		Question question = new Question(this, content, title, tags);
		return question;
	}

	public Answer answerQuestion(String content, Question question) {
		Answer answer = new Answer(this, content);
		answers.add(answer);
		question.addAnswer(answer);
		return answer;
	}

	public void updateReputation(int value) {
		this.reputation += value;
		if (reputation < 0) {
			reputation = 0;
		}
	}
}
