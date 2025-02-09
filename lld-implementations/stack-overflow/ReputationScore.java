package com.practice.stack_overflow_system;

public class ReputationScore {
	private ReputationScore() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
	}

	// Reputation for upvote
	public static final int QUESTION_UPVOTE = 5; // Question author gains 5 points
	public static final int ANSWER_UPVOTE = 10; // Answer author gains 10 points

	// Reputation for downvote
	public static final int QUESTION_DOWNVOTE = -5; // Question author loses 5 points
	public static final int ANSWER_DOWNVOTE = -10; // Answer author loses 10 points

	// Reputation for accepted answer
	public static final int ACCEPTED_ANSWER = 15; // Answer author gains 15 points
	public static final int ACCEPTING_ANSWER = 2; // Question author gains 2 points for accepting an answer

	// Reputation for unaccepted answer
	public static final int UNACCEPTED_ANSWER = -15; // Answer author loses 15 points
	public static final int UNACCEPTING_ANSWER = -2; // Question author loses 2 points for unaccepting an answer
}
