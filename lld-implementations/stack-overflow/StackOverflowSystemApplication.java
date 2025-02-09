package com.practice.stack_overflow_system;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StackOverflowSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackOverflowSystemApplication.class, args);

		StackOverflow stackOverflow = new StackOverflow();
		
		User maha = stackOverflow.createUser("Maha", "maha@gmail.com");
		User debina = stackOverflow.createUser("Debina", "debina@gmail.com");
		User divisha = stackOverflow.createUser("Divisha", "divisha@gmail.com");

		// Debina asks a question
		Question javaQuestion = stackOverflow.postQuestion(debina, "Java OOP Concept - Inheritance",
				"Why multiple inheritance is not supported in Java?", Arrays.asList(new Tag("Java"), new Tag("OOP")));

		// Divisha answers Debina's question
		Answer divishaAnswer = stackOverflow.answerQuestion(divisha,
				"To avoid diamond problems and multiple inheritance is achievable using interfaces.", javaQuestion);

		// Maha asks a question
		Question reactQuestion = stackOverflow.postQuestion(maha, "React - SPA",
				"How React is suitable for small scale application and why?",
				Arrays.asList(new Tag("React"), new Tag("SPA")));

		// Debina answers Maha's question
		Answer debinaAnswer = stackOverflow.answerQuestion(debina,
				"Virtual DOM is so efficient to deduct the exact changes and rendering the DOM very accurately with the changes alone instead of the whole DOM rendering",
				reactQuestion);

		// Divisha comments on Debina's question
		stackOverflow.addComment(divisha, "Great question and I'm also interested in learning this", javaQuestion);

		// Maha comments on Debina's answer
		stackOverflow.addComment(maha, "Great explanation and thanks!", debinaAnswer);

		// Debina add comments to Divisha's answer
		stackOverflow.addComment(debina, "Good answer!", divishaAnswer);

		// Maha accepts Debina's answer
		stackOverflow.acceptAnswer(reactQuestion, debinaAnswer, maha);

		// Vote on ReactQuestion
		reactQuestion.vote(debina, VoteType.UPVOTE);

		// Vote on JavaQuestion
		javaQuestion.vote(divisha, VoteType.UPVOTE);
		javaQuestion.vote(maha, VoteType.UPVOTE);
		javaQuestion.vote(debina, VoteType.UPVOTE);

		// Vote on Debina's answer
		debinaAnswer.vote(maha, VoteType.UPVOTE);
		debinaAnswer.vote(divisha, VoteType.DOWNVOTE);

		System.out.println("Users reputation:");
		System.out.println("Maha: " + maha.getReputation());
		System.out.println("Debina: " + debina.getReputation());
		System.out.println("Divisha: " + divisha.getReputation());

		System.out.println("Question: " + javaQuestion.getTitle());
		System.out.println("Asked by: " + javaQuestion.getAuthor().getUserName());
		System.out.println("Tags: "
				+ javaQuestion.getTags().stream().map(Tag::getName).reduce((a, b) -> a + " , " + b).orElse(""));
		System.out.println("Votes: " + javaQuestion.getTotalVotes());
		System.out.println("Comments: " + javaQuestion.getComments().size());
		System.out.println("Answers: " + javaQuestion.getAnswers().stream().map(Answer::getContent)
				.reduce((a, b) -> a + " , " + b).orElse(""));
	}

}
