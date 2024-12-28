package appMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import birds.Bird;
import birds.Flyable;
import bowl.Bowl;
import bowl.FruitBowl;
import cage.Cage;
import door.Door;
import door.WoodenDoor;
import service.DoorService;
import service.FeedingService;
import serviceImpl.DoorServiceImpl;
import serviceImpl.FeedingServiceImpl;
import zooCharacter.Animal;

public class ZooGame {
	public static void main(String[] args) {
		try {
			System.out.println("Enter thr bird name that you wish to see based on the following classification:");
			System.out.println("Parrot");
			System.out.println("Peacock");
			System.out.println("Kiwi");

			Scanner scanner = new Scanner(System.in);
			String birdType = scanner.next();
			Bird bird = BirdFactory.getBird(birdType);
			bird.eat();
			if (bird instanceof Flyable) {
				((Flyable) bird).fly();
			}
			List<Animal> listAnimal = new ArrayList<Animal>();
			listAnimal.add(bird);

			Bowl fruitBowl = new FruitBowl();
			Door woodenDoor = new WoodenDoor();
			FeedingService feedingService = new FeedingServiceImpl();
			DoorService doorService = new DoorServiceImpl();

			Cage cage = new Cage(listAnimal, feedingService, doorService, fruitBowl, woodenDoor);
			cage.feedAnimals();
			cage.resistAttach(50);

			scanner.close();
		} catch (Exception e) {

		}
	}
}
