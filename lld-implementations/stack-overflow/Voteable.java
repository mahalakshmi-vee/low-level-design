package com.practice.stack_overflow_system;

public interface Voteable {
	void vote(User user, VoteType voteType);

	int getTotalVotes();
}
