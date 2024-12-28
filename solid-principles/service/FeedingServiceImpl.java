package serviceImpl;

import java.util.List;

import bowl.Bowl;
import service.FeedingService;
import zooCharacter.Animal;

public class FeedingServiceImpl implements FeedingService{

	@Override
	public void feedAnimal(List<Animal> listAnimal, Bowl bowl) {
		for (Animal animal : listAnimal) {
			bowl.feed(animal);
		}
	}
}
