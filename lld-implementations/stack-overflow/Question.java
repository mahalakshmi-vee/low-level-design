package com.practice.stack_overflow_system;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Question extends PostEntity implements Commentable, Voteable {
	private String title;
	private List<Answer> answers;
	private List<Comment> comments;
	private List<Tag> tags;
	private List<Vote> votes;

	public Question(User author, String content, String title, List<Tag> tags) {
		super(author, content);
		this.title = title;
		this.tags = tags;
		answers = new ArrayList<>();
		comments = new ArrayList<>();
		votes = new ArrayList<>();
	}

	public void addAnswer(Answer answer) {
		answers.add(answer);
	}

	@Override
	public void addComment(Comment comment) {
		comments.add(comment);
	}

	@Override
	public void vote(User user, VoteType voteType) {
		int value = voteType.equals(VoteType.UPVOTE) ? ReputationScore.QUESTION_UPVOTE
				: ReputationScore.QUESTION_DOWNVOTE;

		Vote alreadyVoted = votes.stream().filter((v) -> v.getUser().equals(user)).findFirst().orElse(null);
		if (alreadyVoted != null) {
			// Remove existing vote and revert reputation change
			votes.remove(alreadyVoted);
			getAuthor().updateReputation(value * -1);
		}

		// Add new vote
		votes.add(new Vote(user, value));
		getAuthor().updateReputation(value); // +5 for upvote, -5 for downvote
	}

	@Override
	public int getTotalVotes() {
		return votes.stream().mapToInt((v) -> v.getValue()).sum();
	}
}
