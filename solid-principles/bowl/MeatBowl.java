package bowl;

import zooCharacter.Animal;

public class MeatBowl implements Bowl {

	@Override
	public void feed(Animal animal) {
		System.out.println("Feed function in MeatBowl and feeding Animal is " + animal.getName());
	}

}
