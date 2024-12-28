package cage;

import java.util.List;

import bowl.Bowl;
import door.Door;
import service.DoorService;
import service.FeedingService;
import zooCharacter.Animal;

public class Cage {
	private List<Animal> listAnimal;
	private FeedingService feedingService;
	private DoorService doorService;
	private Bowl bowl;
	private Door door;

	/*
	 * This class is not tightly coupled with any high level entities rather they
	 * tightly coupled with high level abstraction. This class follows Dependency
	 * Inversion principle.
	 */
	public Cage(List<Animal> listAnimal, FeedingService feedingService, DoorService doorService, Bowl bowl, Door door) {
		this.listAnimal = listAnimal;
		this.feedingService = feedingService;
		this.doorService = doorService;
		this.bowl = bowl;
		this.door = door;
	}

	public void feedAnimals() {
		feedingService.feedAnimal(listAnimal, bowl);
	}

	public void resistAttach(int power) {
		doorService.resistAttack(door, power);
	}
}
