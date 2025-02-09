package com.practice.stack_overflow_system;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import lombok.Getter;

@Getter
public class StackOverflow {
	private Map<Integer, User> users;
	private Map<Long, Question> questions;
	private Map<Long, Answer> answers;
	private Map<Long, Comment> comments;

	public StackOverflow() {
		users = new ConcurrentHashMap<>();
		questions = new ConcurrentHashMap<>();
		answers = new ConcurrentHashMap<>();
		comments = new ConcurrentHashMap<>();
	}

	public User createUser(String userName, String email) {
		int id = users.size() + 1;
		User user = new User(id, userName, email);
		users.put(id, user);
		return user;
	}

	public Question postQuestion(User user, String title, String content, List<Tag> tags) {
		Question question = user.askQuestion(title, content, tags);
		questions.put(question.getId(), question);
		return question;
	}

	public Answer answerQuestion(User user, String content, Question question) {
		Answer answer = user.answerQuestion(content, question);
		answers.put(answer.getId(), answer);
		return answer;
	}

	public Comment addComment(User user, String content, Commentable commentable) {
		Comment comment = new Comment(user, content);
		commentable.addComment(comment);
		comments.put(comment.getId(), comment);
		return comment;
	}

	public List<Question> getQuestionsByUser(User user) {
		return user.getQuestions();
	}

	public List<Question> searchQuestion(String queryString) {
		return questions.values().stream()
				.filter(q -> q.getTitle().toLowerCase().contains(queryString.toLowerCase())
						|| q.getContent().toLowerCase().contains(queryString.toLowerCase())
						|| q.getTags().stream()
								.anyMatch((t) -> t.getName().equalsIgnoreCase(queryString.toLowerCase())))
				.collect(Collectors.toList());
	}

	public void acceptAnswer(Question question, Answer answer, User user) {
		for (Answer ans : question.getAnswers()) {
			if (ans.isAccepted()) {
				unAcceptAnswer(ans, user); // Unaccepting the accepted answer
				break;
			}
		}
		answer.acceptAnswer(ReputationScore.ACCEPTED_ANSWER);
		user.updateReputation(ReputationScore.ACCEPTING_ANSWER); // 2 for accepting the answer
	}

	public void unAcceptAnswer(Answer answer, User user) {
		answer.unAcceptAnswer(ReputationScore.UNACCEPTED_ANSWER);
		user.updateReputation(ReputationScore.UNACCEPTING_ANSWER); // -2 for unaccepting the answer
	}
}
