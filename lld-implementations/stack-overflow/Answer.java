package com.practice.stack_overflow_system;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Answer extends PostEntity implements Commentable, Voteable {
	private List<Comment> comments;
	private List<Vote> votes;
	private boolean isAccepted;

	public Answer(User author, String content) {
		super(author, content);
		comments = new ArrayList<>();
		votes = new ArrayList<>();
		isAccepted = false;
	}

	@Override
	public void addComment(Comment comment) {
		comments.add(comment);
	}

	@Override
	public void vote(User user, VoteType voteType) {
		int value = voteType.equals(VoteType.UPVOTE) ? ReputationScore.ANSWER_UPVOTE : ReputationScore.ANSWER_DOWNVOTE;

		Vote alreadyVoted = votes.stream().filter((v) -> v.getUser().equals(user)).findFirst().orElse(null);
		if (alreadyVoted != null) {
			// Remove existing vote and revert reputation change
			votes.remove(alreadyVoted);
			getAuthor().updateReputation(value * -1);
		}

		// Add new vote
		votes.add(new Vote(user, value));
		getAuthor().updateReputation(value); // +10 for upvote, -10 for downvote
	}

	@Override
	public int getTotalVotes() {
		return votes.stream().mapToInt((v) -> v.getValue()).sum();
	}

	public void acceptAnswer(int value) {
		if (isAccepted) {
			throw new IllegalStateException("This answer is already accepted!");
		}
		isAccepted = true;
		getAuthor().updateReputation(ReputationScore.ACCEPTED_ANSWER); // +15 reputation for accepted answer
	}

	public void unAcceptAnswer(int value) {
		if (!isAccepted) {
			throw new IllegalStateException("This answer is not accpeted!");
		}
		isAccepted = false;
		getAuthor().updateReputation(ReputationScore.UNACCEPTED_ANSWER); // -15 reputation for unaccepted answer
	}
}
