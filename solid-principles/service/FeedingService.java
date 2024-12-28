package service;

import java.util.List;

import bowl.Bowl;
import zooCharacter.Animal;

public interface FeedingService {
	void feedAnimal(List<Animal> listAnimal, Bowl bowl);
}
